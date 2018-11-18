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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
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

        //Input nama item
        jlbItem = new JLabel("Item");
        jlbItem.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbItem.setBounds(8, 20, 100, 35);

        jtfItem = new JTextField();
        jtfItem.setBounds(110, 22, 200, 30);

        
        //Input kuantitas item 
        jlbQua = new JLabel("Kuantitas");
        jlbQua.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbQua.setBounds(8, 35, 100, 75);

        jtfQua = new JTextField("0");
        jtfQua.setBounds(110, 61, 100, 30);

        
        //Input satuan item
        jlbUnit = new JLabel("Satuan");
        jlbUnit.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbUnit.setBounds(8, 76, 100, 75);

        jtfUnit = new JTextField();
        jtfUnit.setBounds(110, 100, 100, 30);
        
        
        //Input harga item
        jlbPrice = new JLabel("Harga");
        jlbPrice.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbPrice.setBounds(8, 117, 100, 75);

        jtfPrice = new JTextField("0");
        jtfPrice.setBounds(110, 140, 100, 30);
        
        
        //Button add item ke database
        jbAdd = new JButton("Add");
        jbAdd.setBounds(110, 180, 94, 30);
        jbAdd.setBackground(Color.DARK_GRAY);
        jbAdd.setForeground(Color.WHITE);

        
        //Button untuk melihat stok item
        jbStock = new JButton("Stock");
        jbStock.setBounds(216, 180, 94, 30);
        jbStock.setBackground(Color.LIGHT_GRAY);

        jlbHistory = new JLabel("History");
        jlbHistory.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbHistory.setBounds(462, -1, 100, 75);
        
        
        jbStock(DataAccess.showStock());
//        JTable jtb = new JTable();
//        DefaultTableModel dtm = new DefaultTableModel(data1, colname1);
//        jtb.setModel(dtm);
//        JScrollPane jsp = new JScrollPane(jtb);
//        jsp.setBounds(350, 61, 300, 130);


        add(jlbItem);
        add(jtfItem);
        add(jlbQua);
        add(jtfQua);
        add(jlbUnit);
        add(jtfUnit);
        add(jlbPrice);
        add(jtfPrice);
        add(jbAdd);
        add(jbStock);
        add(jlbHistory);
//        add(jsp);
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
    }

    private void jbAddClick(ActionEvent e) {

        String item = jtfItem.getText();
        String unit = jtfUnit.getText();
        int qua = Integer.parseInt(jtfQua.getText());
        int price = Integer.parseInt(jtfPrice.getText());

        if (item.length() == 0) {
            JOptionPane.showMessageDialog(this, "Item name field must be filled", "Input item name", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (qua == 0 || jtfQua.getText().equals(null)) {
            JOptionPane.showMessageDialog(this, "Quantity can't be zero", "Input quantity", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (unit.length() == 0) {
            JOptionPane.showMessageDialog(this, "Unit field must be filled", "Input unit", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (price == 0 || jtfPrice.getText().equals(null)) {
            JOptionPane.showMessageDialog(this, "Price can't be zero", "Input price", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int result = JOptionPane.showConfirmDialog((Component) null, "Add " + item + "\nQuantity : " + qua + "\nPrice : " + price +"\nstock ?", "After input", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            Item i = new Item(item, qua, unit ,price);
            DataAccess data = new DataAccess();
            data.addStock(i);
            
            JOptionPane.showMessageDialog(null, "Success");
        }

    }

    private void jbStockClick(ActionEvent e){
        List<Item> listItem = new ArrayList<>();
        jbStock(listItem);
    }
    
    private void jbStock(List<Item> listItem) {
        String[] title = {"id","Item","Qua","Unit","Price"};
        Object[][] arrObj = new Object[listItem.size()][5];
          
        int i = 0;
        for(Item item : listItem){
            arrObj[i][0] = item.getId();
            arrObj[i][1] = item.getName();
            arrObj[i][2] = item.getQua();
            arrObj[i][3] = item.getUnit();
            arrObj[i][4] = item.getPrice();
            i++;
        }
        
        jtbStock = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(arrObj, title);
        jtbStock.setModel(dtm);
        jscJsc1 = new JScrollPane(jtbStock);
        jscJsc1.setBounds(350, 61, 300, 130);
        add(jscJsc1);
        
    }

    JButton jbAdd;
    JButton jbStock;

    JTextField jtfItem;
    JTextField jtfQua;
    JTextField jtfUnit;
    JTextField jtfPrice;

    JLabel jlbItem;
    JLabel jlbQua;
    JLabel jlbUnit;
    JLabel jlbPrice;
    JLabel jlbHistory;

    JTable jtbStock;
    JScrollPane jscJsc1;

    JTabbedPane jtpPn;
    JSplitPane jspPn;
}
