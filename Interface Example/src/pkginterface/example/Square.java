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
public class Square extends Shape {
    private double length;

    public Square(double length) {
        super("Square");
        this.length = length;
    }
    
    @Override
    public double getArea() {
        return length * length;
    }

    public double getLength() {
        return length;
    }
    
    
}
