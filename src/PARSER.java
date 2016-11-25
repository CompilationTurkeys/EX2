
public class PARSER {
	
	/**
	 * represents a simplified fraction
	 * @author bktomer
	 *
	 */
	private class Fraction {
		int numerator;
		int denominator;

		private Fraction(int numerator, int denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}

		private Fraction multiply(Fraction y) {

			return (new Fraction(this.numerator * y.numerator, this.denominator * y.denominator)).simplify();
		}

		private Fraction addition(Fraction y) {
			int commonDenominator = this.denominator * y.denominator;
			int newNumenator = this.numerator * y.denominator + y.numerator * this.denominator;
			return (new Fraction(newNumenator,commonDenominator)).simplify();
		}

		private Fraction subtraction(Fraction y) {
			int commonDenominator = this.denominator * y.denominator;
			int newNumenator = this.numerator * y.denominator - y.numerator * this.denominator;
			return (new Fraction(newNumenator,commonDenominator)).simplify();
		}

		private Fraction simplify() {
			int gcd = GCD(this.numerator, this.denominator);
			this.numerator /= gcd;
			this.denominator /= gcd;
			return this;
		}

		private int GCD(int a, int b) {
			return b==0 ? a : GCD(b, a%b);
		}
	}

	
	
	public static void main(String[] args) {
		
		String inputMatrixFileName = args[0];
		String rowOpsFileName = args[1];
		String outputMatrixFileName = args[2];
		
		

	}

}




