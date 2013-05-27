/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moodle.Gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Mates generuje pole textboxu pro vyplneni odpovedi, jejich tvorbu na
 * zaklade listu, pridavani, ubirani a navraceni
 */
public class Odpovedi extends JPanel {

    List<JTextArea> vpisy = new ArrayList<>();
    JButton pridejPole;
    JButton uberPole;
    JLabel popisek = new JLabel();
    int index = 0;
    BorderLayout mujLayout;
    Box mujBox;
    String nadpis;

    /**
     *
     * @param seznam
     * @param nadpis
     */
    public Odpovedi(List seznam, String nadpis) {
        this.nadpis = nadpis;

        //vytvori prislusny pocet poli
        for (int i = 0; i < seznam.size(); i++) {
            vpisy.add(new JTextArea(seznam.get(i).toString(), 1, 20));
        }

        //jedno pole pro nulovy seznam
        if (seznam.isEmpty()) {
            vpisy.add(new JTextArea("", 1, 20));
        }

        mujLayout = new BorderLayout();
        this.setLayout(mujLayout);
        mujBox = Box.createVerticalBox();

        pridejPole = new JButton("Pridej");
        uberPole = new JButton("Uber");
 
        uberPole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                index--;
                redraw();
                //kdyz je 0 aktivnich poli, vypne ubirani
                if ((vpisy.size() + index) <= 0) {
                    uberPole.setEnabled(false);
                }
            }
        });
        pridejPole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (index >= 0) {
                    vpisy.add(new JTextArea("", 1, 20));
                } else {
                    index++;
                }

                uberPole.setEnabled(true);
                redraw();

            }
        });
        redraw();
    }

    //prekresli grafiku pri nacteni, pridani, ci ubrani
    private void redraw() {

        mujBox.removeAll();
        mujBox.setSize(200, WIDTH);
        Box tlacitka = Box.createHorizontalBox();
        mujBox.add(new JLabel(nadpis), CENTER_ALIGNMENT);
        
        tlacitka.add(pridejPole);
        tlacitka.add(Box.createHorizontalStrut(5));
        tlacitka.add(uberPole);

        mujBox.add(tlacitka, LEFT_ALIGNMENT);

        for (int i = 0; i < vpisy.size() + index; i++) {
            vpisy.get(i).setLineWrap(true);
            mujBox.add(Box.createVerticalStrut(5));
            mujBox.add(vpisy.get(i));

        }
        this.add(mujBox, BorderLayout.CENTER);
        pridejPole.setText("Pridej (" + (vpisy.size() + index) + ")");
    }

    /**
     *
     * @return
     * sesbira obsah z poli a vrati ho jako list
     */
    public List getList() {
        List otazky = new ArrayList();

        for (int i = 0; i < vpisy.size() + index; i++) {
            otazky.add(vpisy.get(i).getText().toString());
        }
        return otazky;
    }
}
