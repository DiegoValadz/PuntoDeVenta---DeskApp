/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Login;
import vista.VistaPrincipal;

/**
 *
 * @author diego
 */
public class ButtonAjustesListener implements ActionListener{
    
    private VistaPrincipal vp;

    public ButtonAjustesListener( VistaPrincipal vp) {
        this.vp = vp;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Login login = new Login(vp);
        login.ventana.setVisible(true);
                vp.ventana.setVisible(false);
                vp.ventana.dispose();
    }
    
}
