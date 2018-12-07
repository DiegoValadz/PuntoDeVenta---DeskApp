/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.logging.Logger;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.DataUsuarios;
import modelo.DataVentas;
import modelo.Venta;
import org.codehaus.jettison.json.JSONException;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import utilities.Utilities;

/**
 *
 * @author diego
 */
public class VentasCliente extends AbstractClient {
    public Response responseGlobal;
    private static final Logger log = Logger.getLogger(UsuariosCliente.class.getName());

    public VentasCliente(String contextPath) {
        super(contextPath);
    }

    public ArrayList<Venta> getVentas() throws ServiceException, JSONException {
        DataVentas aux;
        ResteasyWebTarget client = createClient("");
        Response response = client.request(MediaType.APPLICATION_JSON).get();
        responseGlobal = response;

        log.info("Status " + response.getStatus());
        Integer status = response.getStatus();
        if (Response.Status.OK.getStatusCode() == status) {
            aux = response.readEntity(DataVentas.class);
            for (int i = 0; i < aux.ventas.size(); i++) {
                System.out.println("Id " + (i + 1) + ":" + aux.ventas.get(i)._id);
            }
            //  JSONArray jsonArray = new JSONArray(aux.jsonArray);
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        response.close();
        return aux.ventas;
    }

    public void postVentas(Venta v) throws ServiceException, JSONException {

        ResteasyWebTarget client = createClient("");
        Response response = client.request(MediaType.APPLICATION_JSON).post(Entity.json(v));
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

    public void putVenta(Venta v, String id) throws ServiceException, JSONException {

        log.info("Actualizando Usuario");
        ResteasyWebTarget client = createClient("/" + id);
        Response response = client.request(MediaType.APPLICATION_JSON).put(Entity.json(v));
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

    public void deleteVentas(String id) throws ServiceException, JSONException {

        log.info("Eliminando Usuario");
        ResteasyWebTarget client = createClient("/" + id);
        Response response = client.request(MediaType.APPLICATION_JSON).delete();
        responseGlobal = response;

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

 
}
