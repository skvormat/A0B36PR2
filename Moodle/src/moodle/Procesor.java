package moodle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import au.com.bytecode.opencsv.CSVReader;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import moodle.Otazky.Abc;
import moodle.Otazky.Ot;
import java.io.InputStream;

/**
 *
 * @author Mates
 */
public  class Procesor{
  private static List<Ot> list = new OtArray<>();
  private static int citac=0;

    
    public Procesor() {
  
    }
  
    public static void add(Ot otazka){
    list.add(otazka);
    citac ++;
    }
    
    
    public static Ot get(int i)
    {
    return list.get(i);
    }
    

    public static int size(){return citac;}

   public static String toString2() {
        return list.toString();
    }
    
   public static void set(int i, Ot otazka)
    {
     list.set(i, otazka);
    }
   
   public static void readAbc() throws UnsupportedEncodingException, FileNotFoundException, IOException{
   
       //dopsat vzjimky!
       
    CSVReader reader = new CSVReader(
                new InputStreamReader(new FileInputStream("c:\\Users\\Mates\\Desktop\\Work\\EN2.csv"), "CP1250"), ';', '\"');
        String[] line;
        String namePrefix = new String();
        
        Abc tmp = null;
        
        while ((line = reader.readNext()) != null) {
            
            
          //nacteni jmena bloku
            boolean  prazdnost=true;
            for (int i = 1; i < line.length; i++) {
                if (line[i].length()>=1) {prazdnost=false;break;           
                }
                
            }
            if (line[0].length() >= 1&&prazdnost) {namePrefix = line[0].toString();}

          //filtr obrazku-prevod do html, do final poresit cestu a koncovku
            for (int i = 0; i < 3; i++) {
                if (line[i].length()>4) 
                if("PIC_".equals(line[i].substring(0, 4)))
                    line[i]="<img src=\"img/"+line[i]+".png\">";
            }
            
            
            
          //vztvoreni novehe otezky
            if (line[1].length() > 1) {
                if (tmp!=null) {
                 Procesor.add(tmp);      
                }          
               tmp=new Abc(namePrefix +"_"+ line[0].toString(), line[1].toString());}
            
            if (tmp==null) {continue;}
          //nacteni obrazku z bunek 4 a 5
            if (line[4].length() >= 1) {tmp.setImg(line[4].toString());}           
            if (line[5].length() >= 1) {tmp.setImg(line[5].toString());}

          //nacteni odpovedii do otazky 
            if (line[2].length() >= 1) {tmp.addSpravne(line[2].toString());}
            if (line[3].length() >= 1) {tmp.addSpatne(line[3].toString());}
        
            
        }

   }
   
    public static void save() throws FileNotFoundException, IOException {

        try {  // Catch errors in I/O if necessary.
            FileOutputStream saveFile = new FileOutputStream("SaveObj.sav");

            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            for (int i = 0; i < size(); i++) {
                save.writeObject(list.get(i));

            }
        } catch (Exception exc) {
            exc.printStackTrace(); // If there was an error, print the info.
        }

    }
    
    public static void clear(){
    citac=0;
    list.clear();
    }
    
    public static void restore() throws FileNotFoundException, IOException {

        try {  // Catch errors in I/O if necessary.
            FileInputStream saveFile = new FileInputStream("saveObj.sav");
            
         BufferedInputStream bis = new BufferedInputStream(saveFile);
            
          ObjectInputStream restore = new ObjectInputStream(bis);
           
            while (bis.available() > 0) {                
                list.add((Ot) restore.readObject());
                citac++;
            }
            
        } catch (Exception exc) {
            exc.printStackTrace(); // If there was an error, print the info.
        }

    }
      

}