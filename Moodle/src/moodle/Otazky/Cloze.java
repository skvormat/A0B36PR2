/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moodle.Otazky;

import java.io.Serializable;

/**
 *
 * @author Mates
 */
public class Cloze extends Ot implements Serializable{
    
    
    public Cloze() {
    }

    public Cloze(String name) {
        super(name);
    }

    public Cloze(String name, String zadani) {
        super(name, zadani);
    }
    
    public String prevodNaShort(){
        System.out.println("not supported yet");
        return null;
    }
}
