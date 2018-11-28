/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.logging.Logger;
import com.google.gson.Gson;

import modelo.DataUsuarios;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import modelo.Usuario;
import org.codehaus.jettison.json.JSONException;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 *
 * @author diego
 */
public class UsuariosClient extends AbstractClient {

    private static final Logger log = Logger.getLogger(UsuariosClient.class.getName());

    public UsuariosClient(String contextPath) {
        super(contextPath);
    }

    public ArrayList<Usuario> getUsuarios() throws ServiceException, JSONException {
        DataUsuarios aux;
        log.info("Obteniendo usuarios");
        ResteasyWebTarget client = createClient("");
        Response response = client.request(MediaType.APPLICATION_JSON).get();
        log.info("Status " + response.getStatus());
        Integer status = response.getStatus();
        if (Status.OK.getStatusCode() == status) {
            aux = response.readEntity(DataUsuarios.class);
            //  JSONArray jsonArray = new JSONArray(aux.jsonArray);
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        response.close();
        return aux.usuarios;
    }

    public static void main(String[] args) throws ServiceException, JSONException {
        UsuariosClient client = new UsuariosClient("usuarios");
        ArrayList<Usuario> usuarios = client.getUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i).getNombre());
            System.out.println(usuarios.get(i).getId());
            System.out.println(usuarios.get(i).getTipo());
            System.out.println(usuarios.get(i).getContraseña());
            System.out.println(usuarios.get(i).getUsuario());

        }

    }
}
