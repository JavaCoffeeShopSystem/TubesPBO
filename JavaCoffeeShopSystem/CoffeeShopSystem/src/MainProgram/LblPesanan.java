/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProgram;

import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Panorama121
 */
public class LblPesanan extends JLabel {
    
    String n;
    
    public LblPesanan(String nama) {
        init(nama);
                
    }
    
    private void init(String n){
        
        setAlignmentX(CENTER_ALIGNMENT);
        setFont(new Font("Arial",Font.PLAIN,30));
        setText(n);
        
    }
    
   
    
}
