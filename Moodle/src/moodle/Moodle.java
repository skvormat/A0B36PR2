package moodle;

import java.io.FileNotFoundException;
import java.io.IOException;
import moodle.Gui.Gui3;

public class Moodle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws  FileNotFoundException, IOException {

       Procesor.readAbc();
         
       // Procesor.restore();
        
         Gui3 g= new Gui3();
        g.setVisible(true);

       Procesor.save();
      Procesor.clear();
       Procesor.restore();
        
        //System.out.println(Procesor.toString2());


    }
}



//Nacte a vzpise pole

//        CSVReader reader=new CSVReader(
//    new InputStreamReader(new FileInputStream("c:\\Users\\Mates\\Desktop\\Work\\D1.csv"), "UTF-8"), 
//    ',', '\"');
//String[] line;
//while ((line = reader.readNext()) != null) {
//    StringBuilder stb = new StringBuilder(400);
//    for (int i = 0; i < line.length; i++) {
//         stb.append(line[2]);
//         stb.append("\t\t");
//    }
//    
//    System.out.println(stb);
//}