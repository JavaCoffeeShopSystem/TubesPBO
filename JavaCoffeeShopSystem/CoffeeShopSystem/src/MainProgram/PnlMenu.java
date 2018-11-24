/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Panorama121
 */
public class PnlMenu extends JPanel{
    
    public PnlMenu(String k, String sk){
        init(k,sk);
    }
    
    private void init(String k, String sk){
        setLayout(new CardLayout());
        
        pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout());
        add(pnlMain);
        
        lblGambar = new JLabel(new ImageIcon(ListMenu.m.getUrl()));
        pnlMain.add(lblGambar,BorderLayout.CENTER);
        
        pnlBorderS = new JPanel();
        
        pnlBorderS.setLayout(new BorderLayout());
        
        pnlBorderW = new JPanel();
        pnlBorderW.setLayout(new FlowLayout());
        
        //lbl back
        lblBack = new JLabel("Back");
        lblBack.setForeground(Main.biru);
        lblBack.setAlignmentX(CENTER_ALIGNMENT);
        lblBack.setFont(new Font("Arial", Font.PLAIN, 30));
        
        btnBack = new JButton();
        btnBack.setPreferredSize(new Dimension(150,75));
        btnBack.add(lblBack);
        btnBack.setBackground(Main.merah);
        pnlBorderW.add(btnBack);
        pnlBorderS.add(pnlBorderW,BorderLayout.WEST);
        
        pnlBorderC = new JPanel();
        pnlBorderC.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
        txtJml = new JTextField(2);
        txtJml.setFont(new Font("Arial", Font.PLAIN, 30));
        txtJml.setHorizontalAlignment(JTextField.CENTER);
        pnlBorderC.add(txtJml);
        
        lblOk = new JLabel("OK");
        lblOk.setAlignmentX(CENTER_ALIGNMENT);
        lblOk.setFont(new Font("Arial",Font.PLAIN,20));
        lblOk.setForeground(Main.biru);
        
        btnOK = new JButton();
        btnOK.setPreferredSize(new Dimension(65,65));
        btnOK.add(lblOk);
        btnOK.setBackground(Main.merah);
        
        pnlBorderC.add(btnOK);
        pnlBorderS.add(pnlBorderC,BorderLayout.CENTER);
        pnlMain.add(pnlBorderS,BorderLayout.SOUTH);
        
        pnlBorderC.setBackground(Main.biru);
        pnlBorderS.setBackground(Main.biru);
        pnlBorderW.setBackground(Main.biru);
        pnlMain.setBackground(Main.biru);

        
        //action listener btnBack
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actionBtnBack(k,sk);
            }
        });
        
        btnOK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try {
                    actionBtnOK();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Kolom kosong!!\natau Pastikan input adalh angka!! ");
                }
                
                
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
    
    private void actionBtnOK(){
        ListMenu l = Main.getListMenu(); // ambil listmenu yg diciptakan pertama kali  
        int jml = Integer.parseInt(txtJml.getText());
        l.m.setJml(jml);
        l.addRowTable();
        //ke panel KontenMenu
        CardLayout cl  = (CardLayout) this.getLayout(); ;
        KontenMenu km = new KontenMenu();
        this.add(km,"km");
        cl.addLayoutComponent(km, "km");
        
        cl.show(this, "km");
        
    }
    
    JButton btnOK;
    JButton btnBack;

    JTextField txtJml;
    
    JLabel lblGambar;
    JLabel lblOk;
    JLabel lblBack;
    
    JPanel pnlMain;
    JPanel pnlBorderS;
    JPanel pnlBorderW;
    JPanel pnlBorderC;
}
