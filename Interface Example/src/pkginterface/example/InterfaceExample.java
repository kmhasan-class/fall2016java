/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(10, 20));
        shapes.add(new Square(10));
        shapes.add(new Circle(20));
        shapes.add(new Circle(21));
        shapes.add(new Circle(15));
        shapes.add(new Triangle(3, 4, 5));

        //Collections.sort(shapes, new AreaComparator());
/*        
         Collections.sort(shapes, new Comparator() {
         // anonymous class
         @Override
         public int compare(Object o1, Object o2) {
         Shape a = (Shape) o1;
         Shape b = (Shape) o2;
         return a.getName().compareTo(b.getName());
         }
         });
         */
        // Lambda Expressions
        /*
         Collections.sort(shapes, 
         (a, b) -> a.getName().compareTo(b.getName()));
         */
        Collections.sort(shapes,
                (a, b) -> {
                    if (a.getArea() < b.getArea()) {
                        return -1;
                    } else if (a.getArea() > b.getArea()) {
                        return +1;
                    } else {
                        return 0;
                    }
                });
        
        for (Shape shape : shapes) {
            shape.printName();
            System.out.println("Area: " + shape.getArea());
            if (shape instanceof ShapeInterface) {
                ShapeInterface si = (ShapeInterface) shape;
                System.out.println("Perimeter: " + si.getPerimeter());
            }
            System.out.println();
        }
    }

}
