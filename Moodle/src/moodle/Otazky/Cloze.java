/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moodle.Otazky;

/**
 *
 * @author Mates
 */
public class Cloze extends Ot{
    
    
    /**
     *
     */
    public Cloze() {
    }

    /**
     *
     * @param name
     */
    public Cloze(String name) {
        super(name);
    }

    /**
     *
     * @param name
     * @param zadani
     */
    public Cloze(String name, String zadani) {
        super(name, zadani);
    }
    
    /**
     *
     * @return
     */
    public String getZadaniPrevod(){
        return getZadani().replace("<<", " {1:SHORTANSWER:=").replace(">>", "} ");  
    }

    @Override
    public String toString() {
          StringBuilder stb = new StringBuilder(800);
         
    stb.append("<question type=\"cloze\"><name><text>");
    stb.append(this.getName()); //nahrazeni mnezery v nayvu podtrzitkem
    stb.append("</text></name><questiontext format=\"moodle_auto_format\"><text><![CDATA[<H3>");
    stb.append(this.getZadaniPrevod());
    stb.append("</H3><BR>]]></text></questiontext></question>");

    return stb.toString(); 
    }
    
    
}
