package ui;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Map;
import threads.MatrixViewThread;

public class MatrixView extends Canvas{

	private GraphicsContext graphics;
	private int[][] tileMap;
	private Map map;
	private MatrixViewThread mvt;

	
	public MatrixView(Map map) {
		super(760,560);
		graphics = super.getGraphicsContext2D();
		this.map = map;
		tileMap = map.getCurrentMatrix();
		graphics.setFill(Color.GRAY);
		graphics.fillRect(0, 0, 760, 560);
		//initializeCells();
	}
	
	public void updateTileMap() {
		tileMap = map.getCurrentMatrix();
	}
	
	public void draw() {
		
		int posX = 0;
		int posY = 0;

		for(int i=0;i<tileMap.length;i++) {
			posY = i*40;
			for(int j=0;j<tileMap[i].length;j++) {
				posX = j*40;
				int status = tileMap[i][j];
				if(status==1) {
					graphics.setFill(Color.WHITE);
					graphics.fillRect(posX, posY, 40, 40);
					graphics.setStroke(Color.BLACK);
					graphics.strokeRect(posX, posY, 40, 40);
				}else {
					graphics.setFill(Color.BLACK);
					graphics.fillRect(posX, posY, 40, 40);
					graphics.setStroke(Color.BLACK);
					graphics.strokeRect(posX, posY, 40, 40);
				}
			}
		}
	}
	
	public void start() {
		mvt = new MatrixViewThread(map, this);
		mvt.start();
		
	}
	
	public void pause() {
		mvt.setActive(false);
	}
}
