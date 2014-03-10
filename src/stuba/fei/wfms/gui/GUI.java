
package stuba.fei.wfms.gui;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import stuba.fei.wfms.xmlhandler.HandlerException;
import stuba.fei.wfms.xmlhandler.HandlerXML;

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
        exit_jButton5 = new javax.swing.JButton();
        action_jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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
        setTitle("XML creator - validator - exporter");
        setBackground(new java.awt.Color(48, 241, 17));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("User"));

        jLabel1.setText("Full name:");

        jLabel2.setText("Gender:");

        jLabel3.setText("Age:");

        jLabel4.setText("Role");

        gender_jComboBox1.setMaximumRowCount(3);
        gender_jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<-choose->", "Male", "Female", " " }));
        gender_jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gender_jComboBox1ActionPerformed(evt);
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
                    .add(age_jTextField3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, fullname_jTextField1))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel2)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(role_jTextField4)
                    .add(gender_jComboBox1, 0, 129, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .add(34, 34, 34))
        );

        age_jTextField3.getAccessibleContext().setAccessibleName("age");
        gender_jComboBox1.getAccessibleContext().setAccessibleName("gender_combo");

        exit_jButton5.setText("EXIT");
        exit_jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_jButton5ActionPerformed(evt);
            }
        });

        action_jPanel2.setBackground(new java.awt.Color(132, 229, 115));

        jButton1.setText("Save to XML");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Validate XML");
        jButton2.setMaximumSize(new java.awt.Dimension(100, 28));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 28));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Export to txt");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout action_jPanel2Layout = new org.jdesktop.layout.GroupLayout(action_jPanel2);
        action_jPanel2.setLayout(action_jPanel2Layout);
        action_jPanel2Layout.setHorizontalGroup(
            action_jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(action_jPanel2Layout.createSequentialGroup()
                .add(31, 31, 31)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 54, Short.MAX_VALUE)
                .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(51, 51, 51)
                .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(32, 32, 32))
        );
        action_jPanel2Layout.setVerticalGroup(
            action_jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(action_jPanel2Layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(action_jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton3))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
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
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(exit_jButton5)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        action_jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Triggered action on exit button
     * @param evt 
     */
    private void exit_jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_jButton5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exit_jButton5ActionPerformed
    /**
     * Triggered action on save button
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
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
            chooserSave.setDialogTitle("Choose file to save form");
            chooserSave.setFileFilter(
                new FileNameExtensionFilter("XML file", new String[] {"xml"}));
            chooserSave.showSaveDialog(jFrame1); 
            String filePath = chooserSave.getSelectedFile().getPath();
        
            // DOM structure construction using XML handler
            hxml.loadXml(filePath);
            hxml.createTag(hxml.getRoot(), mainElm);
            hxml.createTag(mainElm, "name", fullname_jTextField1.getText());  
            hxml.createTag(mainElm, "age", age_jTextField3.getText());
            hxml.createTag(mainElm, "role", role_jTextField4.getText());
            hxml.createAttr(mainElm, "gender", gend);
            
            if(hxml.saveXml(filePath) == true){
                HandlerException.showInfoStatus(jFrame1, "Saved!", "Success");
            }else{
                HandlerException.showDialog(jFrame1, "Unsaved!");
            }
            
            // clearing form fields
            fullname_jTextField1.setText("");
            age_jTextField3.setText("");
            role_jTextField4.setText("");
            gender_jComboBox1.setSelectedIndex(0);
            
        } catch (Exception ex) {
            HandlerException.showDialog(jFrame1, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * Triggered action on transformation button
     * @param evt 
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
            HandlerException.showInfoStatus(jFrame1, "Transformed!", "Success"); 
        } else {
            HandlerException.showDialog(jFrame1, "Transformation failed!");
        }  
     } catch(Exception ex) {
        HandlerException.showDialog(jFrame1, ex.getMessage());
     }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void gender_jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gender_jComboBox1ActionPerformed
    }//GEN-LAST:event_gender_jComboBox1ActionPerformed
    /**
     * Triggered action on validation button
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
            HandlerException.showInfoStatus(jFrame1, "Valid!", "Success"); 
        } else {
            HandlerException.showDialog(jFrame1, "Invalid!");
        }  
     } catch(Exception ex) {
        HandlerException.showDialog(jFrame1, ex.getMessage());
     }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
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
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField role_jTextField4;
    // End of variables declaration//GEN-END:variables
    
}
