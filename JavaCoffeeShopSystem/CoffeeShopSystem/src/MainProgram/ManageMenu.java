/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import DatabaseConnection.DataAccess;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
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
 * @author Ronaldo
 */
public class ManageMenu extends JLabel {
    
    private File file = new File("");
    private TblMenu tm = new TblMenu();
    private ButtonGroup bgGroup;

    public ManageMenu() {
        initComponent();
        setUpAction();
//        setVisible(true);
    }

    private void initComponent() {
        this.setLayout(null);
        setSize(600,600);
        setLayout(null);

        //Add menu
        jlbFood = new JLabel("Menu Name");
        jlbFood.setBounds(120, 20, 120, 20);
        jlbFood.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(jlbFood);
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

        bgGroup = new ButtonGroup();

        jrbJBFood = new JRadioButton("Food", true);
        jrbJBFood.setActionCommand("makanan");
        jrbJBFood.setBounds(300, 45, 100, 20);

        jrbJBBev = new JRadioButton("Beverage", true);
        jrbJBBev.setActionCommand("non-kopi");
        jrbJBBev.setBounds(300, 85, 100, 20);

        jrbJBCoff = new JRadioButton("Coffee", true);
        jrbJBCoff.setActionCommand("kopi");
        jrbJBCoff.setBounds(300, 125, 100, 20);

        //Add Menu
        jbAdd2 = new JButton("Add");
        jbAdd2.setBounds(120, 155, 70, 30);

        //Show All menu
        jbShowMenu = new JButton("Menu");
        jbShowMenu.setBounds(200, 155, 70, 30);
        
        
        //ask img
        jbAddPict = new JButton("Add Pict");
        jbAddPict.setBounds(300, 155, 100, 30);
        
        add(jbAdd2);
        add(jbAddPict);
        add(jbShowMenu);
        add(jlbFood);
        add(jtfFood);
        add(jlbPrice);
        add(jtfPrice);
        add(jrbJBFood);
        add(jrbJBBev);
        add(jrbJBCoff);
        add(jlbSelect);

        bgGroup.add(jrbJBFood);
        bgGroup.add(jrbJBBev);
        bgGroup.add(jrbJBCoff);
    }
    
//    public static void main(String[] args) {
//        new ManageMenu();
//    }

    private void setUpAction() {

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
        
        jbAddPict.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jbAddPict();
            }
        });

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
        //set target file location
        File target = new File(System.getProperty("user.dir")+"/img",file.getName());
        
        try {
            //copy file
            Files.copy(file.toPath(), target.toPath(),REPLACE_EXISTING);
        } catch (Exception ex) {
//            System.out.println("gambar kososng!!");
        }

        int result = JOptionPane.showConfirmDialog((Component) null, "Add " + menuName + "\nPrice : " + price 
                + "\nPicture: " + file.getName() + "\nto menu ?", "alert", JOptionPane.OK_CANCEL_OPTION);

        if (result == 0) {
            tm.setHarga(price);
            tm.setNama(menuName);
            tm.setUrl("img\\" + file.getName());
            if (bgGroup.getSelection().getActionCommand().equals("makanan")) {
                tm.setTipe("makanan");
            }else{
                tm.setTipe("minuman");
                tm.setKategori(bgGroup.getSelection().getActionCommand());
            }
            JOptionPane.showMessageDialog(null, "Success");
            DataAccess.addMenu(tm);
        }
        
        

    }

    private void jbShowMenuClick(ActionEvent e) {
       

    }   
    
    private void jbAddPict(){
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        this.file = chooser.getSelectedFile();
        if (!file.getName().contains(".jpg") && !file.getName().contains(".png") && !file.getName().contains(".jpeg")) {
            JOptionPane.showMessageDialog(null, "File harus berekstensi jpg/jpeg/png.","Warning!!",JOptionPane.WARNING_MESSAGE);
            this.file = new File("");
        }
        System.out.println(file.getName());
        
        
    }

    JButton jbAdd2;
    JButton jbShowMenu;
    JButton jbAddPict;

    JTextField jtfFood;
    JTextField jtfPrice;

    JLabel jlbFood;
    JLabel jlbPrice;
    JLabel jlbSelect;

    JRadioButton jrbJBFood;
    JRadioButton jrbJBBev;
    JRadioButton jrbJBCoff;
}
