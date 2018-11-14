/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Panorama121
 */
public class Makanan extends JButton{
    
    private String nama;
    private int harga;
    private String pictUrl;
    
    public Makanan(int x,int y ,int w, int h, String nama, String url){
        setText(nama);
        setBounds(x, y, 225, 225);
        setBackground(Color.yellow);
        
        try {
            setIcon( new ImageIcon(resizeImage(url, 300, 300)));
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        
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
    
    
   
}
