/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import service.ProductosCliente;
import service.ServiceException;

/**
 *
 * @author diego
 */
public class GetProductosThread extends Thread {

    @Override
    public void run() {
        super.run();

        ProductosCliente client = new ProductosCliente("productos");
        try {
            Utilities.productos = client.getProductos();
        } catch (ServiceException ex) {
            Logger.getLogger(GetProductosThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(GetProductosThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}