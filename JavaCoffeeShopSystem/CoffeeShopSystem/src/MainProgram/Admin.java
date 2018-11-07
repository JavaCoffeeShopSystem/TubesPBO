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

/**
 *
 * @author Andre Darsono
 */
public class Admin extends JFrame {

    public Admin() {
        initComponent();
        //setupAction();
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
        setSize(500, 300);
        setIconImage(img.getImage());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        setTitle("Admin");

        //Split Pane Admin Menu
        JSplitPane jspPn = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, setPnlStock(), setPnlMenu());
        jspPn.setContinuousLayout(true);
        jspPn.setOneTouchExpandable(true);
        jspPn.setDividerLocation(500);

        jspPn.setDividerSize(13);
        getContentPane().add(jspPn);
    }

    private JPanel setPnlStock() {
        //Panel 1
        jpPan1 = new JPanel();
        jpPan1.setLayout(null);

        //Input item name
        jlbItem = new JLabel("Item name");
        jlbItem.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbItem.setBounds(8, 5, 100, 35);

        jtfItem = new JTextField();
        jtfItem.setBounds(110, 7, 200, 30);

        //Input Quantity item
        jlbQua = new JLabel("Quantity");
        jlbQua.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbQua.setBounds(20, 20, 100, 75);

        jtfQua = new JTextField("0");
        jtfQua.setBounds(110, 48, 50, 30);

        //Add item name and quantity
        jbAdd = new JButton("Add");
        jbAdd.setBounds(110, 90, 100, 30);
        jbAdd.setBackground(Color.DARK_GRAY);
        jbAdd.setForeground(Color.WHITE);

        //See added item list
        jbStock = new JButton("Stock");
        jbStock.setBounds(110, 130, 100, 30);
        jbStock.setBackground(Color.LIGHT_GRAY);

        jpPan1.add(jlbItem);
        jpPan1.add(jtfItem);
        jpPan1.add(jlbQua);
        jpPan1.add(jtfQua);
        jpPan1.add(jbAdd);
        jpPan1.add(jbStock);

        return jpPan1;
    }

    private JPanel setPnlMenu() {
        jpPan2 = new JPanel();

        jpPan2.setLayout(null);

        //Add menu
        jlbFood = new JLabel("Menu Name");
        jlbFood.setBounds(120, 20, 120, 20);
        jlbFood.setFont(new Font("SansSerif", Font.PLAIN, 20));

        jtfFood = new JTextField();
        jtfFood.setBounds(120, 55, 150, 30);

        //Add menu price
        jlbPrice = new JLabel("Price");
        jlbPrice.setBounds(120, 90, 100, 20);
        jlbPrice.setFont(new Font("SansSerif", Font.PLAIN, 20));

        jtfPrice = new JTextField("0");
        jtfPrice.setBounds(120, 120, 150, 30);

        //Selected menu
        jlbSelect = new JLabel("Select menu");
        jlbSelect.setFont(new Font("SansSerif", Font.PLAIN, 15));
        jlbSelect.setBounds(300, 15, 100, 20);

        ButtonGroup bgGroup = new ButtonGroup();

        jrbJBFood = new JRadioButton("Food", true);
        jrbJBFood.setBounds(300, 45, 100, 20);

        jrbJBBev = new JRadioButton("Beverage", true);
        jrbJBBev.setBounds(300, 85, 100, 20);

        jrbJBCoff = new JRadioButton("Coffee", true);
        jrbJBCoff.setBounds(300, 125, 100, 20);

        //Add Menu
        jbAdd2 = new JButton("Add");
        jbAdd2.setBounds(120, 155, 70, 30);

        //Show All menu
        jbShowMenu = new JButton("Menu");
        jbShowMenu.setBounds(200, 155, 70, 30);

        jpPan2.add(jbAdd2);
        jpPan2.add(jbShowMenu);
        jpPan2.add(jlbFood);
        jpPan2.add(jtfFood);
        jpPan2.add(jlbPrice);
        jpPan2.add(jtfPrice);
        jpPan2.add(jrbJBFood);
        jpPan2.add(jrbJBBev);
        jpPan2.add(jrbJBCoff);
        jpPan2.add(jlbSelect);

        bgGroup.add(jrbJBFood);
        bgGroup.add(jrbJBBev);
        bgGroup.add(jrbJBCoff);

        return jpPan2;
    }

    private void setUpAction() {

        //Add stock
        jbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jbAddClick(e);
            }
        });

        //See stock
        jbStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jbStockClick(e);
            }
        });

        //Add Menu
        jbAdd2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jbAdd2Click(e);
            }
        });

        //See sMenu
        jbShowMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jbShowMenuClick(e);
            }
        });

    }

    private void jbAddClick(ActionEvent e) {

        String itemName = jtfItem.getText().trim();
        int qua = Integer.parseInt(jtfQua.getText());

        if (itemName.length() == 0) {
            JOptionPane.showMessageDialog(this, "Item name field must be filled", "Item name field", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (qua == 0 || jtfQua.getText().equals(null)) {
            JOptionPane.showMessageDialog(this, "Quantity can't be zero", "Quantity field", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int result = JOptionPane.showConfirmDialog((Component) null, "Add " + itemName + "\nQuantity : " + qua + "\nstock ?", "alert", JOptionPane.OK_CANCEL_OPTION);

        if (result == 0) {
            JOptionPane.showMessageDialog(null, "Success");
        }

    }

    private void jbStockClick(ActionEvent e) {

        JDialog showStock = new JDialog();
        showStock.setSize(300, 400);
        showStock.setLocation(1000, 350);
        //showStock.setResizable(false);

        String[] colname = {"No.", "Item", "Quantity"};
        String[][] data = {{"1", "Java Bean", "20"},
        {"2", "Toraja Bean", "15"},
        {"3", "Papua Bean", "15"}};

        jtbStock = new JTable(data, colname);
        jtbStock.setBounds(95, 130, 100, 30);

        jscJsc1 = new JScrollPane(jtbStock);
        showStock.add(jscJsc1);
        showStock.setVisible(true);
    }

    private void jbAdd2Click(ActionEvent e) {

        String menuName = jtfFood.getText().trim();
        double price = Double.parseDouble(jtfPrice.getText());

        if (menuName.length() == 0) {
            JOptionPane.showMessageDialog(this, "Menu field must be filled", "Item name field", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (price == 0) {
            JOptionPane.showMessageDialog(this, "Price can't be zero", "Quantity field", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int result = JOptionPane.showConfirmDialog((Component) null, "Add " + menuName + "\nPrice : " + price + "\nto menu ?", "alert", JOptionPane.OK_CANCEL_OPTION);

        if (result == 0) {
            JOptionPane.showMessageDialog(null, "Success");
        }

    }

    private void jbShowMenuClick(ActionEvent e) {
        //Food
        JDialog showMenuFood = new JDialog();
        showMenuFood.setTitle("Food");
        showMenuFood.setSize(300, 400);
        showMenuFood.setLocation(1000, 350);
        showMenuFood.setResizable(false);

        String[] colname = {"No.", "Name", "Price"};
        String[][] dataMenu = {{"1", "Sandwich", "20000"},
        {"2", "Chocolate Brownie", "15000"},
        {"3", "Lasagne", "40000"}};

        jtbStock = new JTable(dataMenu, colname);
        jtbStock.setBounds(95, 130, 100, 30);

        jscJsc1 = new JScrollPane(jtbStock);
        showMenuFood.add(jscJsc1);
        showMenuFood.setVisible(true);

        //Beverages
        JDialog showMenuBeverages = new JDialog();
        showMenuBeverages.setTitle("Beverages");
        showMenuBeverages.setSize(300, 400);
        showMenuBeverages.setLocation(1000, 350);
        showMenuBeverages.setResizable(false);

        String[][] dataBev = {{"1", "Sprite", "8000"},
        {"2", "Lemon Tea", "12000"},
        {"3", "Lemon Squash", "13000"}};

        jtbStock = new JTable(dataBev, colname);
        jtbStock.setBounds(95, 130, 100, 30);

        jscJsc1 = new JScrollPane(jtbStock);
        showMenuBeverages.add(jscJsc1);
        showMenuBeverages.setVisible(true);

        //Coffee
        JDialog showMenuCoffee = new JDialog();
        showMenuCoffee.setTitle("Coffee");
        showMenuCoffee.setSize(300, 400);
        showMenuCoffee.setLocation(1000, 350);
        showMenuCoffee.setResizable(false);

        String[][] dataCoff = {{"1", "Vietnam Brew", "20000"},
        {"2", "V60", "15000"},
        {"3", "French Press", "15000"}};

        jtbStock = new JTable(dataCoff, colname);
        jtbStock.setBounds(95, 130, 100, 30);

        jscJsc1 = new JScrollPane(jtbStock);
        showMenuCoffee.add(jscJsc1);
        showMenuCoffee.setVisible(true);

    }

    public static void main(String[] args) {

        new Admin().setVisible(true);

    }
    JPanel jpPan1;
    JPanel jpPan2;

    //Panel 1 component
    JButton jbAdd;
    JButton jbStock;

    JTextField jtfItem;
    JTextField jtfQua;

    JLabel jlbItem;
    JLabel jlbQua;

    JTable jtbStock;
    JScrollPane jscJsc1;

    JTabbedPane jtpPn;
    JSplitPane jspPn;

    //Panel 2 component
    JButton jbAdd2;
    JButton jbShowMenu;

    JTextField jtfFood;
    JTextField jtfPrice;

    JLabel jlbFood;
    JLabel jlbPrice;
    JLabel jlbSelect;

    JRadioButton jrbJBFood;
    JRadioButton jrbJBBev;
    JRadioButton jrbJBCoff;
}
