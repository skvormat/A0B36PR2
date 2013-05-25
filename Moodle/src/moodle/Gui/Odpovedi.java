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
import javax.swing.JTextField;

/**
 *
 * @author Mates
 */
public class Odpovedi extends JPanel {

    List<JTextField> vpisy = new ArrayList<>();
    JButton pridej;
    JButton reduce;
    JLabel popisek = new JLabel();
    int index = 0;
    BorderLayout mujLayout;
    Box mujBox;

    public Odpovedi(List seznam) {
        for (int i = 0; i < seznam.size(); i++) {
            vpisy.add(new JTextField(seznam.get(i).toString(), 20));
        }
        if (seznam.size() == 0) {
            vpisy.add(new JTextField("", 20));
        }

        mujLayout = new BorderLayout();
        this.setLayout(mujLayout);
        mujBox = Box.createVerticalBox();

        pridej = new JButton("Pridej");
        reduce = new JButton("Redukuj");

        reduce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                index--;

                redraw();
                if ((vpisy.size()+index)<=0) {
                    reduce.setEnabled(false);

                }

            }
        });

        pridej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(index>=0)
                vpisy.add(new JTextField("", 20));
                else
                    index++;
                
                reduce.setEnabled(true);
                redraw();

            }
        });
        redraw();
    }

    private void redraw() {

        mujBox.removeAll();
        mujBox.add(reduce);
        mujBox.add(pridej);

        for (int i = 0; i < vpisy.size() + index; i++) {
            mujBox.add(vpisy.get(i));
        }
        this.add(mujBox, BorderLayout.CENTER);
        pridej.setText("dalsi" + (vpisy.size() + index));
    }

    public List getList() {
        List otazky = new ArrayList();

        for (int i = 0; i < vpisy.size() + index; i++) {
            otazky.add(vpisy.get(i).getText().toString());
        }
        return otazky;
    }
}
