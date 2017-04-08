package lab2;

import java.util.zip.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Insets;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author PEOPLE
 */
public class Toys extends javax.swing.JFrame {

    public boolean progressFlag = false;
    public final AgeLimits[] defaultAgeLimits;

    public Toys() {
        initComponents();
        addPaneListener();
        defaultAgeLimits = new AgeLimits[]{
            new AgeLimits(0, 3),
            new AgeLimits(3, 5),
            new AgeLimits(5, 8),
            new AgeLimits(8, 8),
            new AgeLimits(10, 10)
        };
    }

    public String getCurrentDirectory() {
        return new File(".").getAbsolutePath().substring(0, new File(".").getAbsolutePath().length() - 2);
    }

    public ArrayList<Toy> readFromDB(String ToysDataBaseZip, String ToysDataBaseTxt) {
        jProgressBar1.setIndeterminate(true);
        ArrayList<Toy> tmp = new ArrayList<>();

        if (!new File(ToysDataBaseZip).exists()) {
            jProgressBar1.setIndeterminate(false);
            return tmp;
        }

        try {
            ZipFile zip = new ZipFile(ToysDataBaseZip);
            BufferedReader in = new BufferedReader(new InputStreamReader(zip.getInputStream(zip.getEntry(ToysDataBaseTxt))));
            String nextLine;
            while ((nextLine = in.readLine()) != null) {
                tmp.add(Toy.convertToToy(nextLine));
            }
        } catch (ZipException ex1) {
            JOptionPane.showMessageDialog(this, "ZipException");
        } catch (IOException ex2) {
            JOptionPane.showMessageDialog(this, "IOException");
        } catch (SecurityException ex3) {
            JOptionPane.showMessageDialog(this, "SecurityException");
        } catch (Exception ex4) {
            JOptionPane.showMessageDialog(this, "Exception");
        } finally {
            jProgressBar1.setIndeterminate(progressFlag);
        }
        return tmp;
    }

