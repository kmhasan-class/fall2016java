/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.program;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    private double width;
    private double height;
    private GraphicsContext gc;

    private double lastX;
    private double lastY;
    
    private boolean firstLine;
    @FXML
    private Canvas drawingCanvas;
    @FXML
    private ColorPicker colorPicker;
    
    private void drawGrid(double xticks, double yticks) {
        gc.setStroke(Color.RED);
        // vertical lines
        for (double x = 0; x <= width; x += xticks)
            gc.strokeLine(x, 0, x, height);
        
        // horizontal lines
        for (double y = 0; y <= height; y += yticks)
            gc.strokeLine(0, y, width, y);
    }
    
    private double f(double x) {
        // HOMEWORK: TRY PLOTTING A SIN CURVE
        return x * x;
    }
    
    private void plotFunction() {
        for (double x1 = -width; x1 <= width; x1 += 1) {
            double y1 = height - f(x1 / 10);
            double x2 = x1 + 1;
            double y2 = height - f(x2 / 10);
            gc.strokeLine(width / 2 + x1, y1, width / 2 + x2, y2);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        width = drawingCanvas.getWidth();
        height = drawingCanvas.getHeight();
        
        gc = drawingCanvas.getGraphicsContext2D();
        
        lastX = 0;
        lastY = 0;
        
        firstLine = true;
        
        //drawGrid(50, 50);
        //plotFunction();
    }    

    @FXML
    private void handleMouseClickAction(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        //gc.strokeOval(x, y, 20, 20);
        if (!firstLine)
            gc.strokeLine(lastX, lastY, x, y);
        firstLine = false;
        lastX = x;
        lastY = y;
    }

    @FXML
    private void handleMouseReleaseAction(MouseEvent event) {
        firstLine = true;
    }

    @FXML
    private void handleColorPickerAction(ActionEvent event) {
        gc.setStroke(colorPicker.getValue());
    }
    
}
