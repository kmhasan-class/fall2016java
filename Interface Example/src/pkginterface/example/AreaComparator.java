/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface.example;

import java.util.Comparator;

/**
 *
 * @author kmhasan
 */
public class AreaComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Shape a = (Shape) o1;
        Shape b = (Shape) o2;
        
        if (a.getArea() < b.getArea())
            return -1;
        else if (a.getArea() > b.getArea())
            return +1;
        else return 0;
    }
    
}
