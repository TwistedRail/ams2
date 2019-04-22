/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import javax.swing.ImageIcon;

/**
 *
 * @author Maan Alaulaqi (201610814@aau.ac.ae)
 */
public class UserInterface extends javax.swing.JFrame {
    protected static final ImageIcon ICON_ACTIVE = createImageIcon("images/Start_ACTIVE.png", "Card reader currently active.");// = new ImageIcon("/images/Start_ACTIVE.png");
    protected static final ImageIcon ICON_INACTIVE = createImageIcon("images/Start_NOTACTIVE.png", "Card reader currently active.");//// = new ImageIcon("/images/Start_NOTACTIVE.png");
    public static boolean x = false;
   protected static String  uid_placeholder = "";
   protected static String UID = uid_placeholder;

    
    /**
     * Creates new form UserInterface
     */
    public UserInterface() {
        initComponents();
    }
    
    /** Returns an ImageIcon, or null if the path was invalid. 
     * This is to allow images to brought in without a NullPointerException
     * Resourced from :
     * https://stackoverflow.com/questions/13151979/null-pointer-exception-when-an-imageicon-is-added-to-jbutton-in-netbeans
     */
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        ACTIVE_ICON = new javax.swing.JLabel();
        INACTIVE_ICON = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        StudentCall = new java.awt.Label();
        main_start = new javax.swing.JPanel();
        currentClass = new java.awt.Label();
        classCall = new java.awt.Label();
        viewStudentsButton = new javax.swing.JButton();
        mainBG_start = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(798, 584));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(798, 584));

        jPanel2.setMaximumSize(new java.awt.Dimension(798, 584));
        jPanel2.setMinimumSize(new java.awt.Dimension(798, 584));
        jPanel2.setPreferredSize(new java.awt.Dimension(798, 584));
        jPanel2.setLayout(null);

        ACTIVE_ICON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Start_ACTIVE.png"))); // NOI18N
        jPanel2.add(ACTIVE_ICON);
        ACTIVE_ICON.setBounds(60, 230, 624, 155);

        INACTIVE_ICON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Start_NOTACTIVE.png"))); // NOI18N
        jPanel2.add(INACTIVE_ICON);
        INACTIVE_ICON.setBounds(60, 230, 624, 155);
        INACTIVE_ICON.setVisible(false);

        jPanel1.setOpaque(false);

        StudentCall.setBackground(new java.awt.Color(255, 255, 255));
        StudentCall.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        StudentCall.setText(((InterfaceCmds.getCurrentSwipe(UID) == null) ? " ": InterfaceCmds.getCurrentSwipe(UID))

        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 151, Short.MAX_VALUE)
                .addComponent(StudentCall, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(StudentCall, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );

        System.out.println(CardConnection.cardUID+"< CardConnect.cardUID lol ");

        jPanel2.add(jPanel1);
        jPanel1.setBounds(90, 410, 541, 105);

        main_start.setMinimumSize(new java.awt.Dimension(798, 584));
        main_start.setLayout(null);

        currentClass.setBackground(new java.awt.Color(255, 255, 255));
        currentClass.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        currentClass.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        currentClass.setText("Current class: ");
        main_start.add(currentClass);
        currentClass.setBounds(90, 170, 160, 40);

        classCall.setBackground(new java.awt.Color(255, 255, 255));
        classCall.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        classCall.setText(InterfaceCmds.getCurrentClass(1));
        main_start.add(classCall);
        classCall.setBounds(250, 167, 390, 50);
        classCall.getAccessibleContext().setAccessibleName("");

        viewStudentsButton.setText("View students");
        viewStudentsButton.setVisible(false);
        viewStudentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStudentsButtonActionPerformed(evt);
            }
        });
        main_start.add(viewStudentsButton);
        viewStudentsButton.setBounds(620, 500, 140, 60);

        mainBG_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mainBG_start.png"))); // NOI18N
        mainBG_start.setAlignmentY(0.0F);
        main_start.add(mainBG_start);
        mainBG_start.setBounds(0, 0, 798, 584);

        jPanel2.add(main_start);
        main_start.setBounds(0, 0, 800, 590);

        jLayeredPane1.add(jPanel2);
        jPanel2.setBounds(0, 0, 798, 584);

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewStudentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStudentsButtonActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassManager().setVisible(true);
            }
        });
        //System.out.println(" Boop:"+ uid_placeholder+ "Coz why not lol ");
        
    }//GEN-LAST:event_viewStudentsButtonActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */ //This is related to my own NetBeans settings, Nimbus theme.
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        
        
