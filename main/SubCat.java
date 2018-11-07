/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

/**
 *
 * @author Panorama121
 */
public class SubCat extends JFrame {
    
    public SubCat(){
        setVisible(true);
        initial();
    }
    
    public void initial(){
        // supaya lebih mudah mengganti ukuran 
        int widthF = 1400, heighF = 900;
        int jarakx = 25, jaraky = 300, width = 300, height = 300; //jarak adalah jarak vertikal antar button
        int listX = 1000,listY=0, listW=400,listH=900; //ukuran dan koordinat panel list 

        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        setSize(widthF,heighF);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(Color.yellow);
        setTitle("Subcar");
        
//        setLayout(null);
        
        lblMenu = new JLabel("Menu");
        lblMenu.setBounds(360,75,280,50);
        lblMenu.setFont(new Font("Arial",Font.PLAIN,50));
        add(lblMenu);
        
        

        lblRoti = new JLabel("Roti");
        lblRoti.setBounds(50, 150, 200, 35);
        lblRoti.setFont(new Font("arial", Font.PLAIN, 35));
        add(lblRoti);
        
        btnRoti1 = new JButton("Roti 1");
        btnRoti1.setBounds(50, 200, 250, 250);
        btnRoti1.setBackground(Color.red);
        add(btnRoti1);
        
        btnRoti2 = new JButton("Roti 2");
        btnRoti2.setBounds(350, 200, 250, 250);
        btnRoti2.setBackground(Color.red);
        add(btnRoti2);
        
        //label list pesan
        lblListPesan = new JLabel("List Pesan");
        lblListPesan.setBounds(1100, 40, 200,50);
        lblListPesan.setFont(new Font("Arial",Font.PLAIN,40));
        add(lblListPesan);
        
        //btn order
        btnOrder = new JButton("Order");
        btnOrder.setBounds(1235,780,150,75);
        btnOrder.setBackground(Color.green);
        add(btnOrder);
        
        //btn delete order
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(1050,780,150,75);
        btnDelete.setBackground(Color.green);
        add(btnDelete);
        
        //lbl nama pada list pesanan
        lblNama = new JLabel("Nama");
        lblNama.setBounds(1000, 85, 200,50);
        lblNama.setFont(new Font("Arial",Font.PLAIN,30));
        add(lblNama);
        
        //lbl qty pada list pesanan
        lblQty = new JLabel("Qty");
        lblQty.setBounds(1100, 85, 200,50);
        lblQty.setFont(new Font("Arial",Font.PLAIN,30));
        add(lblQty);
        
         //lbl harga pada list pesanan
        lblHarga = new JLabel("Harga");
        lblHarga.setBounds(1175, 85, 200,50);
        lblHarga.setFont(new Font("Arial",Font.PLAIN,30));
        add(lblHarga);
        
        //lbl cb pada list pesanan
        lblCb = new JLabel("CB");
        lblCb.setBounds(1300, 85, 200,50);
        lblCb.setFont(new Font("Arial",Font.PLAIN,30));
        add(lblCb);
        
//         pnlListPesan = new JPanel();
//        pnlListPesan.setBounds(listX,listY,listW,listH);
//        pnlListPesan.setBackground(Color.orange);
////        pnlListPesan.setLayout(null);
//        add(pnlListPesan);
//        
        
        
        
    }
    public static void main(String[] args) {
        new SubCat().setVisible(true);
    }

    
    JButton btnRoti1;
    JButton btnRoti2;
    JButton btnOrder;
    JButton btnDelete;
      
    JPanel pnlListPesan;
    JPanel pnl1;
    
//    JCheckBox as;
    
    JTable tblList;
    
    JScrollPane jspList;
    
    JLabel lblMenu;
    JLabel lblListPesan;
    JLabel lblNama;
    JLabel lblHarga;
    JLabel lblQty;
    JLabel lblCb;
    JLabel lblRoti;
    
}
