/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
public class ListMenu extends JPanel implements Runnable {
    
    
    
    public ListMenu(String nama, String harga, String qty, String cb){
        init(nama, harga, qty, cb);
    }
    
    public static ArrayList<String> arr = new ArrayList<String>();
    
    public void tambahArr(String s){
        arr.add(s);
    }
    
    public String getArr(int a){
        return arr.get(a);
    }
    
    public void init(String nama, String harga, String qty, String cb){
        
        ArrayList<String> arr = new ArrayList<String>();
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
        pnlGrid.setLayout(new GridLayout(0,4,15,0));
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
        
        //lbl cb pada list pesanan
        lblCb = new JLabel("CB");
        lblCb.setAlignmentX(CENTER_ALIGNMENT);
        lblCb.setFont(new Font("Arial",Font.PLAIN,30));
        pnlGrid.add(lblCb);
        
        //pnl4
        pnlBtn = new JPanel();
        pnlBtn.setLayout(new FlowLayout(FlowLayout.CENTER,30, 0));
        pnlBorder.add(pnlBtn,BorderLayout.PAGE_END);
        
        
        dtm.addColumn("Nama");
        dtm.addColumn("Jumlah");
        dtm.addColumn("Harga");
        dtm.addColumn("CB");
        tbl = new JTable(dtm);
        tbl.setRowHeight(35);
        tbl.setFont(new Font("Arial", Font.PLAIN, 25));
        
        pnlBorder.add(tbl);
        
        //ukuran btn
        Dimension d = new Dimension(100,50);
        
        //btn order
//        btnAdd = new JButton("Add");
//        btnAdd.setPreferredSize(d);
//        pnlBtn.add(btnAdd);
        
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
        
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(getArr(i));
        }
        
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actionBtnAdd(arr);
            }
        });
    }
    
    private void actionBtnAdd(List <String> list){
        for (int i = 0; i < list.size(); i++) {
            dtm.addRow(new Object[]{list.get(i)});
        }
    }
   
    JButton btnOrder;
    JButton btnDelete;
    JButton btnAdd;
    
    JPanel pnlBorder;
    JPanel pnlGrid;
    JPanel pnlBtn;
    JPanel pnlBt;
    
    public static JTable tbl;
    public DefaultTableModel dtm = new DefaultTableModel();
    JLabel lblListPesan;
    JLabel lblNama;
    JLabel lblHarga;
    JLabel lblQty;
    JLabel lblCb;
    JLabel lblTest;

    @Override
    public void run() {
        System.out.println("s");
        validate();
        repaint();
        dtm.addRow(new Object[]{"sdf"});
    }

    
}
