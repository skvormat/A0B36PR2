/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moodle;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Mates
 */
public class OtArray<E> extends ArrayList<E> {

    @Override
   public String toString() {
        
          System.out.println();
        
        Iterator<E> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<quiz>\n");
        
        for (;;) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.toString();
            sb.append("\n\n");
        }
        
        
      // sb.append("</quiz>");
    }
    
}
