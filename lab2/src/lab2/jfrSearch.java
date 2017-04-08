package lab2;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author PEOPLE
 */
public class jfrSearch extends javax.swing.JInternalFrame {

    private Toys mainToys;
    private ArrayList<Toy> toyArrayList;
    private double minPriceOfToy;
    private double maxPriceOfToy;

    public jfrSearch(String name, AgeLimits[] defAgeLim, Toys parent) {
        mainToys = parent;
        setTitle(name);
        initComponents();
        for (int i = 0; i < defAgeLim.length; i++) {
            jComboBox1.addItem(defAgeLim[i]);
        }

        toyArrayList = mainToys.readFromDB(mainToys.getCurrentDirectory()
                + "\\files\\ToysDataBase.zip", "ToysDataBase.txt");

        if (!toyArrayList.isEmpty()) {
            minPriceOfToy = toyArrayList.get(0).getPrice();
            maxPriceOfToy = toyArrayList.get(0).getPrice();
            for (Toy tmp : toyArrayList) {
                double tmpPrice = tmp.getPrice();
                if (tmpPrice < minPriceOfToy) {
                    minPriceOfToy = tmpPrice;
                }
                if (tmpPrice > maxPriceOfToy) {
                    maxPriceOfToy = tmpPrice;
                }
            }
            textMinPrice.setText("" + minPriceOfToy);
            textMaxPrice.setText("" + maxPriceOfToy);
        } else {
            textMinPrice.setText("0.0");
            textMaxPrice.setText("0.0");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textMinPrice = new javax.swing.JTextField();
        textMaxPrice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textPartOfName = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setVerifyInputWhenFocusTarget(false);

        jLabel1.setText("Ціна іграшки:");

        textMinPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textMinPrice.setText("0.0");
        textMinPrice.setEnabled(false);
        textMinPrice.setName(""); // NOI18N

        textMaxPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textMaxPrice.setText("0.0");
        textMaxPrice.setEnabled(false);
        textMaxPrice.setName(""); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("-");

        jLabel3.setText("Вікові межі:");

        jComboBox1.setEnabled(false);

        jButton1.setText("Пошук");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Назва (повністю або частина):");

        textPartOfName.setText("all");
        textPartOfName.setEnabled(false);
        textPartOfName.setName(""); // NOI18N

        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2))
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(textPartOfName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textMinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textMaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPartOfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textMinPrice)
                                .addComponent(textMaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(14, 14, 14))
        );

        textPartOfName.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        textMinPrice.setBackground(Color.WHITE);
        textMaxPrice.setBackground(Color.WHITE);
        String partOfName = "all";
        AgeLimits ageLimits = new AgeLimits(0, 0);
        double priceFrom = -1;
        double priceTo = -1;

        if (jRadioButton1.isSelected()) {
            partOfName = textPartOfName.getText();
        }
        if (jRadioButton2.isSelected()) {
            ageLimits = (AgeLimits) jComboBox1.getSelectedItem();
        }
        if (jRadioButton3.isSelected()) {
            try {
                priceFrom = Double.parseDouble(textMinPrice.getText());
                priceTo = Double.parseDouble(textMaxPrice.getText());
                if (priceFrom > priceTo) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                if (ex.getClass() == IllegalArgumentException.class) {
                    textMinPrice.setBackground(Color.red);
                } else {
                    textMinPrice.setBackground(Color.red);
                    textMaxPrice.setBackground(Color.red);
                }
                priceFrom = -1;
                priceTo = -1;
            }
        }
        showResultOfQueue(partOfName, ageLimits, priceFrom, priceTo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if (jRadioButton1.isSelected()) {
            textPartOfName.setEnabled(true);
            //textPartOfName.setText(null);
        } else {
            textPartOfName.setEnabled(false);
            textPartOfName.setText("all");
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if (jRadioButton2.isSelected()) {
            jComboBox1.setEnabled(true);
        } else {
            jComboBox1.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        if (jRadioButton3.isSelected()) {
            textMinPrice.setEnabled(true);
            textMaxPrice.setEnabled(true);
            //textMinPrice.setText("" + minPriceOfToy);
            //textMaxPrice.setText("" + maxPriceOfToy);
        } else {
            textMinPrice.setEnabled(false);
            textMaxPrice.setEnabled(false);
            textMinPrice.setText("" + minPriceOfToy);
            textMaxPrice.setText("" + maxPriceOfToy);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private JTable toysTable;
    private JScrollPane jScrollPane1;

    private void showResultOfQueue(String partOfName, AgeLimits ageLimits, double priceFrom, double priceTo) {
        ArrayList<Toy> result = new ArrayList<>();
        for (Toy next : toyArrayList) {
            if (!partOfName.equals("all")) {
                if (!next.getName().contains(partOfName)) {
                    continue;
                }
            }
            if (ageLimits.getMax() != 0) {
                if (!ageLimits.equals(next.getAgeLimits())) {
                    continue;
                }
            }
            if (priceFrom >= 0 && priceTo >= priceFrom) {
                if (next.getPrice() < priceFrom || next.getPrice() > priceTo) {
                    continue;
                }
            }
            result.add(next);
        }

        Object[] columnNames = {
            "Назва",
            "Ціна",
            "Вікові межі",
            "Додаткова інформація",
            "Фото",};

        int countColumns = columnNames.length;
        int countRows = result.size();

        Object[][] data = new String[countRows][countColumns];

        for (int i = 0; i < countRows; i++) {
            Toy tmp = result.get(i);
            data[i][0] = tmp.getName();
            data[i][1] = tmp.getPrice() + "";
            data[i][2] = tmp.getAgeLimits().toString();
            data[i][3] = tmp.getAttribute();
            data[i][4] = tmp.getPictureURL();
            //new ImageIcon(new ImageIcon(tmp.getPictureURL(),
            //"x").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        }

        toysTable = new JTable(data, columnNames);
        jScrollPane1 = new JScrollPane(toysTable);
        JOptionPane.showMessageDialog(this, jScrollPane1);

        ///як відобразити в існуючу таблицю... + фото
        jTable1 = toysTable;
        jTable1.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<AgeLimits> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textMaxPrice;
    private javax.swing.JTextField textMinPrice;
    private javax.swing.JTextField textPartOfName;
    // End of variables declaration//GEN-END:variables
}
