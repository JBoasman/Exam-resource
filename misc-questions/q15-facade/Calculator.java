public class Calculator {

	public double add(double a, double b) {

		//START YOUR CODE
		Operation x = new Addition(a, b);
		return x.evaluate();
		//END YOUR CODE
	}

	public double subtract(double a, double b) {

		//START YOUR CODE
		Operation x = new Subtraction(a, b);
		return x.evaluate();

		//END YOUR CODE
	}

	public double multiply(double a, double b) {

		//START YOUR CODE
		Operation x = new Multiplication(a, b);
		return x.evaluate();

		//END YOUR CODE
	}

	public double divide(double a, double b) {

		//START YOUR CODE
		Operation x = new Division(a, b);
		return x.evaluate();

		//END YOUR CODE
	}
}
