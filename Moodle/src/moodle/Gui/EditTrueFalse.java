package moodle.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import moodle.Procesor;
import moodle.Otazky.TrueFalse;

/**
 *
 * @author Mates
 */
public final class EditTrueFalse extends Edit {

    private TrueFalse otazka;
    private javax.swing.JTextArea zmenaZadani;
    private JButton pravdaNepravda;
    private boolean odpovedTrueFalse;

    /**
     *
     * @param no
     */
    public EditTrueFalse(int no) {
        super(no);

        otazka = (TrueFalse) Procesor.get(no);
        initComponents();
        reset();
        this.setVisible(true);
    }

    /**
     *
     */
    public EditTrueFalse() {
        super(-1);
        otazka = new TrueFalse();
        initComponents();
        reset();
        this.setVisible(true);
    }

    private void initComponents() {
        zmenaZadani = new javax.swing.JTextArea();
        zmenaZadani.setColumns(50);
        zmenaZadani.setLineWrap(true);
        zmenaZadani.setRows(5);
        pravdaNepravda = new JButton("");
        
        odpovedTrueFalse=otazka.getOdpoved();
        
        if (odpovedTrueFalse) {
            pravdaNepravda.setText("Pravda");
        } else {
            pravdaNepravda.setText("Nepravda");

        }

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridLayoutManager.a(panel1, new JLabel("Název:"), 0, 0, 1, 1, GridBagConstraints.EAST);
        GridLayoutManager.a(panel1, new JLabel("Zadání:"), 0, 1, 1, 1, GridBagConstraints.EAST);
        GridLayoutManager.a(panel1, zmenaNazvu, 1, 0, 2, 1, GridBagConstraints.WEST);
        GridLayoutManager.a(panel1, new JScrollPane(zmenaZadani), 1, 1, 1, 1, GridBagConstraints.WEST);
        GridLayoutManager.a(panel1, pravdaNepravda, 1, 3, 1, 1, GridBagConstraints.CENTER);

        this.add(panel1);


        pravdaNepravda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (otazka.getOdpoved()) {
                    pravdaNepravda.setText("Nepravda");
                    odpovedTrueFalse=(false);
                } else {
                    pravdaNepravda.setText("Pravda");

                    odpovedTrueFalse=(true);
                }
            }
        });

    }

    /**
     *
     * @param evt
     */
    @Override
    public void saveButtonActionEvent(java.awt.event.ActionEvent evt) {

        otazka.setName(zmenaNazvu.getText());
        otazka.setZadani(zmenaZadani.getText());
otazka.setOdpoved(odpovedTrueFalse);

        saved = true;

        if (no > -1 && Procesor.size() > 0) {
            Procesor.set(no, otazka);
        } else {
            Procesor.add(otazka);
            no = Procesor.size() - 1;

        }


    }

    @Override
    public void reset() {
odpovedTrueFalse=otazka.getOdpoved();
        if (otazka.getOdpoved()) {
            pravdaNepravda.setText("Pravda");
        } else {
            pravdaNepravda.setText("Nepravda");

        }
        
        if (no > -1 && Procesor.size() > 0) {
            zmenaNazvu.setText(Procesor.get(no).getName());
            zmenaZadani.setText(Procesor.get(no).getZadani());
        } else {
            zmenaNazvu.setText("");
            zmenaZadani.setText("");
        }
        
        

    }
}
