## Parsing

# Generic reader


- Apples
- Bananas
    - Ripe bananas

public class MDFileReader {
public static String read(String filePath)  {
// TODO - Your Code Starts Here
StringBuilder content = new StringBuilder(); //Allows you to actively edit a singlt string object

        //BufferedReader allows you to read one line at a time
        //Filereader opens the text file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            //Readline returns null at file end, returns "" for empty line
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator()); //readline doesnt maintain \n equivlents, so we append a new one.
            }
        } catch (IOException e) { //Handles errors, wraps the exceptioon because erros not delcared in methodology
            throw new UncheckedIOException("Could not read file: " + filePath, e);
        }
        return content.toString();
        // TODO - Your Code Ends Here
    }
String text = MDFileReader.read("example.md");
System.out.print(text);
Output:
- Apples
- Bananas
    - Ripe bananas

# General CSV Reader, reads each line and splits

Alice;20
Bob;25


import java.io.*;
import java.util.*;

    public static List<String[]> readCsv(String filePath) {
        List<String[]> records = new ArrayList<>();
        
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(filePath))) {
    
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
    
                String[] fields = line.split(";", -1);
                records.add(fields);
            }
    
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        
    return records;
    }

List<String[]> records = readCsv("people.csv");

for (String[] fields : records) {
String name = fields[0];
int age = Integer.parseInt(fields[1]);

    System.out.println(name + " is " + age + " years old.");
}
Output:
Alice is 20 years old.
Bob is 25 years old.


## General XML Parser

<people>
    <person id="1">
        <name>Alice</name>
    </person>
    <person id="2">
        <name>Bob</name>
    </person>
</people>
This example returns a map from ID to name:
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public static Map<String, String> readXml(String filePath) {
Map<String, String> people = new HashMap<>();

    try {
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(filePath));
        NodeList nodes = document.getElementsByTagName("person");

        for (int i = 0; i < nodes.getLength(); i++) {
            Element person = (Element) nodes.item(i);

            String id = person.getAttribute("id");
            String name = person.getElementsByTagName("name")
                    .item(0).getTextContent();

            people.put(id, name);
        }

    } catch (ParserConfigurationException
             | SAXException | IOException e) {
        throw new RuntimeException("Could not read XML", e);
    }

    return people;
}


Map<String, String> people = readXml("people.xml");

for (String id : new TreeSet<>(people.keySet())) {
System.out.println("ID: " + id + ", name: " + people.get(id));
}
Output:
ID: 1, name: Alice
ID: 2, name: Bob

## Reusable writer templates (Java 8+)

These examples use only the standard Java library. Each method writes a file;
it does not print to the console. The displayed outputs are the file contents.
Existing files are overwritten. The parent directory must already exist.

Place the methods inside your class and the imports above the class:

```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
```

### 1. General text writer

Use this for plain text, Markdown, or any format where you construct the text yourself.
The method writes exactly the string supplied; it does not add a final newline.

```java
public static void writeText(String filePath, String text) {
    try (BufferedWriter writer = Files.newBufferedWriter(
            Paths.get(filePath), StandardCharsets.UTF_8)) {
        writer.write(text);
    } catch (IOException e) {
        throw new UncheckedIOException("Could not write " + filePath, e);
    }
}
```

Example call (inside `main`):

```java
String text = "- Apples" + System.lineSeparator()
        + "- Bananas" + System.lineSeparator()
        + "    - Ripe bananas" + System.lineSeparator();
writeText("example.md", text);
```

Contents of `example.md`:

```text
- Apples
- Bananas
    - Ripe bananas
```

For line-by-line output, use `writer.write(line); writer.newLine();` in a loop.
Try-with-resources automatically closes the writer and flushes its buffered output.

### 2. CSV writer (semicolon-separated)

Each `String[]` is one row. This version writes the header `name;age`.
Adapt the header, separator, and fields to the question.

```java
public static void writeCsv(String filePath, List<String[]> rows) {
    try (BufferedWriter writer = Files.newBufferedWriter(
            Paths.get(filePath), StandardCharsets.UTF_8)) {
        writer.write("name;age");
        writer.newLine();

        for (String[] row : rows) {
            writer.write(csvField(row[0]));
            writer.write(";");
            writer.write(csvField(row[1]));
            writer.newLine();
        }
    } catch (IOException e) {
        throw new UncheckedIOException("Could not write " + filePath, e);
    }
}

// Quote fields containing a separator, quote, or newline.
// A quote inside a quoted field is written twice.
public static String csvField(String value) {
    if (value.contains(";") || value.contains("\"")
            || value.contains("\n") || value.contains("\r")) {
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }
    return value;
}
```

Example call:

