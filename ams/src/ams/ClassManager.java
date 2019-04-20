/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Maan Alaulaqi (201610814@aau.ac.ae)
 */
public class ClassManager extends javax.swing.JFrame {
    private static Vector<String> elements;// = new Vector<String>(); //Was playing with ArrayList and Vectors here. Read somewhere it made a difference.
    private static DefaultListModel dlm;
    /**
     * Creates new form ClassManager
     */
    public ClassManager() {
        initComponents();
    }
private static String InstructorUID = UserInterface.UID;
    public static void classListFiller(){
//        Vector<String> elements = new Vector<String>();
int x = 0;
        try {
//        dbControl.dbComd("SELECT CLASS.NAME FROM INSTRUCTOR INNER JOIN INSTRUCTOR_CLASS ON INSTRUCTOR.ID =  INSTRUCTOR_CLASS.INSTRUCTOR_ID INNER JOIN CLASS ON INSTRUCTOR_CLASS.CLASS_ID = CLASS.ID WHERE INSTRUCTOR.CARD_ID = '"+InstructorUID+"';");
        dbControl.dbComd("SELECT CLASS.NAME, INSTRUCTOR_CLASS.ID FROM INSTRUCTOR INNER JOIN INSTRUCTOR_CLASS ON INSTRUCTOR.ID =  INSTRUCTOR_CLASS.INSTRUCTOR_ID INNER JOIN CLASS ON INSTRUCTOR_CLASS.CLASS_ID = CLASS.ID WHERE INSTRUCTOR.CARD_ID = 'e0b48a'");
        System.out.println(dbControl.rs.getFetchSize() + " rs.getFetchSize()");
        while (dbControl.rs.next()) {            
                // or whatever is appropriate
                System.out.println(dbControl.rs.getString("NAME"));
                System.out.println(dbControl.rs.getString("NAME"));
              //  elements.add(dbControl.rs.getString("NAME"));
                
                dlm.addElement((dbControl.rs.getString("NAME")));
                //Needed to test if this worked. The list isn't updating so I need to test things. 
                System.out.println(elements.get(x));
                x++;
                //System.out.println(elements.get((dbControl.rs.getInt(dbControl.rs.getRow()))-1));
                //sClassSelect.add(elements.get((dbControl.rs.getInt(dbControl.rs.getRow()))-1));
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassManager.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                dbControl.doClose();
            }  
    System.out.println (elements.size());
    System.out.print(dlm.getSize() + "dlm size");
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        amsPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("amsPU").createEntityManager();
        student_1Query = java.beans.Beans.isDesignTime() ? null : amsPUEntityManager.createQuery("SELECT s FROM Student_1 s");
        student_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : student_1Query.getResultList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        studentListLEFT = new javax.swing.JInternalFrame();
        sClassSelect = new java.awt.List();
        sClassSelectButton = new java.awt.Label();
        sTimeSelectBUTTON = new java.awt.Label();
        sTimeSelect = new java.awt.List();
        sDisplayListBUTTON = new java.awt.Button();
        sExportListBUTTON = new java.awt.Button();
        studentListRIGHT = new javax.swing.JScrollPane();
        studentLIST = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(798, 514));
        setMinimumSize(new java.awt.Dimension(798, 514));
        setPreferredSize(new java.awt.Dimension(798, 514));

        studentListLEFT.setVisible(true);

        sClassSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sClassSelectActionPerformed(evt);
            }
        });

        sClassSelectButton.setText("Select class");

        sTimeSelectBUTTON.setText("Select time");

        sDisplayListBUTTON.setLabel("Display student list");
        sDisplayListBUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sDisplayListBUTTONActionPerformed(evt);
            }
        });

        sExportListBUTTON.setLabel("Export student list");
        sExportListBUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sExportListBUTTONActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentListLEFTLayout = new javax.swing.GroupLayout(studentListLEFT.getContentPane());
        studentListLEFT.getContentPane().setLayout(studentListLEFTLayout);
        studentListLEFTLayout.setHorizontalGroup(
            studentListLEFTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentListLEFTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentListLEFTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentListLEFTLayout.createSequentialGroup()
                        .addGroup(studentListLEFTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sClassSelectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sTimeSelectBUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(studentListLEFTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sClassSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(sTimeSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))
                    .addGroup(studentListLEFTLayout.createSequentialGroup()
                        .addGroup(studentListLEFTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sDisplayListBUTTON, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sExportListBUTTON, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        studentListLEFTLayout.setVerticalGroup(
            studentListLEFTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentListLEFTLayout.createSequentialGroup()
                .addGroup(studentListLEFTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentListLEFTLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sClassSelectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sClassSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(studentListLEFTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sTimeSelectBUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sTimeSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(sDisplayListBUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(sExportListBUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, student_1List, studentLIST);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${studentId}"));
        columnBinding.setColumnName("Student Id");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstName}"));
        columnBinding.setColumnName("First Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastName}"));
        columnBinding.setColumnName("Last Name");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        studentListRIGHT.setViewportView(studentLIST);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(studentListLEFT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentListRIGHT, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentListLEFT)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(studentListRIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 75, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student list", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sDisplayListBUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sDisplayListBUTTONActionPerformed
        // TODO add your handling code here: 
    }//GEN-LAST:event_sDisplayListBUTTONActionPerformed

    private void sExportListBUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sExportListBUTTONActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sExportListBUTTONActionPerformed

    private void sClassSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sClassSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sClassSelectActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClassManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassManager().setVisible(true);
            }
        });
        
        classListFiller();
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager amsPUEntityManager;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.List sClassSelect;
    private java.awt.Label sClassSelectButton;
    private java.awt.Button sDisplayListBUTTON;
    private java.awt.Button sExportListBUTTON;
    private java.awt.List sTimeSelect;
    private java.awt.Label sTimeSelectBUTTON;
    private javax.swing.JTable studentLIST;
    private javax.swing.JInternalFrame studentListLEFT;
    private javax.swing.JScrollPane studentListRIGHT;
    private java.util.List<ams.Student_1> student_1List;
    private javax.persistence.Query student_1Query;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
