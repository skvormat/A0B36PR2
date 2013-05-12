package moodle.Gui;

import javax.swing.Box;
import javax.swing.JLabel;
import moodle.Otazky.Essay;
import moodle.Procesor;

/**
 *
 * @author Mates
 */
public class EditDlouhe extends Edit{
    
   Essay otazka;
        
    javax.swing.JTable tabulkaOdpovedi;
    javax.swing.JTextArea zmenaZadani;


    public EditDlouhe(int no) {
       super(no);
       
        otazka = (Essay) Procesor.get(no);
        initComponents();
        reset();
        this.setVisible(true);
    }

    public EditDlouhe() {
        super(-1);
        otazka= new Essay();
        initComponents();
        reset();
        this.setVisible(true);       
    }
    

   
                     
    private void initComponents() {
       

        zmenaZadani = new javax.swing.JTextArea();
        zmenaZadani.setColumns(20);
        zmenaZadani.setLineWrap(true);
        zmenaZadani.setRows(5);
        
         
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionEvent(evt);
            }});

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() { 
            public void actionPerformed(java.awt.event.ActionEvent evt) {reset();} });
        
    
       Box zadaniBox = Box.createHorizontalBox();
        this.add(zadaniBox);
        zadaniBox.add(new JLabel("Zadani"));
       zadaniBox.add(zmenaZadani);
       
          Box buttonBox = Box.createHorizontalBox();
        this.add(buttonBox);
        buttonBox.add(saveButton);
        buttonBox.add(resetButton);
              
    }
    

  
    
    private void saveButtonActionEvent(java.awt.event.ActionEvent evt) {

        otazka.setName(zmenaNazvu.getText());
        otazka.setZadani(zmenaZadani.getText());
    

        saved=true;
        
        if(no>0)
        Procesor.set(no, otazka);
        else
        Procesor.add(otazka);

    }
    
    private void reset() {
    
        if (no > 0) {
            zmenaNazvu.setText(Procesor.get(no).getName());
            zmenaZadani.setText(Procesor.get(no).getZadani());
        } else {
            zmenaNazvu.setText("");
            zmenaZadani.setText("");
        }

}
    }
