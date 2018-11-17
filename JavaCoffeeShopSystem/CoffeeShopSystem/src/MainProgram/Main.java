/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
    
    public static String subCat;
    public static String categori;
    
    public void initial(){
        
        setSize(1400,900);
        setLayout(new BorderLayout());
        
        pnlKonten = new JPanel();
        pnlList = new JPanel();
        
        pnlKonten.setLayout(new CardLayout());
        pnlKonten.add(new KontenMenu());
        
        pnlList.setLayout(new CardLayout());
        pnlList.add(new List());
        
        getContentPane().add(pnlKonten,BorderLayout.CENTER);
        getContentPane().add(pnlList,BorderLayout.EAST);
    }
    
    
    
    
    
    public static void main(String[] args) {
        new Main().setVisible(true);
    }


    JPanel pnlKonten;
    JPanel pnlList;
    
    
    
}
