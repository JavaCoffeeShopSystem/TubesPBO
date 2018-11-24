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
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Panorama121
 */
public class Kasir extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    public Kasir(){
        initial();
    }
    
    public static Color merah = new Color(242,125,132);
    public static Color biru = new Color(99, 136, 193);
        
    private static ListMenu lm = new ListMenu();
    
    public static ListMenu getListMenu () {
        return lm;
    }
    public void initial(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1600,900);
        setLayout(new BorderLayout());
        
        
//        t.start();
        pnlKonten = new JPanel();
        pnlList = new JPanel();
        
        pnlKonten.setLayout(new CardLayout());
        pnlKonten.add(new KontenMenu());
        
        pnlList.setLayout(new BorderLayout());
        Dimension d = new Dimension(400, 900);
        pnlList.setPreferredSize(d);
        pnlList.add(lm);
        
        getContentPane().add(pnlKonten,BorderLayout.CENTER);
        getContentPane().add(pnlList,BorderLayout.EAST);
    }
    
    public static void main(String[] args) {
        new Kasir().setVisible(true);
    }


    JPanel pnlKonten;
    JPanel pnlList;
    
    
    
}
