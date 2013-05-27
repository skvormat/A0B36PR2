/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moodle.Otazky;

/**
 *
 * @author Mates
 */
public final class TrueFalse extends Ot{
    private boolean odpoved=true;

    /**
     *
     */
    public TrueFalse() {
    }

    /**
     *
     * @param name
     */
    public TrueFalse(String name) {
        super(name);
    }

    /**
     *
     * @param name
     * @param zadani
     */
    public TrueFalse(String name, String zadani) {
        super(name, zadani);
    }
    
    /**
     *
     * @param name
     * @param zadani
     * @param odpoved
     */
    public TrueFalse(String name, String zadani, boolean odpoved) {
        super(name, zadani);
        this.odpoved=odpoved;
    }

    /**
     *
     * @return
     */
    public boolean getOdpoved() {
        return odpoved;
    }

    /**
     *
     * @param odpoved
     */
    public void setOdpoved(boolean odpoved) {
        this.odpoved = odpoved;
    }

    @Override
    public String toString() {
    
      StringBuilder stb = new StringBuilder(800);
         
    stb.append("<question type=\"truefalse\"><name><text>");
    stb.append(this.getName()); //nahrazeni mnezery v nayvu podtrzitkem
    stb.append("</text></name><questiontext format=\"moodle_auto_format\"><text><![CDATA[<H3>");
    stb.append(this.getZadani());    
        if (odpoved) 
    stb.append("</H3><BR>]]></text></questiontext>"
            + " <answer fraction=\"100\">\n" +
"    <text>true</text>\n" +
" </answer>\n" +
" <answer fraction=\"0\">\n" +
"    <text>false</text>\n" +
" </answer></question>");
else
     stb.append("</H3><BR>]]></text></questiontext>"
            + " <answer fraction=\"0\">\n" +
"    <text>true</text>\n" +
" </answer>\n" +
" <answer fraction=\"100\">\n" +
"    <text>false</text>\n" +
" </answer></question>");           
        
        
    return stb.toString();
    }
    
    
}
