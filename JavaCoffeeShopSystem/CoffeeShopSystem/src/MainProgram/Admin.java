/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

/**
 *
 * @author Andre Darsono
 */


public class Admin extends JFrame {

    public Admin() {
        initComponent();
    }

    private void initComponent() {
        ImageIcon img = new ImageIcon("img/admin.png");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setIconImage(img.getImage());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        setTitle("Admin");

        //Split Pane Admin Menu
        JSplitPane jspPn = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new ManageStock(), new ManageMenu());
        jspPn.setContinuousLayout(true);
        jspPn.setOneTouchExpandable(true);
        jspPn.setDividerLocation(800);

        jspPn.setDividerSize(13);
        getContentPane().add(jspPn);
    }

    public static void main(String[] args) {

        new Admin().setVisible(true);

    }

}
