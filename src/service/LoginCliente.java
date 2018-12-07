/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.logging.Logger;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import modelo.Usuario;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;
import utilities.Utilities;

/**
 *
 * @author diego
 */
public class LoginCliente extends AbstractClient {
    public Response responseGlobal;
    public Usuario usuarioActual;
    private static final Logger log = Logger.getLogger(LoginCliente.class.getName());

    public LoginCliente(String contextPath) {
        super(contextPath);
    }

    public Usuario Login(Usuario u) throws ServiceException {
        
        ResteasyWebTarget client = createClient("");
        Response response = client.request(MediaType.APPLICATION_JSON).post(Entity.json(u));
        System.out.println(client.getUri());
        responseGlobal = response;
        Usuario aux = null;
        log.info("Status " + response.getStatus());
        Integer status = response.getStatus();
        if (Response.Status.OK.getStatusCode() == status) {
            aux = response.readEntity(Usuario.class);
            usuarioActual = aux;
            System.out.println(aux.getTipo());
            //  JSONArray jsonArray = new JSONArray(aux.jsonArray);
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        response.close();
        
        return aux;
    }

}
