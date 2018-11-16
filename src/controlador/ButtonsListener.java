/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Login;
import vista.ProductosPanel;
import vista.VistaPrincipal;

/**
 *
 * @author diego
 */
public class ButtonsListener implements ActionListener{
    
    private VistaPrincipal vp;

    public ButtonsListener(VistaPrincipal vp) {
        this.vp = vp;
    }
    
 
    
            
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == vp.btn1){
           
            vp.ventana.remove(vp.centerPanel);

            vp.centerPanel = new ProductosPanel(0, 0, 1300, 900,null);
           vp.ventana.add(vp.centerPanel);
           vp.ventana.repaint();
       }
     
       
    }

    
}
