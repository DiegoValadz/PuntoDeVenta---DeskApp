/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author diego
 */
public class ReciboVentaPanel extends JPanel{
    public JTextArea area;
    public JScrollPane scrollPane;

    public ReciboVentaPanel(String msg) {
        setLayout(null);
        setBounds(0,0,600,550);
        area = new JTextArea(msg);
        area.setBounds(0,0,600,550);
        scrollPane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0,0,600,550);
        add(scrollPane);

        
    }
  /*  public static void main(String[] args) {
        JFrame f = new JFrame();
       
        f.add(new ReciboVentaPanel(msg));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 500);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    */
    
}
