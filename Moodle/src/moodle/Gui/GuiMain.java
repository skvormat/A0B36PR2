package moodle.Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import moodle.Otazky.Abc;
import moodle.Otazky.Essay;
import moodle.Procesor;
import sun.misc.JavaxSecurityAuthKerberosAccess;

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
    JMenuDemo bar = new JMenuDemo();
    Edit editaceOt;
    Box editBox;
    JButton save, reset;

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
                prekresli();
            }
        });

        redrawSeznamu();
        createButton.put(Essay.class, new javax.swing.JButton());

        nahledOtazky = new javax.swing.JLabel();

        createButtonCreateButton(Abc.class, "Abc");
        createButtonCreateButton(Essay.class, "Essay");
        save = new JButton("Save");

        BorderLayout mujLayout = new BorderLayout();
        this.setLayout(mujLayout);
        Box mujBox = Box.createVerticalBox();

        this.add(mujBox, BorderLayout.WEST);


        mujBox.add(seznamOtazek).setSize(500, 500);
                
        Box tlacitka = Box.createHorizontalBox();
        
        
        tlacitka.add(createButton.get(Abc.class));
        tlacitka.add(createButton.get(Essay.class));

        Box tlacitka2 = Box.createHorizontalBox();
        tlacitka2.add(save);
        
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaceOt.saveButtonActionEvent(evt);
                redrawSeznamu();
            }
        });

        reset = new JButton("Reset");
        tlacitka2.add(reset);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prekresli();
            }
        });
mujBox.add(tlacitka);
mujBox.add(tlacitka2);

        editBox = Box.createHorizontalBox();

        this.add(editBox, BorderLayout.CENTER);


bar.setFocusable(true);
bar.isFocusOwner();
        this.setJMenuBar(bar);

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

    public void prekresli() {
        if (Procesor.redraw == true) {
            redrawSeznamu();
            Procesor.redraw = false;

        }

        try {
            editBox.removeAll();
            if (Procesor.get(seznamOtazek.getSelectedIndex()).getClass() == Abc.class) {
                editaceOt = new EditAbc(seznamOtazek.getSelectedIndex());
            }

            if (Procesor.get(seznamOtazek.getSelectedIndex()).getClass() == Essay.class) {
                editaceOt = new EditEssay(seznamOtazek.getSelectedIndex());
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Pretekl seznam v prekresleni");
        } catch (NullPointerException e) {
            System.out.println("nullPointer seznam v prekresleni");

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
