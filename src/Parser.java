import java.io.IOException;

import java_cup.runtime.Symbol;

public class Parser {

	private Lexer   _lexer;
	private Symbol _tok;
	private int rowNum = 1;

	public Parser(Lexer lexer){
		this._lexer = lexer;
	}

	public void parse() throws IOException{
		S();
	}

	private void eat(int expectedToken) throws IOException{
		if (_tok.sym != expectedToken){
			System.out.println(String.format("ILLEGAL ROW OPERATION IN LINE %d",rowNum));
			System.out.println(String.format("Should be %s instead of %s", 
					getTokenName(expectedToken),getTokenName(_tok.sym)));
			System.exit(-1);
		}
	}

	private String getTokenName(int token) {
		switch(token){
			case (0):
				return "EOF";
			case (1):
				return "error";
			case (2):
				return "+";
			case (3):
				return "-";
			case (4):
				return "<-";
			case (5):
				return ">";
			case (6):
				return "R1";
			case (7):
				return "R2";
			case (8):
				return "R3";
			case (9):
				return "INT";
			case (10):
				return "LINE_TERMINATOR";
		}

		return null;
	}

	public void S() throws IOException {
		_tok = _lexer.next_token();
		switch(_tok.sym){
			case(sym.R1):
				_tok = _lexer.next_token();
				eat(sym.ARROW);
				A();
				break;
			case(sym.R2):
				_tok = _lexer.next_token();
				eat(sym.ARROW);
				B();
				break;
			case(sym.R3):
				_tok = _lexer.next_token();
				eat(sym.ARROW);
				C();
			break;
			default:
				System.out.println(String.format("ILLEGAL ROW OPERATION IN LINE %d",rowNum));
				System.out.println("Unexpected token: "+ getTokenName(_tok.sym));
				System.exit(-1);
			}
	}

	public void R() throws IOException {
		switch(_tok.sym){
		case (sym.R1):
		case (sym.R2):
		case (sym.R3):
			break;
		default:
			System.out.println(String.format("ILLEGAL ROW OPERATION IN LINE %d",rowNum));
			System.out.println("Unexpected token: "+ getTokenName(_tok.sym));
			System.exit(-1);

		}

	}

	public void A() throws IOException {
		_tok = _lexer.next_token();
		switch(_tok.sym){
			case (sym.R1):
				OP();
				F();
				endOfRowOperation((_tok=_lexer.next_token()).sym);
			break;
			case (sym.GTSIGN):
				_tok = _lexer.next_token();
				R();
				endOfRowOperation((_tok=_lexer.next_token()).sym);
				break;
			default:
				NUM();
				if (_tok.sym == sym.INTEGER) {
					_tok = _lexer.next_token();
				}
				eat(sym.R1);
				endOfRowOperation((_tok=_lexer.next_token()).sym);
				break;
			}
	}

	private void endOfRowOperation(int token) throws IOException {
		switch(token){
			case (sym.EOF):
				break;
			case (sym.LINE_TERMINATOR):
				rowNum++;
				S();
				break;
			default:
				System.out.println(String.format("ILLEGAL ROW OPERATION IN LINE %d",rowNum));
				System.out.println("Unexpected token: "+ getTokenName(_tok.sym));
				System.exit(-1);
			}
	}

	public void B() throws IOException {
		_tok = _lexer.next_token();
		switch(_tok.sym){
			case (sym.R2):
				OP();
				F();
				endOfRowOperation((_tok=_lexer.next_token()).sym);
				break;
			case (sym.GTSIGN):
				_tok = _lexer.next_token();
				R();
				endOfRowOperation((_tok=_lexer.next_token()).sym);
				break;
			default:
				NUM();
				if (_tok.sym == sym.INTEGER) {
					_tok = _lexer.next_token();
				}
				eat(sym.R2);
				endOfRowOperation((_tok=_lexer.next_token()).sym);
				break;
			}
	}

	public void C() throws IOException {
		_tok = _lexer.next_token();
		switch(_tok.sym){
		case (sym.R3):
			OP();
			F();
			endOfRowOperation((_tok=_lexer.next_token()).sym);
			break;
		case (sym.GTSIGN):
			_tok = _lexer.next_token();
			R();
			endOfRowOperation((_tok=_lexer.next_token()).sym);
		break;
		default:
			NUM();
			if (_tok.sym == sym.INTEGER) {
				_tok = _lexer.next_token();
			}
			eat(sym.R3);
			endOfRowOperation((_tok=_lexer.next_token()).sym);
			break;
		}
	}

	public void NUM() throws IOException {
		switch (_tok.sym){
		case (sym.MINUS):
			_tok = _lexer.next_token();
			eat(sym.INTEGER);
			FRAC();
			break;
		case (sym.INTEGER):
			FRAC();
			break;
		default:
			System.out.println(String.format("ILLEGAL ROW OPERATION IN LINE %d",rowNum));
			System.out.println("Unexpected token: "+ getTokenName(_tok.sym));
			System.exit(-1);
		}

	}


	public void FRAC() throws IOException {
		_tok = _lexer.next_token();
		switch(_tok.sym){
		case (sym.DIV):
			_tok = _lexer.next_token();
			eat(sym.INTEGER);
			break;
		case(sym.R1):
		case(sym.R2):
		case(sym.R3):
			break;
		}
	}


	public void F() throws IOException {
		_tok = _lexer.next_token();
		switch (_tok.sym){
		case (sym.INTEGER):
			FRAC();
			if (_tok.sym == sym.INTEGER) {
				_tok = _lexer.next_token();
			}
			R();
			break;
		default:
			System.out.println(String.format("ILLEGAL ROW OPERATION IN LINE %d",rowNum));
			System.out.println("Unexpected token: "+ getTokenName(_tok.sym));
			System.exit(-1);
		}

	}


	public void OP() throws IOException {
		_tok = _lexer.next_token();
		switch (_tok.sym){
		case (sym.PLUS):
		case (sym.MINUS):
			break;
		default:
			System.out.println(String.format("ILLEGAL ROW OPERATION IN LINE %d",rowNum));
			System.out.println("Unexpected token: "+ getTokenName(_tok.sym));
			System.exit(-1);
		}
	}
}
