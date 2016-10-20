/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.browser;

/**
 *
 * @author kmhasan
 */
public class BankAccount {
    private String accountNumber;
    private String accountName;
    private String address;
    private double balance;
    
    // CONSTRUCTOR
    public BankAccount(String nAccountNumber, 
            String nAccountName, 
            String nAddress, 
            double nBalance) {
        accountNumber = nAccountNumber;
        accountName = nAccountName;
        address = nAddress;
        balance = nBalance;
    }
    
    public void deposit(int amount) {
        if (amount > 0)
            balance = balance + amount;
    }
    
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance)
            balance = balance - amount;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String nAddress) {
        address = nAddress;
    }
    
    public void print() {
        System.out.printf("%s %s %s %.2f\n", accountNumber, accountName, address, balance);
    }
}
