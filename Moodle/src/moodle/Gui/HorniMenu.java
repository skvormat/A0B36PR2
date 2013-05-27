package moodle.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import moodle.Procesor;

/**
 *
 * @author Mates
 */
public class HorniMenu extends JMenuBar {

    /**
     *
     */
    public HorniMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.add(menuBar);


        //jednotliva menu baru
        JMenu spaceMenu = new JMenu("                                                 ");
        spaceMenu.enable(false);
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        //pridani menu na bar
        menuBar.add(spaceMenu);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //vytvoreni polozek
        JMenuItem newAction = new JMenuItem("Novy");
        JMenuItem openAction = new JMenuItem("Open");
        JMenuItem addAction = new JMenuItem("Add");
        JMenuItem saveAction = new JMenuItem("Save");
        JMenuItem exitAction = new JMenuItem("Exit");

        JMenuItem exportAction = new JMenuItem("Export");
        JMenuItem csvImportAction = new JMenuItem("Import z csv");

        //pridani polozek do menu
        fileMenu.add(newAction);
        fileMenu.add(saveAction);
        fileMenu.add(addAction);
        fileMenu.add(openAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);

        editMenu.addSeparator();
        editMenu.add(exportAction);
        editMenu.add(csvImportAction);



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

                        Procesor.load(theFileToSave, false);


                    }
                }
            }
        ;
        });      
        addAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser chooser = new JFileChooser();

                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int option = chooser.showOpenDialog(chooser);
                if (option == JFileChooser.APPROVE_OPTION) {
                    if (chooser.getSelectedFile() != null) {
                        File theFileToSave = chooser.getSelectedFile();

                        Procesor.load(theFileToSave, true);


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
        csvImportAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, "Jedna se o experimentalni (nedodelanou) funkci! ");

                JFileChooser chooser = new JFileChooser();

                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int option = chooser.showOpenDialog(chooser);
                if (option == JFileChooser.APPROVE_OPTION) {
                    if (chooser.getSelectedFile() != null) {
                        File theFileToSave = chooser.getSelectedFile();

                        Procesor.readAbc(theFileToSave);

                    }
                }

            }
        ;
    }

);      

  
       }
}