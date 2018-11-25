/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package MainProgram;

import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Ronaldo
 */
public class Login extends JFrame{
    
    public Login(){
        initComponent();
    }
    
    private void initComponent(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(300,300);
        setLocationRelativeTo(null);
        
        jtfUname = new JTextField();
        jtfPass = new JTextField();
        jlbUname = new JLabel();
        
        setVisible(true);
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
