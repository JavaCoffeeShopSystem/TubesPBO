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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Panorama121
 */
public class ListMenu extends JPanel{
    
    
    
    public ListMenu(){
        init();
    }
    
    private static ArrayList<TblPenjualan> arr = new ArrayList<TblPenjualan>();
    
    public static TblPenjualan m = new TblPenjualan();
    
    
    public void init(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Kasir.merah);
        //label list pesan
        lblListPesan = new JLabel("List Pesan");
        lblListPesan.setAlignmentX(CENTER_ALIGNMENT);
        lblListPesan.setForeground(Kasir.biru);
        lblListPesan.setFont(new Font("Arial",Font.PLAIN,40));
        add(lblListPesan);
        
        //pnl2
        pnlBorder = new JPanel();
        pnlBorder.setLayout(new BorderLayout());
        add(pnlBorder);
        
        //pnl3
        pnlGrid = new JPanel();
        pnlGrid.setLayout(new GridLayout(0,3,15,0));
        pnlGrid.setBackground(Kasir.merah);
        pnlBorder.add(pnlGrid,BorderLayout.NORTH);
        
        //set font
        Font font = new Font("Arial",Font.PLAIN,30);
        
        //lbl nama pada list pesanan
        lblNama = new JLabel("Nama");
        lblNama.setAlignmentX(CENTER_ALIGNMENT);
        lblNama.setForeground(Kasir.biru);
        lblNama.setFont(font);
        pnlGrid.add(lblNama);
          
        //lbl qty pada list pesanan
        lblQty = new JLabel("Qty");
        lblQty.setAlignmentX(CENTER_ALIGNMENT);
        lblQty.setForeground(Kasir.biru);
        lblQty.setFont(font);
        pnlGrid.add(lblQty);
        
         //lbl harga pada list pesanan
        lblHarga = new JLabel("Harga");
        lblHarga.setAlignmentX(CENTER_ALIGNMENT);
        lblHarga.setForeground(Kasir.biru);
        lblHarga.setFont(font);
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
        tbl.setBackground(Kasir.merah);
        tbl.setRowHeight(35);
        tbl.setFont(new Font("Arial", Font.PLAIN, 20));
        pnlBorder.add(tbl);
        
        //ukuran btn
        Dimension d = new Dimension(150,75);      
        
        //label delete
        lblDelete = new JLabel("Delete");
        lblDelete.setFont(new Font("Arial",Font.PLAIN,30));
        lblDelete.setAlignmentX(CENTER_ALIGNMENT);
        lblDelete.setForeground(Kasir.merah);
        
         //btn delete order
        btnDelete = new JButton();
        btnDelete.setPreferredSize(d);
        btnDelete.add(lblDelete);
        btnDelete.setBackground(Kasir.biru);
        pnlBtn.add(btnDelete);
        
        //label Order
        lblOrder = new JLabel("Order");
        lblOrder.setFont(new Font("Arial",Font.PLAIN,30));
        lblOrder.setAlignmentX(CENTER_ALIGNMENT);
        lblOrder.setForeground(Kasir.merah);
        
        //btn order
        btnOrder = new JButton();
        btnOrder.setPreferredSize(d);
        btnOrder.add(lblOrder);
        btnOrder.setBackground(Kasir.biru);
        pnlBtn.add(btnOrder);
        
        pnlBtn.setBackground(Kasir.merah);
        
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (arr.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Belum Ada Menu yang Terpilih", "Warning!!",JOptionPane.WARNING_MESSAGE);
                }else{
                    actionBtnOrder();
                }
                
            }
        });
        
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    actionDelete();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Pilih row yang akan di hapus dahulu!!!", "Warning",JOptionPane.WARNING_MESSAGE);
                }
                
            }
        });
    }
    
    public void addRowTable(){
        //set tanggal
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Date date = new Date();
        m.setDate(dateFormat.format(date));
        
        
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
        for (TblPenjualan menu : arr) {
            new DataAccess().addPenjualan(menu);
        }
        //clear the array of TblPenjualan
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
    JLabel lblDelete;
    JLabel lblOrder;


    

    
}
