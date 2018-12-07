/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.logging.Logger;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.Usuario;
import org.codehaus.jettison.json.JSONException;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import utilities.Utilities;

/**
 *
 * @author diego
 */
public class UploadsCliente extends AbstractClient{
    
    public Response responseGlobal;
    private static final Logger log = Logger.getLogger(UploadsCliente.class.getName());

    public UploadsCliente(String contextPath) {
        super(contextPath);
    }
    
    public void putProductos(String tipo, String id) throws ServiceException, JSONException {

        log.info("Actualizando Imagen Usuario");
        ResteasyWebTarget client = createClient("/" + tipo+"/"+id);
        Response response = client.request(MediaType.MULTIPART_FORM_DATA).put(Entity.form(new Form()));
        responseGlobal = response;
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
}
