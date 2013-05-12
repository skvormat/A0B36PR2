package moodle.Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Box;
import moodle.Otazky.Abc;
import moodle.Otazky.Essay;
import moodle.Procesor;

/**
 *
 * @author Mates
 */
public class GuiMain extends javax.swing.JFrame {

    // private javax.swing.JButton createButtonAbc;
    //private javax.swing.JButton createButtonDlouhe;
    Map<Class, javax.swing.JButton> createButton = new HashMap<>();
    private javax.swing.JLabel nahledOtazky;
    private java.awt.List seznamOtazek;
    Edit editaceOt;
    Box editBox;

    public GuiMain() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    }

    private void initComponents() {
        this.setMinimumSize(new Dimension(800, 700));
        this.setMaximumSize(new Dimension(800, 700));
        this.setResizable(false);
        editaceOt = new EditAbc(0);

        seznamOtazek = new java.awt.List();

        seznamOtazek.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                seznamItemListener(evt);
            }
        });
        redrawSeznamu();

        createButton.put(Essay.class, new javax.swing.JButton());

        nahledOtazky = new javax.swing.JLabel();

        createButtonCreateButton(Abc.class, "Abc");
        createButtonCreateButton(Essay.class, "Essay");

        BorderLayout mujLayout = new BorderLayout();
        this.setLayout(mujLayout);
        Box mujBox = Box.createVerticalBox();

        this.add(mujBox, BorderLayout.WEST);
        mujBox.add(seznamOtazek).setSize(500, 500);
        mujBox.add(createButton.get(Abc.class));
        mujBox.add(createButton.get(Essay.class));

        editBox = Box.createHorizontalBox();

        this.add(editBox, BorderLayout.CENTER);

        pack();
    }

    private void createButtonCreateButton(Class classOtazky, String popisek) {

        createButton.put(classOtazky, new javax.swing.JButton());

        createButton.get(classOtazky).setText(popisek);
        createButton.get(classOtazky).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionEvent(evt);
            }
        });

    }

    private void createButtonActionEvent(ActionEvent evt) {
        editBox.removeAll();

        if (evt.getSource().hashCode() == createButton.get(Abc.class).hashCode()) {
            editaceOt = new EditAbc();
        }
        if (evt.getSource().hashCode() == createButton.get(Essay.class).hashCode()) {
            editaceOt = new EditEssay();
        }

        editBox.add(editaceOt);
        pack();
    }

    public void seznamItemListener(ItemEvent evt) {
        if (editaceOt.saved == true) {
            redrawSeznamu();
        }

        editBox.removeAll();
        if (Procesor.get(seznamOtazek.getSelectedIndex()).getClass() == Abc.class) {
            editaceOt = new EditAbc(seznamOtazek.getSelectedIndex());
        }

        if (Procesor.get(seznamOtazek.getSelectedIndex()).getClass() == Essay.class) {
            editaceOt = new EditEssay(seznamOtazek.getSelectedIndex());
        }


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
