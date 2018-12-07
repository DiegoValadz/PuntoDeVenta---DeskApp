/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import controlador.ButtonsNavListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.core.Response;
import modelo.Producto;
import modelo.Usuario;
import modelo.VentaDW;
import org.codehaus.jettison.json.JSONException;
import service.ProductosCliente;
import service.ServiceException;
import service.UsuariosCliente;
import vista.paneles.DiarioDeVentasPanel;
import vista.paneles.ProductosPanel;
import vista.paneles.UsuariosPanel;

/**
 *
 * @author diego
 */
public class Utilities {

    public static ArrayList<Producto> productos;
    public static ArrayList<Usuario> usuarios;
    public static ArrayList<Usuario> vendedores;
    public static ArrayList<VentaDW> ventas;
    public static final String ADMIN = "Administrador";
    public static final String VEND = "Vendedor";
    public static final String CLIENT = "Cliente";
    public static String ID;
    public static Usuario usuarioActual;
    public static File currentFileImage;
    public static JFrame frameGlobal;
    public static Response response;

    public static DefaultTableModel setUpTableData(ProductosPanel p) {
        DefaultTableModel tableModel = (DefaultTableModel) p.tabla.getModel();

        /**
         * additional code.
         *
         */
        tableModel.setRowCount(0);
        /**/
        for (int i = 0; i < Utilities.productos.size(); i++) {
            String[] data = new String[7];

            data[0] = Utilities.productos.get(i)._id;
            data[1] = Utilities.productos.get(i).getNombre();
            data[2] = String.valueOf(Utilities.productos.get(i).getPrecioCompra());
            data[3] = String.valueOf(Utilities.productos.get(i).getPrecioVenta());
            data[4] = String.valueOf(Utilities.productos.get(i).getExistencia());
            data[5] = Utilities.productos.get(i).getDescripcion();

            tableModel.addRow(data);
        }
        return tableModel;
        /**/
    }

    public static DefaultTableModel setUpTableData(UsuariosPanel p) {
        DefaultTableModel tableModel = (DefaultTableModel) p.tabla.getModel();

        /**
         * additional code.
         *
         */
        tableModel.setRowCount(0);
        /**/

        String[] data = new String[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = "";
        }

        for (int i = 0; i < Utilities.usuarios.size(); i++) {

            data[0] = Utilities.usuarios.get(i)._id;
            data[1] = Utilities.usuarios.get(i).getNombre();
            data[2] = Utilities.usuarios.get(i).getUsuario();
            data[3] = Utilities.usuarios.get(i).getTipo();
            data[4] = Utilities.usuarios.get(i).getDireccion();
            data[5] = Utilities.usuarios.get(i).getCiudad();
            data[6] = Utilities.usuarios.get(i).getEstado();
            data[7] = Utilities.usuarios.get(i).getCp();
            data[8] = Utilities.usuarios.get(i).getTelefono();
            data[9] = Utilities.usuarios.get(i).getEmail();

            tableModel.addRow(data);
        }
        return tableModel;
        /**/
    }

    public static DefaultTableModel setUpTableData(DiarioDeVentasPanel p) {
        DefaultTableModel tableModel = (DefaultTableModel) p.tabla.getModel();

        tableModel.setRowCount(0);

        String[] data = new String[12];
        for (int i = 0; i < data.length; i++) {
            data[i] = "";
        }

        for (int i = 0; i < Utilities.ventas.size(); i++) {

            data[0] = Utilities.ventas.get(i).getId();
            data[1] = Utilities.ventas.get(i).getFecha();
            data[2] = Utilities.ventas.get(i).getHora();
            data[3] = Utilities.ventas.get(i).getSucursal();
            data[4] = Utilities.ventas.get(i).getVendedor()._id;

            data[5] = Utilities.ventas.get(i).getProductos().get(0)._id;
            data[6] = Utilities.ventas.get(i).getProductos().get(0).getNombre();
            data[7] = Utilities.ventas.get(i).getProductos().get(0).getDescripcion();
            data[8] = String.valueOf(Utilities.ventas.get(i).getProductos().get(0).getPrecioVenta());
            data[9] = String.valueOf(Utilities.ventas.get(i).getSubtotal());
            data[10] = String.valueOf(Utilities.ventas.get(i).getIva());
            data[11] = String.valueOf(Utilities.ventas.get(i).getTotal());
            tableModel.addRow(data);
            for (int j = 0; j < Utilities.ventas.get(i).getProductos().size()-1; j++) {
                String subdata[] = new String[12];
                subdata[0]="";
                subdata[1]="";
                subdata[2]="";
                subdata[3]="";
                subdata[4]="";
                subdata[5] = Utilities.ventas.get(i).getProductos().get(j+1)._id;
                subdata[6] = Utilities.ventas.get(i).getProductos().get(j+1).getNombre();
                subdata[7] = Utilities.ventas.get(i).getProductos().get(j+1).getDescripcion();
                subdata[8] = String.valueOf(Utilities.ventas.get(i).getProductos().get(j+1).getPrecioVenta());
                subdata[9] = String.valueOf(Utilities.ventas.get(i).getSubtotal());
                subdata[10] = String.valueOf(Utilities.ventas.get(i).getIva());
                subdata[11] = String.valueOf(Utilities.ventas.get(i).getTotal());
                tableModel.addRow(subdata);

            }

        }
        return tableModel;
    }

}
