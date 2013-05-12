package moodle.Gui;

import javax.swing.Box;
import javax.swing.JLabel;
import moodle.Otazky.Abc;
import moodle.Procesor;

/**
 *
 * @author Mates
 */
public class EditAbc extends Edit {

    Abc otazkaAbc;
    javax.swing.JTable tabulkaOdpovedi;
    javax.swing.JTextArea zmenaZadani;

    public EditAbc(int no) {
        super(no);
        otazkaAbc = (Abc) Procesor.get(no);
        initComponents();
        reset();
        this.setVisible(true);
        this.getAbc();
    }

    private void initComponents() {

        zmenaZadani = new javax.swing.JTextArea();
        zmenaZadani.setColumns(20);
        zmenaZadani.setLineWrap(true);
        zmenaZadani.setRows(5);




        tabulkaOdpovedi = new javax.swing.JTable();

        tabulkaOdpovedi.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
            {null, null},
            {null, null},
            {null, null},
            {null, null},
            {null, null},
            {null, null},
            {null, null},
            {null, null}
        },
                new String[]{
            "Spravne", "Spatne"
        }) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });

        
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

        Box odpovediBox = Box.createHorizontalBox();
        this.add(odpovediBox);
        odpovediBox.add(new JLabel("Odpovedi"));
        odpovediBox.add(tabulkaOdpovedi);

        Box buttonBox = Box.createHorizontalBox();
        this.add(buttonBox);
        buttonBox.add(saveButton);
        buttonBox.add(resetButton);


    }

    private void getAbc() {
        for (int i = 0; i < otazkaAbc.getSpatne().size(); i++) {
            tabulkaOdpovedi.getModel().setValueAt(otazkaAbc.getSpatne().get(i), i, 1);
        }

        for (int i = 0; i < otazkaAbc.getSpravne().size(); i++) {
            tabulkaOdpovedi.getModel().setValueAt(otazkaAbc.getSpravne().get(i), i, 0);
        }
    }

    private void setAbc() {
//desna prasecina s catch try
        otazkaAbc.nulovatSpravneSpatne();
        try {
            for (int i = 0; i < tabulkaOdpovedi.getWidth();) {
                otazkaAbc.addSpatne(tabulkaOdpovedi.getValueAt(i, 1).toString());
                i++;
            }
        } catch (NullPointerException e) {
            System.out.println("preteklo spatne");
        }

        try {
            for (int i = 0; i < tabulkaOdpovedi.getWidth();) {
                otazkaAbc.addSpravne(tabulkaOdpovedi.getValueAt(i, 0).toString());
                i++;
            }
        } catch (NullPointerException e) {
            System.out.println("preteklo spravne");
        }


    }

    private void saveButtonActionEvent(java.awt.event.ActionEvent evt) {

        otazkaAbc.setName(zmenaNazvu.getText());
        otazkaAbc.setZadani(zmenaZadani.getText());
        setAbc();

        saved = true;

        if (no < 0) {
            Procesor.set(no, otazkaAbc);
        } else {
            Procesor.add(otazkaAbc);
        }



    }

    private void reset() {
        zmenaNazvu.setText(Procesor.get(no).getName());
        zmenaZadani.setText(Procesor.get(no).getZadani());
    }
}
