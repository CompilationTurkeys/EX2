
public class Parser {
	public Lexer lexer;
	public int value;
	public Parser(Lexer lexer) {
	 this.lexer = lexer;	
	}
	
	public int Parse() {
		S();
		return this.value;
	}
	
	public void S() {
		switch(lexer.next_token()):
			
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
