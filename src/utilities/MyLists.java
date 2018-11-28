/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import controlador.ButtonsNavListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import org.codehaus.jettison.json.JSONException;
import service.ProductosCliente;
import service.ServiceException;
import vista.paneles.ProductosPanel;

/**
 *
 * @author diego
 */
public class MyLists extends Thread {

    public static ArrayList<Producto> productos;
    public static String ID; 

    @Override
    public void run() {
        ProductosCliente client = new ProductosCliente("productos");

        try {
            MyLists.productos = client.getProductos();
        } catch (ServiceException ex) {
            Logger.getLogger(ButtonsNavListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ButtonsNavListener.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    public static DefaultTableModel setUpTableData(ProductosPanel p) {
        DefaultTableModel tableModel = (DefaultTableModel) p.tabla.getModel();

        /**
         * additional code.
    *
         */
        tableModel.setRowCount(0);
        /**/
        for (int i = 0; i < MyLists.productos.size(); i++) {
            String[] data = new String[7];

            data[0] = MyLists.productos.get(i).getID();
            data[1] = MyLists.productos.get(i).getNombre();
            data[2] = MyLists.productos.get(i).getPrecioCompra();
            data[3] = MyLists.productos.get(i).getPrecioVenta();
            data[4] = MyLists.productos.get(i).getExistencia();
            data[5] = MyLists.productos.get(i).getDescripcion();

            tableModel.addRow(data);
        }
        return tableModel;
        /**/
    }

}
