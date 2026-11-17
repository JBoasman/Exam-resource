import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class Executor {

	private final List<Command> commands;

	private final DataBase db = DataBase.getInstance();

	public Executor(List<Command> commands) {
		this.commands = commands;
	}

	public void execute() {
		for (Command c : this.commands) {
			if (c instanceof LoadCommand) {
				loadFrom((LoadCommand) c);
			} else if (c instanceof SaveCommand) {
				saveTo((SaveCommand) c);
			}
		}
	}

	/**
	 * save the persons from the database to the xml file
	 * 
	 * @param sac
	 */
	private void saveTo(SaveCommand sac) {

		List<Person> persons = this.db.load(sac.getKey());

		File f = new File(sac.getFileName());
		if (f.exists()) {
			f.delete();
		}

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			// TODO
			org.w3c.dom.Element root = doc.createElement(Person.KEY_ROOT);
            doc.appendChild(root);
            for (Person person : persons) {
                org.w3c.dom.Element entry = doc.createElement(Person.KEY_ELEMENT); root.appendChild(entry);
                if (person.getName() != null) { org.w3c.dom.Element child = doc.createElement(Person.KEY_NAME); child.setTextContent(String.valueOf(person.getName())); entry.appendChild(child); }
                if (person.getGender() != null) { org.w3c.dom.Element child = doc.createElement(Person.KEY_GENDER); child.setTextContent(String.valueOf(person.getGender())); entry.appendChild(child); }
                if (true) { org.w3c.dom.Element child = doc.createElement(Person.KEY_AGE); child.setTextContent(String.valueOf(person.getAge())); entry.appendChild(child); }
                if (person.getOccupation() != null) { org.w3c.dom.Element child = doc.createElement(Person.KEY_OCCUPATION); child.setTextContent(String.valueOf(person.getOccupation())); entry.appendChild(child); }
            }

			// ########## YOUR CODE ENDS HERE ##########

			Transformer transformer = TransformerFactory.newInstance().newTransformer();

			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

			// INDENT the xml file is optional, you can
			// uncomment the following statement if you would like the xml files to be more
			// readable
			// transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(f);
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * load the persons from the xml file into the database
	 * 
	 * @param lc
	 */
	private void loadFrom(LoadCommand lc) {

		List<Person> persons = new LinkedList<>();

		File f = new File(lc.getFileName());
		if (!f.exists()) {
			return;
		}

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(f);

			doc.getDocumentElement().normalize();

			// TODO
			org.w3c.dom.NodeList entries = doc.getElementsByTagName(Person.KEY_ELEMENT);
            for (int i = 0; i < entries.getLength(); i++) {
                org.w3c.dom.Element entry = (org.w3c.dom.Element) entries.item(i);
                Person person = new Person();
                if (entry.getElementsByTagName(Person.KEY_NAME).getLength() > 0) person.setName(entry.getElementsByTagName(Person.KEY_NAME).item(0).getTextContent());
                if (entry.getElementsByTagName(Person.KEY_GENDER).getLength() > 0) person.setGender(entry.getElementsByTagName(Person.KEY_GENDER).item(0).getTextContent());
                if (entry.getElementsByTagName(Person.KEY_AGE).getLength() > 0) person.setAge(Integer.parseInt(entry.getElementsByTagName(Person.KEY_AGE).item(0).getTextContent()));
                if (entry.getElementsByTagName(Person.KEY_OCCUPATION).getLength() > 0) person.setOccupation(entry.getElementsByTagName(Person.KEY_OCCUPATION).item(0).getTextContent());
                persons.add(person);
            }

			// ########## YOUR CODE ENDS HERE ##########

			this.db.save(lc.getKey(), persons);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Command> getCommands() {
		return commands;
	}
}
