/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.application;

/**
 *
 * @author kmhasan
 */
public class SavingsAccount extends BankAccount {
    private int counter;
    
    public SavingsAccount(String accountNumber,
            String accountName,
            String address,
            double balance) {
        super(accountNumber, accountName, address, balance);
        counter = 0;
    }
    
    public void withdraw(int amount) {
        if (amount > 0 && amount <= getBalance()) {
            if (counter < 2) {
                counter++;
                super.withdraw(amount);
            }
        }
    }        

    public void resetCounter() {
        counter = 0;
    }
}
