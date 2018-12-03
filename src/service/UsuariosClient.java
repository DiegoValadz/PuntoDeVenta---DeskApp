/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.logging.Logger;
import javax.ws.rs.client.Entity;

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
        ResteasyWebTarget client = createClient("");
        Response response = client.request(MediaType.APPLICATION_JSON).get();
        log.info("Status " + response.getStatus());
        Integer status = response.getStatus();
        if (Status.OK.getStatusCode() == status) {
            aux = response.readEntity(DataUsuarios.class);
            for (int i = 0; i < aux.usuarios.size(); i++) {
                System.out.println("Id "+(i+1)+":"+aux.usuarios.get(i)._id);
            }
            //  JSONArray jsonArray = new JSONArray(aux.jsonArray);
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        response.close();
        return aux.usuarios;
    }

    public void postUsuarios(Usuario u) throws ServiceException, JSONException {

        ResteasyWebTarget client = createClient("");
        Response response = client.request(MediaType.APPLICATION_JSON).post(Entity.json(u));

        log.info("Status " + response.getStatus());
        Integer status = response.getStatus();
        if (Response.Status.OK.getStatusCode() == status) {
            System.out.println("Si se pudo");
            //  JSONArray jsonArray = new JSONArray(aux.jsonArray);
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        response.close();

    }

    public void putProductos(Usuario u, String id) throws ServiceException, JSONException {

        log.info("Actualizando Usuario");
        ResteasyWebTarget client = createClient("/" + id);
        Response response = client.request(MediaType.APPLICATION_JSON).put(Entity.json(u));

        log.info("Status " + response.getStatus());
        Integer status = response.getStatus();
        if (Response.Status.OK.getStatusCode() == status) {
            System.out.println("Si se pudo");
            //  JSONArray jsonArray = new JSONArray(aux.jsonArray);
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        response.close();

    }

    public void deleteProductos(String id) throws ServiceException, JSONException {

        log.info("Eliminando Usuario");
        ResteasyWebTarget client = createClient("/" + id);
        Response response = client.request(MediaType.APPLICATION_JSON).delete();

        log.info("Status " + response.getStatus());
        Integer status = response.getStatus();
        if (Response.Status.OK.getStatusCode() == status) {
            System.out.println("Si se pudo eliminar");
            //  JSONArray jsonArray = new JSONArray(aux.jsonArray);
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        response.close();

    }
/*
    public static void main(String[] args) throws ServiceException, JSONException {
        UsuariosClient c = new UsuariosClient("usuarios");
        ArrayList<Usuario> u = c.getUsuarios();

        for (int i = 0; i < u.size(); i++) {
            System.out.println(u.get(i).getNombre());
            System.out.println(u.get(i).getContraseña());

            System.out.println(u.get(i).getID_USER());

            System.out.println(u.get(i).getTipo());

            System.out.println(u.get(i).getTelefono());

            System.out.println(u.get(i).getCp());

        }
      Usuario u2 = new Usuario();
      u2.setID_USER(u.get(0).getID_USER());
            u2.setNombre("Juan Lopez");
            c.putProductos(u2, u2.getID_USER());

    }*/
}
