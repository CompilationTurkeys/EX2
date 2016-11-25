import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main {


	private static final int MAT_SIZE = 3;



	public static void main(String[] args) {

		String inputMatrixFileName = args[0];
		String rowOpsFileName = args[1];
		String outputMatrixFileName = args[2];

		try {
			Matrix inputMat = parseMatrixFile(inputMatrixFileName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


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

		matString.substring(1, matString.length()-1);

		String[] matLines = matString.split(";");

		Fraction[][] matrix = new Fraction[MAT_SIZE][MAT_SIZE];
		for (int i=0; i<matLines.length; i++) {
			String[] componets = matLines[i].split(" ");

			for (int j=0; j<componets.length;j++){
				boolean isNegative = false; 
				if (componets[j].startsWith("-")){
					componets[j] = componets[j].substring(1);
					isNegative = true;
				}
				String[] fraction = componets[j].split("/");
				Fraction frac;
				if (fraction.length>1){
					frac = isNegative ?  new Fraction(
							-1 *Integer.parseInt(fraction[0]),Integer.parseInt(fraction[1]))
							: new Fraction(Integer.parseInt(fraction[0]), Integer.parseInt(fraction[1]));
				}
				else {
					frac = isNegative ?  new Fraction(
							-1 *Integer.parseInt(fraction[0]),1)
							: new Fraction(Integer.parseInt(fraction[0]), 1);
				}
				
				matrix[i][j] = frac;
			};

		};

		br.close();
		return new Matrix(matrix);
	}

}
