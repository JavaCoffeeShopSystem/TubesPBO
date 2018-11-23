/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import DatabaseConnection.DataAccess;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Panorama121
 */
public class ListMenu extends JPanel{
    
    
    
    public ListMenu(){
        init();
    }
    
    private static ArrayList<Menu> arr = new ArrayList<Menu>();
    
    public static Menu m = new Menu();
    
    
    public void init(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.WHITE);
        //label list pesan
        lblListPesan = new JLabel("List Pesan");
        lblListPesan.setAlignmentX(CENTER_ALIGNMENT);
        lblListPesan.setFont(new Font("Arial",Font.PLAIN,40));
        add(lblListPesan);
        
        //pnl2
        pnlBorder = new JPanel();
        pnlBorder.setLayout(new BorderLayout());
        add(pnlBorder);
        
        //pnl3
        pnlGrid = new JPanel();
        pnlGrid.setLayout(new GridLayout(0,3,15,0));
        pnlGrid.setBackground(Color.WHITE);
        pnlBorder.add(pnlGrid,BorderLayout.NORTH);
        
        //lbl nama pada list pesanan
        lblNama = new JLabel("Nama");
        lblNama.setAlignmentX(CENTER_ALIGNMENT);
        lblNama.setFont(new Font("Arial",Font.PLAIN,30));
        pnlGrid.add(lblNama);
          
        //lbl qty pada list pesanan
        lblQty = new JLabel("Qty");
        lblQty.setAlignmentX(CENTER_ALIGNMENT);
        lblQty.setFont(new Font("Arial",Font.PLAIN,30));
        pnlGrid.add(lblQty);
        
         //lbl harga pada list pesanan
        lblHarga = new JLabel("Harga");
        lblHarga.setAlignmentX(CENTER_ALIGNMENT);
        lblHarga.setFont(new Font("Arial",Font.PLAIN,30));
        pnlGrid.add(lblHarga);
        
        //pnl4
        pnlBtn = new JPanel();
        pnlBtn.setLayout(new FlowLayout(FlowLayout.CENTER,30, 0));
        pnlBorder.add(pnlBtn,BorderLayout.PAGE_END);
        
        tbl = new JTable();
        DefaultTableModel dt =(DefaultTableModel) tbl.getModel();
        dt.addColumn("Nama");
        dt.addColumn("Jumlah");
        dt.addColumn("Harga");
        
        tbl.setModel(dt);
        pnlBorder.add(tbl);
        
        //ukuran btn
        Dimension d = new Dimension(100,50);
        
         //btn delete order
        btnDelete = new JButton("Delete");
        btnDelete.setPreferredSize(d);
        btnDelete.setBackground(Color.green);
        pnlBtn.add(btnDelete);
        
        //btn order
        btnOrder = new JButton("Order");
        btnOrder.setBackground(Color.green);
        btnOrder.setPreferredSize(d);
        pnlBtn.add(btnOrder);
        
        pnlBtn.setBackground(Color.WHITE);
        
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actionBtnOrder();
            }
        });
        
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actionDelete();
            }
        });
    }
    
    public void addRowTable(){
        //set tanggal
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Date date = new Date();
        m.setDate(dateFormat.format(date));
        
        tbl.setRowHeight(35);
        tbl.setFont(new Font("Arial", Font.PLAIN, 15));
        arr.add(m);
        
        DefaultTableModel tblModel =(DefaultTableModel) tbl.getModel();
        System.out.println(arr.size());
        Object []ob = new Object[4];
        ob[0] = arr.get(arr.size()-1).getNama();
        ob[1] = arr.get(arr.size()-1).getJml();
        ob[2] = arr.get(arr.size()-1).getHarga();
        tblModel.addRow(ob);
        
    }
    
    public void clearTable(){
        DefaultTableModel tblModel =(DefaultTableModel) tbl.getModel();
        while (tblModel.getRowCount()>0) {
            tblModel.removeRow(0);
        }
    }
    
    private void actionBtnOrder(){
        
        //insert into database
        for (Menu menu : arr) {
            new DataAccess().addPenjualan(menu);
        }
        //clear the array of Menu
        arr.clear();
        
        //clear the JTable
        clearTable();
        
        
        System.out.println(arr.size());
    }
    
    private void actionDelete(){
        DefaultTableModel tblModel =(DefaultTableModel) tbl.getModel();
        int selectecRow = tbl.getSelectedRow();
        //hapus row yang di tunjuk dari arr
        arr.remove(selectecRow);
        System.out.println(arr.size());
        //hapus row yang di tunjuk
        tblModel.removeRow(selectecRow);
    }
    
  
   
    JButton btnOrder;
    JButton btnDelete;
    JButton btnAdd;
    
    JPanel pnlBorder;
    JPanel pnlGrid;
    JPanel pnlBtn;
    JPanel pnlBt;
    
    JTable tbl;
    JLabel lblListPesan;
    JLabel lblNama;
    JLabel lblHarga;
    JLabel lblQty;


    

    
}
