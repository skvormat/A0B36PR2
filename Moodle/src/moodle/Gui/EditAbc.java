package moodle.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import moodle.Otazky.Abc;
import moodle.Procesor;

/**
 *
 * @author Mates
 */
public class EditAbc extends Edit {

    Abc otazkaAbc;
    javax.swing.JTextArea zmenaZadani;
    JScrollPane scroll;
    Odpovedi odpovediSpravne, odpovediSpatne;

    public EditAbc(int no) {
        super(no);
        otazkaAbc = (Abc) Procesor.get(no);
        initComponents();
        reset();
        this.setVisible(true);
    }

    public EditAbc() {
        super();
        otazkaAbc = new Abc();
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {

        zmenaZadani = new javax.swing.JTextArea();

        zmenaZadani.setColumns(50);
        zmenaZadani.setLineWrap(true);
        zmenaZadani.setRows(5);
        zmenaZadani.setSize(100, 300);
        scroll = new JScrollPane(zmenaZadani);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        a.a(panel1, new JLabel("Název:"), 0, 0, 1, 1, GridBagConstraints.EAST);
        a.a(panel1, new JLabel("Zadání:"), 0, 1, 1, 1, GridBagConstraints.EAST);
        a.a(panel1, new JLabel("Odpovedi:"), 0, 2, 1, 1, GridBagConstraints.EAST);

        a.a(panel1, zmenaNazvu, 1, 0, 2, 1, GridBagConstraints.WEST);

        a.a(panel1, new JScrollPane(zmenaZadani), 1, 1, 1, 1, GridBagConstraints.WEST);

        odpovediSpatne = new Odpovedi(otazkaAbc.getSpatne());
        odpovediSpravne = new Odpovedi(otazkaAbc.getSpravne());
        a.a(panel1, odpovediSpatne, 1, 2, 2, 1, GridBagConstraints.NORTHWEST);
        a.a(panel1, odpovediSpravne, 1, 2, 2, 1, GridBagConstraints.NORTHEAST);
        
        
       




        this.add(panel1);

        this.setVisible(true);


    }

    @Override
    public void saveButtonActionEvent(java.awt.event.ActionEvent evt) {

        otazkaAbc.setName(zmenaNazvu.getText());
        otazkaAbc.setZadani(zmenaZadani.getText());

        otazkaAbc.setSpatne(odpovediSpatne.getList());
        otazkaAbc.setSpravne(odpovediSpravne.getList());
        saved = true;

        if (no > 0) {
            Procesor.set(no, otazkaAbc);
        } else {
            Procesor.add(otazkaAbc);
        }



    }

    private void reset() {
        if (no > 0) {
            zmenaNazvu.setText(Procesor.get(no).getName());
            zmenaZadani.setText(Procesor.get(no).getZadani());
        }
      
    }



}
