
public class Matrix {
		
	Fraction[][] _matrix;
		
	private Matrix(Fraction[][] matrix){
			
	this._matrix=matrix;
			
	}
	
	public void rowAddition(int rowNum, Fraction[] rowToAdd)
	{
		this._matrix[rowNum][0]= this._matrix[rowNum][0].addition(rowToAdd[0]);
	}
	
}
