package threads;

import javafx.application.Platform;
import model.Map;
import ui.MatrixView;

public class MatrixViewThread extends Thread{

	private Map map;
	private MatrixView matrixView;
	private boolean active = true;
	
	public MatrixViewThread(Map m, MatrixView mv) {
		map = m;
		matrixView = mv;
	}
	
	@Override
	public void run() {
		while(active) {
			map.updateMap();

				
			Platform.runLater(new Thread() {
				@Override
				public void run() {
					matrixView.updateTileMap();
					matrixView.draw();	
				}
			});
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setActive(boolean s) {
		active = s;
	}
	
}
