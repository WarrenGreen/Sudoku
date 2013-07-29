
public class Solver {
	public Grid grid;
	public Solver(Grid grid){
		this.grid = grid;
	}
	
	public void print(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(grid.getPosition(i,j)+"|");
			}
			System.out.println("");
		}
	}
	
	public boolean solve(){
		int[] coords = grid.getOpenPosition();
		if(coords[0]==-1 || coords[1]==-1)
			return true;
		
		for(int i=1;i<=9;i++){
			if(!grid.inConflict(i, coords[0],coords[1])){
				grid.setPosition(i, coords[0], coords[1]);
				if(solve()) return true;
				grid.setPosition(-1, coords[0], coords[1]);
			}
		}
		
		return false;
	}
	
	public static void main(String args[]){
		int[][] puzzle =   {{-1,-1, 6, 5,-1, 8, 4,-1,-1},
							{ 5, 2,-1,-1,-1,-1,-1,-1,-1},
							{-1, 8, 7,-1,-1,-1,-1, 3, 1},
							{-1,-1, 3,-1, 1,-1,-1, 8,-1},
							{ 9,-1,-1, 8, 6, 3,-1,-1, 5},
							{-1, 5,-1,-1, 9,-1, 6,-1,-1},
							{ 1, 3,-1,-1,-1,-1, 2, 5,-1},
							{-1,-1,-1,-1,-1,-1,-1, 7, 4},
							{-1,-1, 5, 2,-1, 6, 3,-1,-1}};
		Solver sudukoSolver = new Solver(new Grid(puzzle));
		sudukoSolver.solve();
		sudukoSolver.print();
	}
}
