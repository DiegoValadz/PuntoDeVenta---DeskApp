/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ButtonsProductosListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import vista.paneles.ModifiProdPanel;

/**
 *
 * @author diego
 */
public class ModificarProductosFrame{
    public JFrame ventana;
    public ModifiProdPanel p;
    private ButtonsProductosListener bpl;

    public ModificarProductosFrame(ModifiProdPanel p) {   
        this.p = p;
        //Frame
        ventana = new JFrame("Agregar nuevo producto");
        ventana.add(p);
        addComponents();
        launchFrame();
    }
    
    private void addComponents() {
        
    }

    public void launchFrame() {
        ventana.setSize(700, 550);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

}
