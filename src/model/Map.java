package model;

public class Map {

	private int[][] baseMatrix = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	private int[][] currentMatrix = baseMatrix;
	
	public Map() {
		
	}
	
	public void updateMap() {
		for(int i=0;i<baseMatrix.length;i++) {
			
			for(int j=0;j<baseMatrix[i].length;j++) {
				int aliveNear = getAliveNear(i,j);
				System.out.println("ddddd");
				if(aliveNear==3 && baseMatrix[i][j]==0) {
					currentMatrix[i][j] = 1;
					
				}else if(aliveNear!=3 && aliveNear!=2 && baseMatrix[i][j]==1) {
					currentMatrix[i][j] = 0;
				}
			}
		}

		System.out.println("termina el update");
	}
	
	public int getAliveNear(int i,int j) {
		int aliveNear = 0;		
		aliveNear+=getNearAbove(i,j)+getNearBelow(i,j)+getNearCenter(i,j);

		return aliveNear;
	}
	
	public int getNearAbove(int y,int x) {
		System.out.println("entra a above");
		int aliveNear = 0;
		int i = 0;
		int k;
		for(int j=x-1;j<=x+1;j++) {
			if(y-1<0) {
				i = baseMatrix.length-1;
			}else {
				i = y;
			}
			System.out.println("centro del above");
			if(j<0) {
				k = baseMatrix[i].length-1;
			}else if(j>baseMatrix[i].length-1) {
				k = 0;
			}else {
				k = j;
			}
			
			if(baseMatrix[i][k]==1) {
				aliveNear++;
			}
		}
		System.out.println("termina el above");
		return aliveNear;
	}
	
	public int getNearBelow(int y,int x) {
		int aliveNear = 0;
		int i = 0;
		int k;
		for(int j=x-1;j<=x+1;j++) {
			if(y+1>baseMatrix.length-1) {
				i = 0;
			}else {
				i = y;
			}
			
			if(j<0) {
				k = baseMatrix[i].length-1;
			}else if(j>baseMatrix[i].length-1) {
				k = 0;
			}else {
				k = j;
			}
			
			if(baseMatrix[i][k]==1) {
				aliveNear++;
			}
		}
		System.out.println("termina el below");
		return aliveNear;
	}
	
	public int getNearCenter(int y,int x) {
		int aliveNear = 0;
		int j;
		if((x-1)<0) {
			j = baseMatrix[y].length-1;
		}else {
			j = x-1;
		}
		
		if(baseMatrix[y][j]==1) {////
			aliveNear++;
		}
		
		if(x+1>baseMatrix[y].length-1) {
			j = 0;
		}else {
			j = baseMatrix[y].length-1;
		}
		
		if(baseMatrix[y][j]==1) {
			aliveNear++;
		}
		System.out.println("termina el center");
		return aliveNear;
	}
	
	public int[][] getCurrentMatrix() {
		return currentMatrix;
	}
	
}
