package moodle.Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JButton;
import moodle.Otazky.Abc;
import moodle.Otazky.Cloze;
import moodle.Otazky.Essay;
import moodle.Otazky.TrueFalse;
import moodle.Procesor;

/**
 *
 * @author Mates
 */
public final class GuiMain extends javax.swing.JFrame {

    private Map<Class, javax.swing.JButton> createOtazkaButton = new HashMap<>();
    private java.awt.List listOtazek;
    private HorniMenu bar = new HorniMenu();
    private Edit editOtazkaPanel;
    private Box editBox;
    private JButton save, reset;

    /**
     *
     */
    public GuiMain() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    }

    private void initComponents() {
        this.setMinimumSize(new Dimension(800, 700));
        this.setMaximumSize(new Dimension(800, 700));
        this.setResizable(false);

        listOtazek = new java.awt.List(); //list otazek

        //pri zmene prekresli       
        listOtazek.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                prekresliList();
            }
        });
        listOtazek.addMouseListener(new java.awt.event.MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                    if (Procesor.redraw == true) {
            redrawListuOtazek();
            Procesor.redraw = false;

        }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });


        redrawListuOtazek();//
        createOtazkaButton.put(Essay.class, new javax.swing.JButton());

        //vytvoreni tlacitek pro jednotlive tridz otazek
        createButtonCreateOtazkaButton(Abc.class, "Abc");
        createButtonCreateOtazkaButton(Essay.class, "Essay");
        createButtonCreateOtazkaButton(TrueFalse.class, "True/False");
        createButtonCreateOtazkaButton(Cloze.class, "Cloze");

        save = new JButton("Save");//ulozeni OT
        reset = new JButton("Reset");//Reset OT

        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOtazkaPanel.saveButtonActionEvent(evt);//vola save obstraktni editace odkud ji dedi jednotlive editacni tridy
                redrawListuOtazek();
            }
        });
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prekresliList();
            }
        });
        initGrafiky();
    }

    private void initGrafiky() {
        //pridani baru
        this.setJMenuBar(bar);


//tvorba zakladniho leyoutu
        this.setLayout(new BorderLayout());
        Box zakladniLauot = Box.createVerticalBox();

        this.add(zakladniLauot, BorderLayout.WEST);


        zakladniLauot.add(listOtazek).setSize(500, 500);
        zakladniLauot.add(Box.createVerticalStrut(5));

//boxy jednotlivych radku tlacitek
        Box boxTlacitka1 = Box.createHorizontalBox();
        boxTlacitka1.add(createOtazkaButton.get(Abc.class));
        boxTlacitka1.add(createOtazkaButton.get(Essay.class));
        zakladniLauot.add(boxTlacitka1);
        zakladniLauot.add(Box.createVerticalStrut(5));

        Box boxTlacitka2 = Box.createHorizontalBox();
        boxTlacitka2.add(createOtazkaButton.get(TrueFalse.class));
        boxTlacitka2.add(createOtazkaButton.get(Cloze.class));
        zakladniLauot.add(boxTlacitka2);
        zakladniLauot.add(Box.createVerticalStrut(5));

        Box boxTlacitkaSaveReset = Box.createHorizontalBox();
        boxTlacitkaSaveReset.add(save);
        boxTlacitkaSaveReset.add(reset);
        zakladniLauot.add(boxTlacitkaSaveReset);


        editBox = Box.createHorizontalBox();

        this.add(editBox, BorderLayout.CENTER);


        pack();
    }

    //metoda tvorby tlacitek pro tvorbu otazek
    private void createButtonCreateOtazkaButton(Class classOtazky, String popisek) {

        createOtazkaButton.put(classOtazky, new javax.swing.JButton());
        createOtazkaButton.get(classOtazky).setText(popisek);
        createOtazkaButton.get(classOtazky).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createOtazkaButtonActionEvent(evt);
            }
        });

    }

    //event tlacitek tvorby otazek, dle typu zvoli spravne editokno
    private void createOtazkaButtonActionEvent(ActionEvent evt) {
        editBox.removeAll();

        if (evt.getSource().hashCode() == createOtazkaButton.get(Abc.class).hashCode()) {
            editOtazkaPanel = new EditAbc();
        }
        if (evt.getSource().hashCode() == createOtazkaButton.get(Essay.class).hashCode()) {
            editOtazkaPanel = new EditEssay();
        }
        if (evt.getSource().hashCode() == createOtazkaButton.get(TrueFalse.class).hashCode()) {
            editOtazkaPanel = new EditTrueFalse();
        }
        if (evt.getSource().hashCode() == createOtazkaButton.get(Cloze.class).hashCode()) {
            editOtazkaPanel = new EditCloze();
        }

        editBox.add(editOtazkaPanel);
        pack();
    }

    /**
     * prekresli list otazek
     */
    private void prekresliList() {
        if(Procesor.size()!=0)
        {     
            
        if (Procesor.redraw == true) {
            redrawListuOtazek();
            Procesor.redraw = false;

        }

        //podle typu zvolene otazky zvoli editacni panel
        try {
            editBox.removeAll();
            if (Procesor.get(listOtazek.getSelectedIndex()).getClass() == Abc.class) {
                editOtazkaPanel = new EditAbc(listOtazek.getSelectedIndex());
            }

            if (Procesor.get(listOtazek.getSelectedIndex()).getClass() == Essay.class) {
                editOtazkaPanel = new EditEssay(listOtazek.getSelectedIndex());
            }
            if (Procesor.get(listOtazek.getSelectedIndex()).getClass() == TrueFalse.class) {
                editOtazkaPanel = new EditTrueFalse(listOtazek.getSelectedIndex());
            }
            if (Procesor.get(listOtazek.getSelectedIndex()).getClass() == Cloze.class) {
                editOtazkaPanel = new EditCloze(listOtazek.getSelectedIndex());
            }
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Pretekl seznam v prekresleni");
        } catch (NullPointerException e) {
            System.out.println("nullPointer seznam v prekresleni");
        }

        editBox.add(editOtazkaPanel);
        pack();
        }

    }

    /**
     * prekresli list otazek
     */
    private void redrawListuOtazek() {
        int indexSeznamu = listOtazek.getSelectedIndex();
        listOtazek.removeAll();


        for (int i = 0; i < Procesor.size(); i++) {
            listOtazek.add(Procesor.get(i).getName());
        }
        listOtazek.select(indexSeznamu);
    }
}
