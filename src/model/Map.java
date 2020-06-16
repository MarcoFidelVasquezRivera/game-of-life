package model;

public class Map {

	private int[][] baseMatrix = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	private int[][] currentMatrix = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	public Map() {
		sincronizeMatrix();
	}
	
	public void updateMap() {
		int y = baseMatrix.length;
		int x = baseMatrix[0].length;
		
		for(int i=0;i<baseMatrix.length;i++) {
			
			for(int j=0;j<baseMatrix[i].length;j++) {
				int aliveNear = baseMatrix[Math.floorMod((i-1),y)] [Math.floorMod((j-1),x)]+ 
						 		baseMatrix[Math.floorMod((i-1),y)] [Math.floorMod((j),x)]+
								baseMatrix[Math.floorMod((i-1),y)] [Math.floorMod((j+1),x)]+
								baseMatrix[Math.floorMod((i),y)] [Math.floorMod((j-1),x)]+
								baseMatrix[Math.floorMod((i),y)] [Math.floorMod((j+1),x)]+
								baseMatrix[Math.floorMod((i+1),y)] [Math.floorMod((j-1),x)]+
								baseMatrix[Math.floorMod((i+1),y)] [Math.floorMod((j),x)]+
								baseMatrix[Math.floorMod((i+1),y)] [Math.floorMod((j+1),x)];

				if(aliveNear==3 && baseMatrix[i][j]==0) {
					currentMatrix[i][j] = 1;
					
				}else if((aliveNear>3 || aliveNear<2) && baseMatrix[i][j]==1) {
					currentMatrix[i][j] = 0;
				}
			}
		}
		sincronizeMatrix();
	}
	
	public void sincronizeMatrix() {
		
		for(int i=0;i<baseMatrix.length;i++) {
			for(int j=0;j<baseMatrix[i].length;j++) {
				baseMatrix[i][j] = currentMatrix[i][j];
			}
		}
		
		
	}
	
	public int[][] getCurrentMatrix() {
		return currentMatrix;
	}
	
}
