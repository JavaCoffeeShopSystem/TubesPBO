/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Panorama121
 */
public class Menu extends JPanel{

    public Menu(String url){
        init(url);
        
    }
    
    private void init(String url){
        setLayout(new BorderLayout());
        
        lblGambar = new JLabel(new ImageIcon(url));
        lblGambar.setBounds(250,250,500,500);
        add(lblGambar,BorderLayout.CENTER);
        
        pnlBorderS = new JPanel();
        pnlBorderS.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
        txtJml = new JTextField(2);
        txtJml.setFont(new Font("Arial", Font.PLAIN, 30));
        txtJml.setHorizontalAlignment(JTextField.CENTER);
        pnlBorderS.add(txtJml);
        
        btnOK = new JButton("OK");
        btnOK.setPreferredSize(new Dimension(55,55));
        pnlBorderS.add(btnOK);
        add(pnlBorderS,BorderLayout.SOUTH);
        
    }
    
    public static void main(String[] args) {
        new Menu("d").setVisible(true);
    }
    
    JButton btnOK;
    JTextField txtJml;
    JLabel lblGambar;
    JPanel pnlBorderS;
}
