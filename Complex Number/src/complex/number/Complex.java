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
public class Complex {
    private int real;
    private int imaginary;
    
    public Complex() {
        real = 0;
        imaginary = 0;
    }
    
    public Complex(int r, int i) {
        real = r;
        imaginary = i;
    }
    
    public void print() {
        System.out.printf("%d + %di\n", real, imaginary);
    }
    
    public Complex add(Complex b) {
        Complex a = this;
        Complex c = new Complex();
        c.real = a.real + b.real;
        c.imaginary = a.imaginary + b.imaginary;
        return c;
    }

    public Complex multiply(Complex b) {
        Complex a = this;
        Complex c = new Complex();
        c.real = a.real * b.real - b.imaginary * a.imaginary;
        c.imaginary = a.real * b.imaginary + a.imaginary * b.real;
        return c;
    }
}
