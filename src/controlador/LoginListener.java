/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.ws.rs.core.Response;
import modelo.Usuario;
import utilities.Utilities;
import service.LoginCliente;
import service.ServiceException;
import vista.Login;
import vista.VistaPrincipal;

/**
 *
 * @author diego
 */
public class LoginListener implements ActionListener {

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

        /*    if (ae.getSource() == login.vendeOp) {
            Utilities.usuarioActual.setTipo(Utilities.VEND);
        }else if (ae.getSource() == login.adminOp) {
            Utilities.usuarioActual.setTipo(Utilities.ADMIN);*/
        if (ae.getSource() == login.aceptar) {
            LoginCliente cliente = new LoginCliente("login");
            try {
                System.out.println(login.userTxt.getText());
                System.out.println(login.passTxt.getText());
                Usuario aux = new Usuario();
                aux.setUsuario(login.userTxt.getText());
                aux.setContraseña(login.passTxt.getText());
                if (login.adminOp.isSelected()) {
                    aux.setTipo(Utilities.ADMIN);
                }
                if (login.vendeOp.isSelected()) {
                    aux.setTipo(Utilities.VEND);
                }
                Utilities.usuarioActual = aux;

                aux = cliente.Login(aux);
            } catch (ServiceException ex) {
                Logger.getLogger(LoginListener.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (cliente.responseGlobal.getStatus() == Response.Status.OK.getStatusCode()) {

                login.ventana.setVisible(false);
                vp.ventana.setVisible(true);
                login.ventana.dispose();
                vp.validarFunciones(Utilities.usuarioActual.getTipo());

            } else {
                JOptionPane.showMessageDialog(login.ventana, "Usuario o Contraseña incorrectos");
            }
        }
    }

}
