
public class Parser {
	
	public Lexer 		_lexer;
	public Fraction[][] _outputMatrix;
	public Matrix 		_inputMatrix;
	public static final int MAT_SIZE = 3;

	public Parser(Lexer lexer, Matrix inputMat){
		this._lexer = lexer;
		this._outputMatrix = new Fraction[MAT_SIZE][MAT_SIZE];
		this._inputMatrix = inputMat;
	}
	
	public Fraction[][] parse(){
		S();
		return _outputMatrix;	
	}
	
	public void S() {
		
	}

	public void R() {
		
	}
	
	public void A() {
		
	}
	
	public void B() {
		
	}
	
	public void C() {
		
	}
	
	public void NUM() {
		
	}
	
	
	public void SIGN() {
		
	}
	
	
	public void FRAC() {
		
	}
	
	
	public void F() {
		
	}
	
	
	public void OP() {
		
	}
}
