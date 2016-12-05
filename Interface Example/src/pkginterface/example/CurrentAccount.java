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
public abstract class CurrentAccount extends BankAccount {

    public CurrentAccount(String accountNumber, String accountName, double balance) {
        super(accountNumber, accountName, balance);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 20);
    }
    
    
}
