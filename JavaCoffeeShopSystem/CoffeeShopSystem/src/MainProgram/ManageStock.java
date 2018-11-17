/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        //Input item name
        jlbItem = new JLabel("Item name");
        jlbItem.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbItem.setBounds(8, 20, 100, 35);

        jtfItem = new JTextField();
        jtfItem.setBounds(110, 22, 200, 30);

        //Input Quantity item
        jlbQua = new JLabel("Quantity");
        jlbQua.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbQua.setBounds(20, 35, 100, 75);

        jtfQua = new JTextField("0");
        jtfQua.setBounds(110, 61, 50, 30);

        //Add item name and quantity
        jbAdd = new JButton("Add");
        jbAdd.setBounds(110, 110, 100, 30);
        jbAdd.setBackground(Color.DARK_GRAY);
        jbAdd.setForeground(Color.WHITE);

        //See added item list
        jbStock = new JButton("Stock");
        jbStock.setBounds(110, 150, 100, 30);
        jbStock.setBackground(Color.LIGHT_GRAY);
        
        
        jlbHistory = new JLabel("History");
        jlbHistory.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbHistory.setBounds(462, -1, 100, 75);
        
        
        //Test Stock Panel
        String[] colname1 = {"No.", "Item", "Quantity", "Date"};
        String[][] data1 = {{"1", "Java Bean", "20"},
        {"2", "Toraja Bean", "15"},
        {"3", "Papua Bean", "15"},
        {"3", "Papua Bean", "15"},
        {"3", "Papua Bean", "15"},
        {"3", "Papua Bean", "15"},
        {"3", "Papua Bean", "15"},
        {"3", "Papua Bean", "15"},
        {"3", "Papua Bean", "15"}
        };

        JTable jtb = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(data1, colname1);
        jtb.setModel(dtm);
        JScrollPane jsp = new JScrollPane(jtb);
        jsp.setBounds(350, 61, 300, 130);

        add(jlbItem);
        add(jtfItem);
        add(jlbQua);
        add(jtfQua);
        add(jbAdd);
        add(jbStock);
        add(jlbHistory);
        add(jsp);
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
    
    


    //Stock component
    JButton jbAdd;
    JButton jbStock;

    JTextField jtfItem;
    JTextField jtfQua;

    JLabel jlbItem;
    JLabel jlbQua;
    JLabel jlbHistory;

    JTable jtbStock;
    JScrollPane jscJsc1;

    JTabbedPane jtpPn;
    JSplitPane jspPn;
}
