package moodle.Otazky;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mates
 */
public abstract class Ot implements Serializable{
private String name;
private String zadani;
public List<String> img=new ArrayList<>(3);

    /**
     *
     */
    public Ot() {
    }

    /**
     *
     * @param name
     */
    public Ot(String name) {
        this.name = name.replaceAll(" ", "_");
    }

    /**
     *
     * @param name
     * @param zadani
     */
    public Ot(String name, String zadani) {
        this.name = name.replaceAll(" ", "_");
        this.zadani = zadani;
}

    /**
     *
     * @param img
     */
    public void setImg(String img) {
        if (img.length()>2) this.img.add(img);   
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name.replaceAll(" ", "_");
    }

    /**
     *
     * @param zadani
     */
    public void setZadani(String zadani) {
        this.zadani = zadani;
    }
        
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getZadani() {
        return zadani;
    }

    /**
     *
     * @param img
     */
    public void setImg(List<String> img) {
        this.img = img;
    }
    
    
//    public void setSpravne(String spravne) {
//        System.out.println("setSpravne not supported");
//    }
//
//    public void setSpatne(String spatne) {
//        System.out.println("setSpatne not supported");    
//    }

    /**
     *
     * @return
     */
    public List<String> getImg() {
        return img;
    }

}


