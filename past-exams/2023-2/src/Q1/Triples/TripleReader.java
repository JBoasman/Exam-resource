import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;


public class TripleReader {

    /**
     * Question 1a) Read and create the triple objects from the XML File,
     * (You may assume the XML and the triples, entities so represented is in a VALID format)
     * <p>
     * Note: you may use any `java.io` packages
     * <p>
     * Return the set of triples corresponding to the XML file, or
     * null in the event of an exception. Not that there will NOT be cases of invalid input
     * (it is just to specify that this method must NOT throw an exception).
     */
    public static Set<Triple> read(String filePath) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(filePath);
            Set<Triple> result = new LinkedHashSet<>();
            NodeList nodes = doc.getElementsByTagName("triple");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element e = (Element) nodes.item(i);
                result.add(new Triple(
                    new TripleComponent(TripleComponent.TripleComponentType.SUBJECT, e.getElementsByTagName("subject").item(0).getTextContent()),
                    new TripleComponent(TripleComponent.TripleComponentType.PREDICATE, e.getElementsByTagName("predicate").item(0).getTextContent()),
                    new TripleComponent(TripleComponent.TripleComponentType.OBJECT, e.getElementsByTagName("object").item(0).getTextContent())));
            }
            return result;
        } catch (Exception e) { return null; }
    }


}