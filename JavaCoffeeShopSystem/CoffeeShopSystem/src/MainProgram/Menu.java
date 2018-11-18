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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public Menu(String url,String k, String sk){
        init(url,k,sk);
        
    }
    
    private void init(String url,String k, String sk){
        setLayout(new CardLayout());
        
        pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout());
        add(pnlMain);
        
        lblGambar = new JLabel(new ImageIcon(url));
        pnlMain.add(lblGambar,BorderLayout.CENTER);
        
        pnlBorderS = new JPanel();
        pnlBorderS.setLayout(new BorderLayout());
        
        pnlBorderW = new JPanel();
        pnlBorderW.setLayout(new FlowLayout());
        btnBack = new JButton("Back");
        btnBack.setPreferredSize(new Dimension(80,50));
        pnlBorderW.add(btnBack);
        pnlBorderS.add(pnlBorderW,BorderLayout.WEST);
        
        pnlBorderC = new JPanel();
        pnlBorderC.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
        txtJml = new JTextField(2);
        txtJml.setFont(new Font("Arial", Font.PLAIN, 30));
        txtJml.setHorizontalAlignment(JTextField.CENTER);
        pnlBorderC.add(txtJml);
        
        btnOK = new JButton("OK");
        btnOK.setPreferredSize(new Dimension(55,55));
        pnlBorderC.add(btnOK);
        pnlBorderS.add(pnlBorderC,BorderLayout.CENTER);
        
        pnlMain.add(pnlBorderS,BorderLayout.SOUTH);
        
        
        
        //action listener btnBack
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actionBtnBack(k,sk);
            }
        });
        
    }
    
    private void actionBtnBack(String k, String sk){
        CardLayout cl  = (CardLayout) this.getLayout(); ;
        SubCat sc = new SubCat(k,sk);
        this.add(sc,"sc");
        cl.addLayoutComponent(sc, "sc");
        
        cl.show(this, "sc");
    }
    
    JButton btnOK;
    JTextField txtJml;
    JLabel lblGambar;
    JPanel pnlMain;
    JPanel pnlBorderS;
    JPanel pnlBorderW;
    JPanel pnlBorderC;
    JButton btnBack;
}
