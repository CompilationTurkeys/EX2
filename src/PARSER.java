
public class PARSER {
	class Frac {
		int numerator;
		int denominator;
		
		Frac(int numerator, int denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}
		
		Frac multiply(Frac y) {
			
			return (new Frac(this.numerator * y.numerator, this.denominator * y.denominator)).simplify();
		}
		
		Frac addition(Frac y) {
			int commonDenominator = this.denominator * y.denominator;
			int newNumenator = this.numerator * y.denominator + y.numerator * this.denominator;
			return (new Frac(newNumenator,commonDenominator)).simplify();
		}
		
		Frac subtraction(Frac y) {
			int commonDenominator = this.denominator * y.denominator;
			int newNumenator = this.numerator * y.denominator - y.numerator * this.denominator;
			return (new Frac(newNumenator,commonDenominator)).simplify();
		}
		
		Frac simplify() {
			int gcd = GCD(this.numerator, this.denominator);
			this.numerator /= gcd;
			this.denominator /= gcd;
			return this;
		}
		
		int GCD(int a, int b) { return b==0 ? a : GCD(b, a%b); }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}