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
import modelo.Producto;
import modelo.Usuario;
import org.codehaus.jettison.json.JSONException;
import service.ProductosCliente;
import service.ServiceException;
import service.UsuariosCliente;
import vista.paneles.ModifiUserPanel;

/**
 *
 * @author diego
 */
public class ButtonWinUserListener implements ActionListener {

    ModifiUserPanel mup;

    public ButtonWinUserListener(ModifiUserPanel mup) {
        this.mup = mup;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Usuario user = new Usuario();
        if (ae.getSource() == mup.userbtn) {

            try {
                user._id = mup.idtxt.getText();
                user.setNombre(mup.nombretxt.getText());
                user.setUsuario(mup.usuariotxt.getText());
                user.setContraseña(mup.passtxt.getText());
                user.setTipo(mup.tiposList.getSelectedItem().toString());
                user.setDireccion(mup.direcctxt.getText());
                user.setCiudad(mup.ciudadtxt.getText());
                user.setEstado(mup.estadotxt.getText());
                user.setCp(mup.cptxt.getText());
                user.setTelefono(mup.teltxt.getText());

                UsuariosCliente client = new UsuariosCliente("usuarios");
                client.postUsuarios(user);
                JOptionPane.showMessageDialog(mup, "Uusario agegado correctamente");

            } catch (NullPointerException | IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(mup, "Debes llenar todos los campos");
            } catch (ServiceException | JSONException ex) {
                Logger.getLogger(ButtonsProductosListener.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mup, "Ha ocurrido un error, intenta nuevamente");
            }

        } else if (ae.getSource() == mup.userbtn2) {
            try {
                user.setNombre(mup.nombretxt.getText());
                user.setUsuario(mup.usuariotxt.getText());

                if (mup.passtxt.getText() != null) {

                    user.setContraseña(mup.passtxt.getText());
                }
                user.setTipo(mup.tiposList.getSelectedItem().toString());
                user.setDireccion(mup.direcctxt.getText());
                user.setCiudad(mup.ciudadtxt.getText());
                user.setEstado(mup.estadotxt.getText());
                user.setCp(mup.cptxt.getText());
                user.setTelefono(mup.teltxt.getText());
                user.setEmail(mup.emailtxt.getText());


                UsuariosCliente client = new UsuariosCliente("usuarios");
                client.putUsuarios(user, mup.idtxt.getText());
                JOptionPane.showMessageDialog(mup, "Usuario modificado correctamente");

            } catch (NullPointerException | IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(mup, "Debes llenar todos los campos");
            } catch (ServiceException | JSONException ex) {
                Logger.getLogger(ButtonsProductosListener.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mup, "Ha ocurrido un error, intenta nuevamente");
            }
        }
    }
}