    public boolean writeInDB(Toy newToy) {
        jProgressBar1.setIndeterminate(true);
        String ToysDataBaseZip = getCurrentDirectory() + "\\files\\ToysDataBase.zip";
        String ToysDataBaseTxt = "ToysDataBase.txt";
        ArrayList<Toy> tmp;

        try {
            tmp = readFromDB(ToysDataBaseZip, ToysDataBaseTxt);
            tmp.add(newToy);

            if (!new File(ToysDataBaseZip).exists()) {
                new File(ToysDataBaseZip).createNewFile();
            }
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(ToysDataBaseZip));
            ZipEntry entry1 = new ZipEntry("ToysDataBase.txt");

            zout.putNextEntry(entry1);
            for (int i = 0; i < tmp.size(); i++) {
                zout.write(Toy.convertToString(tmp.get(i)).getBytes());
            }
            zout.closeEntry();
            zout.close();
        } catch (Exception ex) {
            return false;
        } finally {
            jProgressBar1.setIndeterminate(progressFlag);
        }
        return true;
    }

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Іграшки");
        setPreferredSize(new java.awt.Dimension(600, 400));

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

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5000, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.WEST);
        jDesktopPane1.getAccessibleContext().setAccessibleName("");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ready");
        jLabel1.setToolTipText("");
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 16));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 16));
        jLabel1.setName(""); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 16));
        jPanel1.add(jLabel1);
        jLabel1.getAccessibleContext().setAccessibleName("jLabel1");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");
        jSeparator1.setMaximumSize(new java.awt.Dimension(5, 20));
        jSeparator1.setMinimumSize(new java.awt.Dimension(5, 20));
        jSeparator1.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel1.add(jSeparator1);
        jPanel1.add(jProgressBar1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setComponent(JInternalFrame jfr, GridBagLayout gbl, GridBagConstraints gbc,
            Component c, int WIDTH, int HEIGHT, int row, int col, int nrow, int ncol) {
        c.setSize(WIDTH * 10, HEIGHT * 10);
        //c.setBackground(Color.cyan);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.gridwidth = ncol;
        gbc.gridheight = nrow;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.ipadx = 10;
        gbc.ipady = 6;
        gbl.setConstraints(c, gbc);
        jfr.add(c);
    }

    private static final int defaultNRow = 1;
    private static final int defaultNCol = 1;
    private String tempImage = "default";
    private JInternalFrame jfrAdd;
    private JLabel labName;
    private JTextField textName;
    private JLabel labPrice;
    private JTextField textPrice;
    private JLabel labAge;
    private JComboBox<AgeLimits> comboAge;
    private JLabel labAttribute;
    private JTextField textAttribute;
    private JLabel labPicture;
    private JButton butOK;
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        jProgressBar1.setIndeterminate(true);
        if (jToggleButton1.isSelected()) {
            if (jfrAdd != null) {
                jfrAdd.show();
                jProgressBar1.setIndeterminate(progressFlag);
            } else {
                jfrAdd = new JInternalFrame("Додати іграшку");
                jfrAdd.setName("jfrAdd");
                jfrAdd.setResizable(true);
                jfrAdd.setClosable(true);
                GridBagLayout gbl = new GridBagLayout();
                GridBagConstraints gbc = new GridBagConstraints();
                jfrAdd.setLayout(gbl);

                labName = new JLabel("Назва іграшки:");
                setComponent(jfrAdd, gbl, gbc, labName, 10, 2, 0, 0, defaultNRow, defaultNCol);

                textName = new JTextField(15);
                setComponent(jfrAdd, gbl, gbc, textName, 10, 2, 0, 1, defaultNRow, defaultNCol);

                labPrice = new JLabel("Ціна іграшки:");
                setComponent(jfrAdd, gbl, gbc, labPrice, 10, 2, 1, 0, defaultNRow, defaultNCol);

                textPrice = new JTextField(15);
                setComponent(jfrAdd, gbl, gbc, textPrice, 10, 2, 1, 1, defaultNRow, defaultNCol);

                labAge = new JLabel("Вікові межі:");
                setComponent(jfrAdd, gbl, gbc, labAge, 10, 2, 2, 0, defaultNRow, defaultNCol);

                comboAge = new JComboBox<>(defaultAgeLimits);
                comboAge.setSize(1000, 3000);
                setComponent(jfrAdd, gbl, gbc, comboAge, 10, 2, 2, 1, defaultNRow, defaultNCol);

                labAttribute = new JLabel("Додаткова інф.:");
                setComponent(jfrAdd, gbl, gbc, labAttribute, 10, 2, 3, 0, defaultNRow + 1, defaultNCol);

                textAttribute = new JTextField(15);
                setComponent(jfrAdd, gbl, gbc, textAttribute, 10, 2, 3, 1, defaultNRow + 1, defaultNCol);

                labPicture = new JLabel();
                labPicture.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            JFileChooser openImage = new JFileChooser(getCurrentDirectory(), FileSystemView.getFileSystemView());
                            openImage.setFileSelectionMode(openImage.FILES_ONLY);
                            openImage.setFileFilter(new FileNameExtensionFilter("Pictures(*.jpg, *.jpeg, *.png, *.gif)",
                                    "jpg", "jpeg", "gif", "png"));
                            openImage.showOpenDialog(jPanel1);
                            File imageFile = openImage.getSelectedFile();

                            tempImage = imageFile.getAbsolutePath();
                            labPicture.setIcon(new ImageIcon(new ImageIcon(imageFile.getAbsolutePath()).getImage().getScaledInstance(labPicture.getWidth(),
                                    labPicture.getHeight(), Image.SCALE_SMOOTH)));
                        } catch (Exception ex) {
                            labPicture.setIcon(new ImageIcon(new ImageIcon("images\\default.jpg",
                                    "Click to add new image.").getImage().getScaledInstance(labPicture.getWidth(),
                                    labPicture.getHeight(), Image.SCALE_SMOOTH)));
                            tempImage = "default";
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
                labPicture.setBorder(new LineBorder(Color.cyan));
                setComponent(jfrAdd, gbl, gbc, labPicture, 15, 15, 0, 3, defaultNRow + 7, defaultNCol + 1);
                labPicture.setIcon(new ImageIcon(new ImageIcon("images\\default.jpg",
                        "Click to add new image.").getImage().getScaledInstance(labPicture.getWidth(),
                        labPicture.getHeight(), Image.SCALE_SMOOTH)));

                butOK = new JButton("OK");
                butOK.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        butOKActionPerformed(evt);
                    }
                });
                setComponent(jfrAdd, gbl, gbc, butOK, 10, 2, 6, 1, defaultNRow, defaultNCol);

                jDesktopPane1.add(jfrAdd);
                Insets insets = jDesktopPane1.getInsets();
                jfrAdd.setPreferredSize(new Dimension(600, 250));
                Dimension size = jfrAdd.getPreferredSize();

                jfrAdd.setBounds(10 + insets.left, 10 + insets.top,
                        size.width, size.height);

                jfrAdd.setVisible(true);
                jProgressBar1.setIndeterminate(progressFlag);
            }
        } else {
            jProgressBar1.setIndeterminate(progressFlag);
            jfrAdd.hide();
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void butOKActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            progressFlag = true;
            jProgressBar1.setIndeterminate(progressFlag);
            jLabel1.setText("Ready");

            textPrice.setBackground(Color.white);
            textName.setBackground(Color.white);
            double tmpPrice = Double.parseDouble(textPrice.getText());

            String imageURL;
            if (tempImage.equals("default")) {
                imageURL = getCurrentDirectory() + "\\images\\" + "default.jpg";
            } else {
                File sourceImage = new File(tempImage);
                String extension = sourceImage.getCanonicalPath().substring(sourceImage.getCanonicalPath().lastIndexOf("."));
                File destImage;
                do {
                    int id = (int) (Math.random() * 10 + Math.random() * 100 + Math.random() * 1000 + Math.random() * 10000);
                    imageURL = getCurrentDirectory() + "\\images\\" + id + extension;
                    destImage = new File(imageURL);
                } while (destImage.exists());
                Files.copy(sourceImage.toPath(), destImage.toPath());
            }
            Toy newToy = new Toy(textName.getText(), tmpPrice,
                    (AgeLimits) comboAge.getSelectedItem(), textAttribute.getText(), imageURL);

            addToyToFile(newToy);

            textName.setText(null);
            textPrice.setText(null);
            textAttribute.setText(null);
            labPicture.setIcon(new ImageIcon(new ImageIcon("images\\default.jpg",
                    "Click to add new image.").getImage().getScaledInstance(labPicture.getWidth(),
                    labPicture.getHeight(), Image.SCALE_SMOOTH)));
        } catch (NumberFormatException ex1) {
            textPrice.setBackground(Color.red);
            jLabel1.setText("Error");
        } catch (IllegalArgumentException ex2) {
            textName.setBackground(Color.red);
            jLabel1.setText("Error");
        } catch (Exception ex3) {
            jLabel1.setText("Error");
        } finally {
            progressFlag = false;
            jProgressBar1.setIndeterminate(progressFlag);
        }
    }

    private JInternalFrame jfrView;
    private JLabel labName1;
    private JComboBox<Toy> comboName1;
    private JLabel labPrice1;
    private JLabel labAge1;
    private JLabel labAttribute1;
    private JLabel labPicture1;
    //private JButton butOK1;
    private Toy selectedToy;
    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        jProgressBar1.setIndeterminate(true);
        if (jToggleButton2.isSelected()) {
            if (jfrView != null) {
                jfrView.show();
                jProgressBar1.setIndeterminate(progressFlag);
            } else {
                ArrayList<Toy> toyArrayList = readFromDB(getCurrentDirectory()
                        + "\\files\\ToysDataBase.zip", "ToysDataBase.txt");

                jfrView = new JInternalFrame("Перегляд всіх іграшок");
                jfrView.setName("jfrView");
                jfrView.setResizable(true);
                jfrView.setClosable(true);
                GridBagLayout gbl = new GridBagLayout();
                GridBagConstraints gbc = new GridBagConstraints();
                jfrView.setLayout(gbl);

                comboName1 = new JComboBox<Toy>();
                for (Toy next : toyArrayList) {
                    comboName1.addItem(next);
                }
                if (comboName1.getItemCount() < 1) {
                    comboName1.addItem(new Toy("empty",
                            0.0d, new AgeLimits(0, 0), "", getCurrentDirectory()
                            + "\\images\\default.jpg"));
                }
                setComponent(jfrView, gbl, gbc, comboName1, 10, 2, 0, 0, 1, 1);
                comboName1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showToyAndRepaint();
                    }
                });

                labName1 = new JLabel("Назва іграшки: ");
                setComponent(jfrView, gbl, gbc, labName1, 10, 2, 1, 0, 1, 1);

                labPrice1 = new JLabel("Ціна іграшки: ");
                setComponent(jfrView, gbl, gbc, labPrice1, 10, 2, 2, 0, defaultNRow, defaultNCol);

                labAge1 = new JLabel("Вікові межі: ");
                setComponent(jfrView, gbl, gbc, labAge1, 10, 2, 3, 0, defaultNRow, defaultNCol);

                labAttribute1 = new JLabel("Додаткова інф.: ");
                setComponent(jfrView, gbl, gbc, labAttribute1, 10, 2, 4, 0, defaultNRow + 1, defaultNCol);

                labPicture1 = new JLabel();
                labPicture1.setBorder(new LineBorder(Color.cyan));
                setComponent(jfrView, gbl, gbc, labPicture1, 15, 15, 0, 1, defaultNRow + 6, 2);

                //butOK1 = new JButton("OK");
                //setComponent(jfrView, gbl, gbc, butOK1, 10, 2, 6, 0, defaultNRow, 2);
                Insets insets = jDesktopPane1.getInsets();
                jfrView.setPreferredSize(new Dimension(600, 250));
                Dimension size = jfrView.getPreferredSize();

                jfrView.setBounds(30 + insets.left, 10 + insets.top,
                        size.width, size.height);

                showToyAndRepaint();

                jfrView.pack();
                jfrView.setVisible(true);
                jDesktopPane1.add(jfrView);

                jProgressBar1.setIndeterminate(progressFlag);
            }
        } else {
            jProgressBar1.setIndeterminate(progressFlag);
            jfrView.hide();
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void showToyAndRepaint() {
        jLabel1.setText("Ready");
        jProgressBar1.setIndeterminate(true);
        selectedToy = (Toy) comboName1.getSelectedItem();
        if (selectedToy == null) {
            return;
        }

        labName1.setText("Назва іграшки: " + selectedToy.getName());
        labPrice1.setText("Ціна іграшки: " + selectedToy.getPrice());
        labAge1.setText("Вікові межі: " + selectedToy.getAgeLimits().toString());
        labAttribute1.setText("Додаткова інф.: " + selectedToy.getAttribute());
        labPicture1.setIcon(new ImageIcon(new ImageIcon(selectedToy.getPictureURL(),
                "Not found").getImage().getScaledInstance(labPicture1.getWidth(),
                labPicture1.getHeight(), Image.SCALE_DEFAULT)));
        jProgressBar1.setIndeterminate(false);
    }

    private JInternalFrame jfrSearch;
    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if (jToggleButton3.isSelected()) {
            if (jfrSearch != null) {
                jfrSearch.show();
            } else {
                jfrSearch = new jfrSearch("Пошук за критеріями", defaultAgeLimits, this);
                jfrSearch.setName("jfrSearch");
                //jfrSearch.setResizable(true);
                jfrSearch.setClosable(true);

                Insets insets = jDesktopPane1.getInsets();
                //jfrView.setPreferredSize(new Dimension(600, 250));
                Dimension size = jfrSearch.getPreferredSize();

                jfrSearch.setBounds(50 + insets.left, 10 + insets.top,
                        size.width, size.height);

                jfrSearch.pack();
                jfrSearch.setVisible(true);
                jDesktopPane1.add(jfrSearch);
            }
        } else {
            jfrSearch.hide();
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    public void addPaneListener() {
        jDesktopPane1.addContainerListener(new ContainerAdapter() {
            public void componentRemoved(ContainerEvent e) {
                String tmp = e.getChild().getName();
                if (tmp.equals("jfrAdd")) {
                    jfrAdd = null;
                    jToggleButton1.setSelected(false);
                    jLabel1.setText("Ready");
                    jProgressBar1.setValue(0);
                } else if (tmp.equals("jfrView")) {
                    jfrView = null;
                    jToggleButton2.setSelected(false);
                    jLabel1.setText("Ready");
                    jProgressBar1.setValue(0);
                } else if (tmp.equals("jfrSearch")) {
                    jfrSearch = null;
                    jToggleButton3.setSelected(false);
                    jLabel1.setText("Ready");
                    jProgressBar1.setValue(0);
                };
            }
        ;
    }

    );
    }
    
    private void addToyToFile(Toy newToy) {
        try {
            if (writeInDB(newToy)) {
                jLabel1.setText("Added");
            }
        } catch (Exception ex) {
            jLabel1.setText("Error");
        }
    }

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

                ImageIcon icon = new ImageIcon("images/ico.jpg");
                mainFrame.setIconImage(icon.getImage());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
