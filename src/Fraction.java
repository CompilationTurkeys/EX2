
/**
 * represents a simplified fraction
 *
 */
public class Fraction {
	private int numerator;
	private int denominator;

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Fraction multiply(Fraction y) {

		return (new Fraction(this.numerator * y.numerator, this.denominator * y.denominator)).simplify();
	}

	public Fraction addition(Fraction y) {
		int commonDenominator = this.denominator * y.denominator;
		int newNumenator = this.numerator * y.denominator + y.numerator * this.denominator;
		return (new Fraction(newNumenator,commonDenominator)).simplify();
	}

	public Fraction subtraction(Fraction y) {
		int commonDenominator = this.denominator * y.denominator;
		int newNumenator = this.numerator * y.denominator - y.numerator * this.denominator;
		return (new Fraction(newNumenator,commonDenominator)).simplify();
	}

	public Fraction simplify() {
		int gcd = GCD(this.numerator, this.denominator);
		this.numerator /= gcd;
		this.denominator /= gcd;
		return this;
	}

	public int GCD(int a, int b) {
		return b==0 ? a : GCD(b, a%b);
	}
}