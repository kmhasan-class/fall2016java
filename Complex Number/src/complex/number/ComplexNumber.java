/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complex.number;

/**
 *
 * @author kmhasan
 */
public class ComplexNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Complex a = new Complex(2, 3);
        Complex b = new Complex(1, 5);
        Complex c = a.multiply(b);
        a.print();
        b.print();
        c.print();
    }
    
}
