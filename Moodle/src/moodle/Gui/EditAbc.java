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
public final class EditAbc extends Edit {

   private Abc otazkaAbc;
   private javax.swing.JTextArea zmenaZadani;
   private Odpovedi odpovediSpravne, odpovediSpatne;

    /**
     *
     * @param no
     */
    public EditAbc(int no) {
        super(no);
        otazkaAbc = (Abc) Procesor.get(no);
        initComponents();
        this.reset();
        this.setVisible(true);
    }

    /**
     *
     */
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
       try{
        odpovediSpatne = new Odpovedi(otazkaAbc.getSpatne(),"Spatne");
        odpovediSpravne = new Odpovedi(otazkaAbc.getSpravne(), "Spravne");
           }catch (Exception exc) {
            System.out.println("Pretekly odpovedi v Abc");
            System.out.println("Osetreno:");
        }
        
        

        JPanel panelHlavni = new JPanel();
        panelHlavni.setLayout(new GridBagLayout());
        GridLayoutManager.a(panelHlavni, new JLabel("Název:"), 0, 0, 1, 1, GridBagConstraints.EAST);
        GridLayoutManager.a(panelHlavni, new JLabel("Zadání:"), 0, 1, 1, 1, GridBagConstraints.EAST);
        GridLayoutManager.a(panelHlavni, new JLabel("Odpovedi:"), 0, 2, 1, 1, GridBagConstraints.EAST);
        GridLayoutManager.a(panelHlavni, zmenaNazvu, 1, 0, 2, 1, GridBagConstraints.WEST);
        GridLayoutManager.a(panelHlavni, new JScrollPane(zmenaZadani), 1, 1, 1, 1, GridBagConstraints.WEST);
        GridLayoutManager.a(panelHlavni, odpovediSpatne, 1, 2, 2, 1, GridBagConstraints.NORTHWEST);
        GridLayoutManager.a(panelHlavni, odpovediSpravne, 1, 2, 2, 1, GridBagConstraints.NORTHEAST);
        this.add(panelHlavni);
        this.setVisible(true);


    }

    /**
     *
     * @param evt
     */
    @Override
    public void saveButtonActionEvent(java.awt.event.ActionEvent evt) {

        otazkaAbc.setName(zmenaNazvu.getText());
        otazkaAbc.setZadani(zmenaZadani.getText());

        otazkaAbc.setSpatne(odpovediSpatne.getList());
        otazkaAbc.setSpravne(odpovediSpravne.getList());
        saved = true;

        if (no > -1&& Procesor.size()>0) {
            Procesor.set(no, otazkaAbc);
        } else {
            Procesor.add(otazkaAbc);
            no=Procesor.size()-1;
        }



    }

   @Override
    public void reset() {
        if (no >= 0) {
            zmenaNazvu.setText(Procesor.get(no).getName());
            zmenaZadani.setText(Procesor.get(no).getZadani());
        }
      
    }



}
