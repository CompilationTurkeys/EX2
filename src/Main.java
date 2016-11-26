import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java_cup.runtime.*;

public class Main {

	private static final int MAT_SIZE = 3;

	public static void main(String[] args) {
		
		String inputMatrixFileName = args[0];
		String rowOpsFileName = args[1];
		String outputMatrixFileName = args[2];
		Matrix inputMat = null;
		
		try {
			inputMat = parseMatrixFile(inputMatrixFileName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		try{
                 
			Lexer lexer = new Lexer(new FileReader(rowOpsFileName));
 			
			Parser parser = new Parser(lexer, inputMat);
			
			Fraction[][] outputMat = parser.parse();
                                  
			writeMatToFile(outputMat, outputMatrixFileName);
         
                      
		}catch (Exception e){
			 e.printStackTrace();
        }
	}



	private static void writeMatToFile(Fraction[][] outputMat, String outputMatrixFileName) {
			
	}



	private static Matrix parseMatrixFile(String inputMatrixFileName) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(new File(inputMatrixFileName)));
		
		String matString = br.readLine();
		
		matString.substring(1, matString.length()-1);
		
		String[] MatLines = matString.split(";");
		
		Fraction[][] matrix = new Fraction[MAT_SIZE][MAT_SIZE];
		
		for (int i=0; i<MAT_SIZE; i++){
			String[] matLine = MatLines[i].split(" ");
			for (int j=0; j<MAT_SIZE; j++){
				Fraction tempFrac;
				if (matLine[j].indexOf('/') >= 0){
					String[] components = matLine[j].split("/");
					tempFrac = new Fraction(Integer.valueOf(components[0]),Integer.valueOf(components[1]));
				}
				else{
					tempFrac = new Fraction(Integer.valueOf(matLine[j]), 1);
				}
				matrix[i][j] = tempFrac;
			}
		}
		
		return new Matrix(matrix);
	}

}




