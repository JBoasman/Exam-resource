import java.util.List;
import java.util.Set;

public class QueryParser {

    /**
     *  Question 1(e). Given the List of QTokens (representing tokens for the search) and
     *  Set of triples available,
     *  return the corresponding set of objects if the search query adhere to the CFG,
     *  or return null otherwise.
     */
    public static Set<Object> parse(List<QToken> tokens, Set<Triple> triples) {
        if (tokens == null || tokens.size() < 2 || tokens.size() > 4 || tokens.contains(null)) return null;
        QToken select = tokens.get(0);
        if (select.getqTokenType() != QTokenType.SELECT || select.getElemType() == null) return null;
        TripleComponent.TripleComponentType[] types = {TripleComponent.TripleComponentType.SUBJECT, TripleComponent.TripleComponentType.PREDICATE, TripleComponent.TripleComponentType.OBJECT};
        for (int i = 1; i < tokens.size(); i++) {
            QToken token = tokens.get(i);
            if (token.getqTokenType() == QTokenType.WHERE_ANY) {
                if (token.getElemType() != types[i - 1]) return null;
            } else if (token.getqTokenType() != QTokenType.WHERE_MATCH || token.getValue() == null) return null;
        }
        Set<Object> result = new java.util.LinkedHashSet<>();
        for (Triple triple : triples) {
            TripleComponent[] components = {triple.getSubject(), triple.getPredicate(), triple.getObject()};
            boolean matches = true;
            for (int i = 1; i < tokens.size(); i++)
                if (tokens.get(i).getqTokenType() == QTokenType.WHERE_MATCH && !components[i - 1].getValue().equals(tokens.get(i).getValue())) matches = false;
            if (matches) result.add(switch (select.getElemType()) {
                case SUBJECT -> triple.getSubject(); case PREDICATE -> triple.getPredicate(); case OBJECT -> triple.getObject(); case TRIPLE -> triple;
            });
        }
        return result;
    }


}
