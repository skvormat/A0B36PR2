/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moodle.Gui;

/**
 *
 * @author Mates
 */
abstract class Edit extends javax.swing.JPanel {
    int no = -1;
    boolean saved=false;
    
   
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
      
    
    }    
     public void saveButtonActionEvent(java.awt.event.ActionEvent evt)    {
        System.out.println("neni implementovano");
    }
     
  
        
        
}


