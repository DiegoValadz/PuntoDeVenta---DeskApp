/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author diego
 */
public class CustomTitleBar extends JPanel{

    public CustomTitleBar() {
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.gray));
        setBounds(0, 0, 1300, 25);

    }
    
}
