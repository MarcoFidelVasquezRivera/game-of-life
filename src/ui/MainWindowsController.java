package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import model.Map;

public class MainWindowsController {

    @FXML
    private GridPane mainPane;
    
    private Map map = new Map();
    private MatrixView canvas;

    @FXML
    void pause(ActionEvent event) {
    	canvas.pause();
    }

    @FXML
    void start(ActionEvent event) {
    	canvas.start();
    }
 
    public void initialize() {
    	canvas = new MatrixView(map);
    	mainPane.add(canvas, 0, 1);
    	canvas.draw();
    }

    
}
