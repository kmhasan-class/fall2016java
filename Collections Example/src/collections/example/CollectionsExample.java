/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author kmhasan
 */
public class CollectionsExample {

    public CollectionsExample() {
        /*
        ArrayList arrayList = new ArrayList();
        arrayList.add("Something");
        arrayList.add(15);
        arrayList.add(3.65897);
        
        for (Object object: arrayList)
            System.out.println(object);
        */
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Java");
        stringList.add("C++");
        stringList.add("Python");
        
        // primitive data types: int, float, double, boolean
        // Classes: String, ArrayList, Integer, Double
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(new Integer(10)); 
        intList.add(50); // boxing/unboxing
        intList.add(40);
        intList.add(10);
        
        int intArray[] = {100, 500, 400, 100};
        
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("20100000010", "John Doe", 3.43));
        studentList.add(new Student("20100000015", "Jane Doe", 2.33));
        studentList.add(new Student("20100000009", "Abdul Kuddus", 3.89));
        
        System.out.println("Before sorting");
        for (String s : stringList)
            System.out.println(s);
        for (Integer i : intList)
            System.out.println(i);
        for (int i = 0; i < intArray.length; i++)
            System.out.println(intArray[i]);
        for (Student s : studentList)
            s.print();
        
        Collections.sort(stringList);
        Collections.sort(intList);
        Arrays.sort(intArray);
        Collections.sort(studentList);
        
        System.out.println("After sorting");
        for (String s : stringList)
            System.out.println(s);
        for (Integer i : intList)
            System.out.println(i);
        for (Integer i : intArray)
            System.out.println(i);
        for (Student s : studentList)
            s.print();        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new CollectionsExample();
    }
    
}
