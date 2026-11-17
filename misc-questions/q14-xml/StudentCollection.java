import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import java.io.File;
import java.util.List;

/**
 *
 * @author nanwang
 *
The goal of this task is to write a program that loads/stores a list of students in XML format. `StudentCollection.java` class contains
a list of `Student` instances. Each student has his/her `age` and `name`, which need to be saved as attributes of XML node. Additionally,
each student can have three possible properties: `height`, `weight` and `courses`. `courses` property contains a list of `course` elements.
Each course has a course `name` attribute and a `grade` value. Note that not every student has all three properties. Some properties of students may be missing
(for example, see the test cases in StudentsTest.java). You job is to implement the below two methods in `StudentCollection.java`:

* `saveToFile`
* `loadFromFile`

Note that these methods should take into account the available properties of a given student. You are allowed to add additional asserts
and test cases to test your solutions. You can use `getAttribute(String name)` and `setAttribute(String name, String value)` of `Element`
class to get and set the attributes of XML node. **Please upload `StudentCollection.java` to wattle!**
 */
public class StudentCollection {

	private final List<Student> students;

	public StudentCollection(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	/**
	 * Implement this method to save the list of students to XML file
	 * HINT: `setAttribute(String name, String value)` in `Element` can be used to set `name` and `age` properties
	 * @param file
	 */
	public void saveToFile(File file) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = doc.createElement("students");
            doc.appendChild(root);
            for (Student value : students) {
                Element entry = doc.createElement("student");
                root.appendChild(entry);
                entry.setAttribute("name", value.getName());
                entry.setAttribute("age", value.getAge().toString());
                if (value.getHeight() != null) append(doc, entry, "height", value.getHeight().toString());
                if (value.getWeight() != null) append(doc, entry, "weight", value.getWeight().toString());
                if (value.getCourses() != null) {
                    Element courses = doc.createElement("courses"); entry.appendChild(courses);
                    for (Course course : value.getCourses()) {
                        Element c = append(doc, courses, "course", course.getGrade().toString());
                        c.setAttribute("name", course.getName());
                    }
                }
            }
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(file));
        } catch (Exception e) { throw new IllegalStateException("Cannot save XML", e); }
    }

	/**
	 * Implement this method to load from the XML file to create a `StudentCollection`
	 * HINT: `getAttribute(String name)`in `Element` can be used to get `name` and `age` properties
	 * @param file
	 * @return
	 */
	public static StudentCollection loadFromFile(File file) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            List<Student> result = new ArrayList<>();
            NodeList entries = doc.getDocumentElement().getElementsByTagName("student");
            for (int i = 0; i < entries.getLength(); i++) {
                Element entry = (Element) entries.item(i);
                Student value = new Student().withName(entry.getAttribute("name")).withAge(Integer.parseInt(entry.getAttribute("age")));
                NodeList heights = entry.getElementsByTagName("height");
                if (heights.getLength() > 0) value.withHeight(Integer.parseInt(heights.item(0).getTextContent()));
                NodeList weights = entry.getElementsByTagName("weight");
                if (weights.getLength() > 0) value.withWeight(Integer.parseInt(weights.item(0).getTextContent()));
                NodeList courses = entry.getElementsByTagName("course");
                for (int j = 0; j < courses.getLength(); j++) {
                    Element c = (Element) courses.item(j);
                    value.addCourse(new Course(c.getAttribute("name"), Integer.parseInt(c.getTextContent())));
                }
                result.add(value);
            }
            return new StudentCollection(result);
        } catch (Exception e) { throw new IllegalStateException("Cannot load XML", e); }
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof StudentCollection) {
			StudentCollection studentCollection = (StudentCollection) o;
			return this.students.equals(studentCollection.students);
		}

		return false;
	}
    private static Element append(Document doc, Element parent, String tag, String text) {
        Element child = doc.createElement(tag);
        child.setTextContent(text);
        parent.appendChild(child);
        return child;
    }
}
