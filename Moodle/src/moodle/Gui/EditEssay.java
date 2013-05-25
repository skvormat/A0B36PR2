package moodle.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import moodle.Otazky.Essay;
import moodle.Procesor;

/**
 *
 * @author Mates
 */
public class EditEssay extends Edit{
    
   Essay otazka;
        
    javax.swing.JTable tabulkaOdpovedi;
    javax.swing.JTextArea zmenaZadani;


    public EditEssay(int no) {
       super(no);
       
        otazka = (Essay) Procesor.get(no);
        initComponents();
        reset();
        this.setVisible(true);
    }

    public EditEssay() {
        super(-1);
        otazka= new Essay();
        initComponents();
        reset();
        this.setVisible(true);       
    }
    
    private void initComponents() {
        zmenaZadani = new javax.swing.JTextArea();
        zmenaZadani.setColumns(50);
        zmenaZadani.setLineWrap(true);
        zmenaZadani.setRows(5);
    
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
           a.a(panel1, new JLabel("Název:"), 0, 0, 1, 1, GridBagConstraints.EAST);
        a.a(panel1, new JLabel("Zadání:"), 0, 1, 1, 1, GridBagConstraints.EAST);
      
        a.a(panel1, zmenaNazvu, 1, 0, 2, 1, GridBagConstraints.WEST);

        a.a(panel1, new JScrollPane(zmenaZadani), 1, 1, 1, 1, GridBagConstraints.WEST);
        
     this.add(panel1);
    }
    
   @Override
    public void saveButtonActionEvent(java.awt.event.ActionEvent evt) {

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
