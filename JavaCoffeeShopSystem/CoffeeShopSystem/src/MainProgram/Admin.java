/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andre Darsono
 */
public class Admin extends JFrame {

    public Admin() {
        initComponent();
    }

    private Image resizeImage(int x, int y, String url) {
        Image dimg = null;
        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return dimg;
    }

    private void initComponent() {
        ImageIcon img = new ImageIcon("img/admin.png");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 300);
        setIconImage(img.getImage());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        setTitle("Admin");

        //Split Pane Admin Menu
        JSplitPane jspPn = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new ManageStock(), new ManageMenu());
        jspPn.setContinuousLayout(true);
        jspPn.setOneTouchExpandable(true);
        jspPn.setDividerLocation(700);

        jspPn.setDividerSize(13);
        getContentPane().add(jspPn);
    }

    public static void main(String[] args) {

        new Admin().setVisible(true);

    }

}
