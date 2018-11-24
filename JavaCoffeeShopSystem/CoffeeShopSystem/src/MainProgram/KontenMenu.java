/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import DatabaseConnection.ConnectionManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import MainProgram.Main;
import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Panorama121
 */
public class KontenMenu extends JPanel {
    
    SubCat sc;
    CardLayout cl = new CardLayout();
    private boolean tambah;
    
    public KontenMenu(){
        init();
    }
    
    private void init(){
        
        pnlCard = new JPanel();
        pnlKategori = new JPanel();
        pnlSubKategori = new JPanel();
        
        int widthF = 1400, heighF = 900; //ukuran frame
        int jarakx = 25, jaraky = 300, width = 300, height = 300; //jarak adalah jarak vertikal antar button
        int widthB = 218, heightB = 218; //jarak adalah jarak vertikal antar button di pnlSubKategori
        int listX = 1000,listY=0, listW=400,listH=900; //ukuran dan koordinat panel list
        
        setLayout(cl);
        
        pnlKategori.setBackground(Color.white);
        pnlKategori.setLayout(null);
        add(pnlKategori,"kat");
        cl.show(this, "kat");
        
        //set warna panel kategori
        pnlKategori.setBackground(Main.biru);
        
        //set lebel
        lblCat = new JLabel("CATEGORY");
        lblCat.setBounds(360,75,280,50);
        lblCat.setForeground(Main.merah);
        lblCat.setFont(new Font("Arial",Font.PLAIN,50));
        pnlKategori.add(lblCat);

        //btn Makanan
        btnMakanan = new JButton("asd", new ImageIcon(resizeImage("img\\food-icon.png", width,height)));
        btnMakanan.setBounds(jarakx, jaraky, width, height);
        btnMakanan.setBackground(Main.merah);
        pnlKategori.add(btnMakanan);
        
        //btn Kopi
        btnKopi = new JButton(new ImageIcon(resizeImage("img\\coffee-flat.png", width, height)));
        btnKopi.setBounds((width+(jarakx*2)), jaraky, width, height);
        btnKopi.setBackground(Main.merah);
        pnlKategori.add(btnKopi);
        
         //btn non-Kopi
        btnNkopi = new JButton(new ImageIcon(resizeImage("img\\non-coffee.png", width, height)));
        btnNkopi.setBounds(((width*2)+(jarakx*3)), jaraky, width, height);
        btnNkopi.setBackground(Main.merah);
        pnlKategori.add(btnNkopi);
   
        
        
        //action listener btnMakanan
        
        btnMakanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actionBtnMakan();                
            }
            
        });
        
        
        //action listener btnKopi
         btnKopi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actionBtnKopi();
            }
        });
         
        //action listener btnNkopi
         btnNkopi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actionBtnNKopi();
            }
        });     
        
    }
    
    private void actionBtnMakan(){
        if (sc == null) {
            sc = new SubCat("Makanan","");
            this.add(sc,"sc");
            cl.addLayoutComponent(sc, "sc");
            
        }
        
        cl.show(this, "sc");
    }
    
    private void actionBtnKopi(){
        if (sc == null) {
            sc = new SubCat("Minuman","kopi");
            this.add(sc,"sc");
            cl.addLayoutComponent(sc, "sc");
        }
        
        cl.show(this, "sc");
    }
    
    private void actionBtnNKopi(){
        if (sc == null) {
            sc = new SubCat("Minuman","non-kopi");
            this.add(sc,"sc");
            cl.addLayoutComponent(sc, "sc");
        }
        
        cl.show(this, "sc");
    }
    
    private Image resizeImage(String url, int w, int h){
        Image dimg = null;
            
            try {
                BufferedImage img = ImageIO.read(new File(url));
                dimg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        
        return dimg;
    };
    
    
    
    JButton btnMakanan;
    JButton btnKopi;
    JButton btnNkopi;
    JButton btnBack;
      
    JPanel pnlKategori;
    JPanel pnlSubKategori;
    JPanel pnlCard;
    
    
//    JCheckBox as;

    JLabel lblCat;
    JLabel lblMenu;

    
}