```java
List<String[]> rows = Arrays.asList(
        new String[]{"Alice", "20"},
        new String[]{"Bob", "25"}
);
writeCsv("people.csv", rows);
```

Contents of `people.csv`:

```text
name;age
Alice;20
Bob;25
```

For a `Person` object, use its getters and `String.valueOf(p.getAge())` to construct
the fields. If a numeric value is written directly, use
`writer.write(String.valueOf(number))`: `writer.write(number)` writes a character code.

If the exam guarantees that fields contain no separators, quotes, or newlines,
you can write the fields directly without `csvField`. The earlier `split(";", -1)`
reader handles that simple format only; it cannot parse quoted separators or
multiline fields. Skip the header when reading this example.

### 3. XML writer (DOM)

For this example each row contains `{id, name}`. An ID is an attribute and the name
is a child element, matching the XML reader example above.

```java
public static void writeXml(String filePath, List<String[]> rows) {
    try {
        Document document = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().newDocument();

        // The document has one root element.
        Element people = document.createElement("people");
        document.appendChild(people);

        for (String[] row : rows) {
            // Each new person is a child of people: the records are siblings.
            Element person = document.createElement("person");
            person.setAttribute("id", row[0]);
            people.appendChild(person);

            Element name = document.createElement("name");
            name.setTextContent(row[1]);
            person.appendChild(name);
        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document),
                new StreamResult(new File(filePath)));
    } catch (ParserConfigurationException | TransformerException e) {
        throw new RuntimeException("Could not write " + filePath, e);
    }
}
```

Example call:

```java
List<String[]> xmlRows = Arrays.asList(
        new String[]{"1", "Alice"},
        new String[]{"2", "Bob"}
);
writeXml("people.xml", xmlRows);
```

Contents of `people.xml` (indentation and declaration formatting can vary):

```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<people>
    <person id="1">
        <name>Alice</name>
    </person>
    <person id="2">
        <name>Bob</name>
    </person>
</people>
```

If the question requires `<id>1</id>` instead of an attribute, replace
`person.setAttribute("id", row[0]);` with:

```java
Element id = document.createElement("id");
id.setTextContent(row[0]);
person.appendChild(id);
```

DOM relationships determine the XML structure:

```text
document
└── people
    ├── person (id="1")
    │   └── name (text="Alice")
    └── person (id="2")
        └── name (text="Bob")
```

- `createElement("name")`: create an element object with this tag name.
- `setTextContent("Alice")`: give it text; this does not close a tag.
- `parent.appendChild(child)`: attach the child to that specific parent.
- `transform(...)`: write the entire tree, including opening and closing tags.
- `INDENT`: request readable nesting; exact whitespace is implementation-dependent.
- `UTF-8`: choose character encoding, not indentation.

`setTextContent` and `setAttribute` handle XML escaping automatically. For example,
the name `Alice & Bob` is saved as `<name>Alice &amp; Bob</name>`.


## XML Example for Write, CSV for read

	public List<Person> readCsv(String fileName) {

		List<Person> list = new LinkedList<>();

		// ########## YOUR CODE STARTS HERE ##########
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				if (line.isBlank()) {
					continue;
				}

				String[] savedWords = line.split(";", -1);
				Person p = new Person((
						Integer.parseInt(savedWords[0].trim())),
						savedWords[1],
						(Integer.parseInt(savedWords[2].trim())),
						savedWords[3]); //Integer conversion!
				list.add(p);
			}

		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		

		// ########## YOUR CODE ENDS HERE ##########

		return list;
	}

	public void saveXML(RBTree<Integer, Person> tree) {

		if (tree == null) {
			return;
		}

		List<Node> list = tree.levelTraversal();

		// ########## YOUR CODE STARTS HERE ##########
		try {
			// Create the document and its single root element.
			Document document = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().newDocument();
			Element people = document.createElement("people");
			document.appendChild(people);

			for (Node n : list) {
				Person p = (Person) n.getData();
				Element person = document.createElement("person");
				people.appendChild(person);

				Element id = document.createElement("id");
				id.setTextContent(String.valueOf(p.getId()));
				person.appendChild(id);

				Element name = document.createElement("name");
				name.setTextContent(p.getName());
				person.appendChild(name);

				Element age = document.createElement("age");
				age.setTextContent(String.valueOf(p.getAge()));
				person.appendChild(age);

				Element occupation = document.createElement("occupation");
				occupation.setTextContent(p.getOccupation());
				person.appendChild(occupation);
			}

			// Write the document to the required output file.
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document),
					new StreamResult(new File("people.xml")));
		} catch (ParserConfigurationException | TransformerException e) {
			throw new RuntimeException("Could not save people.xml", e);
		}
		

		// ########## YOUR CODE ENDS HERE ##########
	}

}