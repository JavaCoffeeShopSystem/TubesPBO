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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
    private List<TblBahan> listTblBarang = new ArrayList<>();
    
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
        jlbFood = new JLabel("Menu");
        jlbFood.setForeground(Color.LIGHT_GRAY);
        jlbFood.setBounds(30, 20, 120, 20);
        jlbFood.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(jlbFood);
        
        jtfFood = new JTextField();
        jtfFood.setBounds(30, 55, 150, 30);

        //Add menu price
        jlbPrice = new JLabel("Harga");
        jlbPrice.setForeground(Color.LIGHT_GRAY);
        jlbPrice.setBounds(30, 90, 100, 20);
        jlbPrice.setFont(new Font("SansSerif", Font.PLAIN, 20));

        jtfPrice = new JTextField("0");
        jtfPrice.setBounds(30, 120, 150, 30);

        //Selected menu
        jlbSelect = new JLabel("Jenis");
        jlbSelect.setForeground(Color.LIGHT_GRAY);
        jlbSelect.setFont(new Font("SansSerif", Font.PLAIN, 15));
        jlbSelect.setBounds(210, 15, 100, 20);

        bgGroup = new ButtonGroup();

        jrbJBFood = new JRadioButton("Food", true);
        jrbJBFood.setOpaque(false);
        jrbJBFood.setForeground(Color.LIGHT_GRAY);
        jrbJBFood.setActionCommand("makanan");
        jrbJBFood.setBounds(210, 45, 100, 20);

        jrbJBBev = new JRadioButton("Beverage", true);
        jrbJBBev.setOpaque(false);
        jrbJBBev.setForeground(Color.LIGHT_GRAY);
        jrbJBBev.setActionCommand("non-kopi");
        jrbJBBev.setBounds(210, 85, 100, 20);

        jrbJBCoff = new JRadioButton("Coffee", true);
        jrbJBCoff.setOpaque(false);
        jrbJBCoff.setForeground(Color.LIGHT_GRAY);
        jrbJBCoff.setActionCommand("kopi");
        jrbJBCoff.setBounds(210, 125, 100, 20);

        //Add Menu
        jbAdd2 = new JButton("Add");
        jbAdd2.setBounds(30, 155, 70, 30);
        jbAdd2.setBackground(Color.GRAY);
        jbAdd2.setForeground(Color.WHITE);

        //Show All menu
        jbShowMenu = new JButton("Menu");
        jbShowMenu.setBounds(110, 155, 70, 30);
        jbShowMenu.setBackground(Color.GRAY);
        jbShowMenu.setForeground(Color.WHITE);
        
        //ask img
        jbAddPict = new JButton("Add Pict");
        jbAddPict.setBounds(210, 155, 100, 30);
        jbAddPict.setBackground(Color.GRAY);
        jbAddPict.setForeground(Color.WHITE);
        
        //add bahan
        jbAddBahan = new JButton("Add Bahan");
        jbAddBahan.setBounds(210,190, 100, 30);
        jbAddBahan.setBackground(Color.GRAY);
        jbAddBahan.setForeground(Color.WHITE);
        
        ImageIcon background = new ImageIcon("img\\background2.jpg");
        Image img = background.getImage();
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 800, 400);
        
        add(jbAddBahan);
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
        add(back);

        bgGroup.add(jrbJBFood);
        bgGroup.add(jrbJBBev);
        bgGroup.add(jrbJBCoff);
    }
    
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
        
        jbAddBahan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tambahBahan();
                jbUpdate2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        TblBahan bahan = new TblBahan();
                        bahan.setIdBarang(Integer.parseInt(jtfItem.getText()));
                        bahan.setJml(Integer.parseInt(jtfQua.getText()));
                        bahan.setNamaMenu(tm.getNama());
                        listTblBarang.add(bahan);
                    }
                });
            }
        });

    }



    private void jbAdd2Click(ActionEvent e) {

        String menuName = jtfFood.getText().trim();
        double price = Double.parseDouble(jtfPrice.getText());

        if (menuName.length() == 0) {
            JOptionPane.showMessageDialog(this, "Field nama menu tidak boleh kosong!", "Field nama menu", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (price == 0) {
            JOptionPane.showMessageDialog(this, "Harga menu tidak boleh 0!", "Harga menu", JOptionPane.WARNING_MESSAGE);
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
            DataAccess.addMenu(tm,listTblBarang);
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
    
    private void tambahBahan() {

        JDialog jd = new JDialog();
        jd.setLayout(null);
        jd.setLocationRelativeTo(null);
        jd.setSize(600, 300);

        jlbItem = new JLabel("Item Id");
        jlbItem.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbItem.setBounds(8, 20, 100, 35);

        jtfItem = new JTextField();
        jtfItem.setBounds(110, 22, 100, 30);

        //Input kuantitas item 
        jlbQua = new JLabel("Kuantitas");
        jlbQua.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbQua.setBounds(8, 35, 100, 75);

        jtfQua = new JTextField("0");
        jtfQua.setBounds(110, 61, 100, 30);
        
        //Button update stock
        jbUpdate2 = new JButton("Add");
        jbUpdate2.setBounds(110, 150, 100, 30);
        jbUpdate2.setBackground(Color.LIGHT_GRAY);

        jd.add(jlbItem);
        jd.add(jtfItem);
        jd.add(jlbQua);
        jd.add(jtfQua);
        jd.add(jbUpdate2);
        jd.add(showStock((DataAccess.showStock())));
        jd.setVisible(true);
    }

    private JComponent showStock(List<Item> listItem) {
        String[] title = {"id", "Item", "Qua", "Unit", "Price"};
        Object[][] arrObj = new Object[listItem.size()][5];

        int i = 0;
        for (Item item : listItem) {
            arrObj[i][0] = item.getId();
            arrObj[i][1] = item.getName();
            arrObj[i][2] = item.getQty();
            arrObj[i][3] = item.getUnit();
            arrObj[i][4] = item.getPrice();
            i++;
        }

        jtbStock = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(arrObj, title);
        jtbStock.setModel(dtm);
        jscJsc1 = new JScrollPane(jtbStock);
        jscJsc1.setBounds(230, 23, 300, 200);
        
        return jscJsc1;

    }
    
    private void jbAddBahan(){
        
    }

    JButton jbAdd2;
    JButton jbShowMenu;
    JButton jbAddPict;
    JButton jbAddBahan;

    JTextField jtfFood;
    JTextField jtfPrice;

    JLabel jlbFood;
    JLabel jlbPrice;
    JLabel jlbSelect;

    JRadioButton jrbJBFood;
    JRadioButton jrbJBBev;
    JRadioButton jrbJBCoff;
    
    JButton jbUpdate2;

    JTextField jtfItem;
    JTextField jtfQua;

    JLabel jlbItem;
    JLabel jlbQua;

    JTable jtbStock;
    JScrollPane jscJsc1;
}
