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
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 *
 * @author Panorama121
 */
public class ListMenu extends JPanel {
    
    
    public ListMenu(String nama, String harga, String qty, String cb){
        init(nama, harga, qty, cb);
    }
    
    private String nama;
    private String harga;
    private String cb;
    private String qty;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
    
     ArrayList<JComponent> arr = new ArrayList<JComponent>();
   
    public void init(String nama, String harga, String qty, String cb){
        
        ArrayList<JComponent> arr = new ArrayList<JComponent>();
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
        
        String [] judul = {"Nama", "Jumlah", "Haga" , "CB" };
        String [][] isi = {};
        tbl = new JTable(isi,judul);
        tbl.setPreferredSize(new Dimension(200, 200));
        
        pnlBorder.add(tbl);
        
        //ukuran btn
        Dimension d = new Dimension(100,50);
        
        //btn order
        btnAdd = new JButton("Add");
        btnAdd.setPreferredSize(d);
        pnlBtn.add(btnAdd);
        
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
        
        
        
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                  actionBtnAdd();
                
                
            }
        });
    }
    
//    private void actionBtnAdd(){
//        arr.add(new LblPesanan(nama));
//        arr.add(new LblPesanan(qty));
//        arr.add(new LblPesanan(harga));
//        arr.add(new LblPesanan(cb));
//        for (JComponent e : arr) {
//            pnlGrid.add(e);
//        }
//        validate();
//        repaint();
//    }
    
   
    
   
   
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
    JLabel lblCb;
    JLabel lblTest;

    
}
