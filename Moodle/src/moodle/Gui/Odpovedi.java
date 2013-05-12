/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moodle.Gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mates
 */
public class Odpovedi  extends JPanel{
    List<String> seznam;
    List<JTextField> vpisy= new ArrayList<>();
    JButton pridej;
    
  
    public Odpovedi(List seznam) {
    this.seznam=seznam;
    
    
    while(seznam.iterator().hasNext())
    {
    vpisy.add(new JTextField(seznam.iterator().next().toString(), 50));
    }
    vpisy.add(new JTextField(seznam.iterator().next().toString(), 50));
    
    pridej=new JButton("Pridej");
    pridej.addActionListener(null);
    redraw();
      
        

    }
    
    private void redraw(){
        this.removeAll();
      while (vpisy.iterator().hasNext()) {
            this.add(vpisy.iterator().next());    
        }
    this.add(pridej);
    }
    
    
    
}
