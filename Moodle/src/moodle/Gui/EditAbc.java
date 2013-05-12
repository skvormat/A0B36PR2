package moodle.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    JScrollPane scroll;

    public EditAbc(int no) {
        super(no);
        otazkaAbc = (Abc) Procesor.get(no);
        initComponents();
        reset();
        this.setVisible(true);
        this.getAbc();
    }

        public EditAbc() {
        super();
        otazkaAbc = new Abc();
        initComponents();
        this.setVisible(true);
        this.getAbc();
    }

    private void initComponents() {

        zmenaZadani = new javax.swing.JTextArea();
       
        zmenaZadani.setColumns(50);
        zmenaZadani.setLineWrap(true);
        zmenaZadani.setRows(5);
        zmenaZadani.setSize(100, 300);
        scroll =new JScrollPane(zmenaZadani);
          
          
 //scroll.add(zmenaZadani);



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

        
          JPanel panel1 = new JPanel();
    panel1.setLayout(new GridBagLayout());
    addItem(panel1, new JLabel("Name:"), 0, 0, 1, 1, GridBagConstraints.EAST);
    addItem(panel1, new JLabel("Phone:"), 0, 1, 1, 1, GridBagConstraints.EAST);
 addItem(panel1, new JLabel("Odpovedi:"), 0, 2, 1, 1, GridBagConstraints.EAST);

        addItem(panel1, zmenaNazvu, 1, 0, 2, 1, GridBagConstraints.WEST);
        
       
    addItem(panel1, new JScrollPane(zmenaZadani), 1, 1, 1, 1, GridBagConstraints.WEST);
    
    
    
    addItem(panel1, new Odpovedi(otazkaAbc.getSpatne()), 1, 2, 2, 1, GridBagConstraints.WEST);
    
    
    

    
    this.add(panel1);
    
    this.setVisible(true);

    //    this.setLayout(new GridBagLayout());
  //      this.add(new JLabel("nazev:"), new GBCBuilder(0, 0, 1, 1).inset(10, 5).alignRight().build());
      //  this.add(zmenaNazvu, new GBCBuilder(1, 0, 5, 1).fillX().build());        
   //     
    //     this.add(new JLabel("zadani:"), new GBCBuilder(0, 1, 1, 1).inset(10, 5).alignRight().build());
 //   this.add(zmenaZadani, new GBCBuilder(1, 0, 2, 1).fillX().build());
    
//    this.add(new JLabel("Password:"), new GBCBuilder(0, 1, 1, 1).inset(10, 5).alignRight().build());
//    this.add(new JTextField(), new GBCBuilder(1, 1, 2, 1).fillX().build());
// 
//    this.add(new JButton("Login"), new GBCBuilder(1, 2, 1, 1).pad(5, 20).build());
//    this.add(new JButton("Exit"), new GBCBuilder(2, 2, 1, 1).pad(5, 5).build());
// 
//    this.add(new JLabel("Are you not a member?"), new GBCBuilder(1, 3, 2, 1).inset(0, 20).alignCenter().build());
//    this.add(new JButton("Register here..."), new GBCBuilder(1, 4, 2, 1).fill().alignCenter().build());
//        
    
    
    
//        Box zadaniBox = Box.createHorizontalBox();
//        this.add(zadaniBox);
//        zadaniBox.add(new JLabel("Zadani"));
//        zadaniBox.add(zmenaZadani);
//
//        Box odpovediBox = Box.createHorizontalBox();
//        this.add(odpovediBox);
//        odpovediBox.add(new JLabel("Odpovedi"));
//        odpovediBox.add(tabulkaOdpovedi);
//
//        Box buttonBox = Box.createHorizontalBox();
//        this.add(buttonBox);
//        buttonBox.add(saveButton);
//        buttonBox.add(resetButton);


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

        if (no > 0) {
            Procesor.set(no, otazkaAbc);
        } else {
            Procesor.add(otazkaAbc);
        }



    }

    private void reset() {
        if (no > 0){
        zmenaNazvu.setText(Procesor.get(no).getName());
        zmenaZadani.setText(Procesor.get(no).getZadani());
    }}
  
   private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
    GridBagConstraints gc = new GridBagConstraints();
    gc.gridx = x;
    gc.gridy = y;
    gc.gridwidth = width;
    gc.gridheight = height;
    gc.weightx = 100.0;
    gc.weighty = 100.0;
    gc.insets = new Insets(5, 5, 5, 5);
    gc.anchor = align;
    gc.fill = GridBagConstraints.NONE;
    p.add(c, gc);
  }
}
