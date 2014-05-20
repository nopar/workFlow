package sk.stuba.fei.wfms.gui;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import sk.stuba.fei.wfms.integration.ComWrapper;
import sk.stuba.fei.wfms.integration.Timestamper;
import sk.stuba.fei.wfms.xmlhandler.HandlerXML;

public class GUI extends javax.swing.JFrame {
    
    public GUI() {
        initComponents();
    }    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fullname_jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        age_jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        role_jTextField4 = new javax.swing.JTextField();
        gender_jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        action_jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoPanel = new javax.swing.JTextArea();
        exit_jButton5 = new javax.swing.JButton();

        org.jdesktop.layout.GroupLayout jFrame1Layout = new org.jdesktop.layout.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jFrame2Layout = new org.jdesktop.layout.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("XAdES - T generator");
        setBackground(new java.awt.Color(48, 241, 17));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("User"));

        jLabel1.setText("Full name:");

        jLabel2.setText("Gender:");

        jLabel3.setText("Age:");

        jLabel4.setText("Role:");

        gender_jComboBox1.setMaximumRowCount(3);
        gender_jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<-choose->", "Male", "Female", " " }));
        gender_jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });

        jButton1.setText("Save to XML");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel3)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(fullname_jTextField1)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(age_jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 98, Short.MAX_VALUE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(gender_jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(role_jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(57, 57, 57))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(fullname_jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2)
                    .add(gender_jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(role_jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel4)
                        .add(age_jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(11, 11, 11)
                .add(jButton1))
        );

        age_jTextField3.getAccessibleContext().setAccessibleName("age");
        gender_jComboBox1.getAccessibleContext().setAccessibleName("gender_combo");

        action_jPanel2.setBackground(new java.awt.Color(132, 229, 115));

        jButton2.setText("Validate XML");
        jButton2.setMaximumSize(new java.awt.Dimension(100, 28));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 28));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateActionPerformed(evt);
            }
        });

        jButton3.setText("Export to txt");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });

        jButton4.setText("Sign");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signActionPerformed(evt);
            }
        });

        jButton5.setText("Obtain timestamp");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timestampActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout action_jPanel2Layout = new org.jdesktop.layout.GroupLayout(action_jPanel2);
        action_jPanel2.setLayout(action_jPanel2Layout);
        action_jPanel2Layout.setHorizontalGroup(
            action_jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(action_jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(action_jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(action_jPanel2Layout.createSequentialGroup()
                        .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jButton4))
                    .add(action_jPanel2Layout.createSequentialGroup()
                        .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jButton5)))
                .addContainerGap())
        );
        action_jPanel2Layout.setVerticalGroup(
            action_jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(action_jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(action_jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(action_jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton3)
                    .add(jButton5))
                .addContainerGap())
        );

        infoPanel.setEditable(false);
        infoPanel.setColumns(20);
        infoPanel.setRows(5);
        infoPanel.setName("infoPanel"); // NOI18N
        jScrollPane1.setViewportView(infoPanel);

        exit_jButton5.setText("EXIT");
        exit_jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1)
                    .add(action_jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(exit_jButton5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(action_jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 11, Short.MAX_VALUE)
                .add(exit_jButton5))
        );

        action_jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Triggered action on exit button
     * @param evt 
     */
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed
    /**
     * Triggered action on save button
     * @param evt 
     */
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        
        // main repeating element
        String mainElm = "user";
        // initialization of XML handler class
        HandlerXML hxml = new HandlerXML("users");
        
        try 
        {
            // gender transform to abbreviation
            int gender = gender_jComboBox1.getSelectedIndex();
            String gend = null;
            switch(gender){
               case 0:
                   throw new Exception("Gender not selected!");
               case 1:
                   gend = "M";
                   break;
               case 2:
                    gend = "F";
                   break;
            }
            // check of not null name at least
            if(fullname_jTextField1.getText().isEmpty())
                throw new Exception("Name field empty!");
            
            JFileChooser chooserSave = new JFileChooser();
            chooserSave.setDialogTitle("Choose file to save to");
            chooserSave.setFileFilter(
                new FileNameExtensionFilter("XML file", new String[] {"xml"}));
            chooserSave.showSaveDialog(jFrame1); 
            String filePath = chooserSave.getSelectedFile().getPath();
        
            // DOM structure construction using XML handler
            hxml.loadXml(filePath,"http://wfms.fei.stuba.sk/team/R");
            // sets info about file
            infoPanel.append("XML - " + filePath + " loaded.\n");
            
            hxml.createTag(hxml.getRoot(), mainElm);
            hxml.createTag(mainElm, "name", fullname_jTextField1.getText());  
            hxml.createTag(mainElm, "age", age_jTextField3.getText());
            hxml.createTag(mainElm, "role", role_jTextField4.getText());
            hxml.createAttr(mainElm, "gender", gend);
            
            if(hxml.saveXml(filePath) == true){
                infoPanel.append("XML file saved!\n");
            }else{
                infoPanel.append("Error saving XML file.\n");
            }
            
            // clearing form fields
            fullname_jTextField1.setText("");
            age_jTextField3.setText("");
            role_jTextField4.setText("");
            gender_jComboBox1.setSelectedIndex(0);
            
        } catch (Exception ex) {
            infoPanel.append(ex.getMessage()+"\n");
        }
    }//GEN-LAST:event_saveActionPerformed
    /**
     * Triggered action on transformation button
     * @param evt 
     */
    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
     // init of file chooser
     JFileChooser chooserTrans = new JFileChooser();
        
     try {
        // selection of input XML
        chooserTrans.setFileFilter(
                new FileNameExtensionFilter("XML file", new String[] {"xml"}));
        chooserTrans.setDialogTitle("XML input file to transform");
        chooserTrans.showOpenDialog(jFrame1); 
        if(!chooserTrans.getSelectedFile().exists())
            throw new Exception("XML file not selected or invalid!");
        String xmlFilePath = chooserTrans.getSelectedFile().getPath();
        
        // selection of input XSL
        chooserTrans.setFileFilter(
                new FileNameExtensionFilter("XSL file", new String[] {"xsl"}));
        chooserTrans.setDialogTitle("XSL transformation file");
        chooserTrans.showOpenDialog(jFrame1);
        if(!chooserTrans.getSelectedFile().exists())
            throw new Exception("XSL file not selected or invalid path!");
        String xslFilePath = chooserTrans.getSelectedFile().getPath();
        
        // selection of output file
        chooserTrans.setFileFilter(
                new FileNameExtensionFilter("TXT file", new String[] {"txt"}));
        chooserTrans.setDialogTitle("Select output file");
        chooserTrans.showSaveDialog(jFrame1);
        String outputFilePath = chooserTrans.getSelectedFile().getPath();
        
        // transformation using handler static method and info catching
        if( 
            HandlerXML.xslTransformXml(xmlFilePath, xslFilePath, outputFilePath)
          ) 
        {
            infoPanel.append("XML file transformed!\n");
        } else {
            infoPanel.append("Transformation failed\n");
        }  
     } catch(Exception ex) {
        infoPanel.append(ex.getMessage()+"\n");
     }
    }//GEN-LAST:event_exportActionPerformed
    /**
     * Triggered action on gender combobox.
     * @param evt 
     */
    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
    }//GEN-LAST:event_genderActionPerformed
    /**
     * Triggered action on validation button
     * @param evt 
     */
    private void validateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateActionPerformed
        // init of file chooser
     JFileChooser chooserVal = new JFileChooser();
     try {
         // selection of input XML
        chooserVal.setFileFilter(
                new FileNameExtensionFilter("XML file", new String[] {"xml"}));
        chooserVal.setDialogTitle("XML input file for validation");
        chooserVal.showOpenDialog(jFrame1); 
        if(!chooserVal.getSelectedFile().exists())
            throw new Exception("XML file not selected or invalid!");
        String xmlFilePath = chooserVal.getSelectedFile().getPath();
        
        // selection of input XSL
        chooserVal.setFileFilter(
                new FileNameExtensionFilter("XSD file", new String[] {"xsd"}));
        chooserVal.setDialogTitle("XSD schema file to check against");
        chooserVal.showOpenDialog(jFrame1);
        if(!chooserVal.getSelectedFile().exists())
            throw new Exception("XSD file not selected or invalid path!");
        String xsdFilePath = chooserVal.getSelectedFile().getPath();
        
        // validation using handler static method and info catching
        if( HandlerXML.XsdValidateXml(xmlFilePath, xsdFilePath) ) 
        {   
            infoPanel.append("XML file is valid!\n");
        } else {
            infoPanel.append("XML file is invalid!\n");
        }  
     } catch(Exception ex) {
        infoPanel.append(ex.getMessage()+"\n");
     }
    }//GEN-LAST:event_validateActionPerformed
    /**
    * Triggered action on sign button.
    * @param evt 
    */
    private void signActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signActionPerformed
       
        String namespace = "http://wfms.fei.stuba.sk/team/R";
        infoPanel.append("Namespace: " + namespace + "\n");
        
        ComWrapper cw = new ComWrapper("lib/jacob-1.17-x86.dll");
        
        try {
            cw.loadLibrary();
            infoPanel.append("Java COM bridge library loaded...\n");
        
            // choose input XML
            JFileChooser chSignXML = new JFileChooser();
            chSignXML.setFileFilter(
                new FileNameExtensionFilter("XML file", new String[] {"xml"}));
            chSignXML.setDialogTitle("XML input file to be signed");
            chSignXML.showOpenDialog(jFrame1); 
            if(!chSignXML.getSelectedFile().exists())
                throw new Exception("XML file not selected or invalid!");
            String xmlFile = chSignXML.getSelectedFile().getPath();
            // choose input schema
            JFileChooser chSignXSD = new JFileChooser();
            chSignXSD.setFileFilter(
                new FileNameExtensionFilter("XSD file", new String[] {"xsd"}));
            chSignXSD.setDialogTitle("XML Schema for input XML for validation");
            chSignXSD.showOpenDialog(jFrame1); 
            if(!chSignXSD.getSelectedFile().exists())
                throw new Exception("XSD file not selected or invalid!");
            String xsdFile = chSignXSD.getSelectedFile().getPath();
            // choose input transformation
            JFileChooser chSignXSL = new JFileChooser();
            chSignXSL.setFileFilter(
                new FileNameExtensionFilter("XSL file", new String[] {"xsl"}));
            chSignXSL.setDialogTitle("XML Schema for input XML for validation");
            chSignXSL.showOpenDialog(jFrame1); 
            if(!chSignXSL.getSelectedFile().exists())
                throw new Exception("XSL file not selected or invalid!");
            String xslFile = chSignXSL.getSelectedFile().getPath();
            // creation of signed XML
            String sxml;
            sxml = cw.signXades256(
                    new File(xmlFile),
                    new File(xsdFile),
                    "http://wfms.fei.stuba.sk/team/R/xsd",
                    new File(xslFile),
                    "http://wfms.fei.stuba.sk/team/R/xslt",
                    namespace
            );
            infoPanel.append("Signed XML envelope created!\n");
            // saving of created envelope
            JFileChooser chSave = new JFileChooser();
            chSave.setDialogTitle("Choose file to save to");
            chSave.setFileFilter(
                new FileNameExtensionFilter("XML file", new String[] {"xml"}));
            chSave.showSaveDialog(jFrame1); 
            String filePath = chSave.getSelectedFile().getPath();
            ComWrapper.saveXmlAsString(sxml, filePath);
            infoPanel.append("Signed XML saved to " + filePath + "\n");
        } catch(UnsatisfiedLinkError | Exception e) {
            infoPanel.append(e.getMessage()+"\n");
        }
    }//GEN-LAST:event_signActionPerformed
    /**
    * Triggered action on timestamp button.
    * @param evt 
    */
    private void timestampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timestampActionPerformed
        try {
            JFileChooser tsXML = new JFileChooser();
            tsXML.setFileFilter(
                    new FileNameExtensionFilter("XML file", new String[] {"xml"}));
            tsXML.setDialogTitle("Signed XML input file to be stamped");
            tsXML.showOpenDialog(jFrame1);
            if(!tsXML.getSelectedFile().exists())
                throw new Exception("XML file not selected or invalid!");
            String xmlFile = tsXML.getSelectedFile().getPath();
            
            Timestamper.injectTimestamp(xmlFile);
            
            infoPanel.append("Signed XML successfully timestamped\n");
        } catch(Exception e) {
            infoPanel.append(e.getMessage()+"\n");
        }
    }//GEN-LAST:event_timestampActionPerformed
    
    /**
     * Generated main method.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (UIManager.LookAndFeelInfo installedLookAndFeel : installedLookAndFeels) {
                if ("Nimbus".equals(installedLookAndFeel.getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeel.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel action_jPanel2;
    private javax.swing.JTextField age_jTextField3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton exit_jButton5;
    private javax.swing.JTextField fullname_jTextField1;
    private javax.swing.JComboBox gender_jComboBox1;
    private javax.swing.JTextArea infoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField role_jTextField4;
    // End of variables declaration//GEN-END:variables
    
}
