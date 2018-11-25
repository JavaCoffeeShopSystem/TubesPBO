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
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronaldo
 */
public class ManageStock extends JPanel {

    public ManageStock() {
        initComponent();
        setUpAction();
    }

    private void initComponent() {
        this.setLayout(null);

        //Input id item 
        jlbId = new JLabel("Id");
        jlbId.setFont(new Font("SansSerif", Font.PLAIN, 19));
        jlbId.setForeground(Color.LIGHT_GRAY);
        jlbId.setBounds(225, 37, 100, 75);
        
        jtfId = new JTextField("0");
        jtfId.setBounds(253, 61, 56, 30);

        //Input nama item
        jlbItem = new JLabel("Item");
        jlbItem.setFont(new Font("SansSerif", Font.PLAIN, 19));
        jlbItem.setForeground(Color.LIGHT_GRAY);
        jlbItem.setBounds(8, 20, 100, 35);

        jtfItem = new JTextField();
        jtfItem.setBounds(110, 22, 200, 30);

        //Input kuantitas item 
        jlbQua = new JLabel("Kuantitas");
        jlbQua.setFont(new Font("SansSerif", Font.PLAIN, 19));
        jlbQua.setForeground(Color.LIGHT_GRAY);
        jlbQua.setBounds(8, 37, 100, 75);

        jtfQua = new JTextField("0");
        jtfQua.setBounds(110, 61, 100, 30);

        //Input satuan item
        jlbUnit = new JLabel("Satuan");
        jlbUnit.setFont(new Font("SansSerif", Font.PLAIN, 19));
        jlbUnit.setForeground(Color.LIGHT_GRAY);
        jlbUnit.setBounds(8, 76, 100, 75);

        jtfUnit = new JTextField();
        jtfUnit.setBounds(110, 100, 100, 30);

        //Input harga item
        jlbPrice = new JLabel("Harga");
        jlbPrice.setFont(new Font("SansSerif", Font.PLAIN, 19));
        jlbPrice.setForeground(Color.LIGHT_GRAY);
        jlbPrice.setBounds(8, 117, 100, 75);

        jtfPrice = new JTextField("0");
        jtfPrice.setBounds(110, 140, 100, 30);

        //Button add item ke database
        jbAdd = new JButton("Add");
        jbAdd.setBounds(110, 180, 200, 45);
        jbAdd.setBackground(Color.GRAY);
        jbAdd.setForeground(Color.WHITE);

        //Button update stock
        jbUpdate = new JButton("Update");
        jbUpdate.setBounds(110, 230, 200, 45);
        jbUpdate.setBackground(Color.GRAY);
        jbUpdate.setForeground(Color.WHITE);

        //Button hapus item di stock
        jbDelete = new JButton("Delete");
        jbDelete.setBounds(110, 280, 200, 45);
        jbDelete.setBackground(Color.GRAY);
        jbDelete.setForeground(Color.WHITE);

        ImageIcon background = new ImageIcon("img\\background.jpg");
        Image img = background.getImage();
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 800, 400);
        //Tabel item yang ada dalam stock
        showStock(DataAccess.showStock());

