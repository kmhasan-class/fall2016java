/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist.demo;

import java.util.ArrayList;

/**
 *
 * @author kmhasan
 */
public class ArrayListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        String stringArray[] = new String[5];
        stringArray[0] = "Abul";
        stringArray[1] = "Babul";
        stringArray[2] = "Kabul";
        stringArray[3] = "Ratul";
        stringArray[4] = "Putul";
        stringArray[5] = "Tetul";
        for (int i = 0; i < stringArray.length; i++)
            System.out.println(stringArray[i]);
        */
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Abul");
        stringList.add("Babul");
        stringList.add("Kabul");
        stringList.add("Ratul");
        stringList.add("");
        stringList.set(4, "Putul");
        stringList.add("Tetul");
        stringList.remove(2);
        stringList.remove("Ratul");
        int index = stringList.indexOf("Tetul");
        System.out.println("Tetul found at index " + index);
        for (int i = 0; i < stringList.size(); i++)
            System.out.println(stringList.get(i));
        
        System.out.println("Printing with enhanced for");
        // enhanced for loop
        for (String s: stringList)
            if (s.length() == 5)
                System.out.println(s);
        
        //stringList.forEach(System.out::println);
    }
    
}
