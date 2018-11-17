/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import DatabaseConnection.ConnectionManager;

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
        int jarakx = 25, jaraky = 100, widthB = 218, heightB = 218; //jarak adalah jarak vertikal antar button
        int listX = 1000,listY=0, listW=400,listH=900; //ukuran dan koordinat panel list 

        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        setSize(widthF,heighF);
        setLocationRelativeTo(null);
        
        setTitle("Sub-Category");
        
        setLayout(null);
        
        lblMenu = new JLabel(new Main().categori);
        lblMenu.setBounds(360,25,280,50);
        lblMenu.setFont(new Font("Arial",Font.PLAIN,50));
        add(lblMenu);
        
        Connection con = new ConnectionManager().getConnection();
        
        try {
            String categori = new Main().categori;
            String subCat = new Main().subCat;
            String sMenu;
            Statement smt = con.createStatement();
            
            if (categori == "makanan") {
                sMenu= "SELECT m.nama,m.harga,m.url FROM menu m inner join " + categori +" c on (m.id_menu = c.id_menu) ";
            }else{
                 sMenu= "SELECT m.nama,m.harga,m.url "
                         + "FROM menu m inner join " + categori +" c on (m.id_menu = c.id_menu) where c.category = '"+ subCat + "'";
                 
            }
            
            ResultSet rs = smt.executeQuery(sMenu);
            
            //cek brp banyak record di temuakan
            int rowFound = 0;
            if (rs.last()) {// geser ke rocrd terakir
                rowFound = rs.getRow();
            }
            
            System.out.println("jumlah row: " + rowFound);
            System.out.println("");
            
            //geser ke posisi before of resoult
            rs.beforeFirst();
            
            int i =1 ;
            while(rs.next()) {
                
                String nama = rs.getString(1);
                String url = rs.getString(3);
                System.out.println(nama);
                
                int x = jarakx + ((jarakx+ widthB)*(i-1));
                if (i == 5) {
                    i=-4;
                    jaraky=+ jaraky;
                }
                System.out.println(i);
                add(new Makanan(x, jaraky,widthB, heightB, nama ,url)).addMouseListener(new MouseListener() {
                
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        System.out.println("makanan");
                    }

                    @Override
                    public void mousePressed(MouseEvent me) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent me) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent me) {
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                    }

                });
                i++;

        }
            
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        
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
        
        pnlListPesan = new JPanel();
        pnlListPesan.setBounds(listX,listY,listW,listH);
        pnlListPesan.setBackground(Color.orange);
        add(pnlListPesan);     
        
        btnBack = new JButton("Back");
        btnBack.setBounds(0,780,150,75);
        btnBack.setBackground(Color.green);
        add(btnBack);
   
        //action listener btnBack
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Main().setVisible(true);
                setVisible(false);
            }
        });
        
        
        
    }

    JButton btnOrder;
    JButton btnDelete;
    JButton btnBack;
      
    JPanel pnlListPesan;
    JPanel pnl1;
    
//    JCheckBox as;

    JLabel lblMenu;
    JLabel lblListPesan;
    JLabel lblNama;
    JLabel lblHarga;
    JLabel lblQty;
    JLabel lblCb;
    JLabel lblRoti;
    
}
