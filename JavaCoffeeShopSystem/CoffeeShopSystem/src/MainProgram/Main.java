/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
        List list = new ArrayList();
        lm = new ListMenu("v","v","v","v");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setSize(1500,900);
        setLayout(new BorderLayout());
        
//        t.start();
        pnlKonten = new JPanel();
        pnlList = new JPanel();
        
        pnlKonten.setLayout(new CardLayout());
        pnlKonten.add(new KontenMenu());
        
        pnlList.setLayout(new BorderLayout());
        pnlList.add(lm);
        
        getContentPane().add(pnlKonten,BorderLayout.CENTER);
        getContentPane().add(pnlList,BorderLayout.EAST);
    }
    
    public static void main(String[] args) {
        new Main().setVisible(true);
    }


    JPanel pnlKonten;
    JPanel pnlList;
    public ListMenu lm;
    
    
    
}
