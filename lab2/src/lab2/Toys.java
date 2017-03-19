package lab2;

import java.awt.*;
import javax.swing.*;
import java.awt.Insets;
import java.awt.event.*;
import java.net.URL;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PEOPLE
 */
public class Toys extends javax.swing.JFrame {

    /**
     * Creates new form Toys
     */
    public Toys() {
        initComponents();
        addPaneListener();               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jProgressBar1 = new javax.swing.JProgressBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Іграшки");
        setPreferredSize(new java.awt.Dimension(1200, 800));

        jToolBar1.setAutoscrolls(true);
        jToolBar1.setBorderPainted(false);
        jToolBar1.setDoubleBuffered(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(18, 30));
        jToolBar1.setMinimumSize(new java.awt.Dimension(18, 30));

        jToggleButton1.setText("Додати іграшку");
        jToggleButton1.setToolTipText("");
        jToggleButton1.setFocusable(false);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleButton1);

        jToggleButton2.setText("Перегляд іграшок");
        jToggleButton2.setFocusable(false);
        jToggleButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleButton2);

        jToggleButton3.setText("Пошук іграшок");
        jToggleButton3.setFocusable(false);
        jToggleButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleButton3);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(5000, 5000));
        jDesktopPane1.setRequestFocusEnabled(false);
        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.WEST);
        jDesktopPane1.getAccessibleContext().setAccessibleName("");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 16));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 16));
        jLabel1.setName(""); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 16));
        jPanel1.add(jLabel1);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");
        jSeparator1.setMaximumSize(new java.awt.Dimension(5, 20));
        jSeparator1.setMinimumSize(new java.awt.Dimension(5, 20));
        jSeparator1.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel1.add(jSeparator1);
        jPanel1.add(jProgressBar1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("jMenu3");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void setComponent(JInternalFrame jfr, GridBagLayout gbl, GridBagConstraints gbc,
            Component c, int row, int col, int nrow, int ncol) { 
      gbc.gridx = col; 
      gbc.gridy = row; 
      gbc.gridwidth = ncol ; 
      gbc.gridheight = nrow; 
      gbl.setConstraints(c, gbc); 
      jfr.add(c);
    }
    
    JInternalFrame jfrAdd;
    JLabel labName;
    JTextField textName;
    JLabel labPrice;
    JTextField textPrice;
    JLabel labAge;
    JComboBox<String> comboAge;
    JLabel labAttribute;
    JTextArea textAttribute;
    JLabel labPicture;
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
            if (jfrAdd != null) {
                jfrAdd.show();
            } else {
                jfrAdd = new JInternalFrame("Додати іграшку");
                jfrAdd.setName("jfrAdd");
                jfrAdd.setResizable(true);
                jfrAdd.setClosable(true);
                GridBagLayout gbl = new GridBagLayout();
                GridBagConstraints c = new GridBagConstraints();
                jfrAdd.setLayout(gbl);
                
                labName = new JLabel("Назва іграшки:");
                c.anchor = GridBagConstraints.NORTHWEST; 
                c.fill = GridBagConstraints.NONE;
                c.insets = new Insets(0, 10, 0, 0);    
                setComponent(jfrAdd, gbl, c, labName, 0, 0, 1, 1);
                
                textName = new JTextField(5);
                setComponent(jfrAdd, gbl, c, textName, 0, 1, 1, 1);
                
                labPrice = new JLabel("Ціна іграшки:");
                setComponent(jfrAdd, gbl, c, labPrice, 1, 0, 1, 1);
                
                textPrice = new JTextField(5);
                setComponent(jfrAdd, gbl, c, textPrice, 1, 1, 1, 1);
                
                labAge = new JLabel("Вікові межі:");
                setComponent(jfrAdd, gbl, c, labAge, 2, 0, 1, 1);
                
                String[] defaultAgeLimits = new String[] {
                    "0-3",
                    "3-5",
                    "5-8",
                    "5+",
                    "10+"
                };
                comboAge = new JComboBox<>(defaultAgeLimits);
                setComponent(jfrAdd, gbl, c, comboAge, 2, 1, 1, 1);
                
                labAttribute = new JLabel("Додаткова інф.:");
                setComponent(jfrAdd, gbl, c, labAttribute, 3, 0, 2, 1);

                textAttribute = new JTextArea(2, 5);
                setComponent(jfrAdd, gbl, c, textAttribute, 3, 1, 2, 1);
                
                labPicture = new JLabel(new ImageIcon("images/ico.jpeg","Not found"));
                setComponent(jfrAdd, gbl, c, labPicture, 0, 3, 5, 5);
                
                ////////////////////////////////////////////////////////////////
                jDesktopPane1.add(jfrAdd);
                Insets insets = jDesktopPane1.getInsets();
                jfrAdd.setPreferredSize(new Dimension(500, 500));
                Dimension size = jfrAdd.getPreferredSize();

                jfrAdd.setBounds(10 + insets.left, 10 + insets.top,
                        size.width, size.height);

                jfrAdd.setVisible(true);
            }
        } else {
            jfrAdd.hide();
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    JInternalFrame jfrView;
    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if (jToggleButton2.isSelected()) {
            if (jfrView != null) {
                jfrView.show();
            } else {
                jfrView = new JInternalFrame("Перегляд всіх іграшок");
                jfrView.setName("jfrView");
                jfrView.setResizable(true);
                jfrView.setClosable(true);

                jDesktopPane1.add(jfrView);
                Insets insets = jDesktopPane1.getInsets();
                jfrView.setPreferredSize(new Dimension(500, 500));
                Dimension size = jfrView.getPreferredSize();

                jfrView.setBounds(10 + insets.left, 10 + insets.top,
                        size.width, size.height);

                jfrView.setVisible(true);
            }
        } else {
            jfrView.hide();
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    JInternalFrame jfrSearch;
    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if (jToggleButton3.isSelected()) {
            if (jfrSearch != null) {
                jfrSearch.show();
            } else {
                jfrSearch = new JInternalFrame("Пошук за критеріями");
                jfrSearch.setName("jfrSearch");
                jfrSearch.setResizable(true);
                jfrSearch.setClosable(true);

                jDesktopPane1.add(jfrSearch);
                Insets insets = jDesktopPane1.getInsets();
                jfrSearch.setPreferredSize(new Dimension(500, 500));
                Dimension size = jfrSearch.getPreferredSize();

                jfrSearch.setBounds(10 + insets.left, 10 + insets.top,
                        size.width, size.height);

                jfrSearch.setVisible(true);
            }
        } else {
            jfrSearch.hide();        
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Toys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Toys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Toys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Toys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Toys mainFrame = new Toys();
                mainFrame.setVisible(true);
                mainFrame.setExtendedState(MAXIMIZED_BOTH);
                                
              //  String path = "/lab2/images/ico.jpeg";
                //URL imgURL = getClass().getResource(path);
               // ImageIcon icon = new ImageIcon(imgURL);
                
               // mainFrame.setIconImage(icon.getImage());
            }
        });        
    }

    public void addPaneListener() {
        jDesktopPane1.addContainerListener(new ContainerAdapter() {
            public void componentRemoved(ContainerEvent e) {
                //JOptionPane.showConfirmDialog(e.getContainer(), e.getChild().getName() + " dsgfsdg");
                String tmp = e.getChild().getName();
                if (tmp.equals("jfrAdd")) {
                    jfrAdd = null;
                    jToggleButton1.setSelected(false);
                } else if(tmp.equals("jfrView")) {
                    jfrView = null;
                    jToggleButton2.setSelected(false);
                } else if(tmp.equals("jfrSearch")) {
                    jfrSearch = null;
                    jToggleButton3.setSelected(false);
                };
            }
        ;
    }
    );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
