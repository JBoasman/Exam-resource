package Q2;

public class MDTokenizer {
    String buffer;
    MDToken current = null;

    public MDTokenizer(String mdContent) {
        this.buffer = mdContent;
    }

    public boolean hasNext() {
        return !buffer.isBlank();
    }


    public MDToken next() {
        while (!buffer.isEmpty()) {
            int newline = buffer.indexOf('\n');
            String line = newline < 0 ? buffer : buffer.substring(0, newline);
            buffer = newline < 0 ? "" : buffer.substring(newline + 1);
            if (line.isBlank()) continue;
            int spaces = 0; while (spaces < line.length() && line.charAt(spaces) == ' ') spaces++;
            int level = spaces / 4 + 1;
            String item = line.substring(spaces).trim();
            if (item.startsWith("- ")) current = new MDToken(MDTokenType.UNORDERED_ITEM, item.substring(2), level);
            else {
                int dot = item.indexOf('.');
                current = new MDToken(MDTokenType.ORDERED_ITEM, item.substring(dot + 1).trim(), Integer.parseInt(item.substring(0, dot)), level);
            }
            return current;
        }
        current = null; return null;
    }


    public MDToken getCurrent() {
        return this.current;
    }



}
