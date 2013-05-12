/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moodle.Otazky;

/**
 *
 * @author Mates
 */
public class TrueFalse extends Ot{
    private boolean odpoved;

    public TrueFalse() {
    }

    public TrueFalse(String name) {
        super(name);
    }

    public TrueFalse(String name, String zadani) {
        super(name, zadani);
    }
    
    public TrueFalse(String name, String zadani, boolean odpoved) {
        super(name, zadani);
        this.odpoved=odpoved;
    }

    public boolean isOdpoved() {
        return odpoved;
    }

    public void setOdpoved(boolean odpoved) {
        this.odpoved = odpoved;
    }
}
