package lab2;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PEOPLE
 */
public class jfrSearch extends javax.swing.JInternalFrame {

    private Toys mainToys;
    private ArrayList<Toy> toyArrayList;
    private double minPriceOfToy;
    private double maxPriceOfToy;

    private JTable toysTable;
    private JScrollPane tableScrollPane;
    private opaTableModel tModel;

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

        tModel = new opaTableModel(getResultOfQueue("all", new AgeLimits(0, 0), -1, -1));
        toysTable = new JTable(tModel);
        tableScrollPane = new JScrollPane(toysTable);
        tableScrollPane.setEnabled(true);
        jPanel1.add(tableScrollPane);
        jPanel1.updateUI();

        toysTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //if(toysTable)
                try {
                    Point p = e.getPoint();
                    int y = toysTable.columnAtPoint(p);
                    if (y == 4) {
                        int x = toysTable.rowAtPoint(p);
                        Object obj = toysTable.getValueAt(x, y);
                        if (obj.getClass() == ImageIcon.class) {
                            ImageIcon icon = (ImageIcon) obj;                            
                            Component c = e.getComponent().getParent().getParent().getParent();
                            if (icon.getIconWidth() > c.getWidth() || icon.getIconHeight() > c.getHeight()) {
                                icon = new ImageIcon(icon.getImage().getScaledInstance(
                                        c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH));
                            }

                            JOptionPane.showMessageDialog(e.getComponent(), icon, "", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(e.getComponent(), obj, "", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                } catch (Exception ex) {
                }
            }
        });
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
        jPanel1 = new javax.swing.JPanel();

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

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
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
                .addGap(15, 15, 15))
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

        tModel.setDataSource(getResultOfQueue(partOfName, ageLimits, priceFrom, priceTo));
        toysTable.updateUI();
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

    private ArrayList<Toy> getResultOfQueue(String partOfName, AgeLimits ageLimits, double priceFrom, double priceTo) {
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
        return result;
    }

    public class opaTableModel extends AbstractTableModel {

        private ArrayList<Toy> result;

        public opaTableModel(ArrayList<Toy> result) {
            super();
            this.result = result;
        }

        public void setDataSource(ArrayList<Toy> result) {
            this.result = result;
        }

        @Override
        public int getRowCount() {
            return result.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "Назва";
                case 1:
                    return "Ціна";
                case 2:
                    return "Вікові межі";
                case 3:
                    return "Додаткова інформація";
                case 4:
                    return "Фото";
                default:
                    return "";
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 4) {
                return ImageIcon.class;
            } else {
                return String.class;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Toy current = result.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return current.getName();
                case 1:
                    return current.getPrice();
                case 2:
                    return current.getAgeLimits();
                case 3:
                    return current.getAttribute();
                case 4:
                    return new ImageIcon(mainToys.getCurrentDirectory() + current.getPictureURL());
                default:
                    return "";
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addTableModelListener(TableModelListener l) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<AgeLimits> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField textMaxPrice;
    private javax.swing.JTextField textMinPrice;
    private javax.swing.JTextField textPartOfName;
    // End of variables declaration//GEN-END:variables

    public static abstract class ImageResizer {

        public static BufferedImage resize(BufferedImage imageToResize, int width, int height) {
            //BufferedImage  in = ImageIO.read(new File("/home/yura/Desktop/img.jpg"));	
            //BufferedImage out = ImageResizer.resize(in, 3400, 3400);
            //ImageIO.write(out, "jpg", new File("/home/yura/Desktop/img1.jpg"));
        
            float dx = ((float) width) / imageToResize.getWidth();
            float dy = ((float) height) / imageToResize.getHeight();

            int genX, genY;
            int startX, startY;

            if (imageToResize.getWidth() <= width && imageToResize.getHeight() <= height) {
                genX = imageToResize.getWidth();
                genY = imageToResize.getHeight();
            } else {
                if (dx <= dy) {
                    genX = width;
                    genY = (int) (dx * imageToResize.getHeight());
                } else {
                    genX = (int) (dy * imageToResize.getWidth());
                    genY = height;
                }
            }

            startX = (width - genX) / 2;
            startY = (height - genY) / 2;

            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = null;

            try {
                graphics2D = bufferedImage.createGraphics();
                graphics2D.fillRect(0, 0, width, height);
                graphics2D.drawImage(imageToResize, startX, startY, genX, genY, null);
            } finally {
                if (graphics2D != null) {
                    graphics2D.dispose();
                }
            }

            return bufferedImage;
        }
    }
}
