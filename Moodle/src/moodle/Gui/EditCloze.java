package moodle.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import moodle.Otazky.Cloze;
import moodle.Procesor;

/**
 *
 * @author Mates
 */
public final class EditCloze extends Edit {

    private Cloze otazka;
    private    javax.swing.JTable tabulkaOdpovedi;
    private javax.swing.JTextArea zmenaZadani;
    private JButton prevod;

    /**
     *editace otazky z procesoru
     * @param no
     */
    public EditCloze(int no) {
        super(no);

        otazka = (Cloze) Procesor.get(no);
        initComponents();
        reset();
        this.setVisible(true);
    }

    /**
     *vytvoreni nove otazky
     */
    public EditCloze() {
        super(-1);
        otazka = new Cloze();
        initComponents();
        reset();
        this.setVisible(true);
    }

    private void initComponents() {
        zmenaZadani = new javax.swing.JTextArea();
        zmenaZadani.setColumns(50);
        zmenaZadani.setLineWrap(true);
        zmenaZadani.setRows(10);
        prevod = new JButton("Preved"); //tlacitko ukaze prevod na cloze format

        JPanel hlavniPanel = new JPanel();
        hlavniPanel.setLayout(new GridBagLayout());
        GridLayoutManager.a(hlavniPanel, new JLabel("Název:"), 0, 0, 1, 1, GridBagConstraints.EAST);
        GridLayoutManager.a(hlavniPanel, new JLabel("Zadání:"), 0, 1, 1, 1, GridBagConstraints.EAST);
        GridLayoutManager.a(hlavniPanel, zmenaNazvu, 1, 0, 2, 1, GridBagConstraints.WEST);
        GridLayoutManager.a(hlavniPanel, new JScrollPane(zmenaZadani), 1, 1, 1, 1, GridBagConstraints.WEST);
        GridLayoutManager.a(hlavniPanel, new JLabel("Skrytou odpoved umistete do <<tajenka>>"), 1, 3, 1, 1, GridBagConstraints.CENTER);
        GridLayoutManager.a(hlavniPanel, prevod, 0, 3, 1, 1, GridBagConstraints.CENTER);

        this.add(hlavniPanel);

        prevod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 otazka.setZadani(zmenaZadani.getText());
                JOptionPane.showMessageDialog(null, "Prevede se na:\n" + otazka.getZadaniPrevod());
            }
        });
    }

    /**
     *
     * @param evt
     * ulozi otazku, pripadne vytvori novou GridLayoutManager ulozi
     */
    @Override
    public void saveButtonActionEvent(java.awt.event.ActionEvent evt) {

        otazka.setName(zmenaNazvu.getText());
        otazka.setZadani(zmenaZadani.getText());


        saved = true;

        if (no > -1 && Procesor.size() > 0) {
            Procesor.set(no, otazka);
        } else {
            Procesor.add(otazka);
            no = Procesor.size() - 1;

        }


    }
    
    //znovunacte otazku, v pripade ze se tvori nova jen nuluje
     @Override 
    public void reset() {

        if (no > -1) {
            zmenaNazvu.setText(Procesor.get(no).getName());
            zmenaZadani.setText(Procesor.get(no).getZadani());
        } else {
            zmenaNazvu.setText("");
            zmenaZadani.setText("");
        }

    }
}
