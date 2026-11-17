
public class Division extends Operation {

	public Division(double a, double b) {
		super(a, b);
	}

	@Override
	public double evaluate() {

		//START YOUR CODE
		if (this.b == 0) {
			throw new ArithmeticException("Can not divide by 0");
		}
		return this.a / this.b;
		//END YOUR CODE
	}
}
