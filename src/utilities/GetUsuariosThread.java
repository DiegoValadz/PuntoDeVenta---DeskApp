/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import service.ServiceException;
import service.UsuariosCliente;

/**
 *
 * @author diego
 */
public class GetUsuariosThread extends Thread {

    @Override
    public void run() {
        super.run();

        UsuariosCliente client = new UsuariosCliente("usuarios");
        
        try {
            Utilities.usuarios = client.getUsuarios();
        } catch (ServiceException ex) {
            Logger.getLogger(GetUsuariosThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(GetUsuariosThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
