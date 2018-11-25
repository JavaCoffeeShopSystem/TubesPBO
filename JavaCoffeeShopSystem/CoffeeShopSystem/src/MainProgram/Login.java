/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package MainProgram;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Ronaldo
 */
public class Login extends JFrame{
    
    public Login(){
        initComponent();
        //setupAction();
    }
    
    private void initComponent(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(350,300);
        setLocationRelativeTo(null);
        
        JPanel jpLogin = new JPanel();
        jpLogin.setLayout(null);
        
        jlbUname = new JLabel("Username");
        jlbUname.setFont(new Font("SansSerif", Font.PLAIN, 15));
        jlbUname.setBounds(10, 50, 100, 30);
        
        jtfUname = new JTextField(20);
        jtfUname.setBounds(130, 50, 150, 30);
        
        jlbPass = new JLabel();
        
        jtfPass = new JTextField(20);
        jtfPass.setBounds(130, 90, 150, 30);
        
        jlbLogin = new JLabel("            Login");
        jlbLogin.setBounds(130, 140, 100, 30);
        jlbLogin.setOpaque(true);
        jlbLogin.setBackground(Color.LIGHT_GRAY);
        
        jpLogin.add(jlbUname);
        jpLogin.add(jlbPass);
        jpLogin.add(jtfUname);
        jpLogin.add(jtfPass);
        jpLogin.add(jlbLogin);
        
        add(jpLogin);
        setVisible(true);
    }
    
    private void setupAction(){
        jlbLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                
            }
            
        });
    }
    
    
    public static void main(String[] args) {
        new Login();
    }
    
    JTextField jtfUname;
    JTextField jtfPass;
    JLabel jlbUname;
    JLabel jlbPass;
    JLabel jlbLogin;
    
    
}
