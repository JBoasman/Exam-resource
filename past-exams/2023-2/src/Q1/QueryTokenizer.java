public class QueryTokenizer {
    String buffer;

    public QueryTokenizer(String buffer) {
        this.buffer = buffer;
    }

    public boolean hasNext() {
        return this.buffer.trim().length() > 0;
    }


    /**
     *  Question 1(b). Returns the SELECT Token if a valid SELECT statement was found, or null otherwise.
     *  <p>
     *  You may also update the buffer to get prepared for the subsequent tokenization tasks.
     *      The updates do not need to be precise as long as it does not wrongly remove information
     *      (i.e., you could choose to not update the buffer here too)
     */
    public QToken getSelectTokenIfValid() {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("^\\s*SELECT\\s+(\\?subject|\\?predicate|\\?object|triple)(?=\\s|$)").matcher(buffer);
        if (!matcher.find()) return null;
        String target = matcher.group(1);
        buffer = buffer.substring(matcher.end());
        return new QToken(QTokenType.SELECT, TripleComponent.TripleComponentType.valueOf(target.replace("?", "").toUpperCase(java.util.Locale.ROOT)));
    }


    /**
     *  Question 1(c). Determine whether the WHERE statement for search is valid.
     *  <p>
     *  You may also update the buffer to get prepared for the subsequent tokenization tasks.
     *      The updates do not need to be precise as long as it does not wrongly remove information
     *      (i.e., you could choose to not update the buffer here too)
     */
    public boolean whereIsValid() {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("^\\s*WHERE\\s+\\{\\s+([^{}]*?)\\s+}\\s*$", java.util.regex.Pattern.DOTALL).matcher(buffer);
        if (!matcher.matches()) return false;
        buffer = matcher.group(1).trim();
        return true;
    }


    /**
     *  Question 1(d). Return the next (WHERE_*) QToken for search.
     */
    public QToken next() {
        buffer = buffer.trim();
        if (buffer.isEmpty()) return null;
        String value = buffer.split("\\s+", 2)[0];
        buffer = buffer.substring(value.length());
        if (value.equals("?subject") || value.equals("?predicate") || value.equals("?object"))
            return new QToken(QTokenType.WHERE_ANY, TripleComponent.TripleComponentType.valueOf(value.substring(1).toUpperCase(java.util.Locale.ROOT)));
        if (value.matches("[a-zA-Z0-9:/_.]+")) return new QToken(value);
        return null;
    }





}
