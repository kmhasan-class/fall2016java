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
public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountName, double balance) {
        super(accountNumber, accountName, balance);
    }
    
    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 10);
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Hey I'm inside deposit method doing nothing");
    }
}
