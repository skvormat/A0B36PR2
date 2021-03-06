package moodle.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import moodle.Otazky.Essay;
import moodle.Procesor;

/**
 *
 * @author Mates
 */
public final class EditEssay extends Edit {

    private Essay otazka;
    private javax.swing.JTextArea zmenaZadani;

    /**
     *
     * @param no
     */
    public EditEssay(int no) {
        super(no);

        otazka = (Essay) Procesor.get(no);
        initComponents();
        reset();
        this.setVisible(true);
    }

    /**
     *
     */
    public EditEssay() {
        super(-1);
        otazka = new Essay();
        initComponents();
        reset();
        this.setVisible(true);
    }

    private void initComponents() {
        zmenaZadani = new javax.swing.JTextArea();
        zmenaZadani.setColumns(50);
        zmenaZadani.setLineWrap(true);
        zmenaZadani.setRows(5);

        JPanel hlavniPanel = new JPanel();
        hlavniPanel.setLayout(new GridBagLayout());
        GridLayoutManager.a(hlavniPanel, new JLabel("Název:"), 0, 0, 1, 1, GridBagConstraints.EAST);
        GridLayoutManager.a(hlavniPanel, new JLabel("Zadání:"), 0, 1, 1, 1, GridBagConstraints.EAST);
        GridLayoutManager.a(hlavniPanel, zmenaNazvu, 1, 0, 2, 1, GridBagConstraints.WEST);
        GridLayoutManager.a(hlavniPanel, new JScrollPane(zmenaZadani), 1, 1, 1, 1, GridBagConstraints.WEST);

        this.add(hlavniPanel);
    }

    /**
     *
     * @param evt
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
