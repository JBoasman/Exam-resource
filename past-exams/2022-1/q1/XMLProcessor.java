import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XMLProcessor {

	private static final String STATE_ROOT_ELEMENT = "States";

	public static List<List<String>> read(String fileName) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(fileName));
            List<String> keys = new java.util.ArrayList<>(), states = new java.util.ArrayList<>();
            org.w3c.dom.NodeList children = doc.getDocumentElement().getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                org.w3c.dom.Node child = children.item(i);
                if (child instanceof org.w3c.dom.Element) { keys.add(child.getNodeName()); states.add(child.getTextContent()); }
            }
            return java.util.Arrays.asList(keys, states);
        } catch (Exception e) { throw new IllegalStateException("Cannot read states", e); }
    }

	public static void write(String fileName, List<String> keys, List<String> states) {
        if (keys.size() != states.size()) throw new IllegalArgumentException("Mismatched lists");
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            org.w3c.dom.Element root = doc.createElement(STATE_ROOT_ELEMENT); doc.appendChild(root);
            for (int i = 0; i < keys.size(); i++) {
                org.w3c.dom.Element child = doc.createElement(keys.get(i));
                child.setTextContent(states.get(i)); root.appendChild(child);
            }
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(new File(fileName)));
        } catch (Exception e) { throw new IllegalStateException("Cannot save states", e); }
    }
}
