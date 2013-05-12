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
List<String> img=new ArrayList<>(3);

public Ot() {
    }

public Ot(String name) {
        this.name = name.replaceAll(" ", "_");
    }

    public Ot(String name, String zadani) {
        this.name = name.replaceAll(" ", "_");
        this.zadani = zadani;
}

    


    public void setImg(String img) {
        if (img.length()>2) this.img.add(img);
            
        
        
    }

 public void setName(String name) {
        this.name = name.replaceAll(" ", "_");
    }

    public void setZadani(String zadani) {
        this.zadani = zadani;
    }
        
    public String getName() {
        return name;
    }

    public String getZadani() {
        return zadani;
    }

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

    public List<String> getImg() {
        return img;
    }

}


