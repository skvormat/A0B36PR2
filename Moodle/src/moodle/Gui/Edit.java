/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moodle.Gui;

import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JLabel;

/**
 *
 * @author Mates
 */
abstract class Edit extends javax.swing.JPanel {
    int no = -1;
    boolean saved=false;
    
        javax.swing.JButton resetButton;
    javax.swing.JButton saveButton;
        javax.swing.JTextField zmenaNazvu;     

    public Edit(int no) {
         this.no = no;
         initComponents();
         
    }

    public Edit() {
        initComponents();
    }
    
    private void initComponents() {
     zmenaNazvu = new javax.swing.JTextField(20);
    
     saveButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();

        
//        
//         GridLayout experimentLayout = new GridLayout(4,2);
//        
//        this.setLayout(experimentLayout);
//        Box nazevBox = Box.createHorizontalBox();
//        this.add(nazevBox);
//        
//        nazevBox.add(new JLabel("Nazev"));
//        nazevBox.add(Box.createHorizontalStrut(10));
//        nazevBox.add(zmenaNazvu);
//        
         
  
    
    }    
    
  
        
        
}


