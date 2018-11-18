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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Panorama121
 */
public class List extends JPanel{
    public List(){
        init();
    }
    
    public void init(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
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
        
        //lblcat
        lblCat = new JLabel("sdfsd");
        
        //pnl4
        pnlBtn = new JPanel();
        pnlBtn.setLayout(new FlowLayout(FlowLayout.CENTER,30, 0));
        pnlBorder.add(pnlBtn,BorderLayout.PAGE_END);
        
         //btn delete order
        btnDelete = new JButton("Delete");
        btnDelete.setPreferredSize(new Dimension(150,75));
        btnDelete.setBackground(Color.green);
        pnlBtn.add(btnDelete);
        
        //btn order
        btnOrder = new JButton("Order");
        btnOrder.setBackground(Color.green);
        btnOrder.setPreferredSize(new Dimension(150,75));
        pnlBtn.add(btnOrder);
        
       
        
        
        
    }
    
    
    
 
    JButton btnOrder;
    JButton btnDelete;
    
    JPanel pnlBorder;
    JPanel pnlGrid;
    JPanel pnlBtn;
    
    JLabel lblCat;
    JLabel lblListPesan;
    JLabel lblNama;
    JLabel lblHarga;
    JLabel lblQty;
    JLabel lblCb;
}
