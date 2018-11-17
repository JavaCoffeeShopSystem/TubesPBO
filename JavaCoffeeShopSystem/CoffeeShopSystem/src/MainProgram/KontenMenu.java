/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

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
/**
 *
 * @author Panorama121
 */
public class KontenMenu extends JPanel{
    
    public KontenMenu(){
        init();
    }
    
    private void init(){
        int widthF = 1400, heighF = 900; //ukuran frame
        int jarakx = 25, jaraky = 300, width = 300, height = 300; //jarak adalah jarak vertikal antar button
        int listX = 1000,listY=0, listW=400,listH=900; //ukuran dan koordinat panel list
        
        setLayout(null);
        //set lebel
        lblCat = new JLabel("CATEGORY");
        lblCat.setBounds(360,75,280,50);
        lblCat.setFont(new Font("Arial",Font.PLAIN,50));
        add(lblCat);

        //btn Makanan
        btnMakanan = new JButton("asd", new ImageIcon(resizeImage("img\\food-icon.png", width,height)));
        btnMakanan.setBounds(jarakx, jaraky, width, height);
        btnMakanan.setBackground(Color.RED);
        add(btnMakanan);
        
        //btn Kopi
        btnKopi = new JButton(new ImageIcon(resizeImage("img\\coffee-flat.png", width, height)));
        btnKopi.setBounds((width+(jarakx*2)), jaraky, width, height);
        btnKopi.setBackground(Color.red);
        add(btnKopi);
        
         //btn non-Kopi
        btnNkopi = new JButton(new ImageIcon(resizeImage("img\\non-coffee.png", width, height)));
        btnNkopi.setBounds(((width*2)+(jarakx*3)), jaraky, width, height);
        btnNkopi.setBackground(Color.red);
        add(btnNkopi);
        
        //action listener btnMakanan
        btnMakanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Main().subCat = "MAKANAN";
                new SubCat();
                setVisible(false);
            }
        });
        
        //action listener btnKopi
         btnKopi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Main().subCat = "KOPI";
                new SubCat();
                setVisible(false);
            }
        });
         
        //action listener btnNkopi
         btnNkopi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Main().subCat = "NON-KOPI";
                new SubCat();
                setVisible(false);
                
            }
        });
        
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
    JButton btnOrder;
    JButton btnDelete;
      
    JPanel pnlListPesan;
    JPanel pnlKonten;
    
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
