package moodle.Otazky;

//Zatim neimplementovano
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
    /**
     *
     */
    public Short() {
        
    }

    /**
     *
     * @param name
     */
    public Short(String name) {
        super(name);
    }

    /**
     *
     * @param name
     * @param zadani
     */
    public Short(String name, String zadani) {
        super(name, zadani);
    }

    /**
     *
     * @return
     */
    public String getOdpoved() {
        return odpoved;
    }

    /**
     *
     * @param odpoved
     */
    public void setOdpoved(String odpoved) {
        this.odpoved = odpoved;
    }
    
    
    
}