        add(jlbItem);
        add(jtfItem);
        add(jlbQua);
        add(jtfQua);
        add(jtfId);
        add(jlbId);
        add(jlbUnit);
        add(jtfUnit);
        add(jlbPrice);
        add(jtfPrice);
        add(jbAdd);
        add(jbUpdate);
        add(jbDelete);
        add(back);
    }

    private void setUpAction() {

        //Add stock
        jbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(jtfId.getText());
                String item = jtfItem.getText();
                String unit = jtfUnit.getText();
                int qua = Integer.parseInt(jtfQua.getText());
                int price = Integer.parseInt(jtfPrice.getText());

                if (id == 0) {
                    JOptionPane.showMessageDialog(null, "Id tidak boleh 0!", "Input id item", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (item.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Field nama item harus terisi!", "Input nama item", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (qua == 0) {
                    JOptionPane.showMessageDialog(null, "Quantity item tidak boleh 0!", "Input quantity item", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (unit.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Field satuan item harus terisi!", "Input satuan item", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (price == 0) {
                    JOptionPane.showMessageDialog(null, "Harga item tidak boel 0!", "Input price", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int result = JOptionPane.showConfirmDialog((Component) null, "Add "
                        + "\nNama : " + item
                        + "\nQuantity : " + qua
                        + "\nHarga : " + price
                        + "\nstock ?", "After input", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    Item i = new Item(id, item, qua, unit, price);
                    DataAccess data = new DataAccess();
                    data.addStock(i);
                    showStock(DataAccess.showStock());
                    JOptionPane.showMessageDialog(null, "Success");
                    jtfId.setText("0");
                    jtfItem.setText("");
                    jtfPrice.setText("0");
                    jtfQua.setText("0");
                    jtfUnit.setText("");

                }

            }
        });

        //Update stock
        jbUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan id barang : "));
                Item i = DataAccess.searchItem(id);

                if (i == null) {
                    JOptionPane.showMessageDialog(null, "Barang tidak ditemukan!");
                } else {
                    updateItem();
                    jbUpdate2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Item i2 = new Item();
                            i2.setId(id);
                            i2.setQty(Integer.parseInt(jtfQua.getText()));
                            i2.setPrice(Integer.parseInt(jtfPrice.getText()));
                            DataAccess.updateItem(i2);
                            showStock(DataAccess.showStock());
                            JOptionPane.showMessageDialog(null, "Tabel telah diperbaharui");
                            jdUpdate.setVisible(false);
                        }
                    });
                }
            }
        });

        //Delete item 
        jbDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Input Id : "));
                Item i = DataAccess.searchItem(id);

                if (i == null) {
                    JOptionPane.showMessageDialog(null, "Barang tidak ditemukan!");
                } else {
                    DataAccess.deleteItem(id);
                    showStock(DataAccess.showStock());
                    JOptionPane.showMessageDialog(null, "Table stok berhasil diperbaharui");
                }
            }
        });
    }

    private void showStock(List<Item> listItem) {
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
        jscJsc1.setBounds(350, 23, 400, 308);
        add(jscJsc1);

    }

    private void updateItem() {

        jdUpdate = new JDialog();
        jdUpdate.setLayout(null);
        jdUpdate.setLocationRelativeTo(null);
        jdUpdate.setSize(400, 250);

        //Input kuantitas item 
        jlbQua = new JLabel("Kuantitas");
        jlbQua.setForeground(Color.LIGHT_GRAY);
        jlbQua.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbQua.setBounds(8, 7, 100, 75);

        jtfQua = new JTextField("0");
        jtfQua.setBounds(110, 30, 100, 30);

        //Input harga item
        jlbPrice = new JLabel("Harga");
        jlbPrice.setForeground(Color.LIGHT_GRAY);
        jlbPrice.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbPrice.setBounds(8, 53, 100, 75);

        jtfPrice = new JTextField("0");
        jtfPrice.setBounds(110, 79, 100, 30);

        //Button update stock
        jbUpdate2 = new JButton("Update");
        jbUpdate2.setBounds(110, 130, 200, 40);
        jbUpdate2.setBackground(Color.GRAY);
        jbUpdate2.setForeground(Color.WHITE);
        
        ImageIcon background = new ImageIcon("img\\login.jpg");
        Image img = background.getImage();
        JLabel lblBack = new JLabel(background);
        lblBack.setLayout(null);
        lblBack.setBounds(0, 0, 800, 400);

        jdUpdate.add(jlbQua);
        jdUpdate.add(jtfQua);
        jdUpdate.add(jlbPrice);
        jdUpdate.add(jtfPrice);
        jdUpdate.add(jbUpdate2);
        jdUpdate.add(lblBack);

        jdUpdate.setVisible(true);
    }
    
    JButton jbAdd;
    JButton jbUpdate;
    JButton jbUpdate2;
    JButton jbDelete;

    JTextField jtfId;
    JTextField jtfItem;
    JTextField jtfQua;
    JTextField jtfUnit;
    JTextField jtfPrice;

    JLabel jlbId;
    JLabel jlbItem;
    JLabel jlbQua;
    JLabel jlbUnit;
    JLabel jlbPrice;

    JTable jtbStock;
    JScrollPane jscJsc1;
    JComboBox jCb;

    JSplitPane jspPn;
    JDialog jdUpdate;
}
