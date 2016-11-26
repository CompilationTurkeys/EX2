import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	private static final int MAT_SIZE = 3;

	public static void main(String[] args) {
		
		String inputMatrixFileName = args[0];
		String rowOpsFileName = args[1];
		String outputMatrixFileName = args[2];
		Matrix inputMat = null;
		Matrix outputMat = null;
		
		try {
			inputMat = parseMatrixFile(inputMatrixFileName);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		try{
                 
			Lexer lexer = new Lexer(new FileReader(rowOpsFileName));
 			
			Parser parser = new Parser(lexer, inputMat);
			parser.parse();
			outputMat = parseRowOps(rowOpsFileName, inputMat);
			writeMatToFile(outputMat._matrix, outputMatrixFileName);
         
                      
		}catch (Exception e){
			 e.printStackTrace();
        }
		
		System.out.println("Completed successfully.Output saved in " + outputMatrixFileName);

	}



	private static void writeMatToFile(Fraction[][] outputMat, String outputMatrixFileName) throws IOException {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(outputMatrixFileName)));
			bw.write("[");
			for (int i=0 ; i<MAT_SIZE ; i++){
				for (int j=0;j<MAT_SIZE;j++){
					bw.write(outputMat[i][j].toString() + " ");
				}
				if (i<MAT_SIZE-1){
					bw.write(";");
				}
			}
			bw.write("]");
			bw.close();
	}



	private static Matrix parseMatrixFile(String inputMatrixFileName) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(new File(inputMatrixFileName)));
		
		String matString = br.readLine();
		
		matString = matString.substring(1, matString.length()-1);
		
		String[] MatLines = matString.split("; ");
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
		br.close();
		return new Matrix(matrix);
	}

	private static Matrix parseRowOps(String RowOperationsFileName, Matrix inputMatrix) throws IOException {
				
		BufferedReader br = new BufferedReader(new FileReader(new File(RowOperationsFileName)));
		String opsString;
				
		Fraction[][] matrix = new Fraction[MAT_SIZE][MAT_SIZE];

		while((opsString = br.readLine()) != null) { // iterate over lines of operations
			opsString = opsString.replaceAll(" ","");
			int curRow;
			int newRow;
			int newRow2;
			curRow = Character.getNumericValue(opsString.charAt(1)) - 1;
			
			if(opsString.charAt(4) == '>') { // case it's switching - R1<->R2
				newRow = Character.getNumericValue(opsString.charAt(6)) - 1;
				inputMatrix.switchRows(curRow, newRow);
			}
			else { // case it's R1<-R2 or R1<-(FRAC)R1 or R1<-R1(OP)(FRAC)R2
//				
//				if(opsString.charAt(4) == 'R'&&  curRow != (newRow = Character.getNumericValue(opsString.charAt(5)))) { 
//					inputMatrix.putRow(curRow, newRow);// case it's R1<-R2
//				}
				if(curRow == (newRow = Character.getNumericValue(opsString.charAt(5) -1))) { // R1<-R1(OP)(FRAC)R2
					// R1<-R1(OP)(FRAC)R2
					char op = opsString.charAt(6);
					String secondRow = opsString.substring(7);
					Fraction factor = new Fraction(secondRow.split("R")[0]);
					newRow2 = Integer.parseInt(secondRow.split("R")[1]) - 1;
					if(op == '+') {
						inputMatrix.rowAddition(curRow, newRow2, factor);
					}
					else { // op is '-'
						inputMatrix.rowSubtraction(curRow, newRow2, factor);
					}
					
				}
				else { // R1<-(FRAC)R1
					String rightSide = opsString.split("<-")[1];
					Fraction factor = new Fraction(rightSide.split("R")[0]);
					inputMatrix.rowMultiply(curRow, factor);
				}
			}
		}
		
		br.close();
		return inputMatrix;
	}
}




