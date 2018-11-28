/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.buttons;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author diego
 */
public class CustomButton extends JButton{
    
    
    
    public CustomButton() {
        
        
    }
    
    public CustomButton(String string, Icon icon,Icon icon2) {
        super(string, icon);     
        setBorder(BorderFactory.createLineBorder(new Color(0, 128, 255)));    
        //setBackground(new Color(162, 240, 205));
        setBackground(Color.WHITE);
        setFocusPainted(false);
        setFont(new Font("Yu Gothic UI Semibold",Font.ITALIC , 35));
        setForeground(new Color(0, 76, 153));
        //setForeground(Color.WHITE);
        setRolloverEnabled(true);
        setRolloverIcon(icon2);
    }

    public CustomButton(String string, Icon icon) {
        super(string, icon);     
        setBorder(BorderFactory.createLineBorder(new Color(0, 128, 255)));    
        setBackground(Color.white);
        setFocusPainted(false);
        setFont(new Font("Yu Gothic UI Semibold",Font.ITALIC , 35));
        setForeground(new Color(0, 76, 153));
        setRolloverEnabled(true);
    }

    public CustomButton(String string) {
        super(string);
    
        //setBorder(BorderFactory.createLineBorder(new Color(0, 128, 255)));
        
        setBackground(Color.white);
        //setContentAreaFilled(false);
        setFocusPainted(false);
    }
    
    
    
    
}
