/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.calculator.extended;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    String operation;
    int operand1;
    int operand2;

    @FXML
    private TextField displayField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleOneAction(ActionEvent event) {
        String oldText = displayField.getText();
        String newText = oldText + "1";
        displayField.setText(newText);
    }

    @FXML
    private void handleTwoAction(ActionEvent event) {
        String oldText = displayField.getText();
        String newText = oldText + "2";
        displayField.setText(newText);
    }

    @FXML
    private void handleThreeAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "3");
    }

    @FXML
    private void handleSixeAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "6");
    }

    @FXML
    private void handleFiveAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "5");
    }

    @FXML
    private void handleFourAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "4");
    }

    @FXML
    private void handleNineAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "9");
    }

    @FXML
    private void handleEightAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "8");
    }

    @FXML
    private void handleSevenAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "7");
    }

    @FXML
    private void handleZeroAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "0");
    }

    @FXML
    private void handleDotAction(ActionEvent event) {
    }

    @FXML
    private void handleEqualAction(ActionEvent event) {
        if (operation.equals("ADD")) {
            operand2 = Integer.parseInt(displayField.getText());
            int result = operand1 + operand2;
            displayField.setText("" + result);
        }
    }

    @FXML
    private void handleAddAction(ActionEvent event) {
        operand1 = Integer.parseInt(displayField.getText());
        displayField.setText("");
        operation = "ADD";
    }

}
