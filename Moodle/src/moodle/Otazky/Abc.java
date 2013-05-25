package moodle.Otazky;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import moodle.Gui.EditAbc;


/**
 *
 * @author Mates
 */
public class Abc extends Ot implements Serializable{

List spravne=new ArrayList<>();
List spatne=new ArrayList<>();

    public Abc(String name) {
        super(name);
    }

    public Abc(String name, String zadani) {
        super(name, zadani);
    }

    public Abc() {
    }



    public List getSpravne() {
        return spravne;
    }

    public List getSpatne() {
        return spatne;
    }
    public void nulovatSpravneSpatne()    
    {
    this.spatne.clear();
    this.spravne.clear();
    }
            
    public void addSpravne(String spravne) {
        this.spravne.add(spravne);
    }

    public void addSpatne(String spatne) {
        this.spatne.add(spatne);
    }

    
   
    
    
    
    public String toXml() {
        StringBuilder stb = new StringBuilder(800);


        stb.append("<question type=\"multichoice\">\n<name>\n<text>").append(this.getName()).append("</text>\n</name>");

        stb.append("\n<questiontext format=\"html\">\n<text><![CDATA[").append(this.getZadani());
        
        //vypsani img
        for (int i = 0; i < img.size(); i++) {
            stb.append("<img src=\"img/").append(img.get(i)).append(".png\">");      
        }

        stb.append("]]></text>\n</questiontext>");


        for (int i = 0; i < spravne.size(); i++) {

            stb.append("\n<answer fraction=\"").append(100 / (double) spravne.size()).append("\" format=\"html\"><text><![CDATA[");
            stb.append(spravne.get(i));
            stb.append("]]></text><feedback><text>Dobre!</text></feedback></answer>");
        }
        for (int i = 0; i < spatne.size(); i++) {
            stb.append("\n<answer fraction=\"-75\" format=\"html\"><text><![CDATA[");
            stb.append(spatne.get(i));
            stb.append("]]></text><feedback><text>Spatne!</text></feedback></answer>");
        }

        stb.append("\n<shuffleanswers>0</shuffleanswers><single>true</single> \n<answernumbering>abc</answernumbering>\n</question>");

        return stb.toString();
         
    }

    public void setSpravne(List spravne) {
        this.spravne = spravne;
    }

    public void setSpatne(List spatne) {
        this.spatne = spatne;
    }

    @Override
    public String toString() {
         StringBuilder stb = new StringBuilder(800);


        stb.append("<question type=\"multichoice\">\n<name>\n<text>").append(this.getName()).append("</text>\n</name>");

        stb.append("\n<questiontext format=\"html\">\n<text><![CDATA[").append(this.getZadani());
        
        //vypsani img
        for (int i = 0; i < img.size(); i++) {
            stb.append("<img src=\"img/").append(img.get(i)).append(".png\">");      
        }

        stb.append("]]></text>\n</questiontext>");


        for (int i = 0; i < spravne.size(); i++) {

            stb.append("\n<answer fraction=\"").append(100 / (double) spravne.size()).append("\" format=\"html\"><text><![CDATA[");
            stb.append(spravne.get(i));
            stb.append("]]></text><feedback><text>Dobre!</text></feedback></answer>");
        }
        for (int i = 0; i < spatne.size(); i++) {
            stb.append("\n<answer fraction=\"-75\" format=\"html\"><text><![CDATA[");
            stb.append(spatne.get(i));
            stb.append("]]></text><feedback><text>Spatne!</text></feedback></answer>");
        }

        stb.append("\n<shuffleanswers>0</shuffleanswers><single>true</single> \n<answernumbering>abc</answernumbering>\n</question>");

        return stb.toString();
    }


}
