/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface.example;

/**
 *
 * @author kmhasan
 */
public abstract class BankAccount {
    private String accountNumber;
    private String accountName;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }
    
    public void withdraw(double amount) {
        balance = balance - amount;
    }
    
    public abstract void deposit(double amount);

    @Override
    public String toString() {
        return "BankAccount{" + "accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance + '}';
    }
    
    
}
