/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import DatabaseConnection.DataAccess;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Ronaldo
 */
public class Login extends JFrame {

    public Login() {
        initComponent();
        setupAction();
    }

    private void initComponent() {

        ImageIcon img = new ImageIcon("img/admin.png");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(img.getImage());
        setTitle("Login");
        setSize(350, 270);
        setLocationRelativeTo(null);

        JPanel jpLogin = new JPanel();
        jpLogin.setLayout(null);

        jlbUname = new JLabel("Username");
        jlbUname.setFont(new Font("SansSerif", Font.BOLD, 15));
        jlbUname.setForeground(Color.LIGHT_GRAY);
        jlbUname.setBounds(25, 50, 100, 30);

        jtfUname = new JTextField(20);
        jtfUname.setBounds(130, 50, 150, 30);

        jlbPass = new JLabel("Password");
        jlbPass.setFont(new Font("SansSerif", Font.BOLD, 15));
        jlbPass.setForeground(Color.LIGHT_GRAY);
        jlbPass.setBounds(25, 90, 150, 30);
        jtfPass = new JPasswordField(20);
        jtfPass.setBounds(130, 90, 150, 30);

        jbLogin = new JButton("Login");
        jbLogin.setBounds(130, 140, 100, 30);
        jbLogin.setOpaque(true);
        jbLogin.setBackground(Color.LIGHT_GRAY);

        ImageIcon background = new ImageIcon("img\\login.jpg");
        Image img2 = background.getImage();
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 350, 270);

        jpLogin.add(jlbUname);
        jpLogin.add(jlbPass);
        jpLogin.add(jtfUname);
        jpLogin.add(jtfPass);
        jpLogin.add(jbLogin);
        jpLogin.add(back);

        add(jpLogin);
        setVisible(true);
    }

    private void setupAction() {
        jbLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  String uname = jtfUname.getText();
                String pass = new String (jtfPass.getPassword());
                
                AdminUser a = DataAccess.login(uname, pass);
                if(a == null){
                    JOptionPane.showMessageDialog(null, "Username tidak ada ! \n Password salah");
                }else{
                    setVisible(false);
                    new Admin().setVisible(true);
                }

            }

        });
    }

    public static void main(String[] args) {
        new Login();
    }

    JTextField jtfUname;
    JPasswordField jtfPass;
    JLabel jlbUname;
    JLabel jlbPass;
    JButton jbLogin;

}
