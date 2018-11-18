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
import java.awt.CardLayout;

/**
 *
 * @author Panorama121
 */
public class SubCat extends JPanel {
    
    public SubCat(String kategori, String subKategori){
        setVisible(true);
        initial(kategori, subKategori);
    }
    
    public void initial(String k, String sk){
        CardLayout cl = new CardLayout();
        pnlNull = new JPanel();
        // supaya lebih mudah mengganti ukuran 
        int widthF = 1400, heighF = 900;
        int jarakx = 25, jaraky = 100, widthB = 218, heightB = 218; //jarak adalah jarak vertikal antar button
        int listX = 1000,listY=0, listW=400,listH=900; //ukuran dan koordinat panel list 

        setSize(widthF,heighF);
        
        setLayout(cl);
        
        pnlNull.setLayout(null);
        add(pnlNull,"sc");
        cl.show(this, "sc");
        
        lblMenu = new JLabel(k);
        lblMenu.setBounds(360,25,280,50);
        lblMenu.setFont(new Font("Arial",Font.PLAIN,50));
        pnlNull.add(lblMenu);
        
        Connection con = new ConnectionManager().getConnection();
        
        try {
            String categori = k;
            String subCat = sk;
            String sMenu;
            Statement smt = con.createStatement();
            
            if (categori == "makanan") {
                sMenu= "SELECT m.nama,m.harga,m.url FROM menu m inner join " + categori +" c on (m.id_menu = c.id_menu) ";
            }else{
                 sMenu= "SELECT m.nama,m.harga,m.url "
                         + "FROM menu m inner join " + categori +" c on (m.id_menu = c.id_menu) where c.category = '"+ subCat + "'";
                 
            }
            System.out.println(sMenu);
            
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
                
                if (i == 5) {
                    i-=4;
                    jaraky+= (50 + heightB);
                }
                int x = jarakx + ((jarakx+ widthB)*(i-1));
                System.out.println(i);
                pnlNull.add(new Makanan(x, jaraky,widthB, heightB, nama ,url)).addMouseListener(new MouseListener() {
                
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        actionMenu(url);
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
         
        
        btnBack = new JButton("Back");
        btnBack.setBounds(0,780,150,75);
        btnBack.setBackground(Color.green);
        pnlNull.add(btnBack);
   
        //action listener btnBack
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Main().setVisible(true);
                new Main().setVisible(false);
            }
        });
        
        
        
    }
    
    private void actionMenu(String url){
        CardLayout cl  = (CardLayout) this.getLayout(); ;
        Menu m = new Menu(url);
        this.add(m,"m");
        cl.addLayoutComponent(m, "m");
        
        cl.show(this, "m");
    }
    
    
    
    KontenMenu km;

    JButton btnOrder;
    JButton btnDelete;
    JButton btnBack;
    
    JPanel pnlNull;
    
//    JCheckBox as;

    JLabel lblMenu;
    
    
}
