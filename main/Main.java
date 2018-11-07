/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
public class Main extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    public Main(){
        initial();
    }
    
    
    
    public void initial(){
        // supaya lebih mudah mengganti ukuran 
        int widthF = 1400, heighF = 900;
        int jarakx = 25, jaraky = 300, width = 300, height = 300; //jarak adalah jarak vertikal antar button
        int listX = 1000,listY=0, listW=400,listH=900; //ukuran dan koordinat panel list 

        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        setSize(widthF,heighF);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(Color.yellow);
        setTitle("System");
        
//        getContentPane().setLayout(null);

        lblCat = new JLabel("CATEGORY");
        lblCat.setBounds(360,75,280,50);
        lblCat.setFont(new Font("Arial",Font.PLAIN,50));
        add(lblCat);

        //btn Makanan
//        lbl2 = new JLabel("Stock");
        btnMakanan = new JButton("Makanan");
        btnMakanan.setBounds(jarakx, jaraky, width, height);
        btnMakanan.setBackground(Color.red);
        add(btnMakanan);
        
        //btn Kopi
        btnKopi = new JButton("Kopi");
        btnKopi.setBounds((width+(jarakx*2)), jaraky, width, height);
        btnKopi.setBackground(Color.red);
        add(btnKopi);
        
         //btn non-Kopi
        btnNkopi = new JButton("Non-Kopi");
        btnNkopi.setBounds(((width*2)+(jarakx*3)), jaraky, width, height);
        btnNkopi.setBackground(Color.red);
        add(btnNkopi);
        
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
        lblCb.setBounds(1250, 85, 200,50);
        lblCb.setFont(new Font("Arial",Font.PLAIN,30));
        add(lblCb);
        
//        //panel list pesan
//        pnlListPesan = new JPanel();
//        pnlListPesan.setBounds(listX,listY,listW,listH);
//        pnlListPesan.setBackground(Color.orange);
////        pnlListPe san.setLayout(null);
//        add(pnlListPesan);
        
        //table
//        String data[][] = {
//            {"ayam","jagung"},
//            {"burung","cacing"}
//        };
//        
//        String judul[] = {"nama","makanan"};
//        
//        table = new JTable(data,judul);
//        table.setPreferredSize(new Dimension(50,50));
//        
//        jsp = new JScrollPane(table);
//        pnlListPesan.add(jsp);

        //action listener
        btnMakanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new SubCat();
                setVisible(false);
            }
        });
    }
    
    
    
    
    public static void main(String[] args) {
        new Main().setVisible(true);
    }


    JButton btnMakanan;
    JButton btnKopi;
    JButton btnNkopi;
    JButton btnOrder;
    JButton btnDelete;
      
    JPanel pnlListPesan;
    
//    JCheckBox as;
    
    JScrollPane jsp;
    JTable table;
            
    JLabel lblCat;
    JLabel lblListPesan;
    JLabel lblNama;
    JLabel lblHarga;
    JLabel lblQty;
    JLabel lblCb;
    
    
    
}
