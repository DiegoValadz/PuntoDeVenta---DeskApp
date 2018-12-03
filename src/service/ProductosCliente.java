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
import modelo.DataProductos;
import modelo.Producto;
import org.codehaus.jettison.json.JSONException;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import utilities.Utilities;

/**
 *
 * @author diego
 */
public class ProductosCliente extends AbstractClient {

    private static final Logger log = Logger.getLogger(ProductosCliente.class.getName());

    public ProductosCliente(String contextPath) {
        super(contextPath);
    }

    public ArrayList<Producto> getProductos() throws ServiceException, JSONException {
        DataProductos aux;
        log.info("Obteniendo Productos");
        ResteasyWebTarget client = createClient("");
        Response response = client.request(MediaType.APPLICATION_JSON).get();

        log.info("Status " + response.getStatus());
        Integer status = response.getStatus();
        if (Response.Status.OK.getStatusCode() == status) {
            aux = response.readEntity(DataProductos.class);
            //  JSONArray jsonArray = new JSONArray(aux.jsonArray);
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        response.close();

        return aux.productos;
    }

    public void postProductos(Producto p) throws ServiceException, JSONException {

        DataProductos aux;
        ResteasyWebTarget client = createClient("");
        Response response = client.request(MediaType.APPLICATION_JSON).post(Entity.json(p));

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
    
     public void putProductos(Producto p,String id) throws ServiceException, JSONException {

        log.info("Actualizando Productos");
        ResteasyWebTarget client = createClient("/"+id);
        Response response = client.request(MediaType.APPLICATION_JSON).put(Entity.json(p));

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

        log.info("Eliminando Producto");
        ResteasyWebTarget client = createClient("/"+id);
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

}
