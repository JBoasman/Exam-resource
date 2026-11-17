public class Parser {
    Tokeniser tokeniser;

    public Parser(Tokeniser tokeniser) {
        this.tokeniser = tokeniser;
    }


    /**
     * Task (B)
     * Parse the tokens and return the corresponding Exp, or return
     * null if it does not represent not a valid Exp.
     */
    public Exp parse() {
        java.util.List<Exp> expressions = new java.util.ArrayList<>();
        while (tokeniser.hasNext()) {
            Exp expression = single();
            if (expression == null) return null;
            expressions.add(expression);
            if (!tokeniser.hasNext()) break;
            Token separator = tokeniser.takeNext();
            if (separator == null || separator.getType() != TokenType.EOL) return null;
        }
        if (expressions.isEmpty()) return null;
        return expressions.size() == 1 ? expressions.get(0) : new SeqExp(expressions);
    }

    private Exp single() {
        Token value = tokeniser.takeNext();
        if (value == null) return null;
        Exp left;
        if (value.getType() == TokenType.VARIABLE) left = new VarExp(value.getValue());
        else if (value.getType() == TokenType.INT) {
            try { left = new IntExp(Integer.valueOf(value.getValue())); } catch (NumberFormatException e) { return null; }
        } else return null;
        Token next = tokeniser.next();
        if (next == null || next.getType() != TokenType.OPERATOR) return left;
        tokeniser.takeNext();
        Exp right = single();
        if (right == null) return null;
        OpExp.OpType op = switch (next.getValue()) { case "+" -> OpExp.OpType.ADD; case "-" -> OpExp.OpType.SUBTRACT; default -> OpExp.OpType.MULTIPLY; };
        return new OpExp(left, op, right);
    }
}
