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
public class InterfaceExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student student = new Student("1235", "Hasan Tareque", 3.25);
        System.out.println(student.toString());
        
        BankAccount bankAccount = new SavingsAccount("444", "Test", 6000);
        bankAccount.deposit(1000);
        System.out.println(bankAccount);
    }
    
}
