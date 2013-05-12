package moodle.Otazky;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Mates
 */
public class Short extends Ot{
private String odpoved;
    public Short() {
        
    }

    public Short(String name) {
        super(name);
    }

    public Short(String name, String zadani) {
        super(name, zadani);
    }

    public String getOdpoved() {
        return odpoved;
    }

    public void setOdpoved(String odpoved) {
        this.odpoved = odpoved;
    }
    
    
    
}
