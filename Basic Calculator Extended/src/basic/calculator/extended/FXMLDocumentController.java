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
    double operand1;
    double operand2;
    boolean operationPending = true;

    @FXML
    private TextField displayField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleOneAction(ActionEvent event) {
        if (!operationPending) {
            displayField.setText("");
            operationPending = true;
        }
        String oldText = displayField.getText();
        String newText = oldText + "1";
        displayField.setText(newText);
    }

    @FXML
    private void handleTwoAction(ActionEvent event) {
        if (!operationPending) {
            displayField.setText("");
            operationPending = true;
        }
        String oldText = displayField.getText();
        String newText = oldText + "2";
        displayField.setText(newText);
    }

    @FXML
    private void handleThreeAction(ActionEvent event) {
        if (!operationPending) {
            displayField.setText("");
            operationPending = true;
        }
        displayField.setText(displayField.getText() + "3");
    }

    @FXML
    private void handleSixeAction(ActionEvent event) {
        if (!operationPending) {
            displayField.setText("");
            operationPending = true;
        }
        displayField.setText(displayField.getText() + "6");
    }

    @FXML
    private void handleFiveAction(ActionEvent event) {
        if (!operationPending) {
            displayField.setText("");
            operationPending = true;
        }
        displayField.setText(displayField.getText() + "5");
    }

    @FXML
    private void handleFourAction(ActionEvent event) {
        if (!operationPending) {
            displayField.setText("");
            operationPending = true;
        }
        displayField.setText(displayField.getText() + "4");
    }

    @FXML
    private void handleNineAction(ActionEvent event) {
        if (!operationPending) {
            displayField.setText("");
            operationPending = true;
        }
        displayField.setText(displayField.getText() + "9");
    }

    @FXML
    private void handleEightAction(ActionEvent event) {
        if (!operationPending) {
            displayField.setText("");
            operationPending = true;
        }
        displayField.setText(displayField.getText() + "8");
    }

    @FXML
    private void handleSevenAction(ActionEvent event) {
        if (!operationPending) {
            displayField.setText("");
            operationPending = true;
        }
        displayField.setText(displayField.getText() + "7");
    }

    @FXML
    private void handleZeroAction(ActionEvent event) {
        if (!operationPending) {
            displayField.setText("");
            operationPending = true;
        }
        if (!displayField.getText().equals("0"))
            displayField.setText(displayField.getText() + "0");
    }

    @FXML
    private void handleDotAction(ActionEvent event) {
        if (!operationPending) {
            displayField.setText("");
            operationPending = true;
        }
        if (!displayField.getText().contains("."))
            displayField.setText(displayField.getText() + ".");
    }

    @FXML
    private void handleEqualAction(ActionEvent event) {
        operand2 = Double.parseDouble(displayField.getText());
        double result = 0;

        if (operation.equals("ADD")) {
            result = operand1 + operand2;
        } else if (operation.equals("SUB")) {
            result = operand1 - operand2;
        } else if (operation.equals("DIV")) {
            result = operand1 / operand2;
        }

        String output = String.format("%.2f", result);
        displayField.setText(output);
        operationPending = false;
    }

    @FXML
    private void handleAddAction(ActionEvent event) {
        operand1 = Double.parseDouble(displayField.getText());
        displayField.setText("");
        operation = "ADD";
    }

    @FXML
    private void handleSubtractAction(ActionEvent event) {
        operand1 = Double.parseDouble(displayField.getText());
        displayField.setText("");
        operation = "SUB";
    }

    @FXML
    private void handleDivisionAction(ActionEvent event) {
        operand1 = Double.parseDouble(displayField.getText());
        displayField.setText("");
        operation = "DIV";
    }

    @FXML
    private void handleMultiplicationAction(ActionEvent event) {
    }

}
