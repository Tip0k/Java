package lab2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class NewClass extends JFrame {

    public NewClass() {
        defaultAgeLimits = new AgeLimits[]{
            new AgeLimits(0, 3),
            new AgeLimits(3, 5),
            new AgeLimits(5, 8),
            new AgeLimits(8, 8),
            new AgeLimits(10, 10)};
        createGUI();
    }

    private JInternalFrame jfrAdd;
    private static final int defaultNRow = 1;
    private static final int defaultNCol = 1;
    private String tempImage = "default";
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
    public AgeLimits[] defaultAgeLimits;

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

    public void createGUI() {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JDesktopPane d = new JDesktopPane();
        frame.setContentPane(d);

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
        labPicture.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

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
                //butOKActionPerformed(evt);
            }
        });
        setComponent(jfrAdd, gbl, gbc, butOK, 10, 2, 6, 1, defaultNRow, defaultNCol);

        d.add(jfrAdd);
        Insets insets = d.getInsets();
        jfrAdd.setPreferredSize(new Dimension(600, 250));
        Dimension size = jfrAdd.getPreferredSize();

        jfrAdd.setBounds(10 + insets.left, 10 + insets.top,
                size.width, size.height);

        jfrAdd.setVisible(true);
        frame.setPreferredSize(new Dimension(450, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                NewClass c = new NewClass();
            }
        });
    }
}
