
public class Grid {
	private int[][] grid;
	
	public Grid(){
		grid = new int[9][9];
	}
	
	public Grid(int[][] grid){
		this.grid = grid;
	}
	
	public int[][] getGrid(){
		return grid;
	}
	
	public int getPosition(int row, int column){
		return grid[row][column];
	}
	
	public void setPosition(int value, int row, int column){
		grid[row][column] = value;
	}
	
	public boolean inConflict(int value,int row,int column){
		for(int i=0;i<9;i++){
			if(grid[row][i]==value)
				return true;
			if(grid[i][column]==value)
				return true;
		}
		return subgridConflict(value, row, column);
	}
	
	public int[] getOpenPosition(){
		int[] coords = {-1,-1};
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(grid[i][j]==-1){
					coords[0]=i;
					coords[1]=j;
					return coords;
				}
			}
		}
		return coords;
	}
	
	public boolean subgridConflict(int value, int row, int column){
		int rowRange = 8;
		int colRange = 8;
		if(row/3.0<1)
			rowRange = 2;
		else if(row/3.0<2)
			rowRange=5;
		
		if(column/3.0<1)
			colRange = 2;
		else if(column/3.0<2)
			colRange = 5;
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(grid[rowRange-i][colRange-j]==value)
					return true;
			}
		}
		
		return false;
	}
}
