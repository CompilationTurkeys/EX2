
public class Matrix {
		
	Fraction[][] _matrix;
		
	public Matrix(Fraction[][] matrix){
			
		this._matrix=matrix;
			
	}
	
	public void rowAddition(int row1, int row2, Fraction factor)
	{
		for(int i=0;i<3;i++)
		{
			this._matrix[row1][i]= _matrix[row1][i].addition(this._matrix[row2][i].multiply(factor));
		}
	}
	
	public void rowMultiply(int row, Fraction factor){
		for(int i=0;i<3;i++)
		{
			this._matrix[row][i]= this._matrix[row][i].multiply(factor);
		}
	}
	
	public void switchRows(int row1, int row2)
	{
		for(int i=0;i<3;i++){
			Fraction temp=this._matrix[row1][i];
			this._matrix[row1][i]=this._matrix[row2][i];
			this._matrix[row2][i]=temp;
		}

	}
	
	public void putRow(int row1, int row2)
	{
		for(int i=0;i<3;i++){
			this._matrix[row1][i]=this._matrix[row2][i];
		}

	}
	
}
