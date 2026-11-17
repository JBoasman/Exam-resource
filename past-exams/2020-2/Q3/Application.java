
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Application {

	public RBTree<Integer, Person> createTree(List<Person> personList) {

		RBTree<Integer, Person> tree = new RBTree<>();

		// ########## YOUR CODE STARTS HERE ##########
		if (personList == null) {
			return tree;
		}
		for (Person person : personList) {
			tree.insert(person.getId(), person);
		}
		// ########## YOUR CODE ENDS HERE ##########

		return tree;
	}

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
