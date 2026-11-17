import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.*;


public class LocationLoader {


    /**
     * Task (A) - Load location data as a map of names to populations.
     */
    public static Map<String, Integer> loadPopulationInfo(File f) {
        try {
            Element root = documentRoot(f);
            Map<String, Integer> result = new LinkedHashMap<>();
            for (Element location : elements(root)) {
                if (!location.hasAttribute("name")) return null;
                Integer population = null;
                boolean seen = false;
                for (Element child : elements(location)) {
                    if (!child.getTagName().equals("Population") || seen || !elements(child).isEmpty()) return null;
                    seen = true;
                    if (!child.getTextContent().isBlank()) population = Integer.valueOf(child.getTextContent().trim());
                }
                result.put(location.getAttribute("name"), population);
            }
            return result;
        } catch (Exception e) { return null; }
    }


    /**
     * Task (B) - Load a tree of locations from a hierarchical XML.
     * @return the set of locations represented by the direct children
     *         in a valid format of the root <Locations> .
     */
    public static Set<Location> loadLocations(File f) {
        try {
            Set<Location> result = new LinkedHashSet<>();
            for (Element child : elements(documentRoot(f))) {
                Location location = location(child);
                if (location != null) result.add(location);
            }
            return result;
        } catch (Exception e) { return null; }
    }

    private static Element documentRoot(File file) throws Exception {
        Element root = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file).getDocumentElement();
        if (!root.getTagName().equals("Locations")) throw new IllegalArgumentException("Expected Locations root");
        return root;
    }
    private static List<Element> elements(Element parent) {
        List<Element> result = new ArrayList<>();
        NodeList nodes = parent.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) if (nodes.item(i) instanceof Element e) result.add(e);
        return result;
    }
    private static Location location(Element element) {
        if (!element.hasAttribute("name")) return null;
        Location location = new Location(element.getTagName(), element.getAttribute("name"));
        if (!element.getAttribute("population").isBlank()) location.population = Integer.valueOf(element.getAttribute("population").trim());
        for (Element child : elements(element)) {
            Location nested = location(child);
            if (nested != null) location.addChild(nested);
        }
        return location;
    }
}
