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
public class BankAccountApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String accountNumber[];
        String accountName[];
        String address[];
        double balance[];
        BankAccount bankAccountArray[];
        /*
        bankAccountArray = new BankAccount[100];
        bankAccountArray[0].accountNumber = "98777";
        bankAccountArray[0].accountName = "Hasan Tareque";
        bankAccountArray[0].balance = 5000;
        */
        accountNumber = new String[100];
        accountName = new String[100];
        address = new String[100];
        balance = new double[100];
        
        accountNumber[0] = "420-254-689";
        accountName[0] = "Md. Rakibul Hasan";
        address[0] = "24, Kemal Ataturk Avenue";
        balance[0] = 358871254.00;

        accountNumber[1] = "420-254-677";
        accountName[1] = "Monirul Hasan";
        address[1] = "24, Kemal Ataturk Avenue";
        balance[1] = 100.00;
        
        int amount = 100;
        
        // deposit
        balance[0] = balance[0] + 1000;
        
        //withdraw
        balance[0] = balance[0] - amount;
        
        //withdraw
        balance[1] = balance[0] - amount;
        
        System.out.printf("Balance %.2f\n", balance[0]);
        
        // declaration
        BankAccount bankAccountObject;
        // instantiation
        bankAccountObject = new BankAccount("1234", "Md. Ashiqur Rahman", "Gulshan", 1000);
        bankAccountObject.setAddress("Mirpur");
        bankAccountObject.withdraw(-100);
        bankAccountObject.deposit(200);
        System.out.printf("Balance: %.2f\n", bankAccountObject.getBalance());
    }
    
}
