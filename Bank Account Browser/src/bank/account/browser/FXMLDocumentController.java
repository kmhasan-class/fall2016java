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
    private int currentIndex;
    @FXML
    private Label statusLabel;
    
    public void display(int index) {
        accountNumberField.setText(bankAccountArray[index].getAccountNumber());
        accountNameField.setText(bankAccountArray[index].getAccountName());
        addressArea.setText(bankAccountArray[index].getAddress());
        balanceField.setText("" + bankAccountArray[index].getBalance());
    }
    
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
            currentIndex = 0;
            display(currentIndex);
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
        if (currentIndex > 0) {
            currentIndex--;
            statusLabel.setText("Current index: " + currentIndex);
        } else {
            statusLabel.setText("We're at the beginning");
        }
        display(currentIndex);
    }

    @FXML
    private void handleNextAction(ActionEvent event) {
        if (currentIndex < numberOfAccounts - 1) {
            currentIndex++;
            statusLabel.setText("Current index: " + currentIndex);
        } else {
            statusLabel.setText("We're at the end");
        }
        display(currentIndex);
    }

    @FXML
    private void handleSearchAction(ActionEvent event) {
        String accountKey = searchField.getText();
        for (int i = 0; i < numberOfAccounts; i++)
            if (bankAccountArray[i].getAccountNumber().equals(accountKey)) {
                currentIndex = i;
                break;
            }
        if (!bankAccountArray[currentIndex].getAccountNumber().equals(accountKey))
            statusLabel.setText("No account found with number " + accountKey);
        else statusLabel.setText("");
        display(currentIndex);
    }

    @FXML
    private void handlePrintAction(ActionEvent event) {
        for (int i = 0; i < numberOfAccounts; i++) {
            bankAccountArray[i].print();
        }
    }

}