//        ImageIcon ACTIVE = 
       /* ImageIcon ICON_ACTIVE1;
        ICON_ACTIVE1 = createImageIcon2("/images/Start_ACTIVE.png", "Card reader currently active.");
         ICON_INACTIVE = new createImageIcon("/images/Start_NOTACTIVE.png");
        */
       
       //updateActiveCheck(false); 
       //createImageIcon.updateMe(true);
       //ActiveCheck.setIcon(ICON_ACTIVE);
//        UserInterface.viewStudentsButton.setVisible(false);

    }
     public static ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = ClassLoader.getSystemResource(path);
        if (imgURL != null) {
            //System.out.println(path);
            return new ImageIcon(imgURL);
        } else {
            System.out.println("Couldn't find file: " + path);
            return null;
        }
    }
   
   /**
    * Need a way to access non-static methods from static context
    * Referenced from https://www.javacodegeeks.com/2017/10/can-non-static-method-access-static-variablemethod-java.html
    * 
    * @param d 
    */
     

   public static ImageIcon getIcon(String x) {
     ImageIcon defaultIcon = new ImageIcon(ClassLoader.getSystemResource(x));
     return defaultIcon;
   }
   /**
    * This is to update the name bar of the student/employee. I just stuck to student coz it's easier
    * @param UID 
    */
   public static void updateStudent(String UID){
       if (UID == ""){}
       else {
           //Update Student here
           uid_placeholder = UID;
           uid_placeholder = InterfaceCmds.getCurrentUID(UID);
           String y = InterfaceCmds.getCurrentSwipe(UID);
           StudentCall.setText(y);
          // System.out.println(uid_placeholder+ " " +y + " InterfaceCmds.getCurrentSwipe() reached");
           //System.out.println("MAAN LOOK AT ME I'M THE UID WOO! " + UID);
       }
   }

     
    public static void updateActiveCheck(boolean success) {
        /*
        System.out.println(ACTIVE_ICON+" SYSTEM");
        ImageIcon x,y;
        x = new ImageIcon(UserInterface.class.getResource("/images/Start_ACTIVE.png"));
        System.out.println(x + "LOLOLOLLOOLLOL");
        y = new ImageIcon(UserInterface.class.getResource("/images/Start_NOTACTIVE.png"));*/
        
        if(success) {
            
            
            /*System.out.println("YES" + x);
            ACTIVE_ICON.setIcon(ICON_ACTIVE);// = new ImageIcon("/images/Start_ACTIVE.png"););
            ACTIVE_ICON.setVisible(true);
            INACTIVE_ICON.setVisible(false);*/
            updateChecker.updateActiveCheck(true);
            x = true;
            viewStudentsButton.setVisible(true);
            
        }
        else if(!success) {
            /*
            System.out.println("NO" + x);
            ACTIVE_ICON.setIcon(y);
            ACTIVE_ICON.setVisible(false);
            INACTIVE_ICON.setVisible(true);*/
            x = false;
            updateChecker.updateActiveCheck(false);
            viewStudentsButton.setVisible(false);

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel ACTIVE_ICON;
    public static javax.swing.JLabel INACTIVE_ICON;
    private static java.awt.Label StudentCall;
    private java.awt.Label classCall;
    private java.awt.Label currentClass;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel mainBG_start;
    private javax.swing.JPanel main_start;
    public static javax.swing.JButton viewStudentsButton;
    // End of variables declaration//GEN-END:variables

    
}
