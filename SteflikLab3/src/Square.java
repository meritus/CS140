
public class Square
{
	int[][] square;
	
	Square(int[][] n)
	{
		square = new int[4][4];
	}
	
	int addCol(int col)
	{
		int sum=0;
		for(int i=0;i<square.length;i++)
			sum+=square[i][col];
		return sum;
	}
	
	int addRow(int row)
	{
		int sum=0;
		for(int i=0;i<square.length;i++)
			sum+=square[row][i];
		return sum;
	}
	
	int addMajorDiag()
	{
		int sum=0;
		for(int i=0;i<square.length;i++)
			sum+=square[i][i];
		return sum;
	}
	
	int addMinorDiag()
	{
		int sum=0;
		for(int i=0;i<square.length;i++)
			sum+=square[square.length-i][square.length-i];
		return sum;
	}
	
	boolean isMagic()
	{
		boolean is_magic = true;
		int sum = addMajorDiag();
		for(int i=0; i<square.length;i++)
		{
			if(sum!=addRow(i)||sum!=addCol(i))
			{
				is_magic=false;
				break;
			}
		}
		return sum==addMinorDiag();
	}
}
