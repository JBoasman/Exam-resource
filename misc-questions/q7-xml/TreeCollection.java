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
 The goal of this task it to write a program that loads/stores a list of trees in XML format. `TreeCollection.java` class contains a
 list of `Tree` instances. Each tree has its own `kind`, which needs to be saved as an attribute of XML node. Additionally, each tree
 can have three possible properties: `dimension`, `color` and `types`. `dimension` property has two integer attributes: `diameter` and
 `height`. `types` property has a list of `type` elements. Note that not every tree has all three properties. Some properties of trees
 may be missing (for example, see the test cases in TreesTest.java). You job is to implement the below methods in `TreeCollection.java`:

* `saveToFile`
* `loadFromFile`

Note that these methods should take into account the available properties of a given tree. You are allowed to add additional asserts
and test cases to test your solutions. You can use `getAttribute(String name)` and `setAttribute(String name, String value)` of `Element`
class to get and set the attributes of XML node. **Please upload `TreeCollection.java` file to wattle!**
 *
 */
public class TreeCollection {

	private final List<Tree> trees;

	public TreeCollection(List<Tree> trees) {
		this.trees = trees;
	}

	public List<Tree> getTrees() {
		return trees;
	}

	/**
	 * Implement this method to save the list of trees to XML file
	 * HINT: `setAttribute(String name, String value)` in `Element` can be used to set `kind`, `diameter` and `height` properties
	 * @param file
	 */
	public void saveToFile(File file) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = doc.createElement("trees");
            doc.appendChild(root);
            for (Tree value : trees) {
                Element entry = doc.createElement("tree");
                root.appendChild(entry);
                entry.setAttribute("kind", value.getKind());
                if (value.getDimension() != null) {
                    Element dim = doc.createElement("dimension");
                    dim.setAttribute("diameter", value.getDimension().getDiameter().toString());
                    dim.setAttribute("height", value.getDimension().getHeight().toString());
                    entry.appendChild(dim);
                }
                if (value.getColor() != null) append(doc, entry, "color", value.getColor());
                if (value.getTypes() != null) {
                    Element types = doc.createElement("types"); entry.appendChild(types);
                    for (String type : value.getTypes()) append(doc, types, "type", type);
                }
            }
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(file));
        } catch (Exception e) { throw new IllegalStateException("Cannot save XML", e); }
    }

	/**
	 * Implement this method to load from the XML file to create a `TreeCollection`
	 * HINT: `getAttribute(String name)`in `Element` can be used to get `kind`, `diameter` and `height` properties
	 * @param file
	 * @return
	 */
	public static TreeCollection loadFromFile(File file) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            List<Tree> result = new ArrayList<>();
            NodeList entries = doc.getDocumentElement().getElementsByTagName("tree");
            for (int i = 0; i < entries.getLength(); i++) {
                Element entry = (Element) entries.item(i);
                Tree value = new Tree().withKind(entry.getAttribute("kind"));
                NodeList dims = entry.getElementsByTagName("dimension");
                if (dims.getLength() > 0) {
                    Element d = (Element) dims.item(0);
                    value.withDimension(new Dimension(Integer.parseInt(d.getAttribute("diameter")), Integer.parseInt(d.getAttribute("height"))));
                }
                NodeList colors = entry.getElementsByTagName("color");
                if (colors.getLength() > 0) value.withColor(colors.item(0).getTextContent());
                NodeList types = entry.getElementsByTagName("type");
                for (int j = 0; j < types.getLength(); j++) value.addType(types.item(j).getTextContent());
                result.add(value);
            }
            return new TreeCollection(result);
        } catch (Exception e) { throw new IllegalStateException("Cannot load XML", e); }
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof TreeCollection) {
			TreeCollection treeCollection = (TreeCollection) o;
			return this.trees.equals(treeCollection.trees);
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
