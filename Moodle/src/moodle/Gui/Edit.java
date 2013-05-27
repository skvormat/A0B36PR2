/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moodle.Gui;

/**
 * Abstraktni trida ze ktere dedi panely editace otazek
 *
 * @author Mates
 */
abstract class Edit extends javax.swing.JPanel {

    int no = -1;
    boolean saved = false;
    javax.swing.JTextField zmenaNazvu;

    public Edit(int no) {
        this.no = no;
        initComponents();

    }

    public Edit() {
        initComponents();
    }

    private void initComponents() {
        zmenaNazvu = new javax.swing.JTextField(20);


    }

    //obsluha tlacitka ulozeni
    public void saveButtonActionEvent(java.awt.event.ActionEvent evt) {
        System.out.println("neni implementovano");
    }

    //reset obsahu otazky
    public void reset() {
        System.out.println("neni implementovano");

    }
}
