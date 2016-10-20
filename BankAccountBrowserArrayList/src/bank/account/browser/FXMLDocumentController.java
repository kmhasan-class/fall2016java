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
import java.util.ArrayList;
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
    private ArrayList<BankAccount> bankAccountList;
    private int currentIndex;
    @FXML
    private Label statusLabel;
    
    public void display(int index) {
        accountNumberField.setText(bankAccountList.get(index).getAccountNumber());
        accountNameField.setText(bankAccountList.get(index).getAccountName());
        addressArea.setText(bankAccountList.get(index).getAddress());
        balanceField.setText("" + bankAccountList.get(index).getBalance());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bankAccountList = new ArrayList<>();
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
                bankAccountList.add(bankAccount);
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
            for (BankAccount account: bankAccountList) {
                output.writeBytes(account.getAccountNumber() + "\n");
                output.writeBytes(account.getAccountName() + "\n");
                output.writeBytes(account.getAddress() + "\n");
                output.writeBytes("" + account.getBalance() + "\n");
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
            bankAccountList.add(account);

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
        if (currentIndex < bankAccountList.size() - 1) {
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
        for (int i = 0; i < bankAccountList.size(); i++)
            if (bankAccountList.get(i).getAccountNumber().equals(accountKey)) {
                currentIndex = i;
                break;
            }
        if (!bankAccountList.get(currentIndex).getAccountNumber().equals(accountKey))
            statusLabel.setText("No account found with number " + accountKey);
        else statusLabel.setText("");
        display(currentIndex);
    }

    @FXML
    private void handlePrintAction(ActionEvent event) {
        for (BankAccount account : bankAccountList) {
            account.print();
        }
    }

}
