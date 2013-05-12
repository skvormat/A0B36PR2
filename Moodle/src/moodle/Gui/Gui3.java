package moodle.Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import javax.swing.Box;
import moodle.Otazky.Abc;
import moodle.Otazky.Essay;
import moodle.Procesor;

/**
 *
 * @author Mates
 */
public class Gui3 extends javax.swing.JFrame {

    private javax.swing.JButton createButton;
    private javax.swing.JLabel nahledOtazky;
    private java.awt.List seznamOtazek;
    Edit editaceOt;
    Box editBox;

    public Gui3() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    }

    private void initComponents() {
        this.setMinimumSize(new Dimension(500, 500));

        editaceOt = new EditAbc(0);

        seznamOtazek = new java.awt.List();

        seznamOtazek.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                seznamItemListener(evt);
            }
        });
        redrawSeznamu();

        createButton = new javax.swing.JButton();
        createButton.setText("Vytvor");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 editBox.removeAll();
                 
                editaceOt = new EditDlouhe();
                editBox.add(editaceOt);
                pack();
            }
        });

        nahledOtazky = new javax.swing.JLabel();

        BorderLayout mujLayout = new BorderLayout();
        this.setLayout(mujLayout);
        Box mujBox = Box.createVerticalBox();

        this.add(mujBox, BorderLayout.WEST);
        mujBox.add(seznamOtazek).setSize(500, 500);
        mujBox.add(createButton);

        editBox = Box.createHorizontalBox();

        this.add(editBox, BorderLayout.CENTER);

        pack();
    }

    public void seznamItemListener (ItemEvent evt){
    if (editaceOt.saved == true) redrawSeznamu();

    editBox.removeAll();
    if (Procesor.get(seznamOtazek.getSelectedIndex()).getClass()==Abc.class)
    editaceOt = new EditAbc(seznamOtazek.getSelectedIndex());
    
    if (Procesor.get(seznamOtazek.getSelectedIndex()).getClass()== Essay.class)
    editaceOt = new EditDlouhe(seznamOtazek.getSelectedIndex());
                
                
                editBox.add(editaceOt);
                pack();
    }
    
    public void redrawSeznamu() {
        int indexSeznamu = seznamOtazek.getSelectedIndex();
        seznamOtazek.removeAll();
        for (int i = 0; i < Procesor.size(); i++) {
            seznamOtazek.add(Procesor.get(i).getName());

        }
        seznamOtazek.select(indexSeznamu);
    }
}
