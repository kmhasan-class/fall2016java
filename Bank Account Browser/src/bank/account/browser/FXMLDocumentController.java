/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.browser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField accountNumberField;
    @FXML
    private TextField accountNameField;
    @FXML
    private TextArea addressArea;
    @FXML
    private TextField balanceField;
    @FXML
    private TextField searchField;
    private BankAccount bankAccountArray[];
    private int numberOfAccounts;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bankAccountArray = new BankAccount[100];
        numberOfAccounts = 0;
        try {
            RandomAccessFile input = new RandomAccessFile("accounts.txt", "r");

            for ( ; ; ) {
                String accountNumber = input.readLine();
                if (accountNumber == null)
                    break;
                String accountName = input.readLine();
                String address = input.readLine();
                double balance = Double.parseDouble(input.readLine());

                BankAccount bankAccount = new BankAccount(accountNumber, accountName, address, balance);
                bankAccountArray[numberOfAccounts] = bankAccount;
                numberOfAccounts++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("accounts.txt doesn't exist!");
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSaveAction(ActionEvent event) {
        RandomAccessFile output;
        try {
            output = new RandomAccessFile("accounts.txt", "rw");
            long startPosition = output.length();
            output.seek(startPosition);
            // to start fresh
            //output.setLength(0);
            for (int i = 0; i < numberOfAccounts; i++) {
                output.writeBytes(bankAccountArray[i].getAccountNumber() + "\n");
                output.writeBytes(bankAccountArray[i].getAccountName() + "\n");
                output.writeBytes(bankAccountArray[i].getAddress() + "\n");
                output.writeBytes("" + bankAccountArray[i].getBalance() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("accounts.txt file not found.");
        } catch (java.io.IOException e) {
            System.out.println("Something went wrong while writing to the file");
        }
    }

    public void resetForm() {
        accountNumberField.setText("");
        accountNameField.setText("");
        addressArea.setText("");
        balanceField.setText("");
    }

    @FXML
    private void handleAddAction(ActionEvent event) {
        String accountNumber = accountNumberField.getText();
        String accountName = accountNameField.getText();
        String address = addressArea.getText();
        try {
            double balance = Double.parseDouble(balanceField.getText());

            BankAccount account = new BankAccount(accountNumber, accountName, address, balance);
            bankAccountArray[numberOfAccounts] = account;
            numberOfAccounts++;

            resetForm();
        } catch (NumberFormatException e) {
            System.err.println("Balance field cannot be blank; it must be a decimal number.");
        }
    }

    @FXML
    private void handlePreviousAction(ActionEvent event) {
    }

    @FXML
    private void handleNextAction(ActionEvent event) {
    }

    @FXML
    private void handleSearchAction(ActionEvent event) {
    }

    @FXML
    private void handlePrintAction(ActionEvent event) {
        for (int i = 0; i < numberOfAccounts; i++) {
            bankAccountArray[i].print();
        }
    }

}
