import java.io.FileReader;

public class Main {
	
	
	public static void main(String[] args) {
		
		String inputMatrixFileName = args[0];
		String rowOpsFileName = args[1];
		String outputMatrixFileName = args[2];
		
		Matrix inputMat = parseMatrixFile(inputMatrixFileName);
		
		
		try
         {
                 
                 //Lexer lexer = new Lexer(new FileReader(rowOpsFileName));
 
                // Symbol token = lexer.next_token();
                 
                 //while (token.sym != sym.EOF)
                 //{
                   //      token = lexer.next_token();
                 //}
         }
                      
         catch (Exception e)
         {
                 e.printStackTrace();
         }

		
		

	}



	private static Matrix parseMatrixFile(String inputMatrixFileName) {
		// TODO Auto-generated method stub
		return null;
	}

}




