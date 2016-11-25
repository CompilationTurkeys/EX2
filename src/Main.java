
public class Main {
	
	public Matrix inputMat
	
	/**
	 * represents a simplified fraction
	 * @author bktomer
	 *
	 */
	public class Fraction {
		private int numerator;
		private int denominator;

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

	
	
	public static void main(String[] args) {
		
		String inputMatrixFileName = args[0];
		String rowOpsFileName = args[1];
		String outputMatrixFileName = args[2];
		
		
		
		try
         {
                 
                 Lexer lexer = new Lexer(new FileReader(argv[0]));
 
                 Symbol token = lexer.next_token();
                 
                 while (token.sym != sym.EOF)
                 {
                         token = lexer.next_token();
                 }
         }
                      
         catch (Exception e)
         {
                 e.printStackTrace();
         }

		
		

	}

}




