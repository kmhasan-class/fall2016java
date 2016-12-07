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
public abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }
    
    public void printName() {
        System.out.println(name);
    }
    
    public abstract double getArea();
    
}
