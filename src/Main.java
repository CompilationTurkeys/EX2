import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
	
	
	private static final int MAT_SIZE = 3;



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



	private static Matrix parseMatrixFile(String inputMatrixFileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(inputMatrixFileName)));
		
		String matString = br.readLine();
		
		String[] MatLines = mat.split(";");
		
		Fraction[][] matrix = new Fraction[MAT_SIZE][MAT_SIZE];
		
		return null;
	}

}




