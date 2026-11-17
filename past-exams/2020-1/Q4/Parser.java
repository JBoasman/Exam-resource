/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * Implement a parser to extract the columns and values from tokens and execute
 * the SQL command to insert new customers. Do not insert customers if the
 * following errors are found: 
 * 1 - some brackets are missing 
 * 2 - some columnnames are wrong
 * 
 * Please see the columns names in Customer.java file. Please see test cases in
 * ParserTest.java
 */
public class Parser {

	Tokeniser tokeniser;
	XMLTable table;

	public Parser(Tokeniser tokeniser, XMLTable table) {
		this.tokeniser = tokeniser;
		this.table = table;
	}

	/**
	 * Extract the columns and values from tokens and execute the SQL command to insert new customers
	 */
	public void parseExp() {
        Token insert = tokeniser.takeNext(), values = tokeniser.takeNext();
        if (insert == null || values == null || insert.type != Token.Type.INSERT_INTO || values.type != Token.Type.VALUES || tokeniser.hasNext()) return;
        int bracket = insert.value.indexOf('(');
        String tableName = insert.value.substring(0, bracket).trim();
        String[] columns = insert.value.substring(bracket + 1, insert.value.length() - 1).split(",");
        String[] data = values.value.substring(1, values.value.length() - 1).split(",(?=(?:[^']*'[^']*')*[^']*$)", -1);
        if (columns.length != data.length) return;
        Customer customer = new Customer();
        boolean hasId = false;
        try {
            for (int i = 0; i < columns.length; i++) {
                String value = data[i].trim();
                if (value.startsWith("'") && value.endsWith("'")) value = value.substring(1, value.length() - 1);
                switch (columns[i].trim()) {
                    case Customer.KEY_ID: customer.setId(Integer.parseInt(value)); hasId = true; break;
                    case Customer.KEY_NAME: customer.setName(value); break;
                    case Customer.KEY_ADDRESS: customer.setAddress(value); break;
                    case Customer.KEY_CITY: customer.setCity(value); break;
                    case Customer.KEY_POSTCODE: customer.setPostCode(value); break;
                    case Customer.KEY_COUNTRY: customer.setCountry(value); break;
                    default: return;
                }
            }
        } catch (NumberFormatException e) { return; }
        if (hasId) table.insert(tableName, customer);
    }
}
