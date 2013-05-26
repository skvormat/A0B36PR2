package moodle.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import moodle.Procesor;

public class JMenuDemo extends JMenuBar {

    public JMenuDemo() {
        // Creates a menubar for a JFrame
        JMenuBar menuBar = new JMenuBar();

        this.add(menuBar);

        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");

        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Create and add simple menu item to one of the drop down menu
        JMenuItem newAction = new JMenuItem("Novy");
        JMenuItem openAction = new JMenuItem("Open");
        JMenuItem saveAction = new JMenuItem("Save");
        JMenuItem exitAction = new JMenuItem("Exit");

        JMenuItem exportAction = new JMenuItem("Export");

    
        fileMenu.add(newAction);
        fileMenu.add(saveAction);
        fileMenu.add(openAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);

        editMenu.addSeparator();
        editMenu.add(exportAction);

   
        exportAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser chooser = new JFileChooser();

                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int option = chooser.showOpenDialog(chooser);
                if (option == JFileChooser.APPROVE_OPTION) {
                    if (chooser.getSelectedFile() != null) {
                        File theFileToSave = chooser.getSelectedFile();

                        Procesor.xmlExport(theFileToSave);

                    }
                }
            }
        ;
        });            
        saveAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser chooser = new JFileChooser();

                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int option = chooser.showOpenDialog(chooser);
                if (option == JFileChooser.APPROVE_OPTION) {
                    if (chooser.getSelectedFile() != null) {
                        File theFileToSave = chooser.getSelectedFile();

                        Procesor.save(theFileToSave);

                    }
                }
            }
        ;
        });            
        openAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser chooser = new JFileChooser();

                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int option = chooser.showOpenDialog(chooser);
                if (option == JFileChooser.APPROVE_OPTION) {
                    if (chooser.getSelectedFile() != null) {
                        File theFileToSave = chooser.getSelectedFile();

                        Procesor.load(theFileToSave);


                    }
                }
            }
        ;
        });      
        newAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Procesor.clear();


            }
        ;
        });              
        exitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                System.exit(0);

            }
        ;
    });      

  
       }


}