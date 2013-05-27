package moodle.Otazky;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Mates
 */
public class Essay extends Ot{
    
    /**
     *
     * @param name
     */
    public Essay(String name) {
        super(name);
    }

    /**
     *
     * @param name
     * @param zadani
     */
    public Essay(String name, String zadani) {
        super(name, zadani);
    }

    /**
     *
     */
    public Essay() {
    }

    @Override
    public String toString() {
   StringBuilder stb = new StringBuilder(800);
         
    stb.append("<question type=\"essay\"><name><text>");
    stb.append(this.getName()); //nahrazeni mnezery v nayvu podtrzitkem
    stb.append("</text></name><questiontext format=\"moodle_auto_format\"><text><![CDATA[<H3>");
    stb.append(this.getZadani());     
    stb.append("</H3><BR>]]></text></questiontext><responseformat>plain</responseformat><responsefieldlines>6</responsefieldlines></question>");

    return stb.toString();
    }

 
    
    
    
    
}
