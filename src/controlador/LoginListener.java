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
public class LoginListener implements ActionListener{
    
    private Login login;
    private VistaPrincipal vp;

    public LoginListener(Login login, VistaPrincipal vp) {
        this.login = login;
        this.vp = vp;
    }

    public LoginListener(Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == login.aceptar){
           
           login.ventana.setVisible(false);
           vp.ventana.setVisible(true);
           login.ventana.dispose();
       }
    }
    
}
