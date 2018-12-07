/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Producto;
import modelo.Venta;
import org.codehaus.jettison.json.JSONException;
import service.ServiceException;
import service.UsuariosCliente;
import service.VentasCliente;
import vista.ModificarCustomDialog;
import vista.paneles.GenerarVentasPanel;
import vista.paneles.ReciboVentaPanel;

/**
 *
 * @author diego
 */
public class ButtonGVentaListener implements ActionListener {

    private GenerarVentasPanel gvp;
    private ArrayList<Integer> cantlist;

    public ButtonGVentaListener(GenerarVentasPanel gvp) {
        this.gvp = gvp;
        cantlist = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ArrayList<Producto> aux = gvp.venta.getProductosList();
        cantlist.add(Integer.parseInt(gvp.canttxt.getText()));
        if (ae.getSource() == gvp.agregarbtn) {

            try {
                aux.add(gvp.productoActual);
                gvp.venta.setProductosList(aux);
                gvp.venta.generarVenta(Integer.parseInt(gvp.canttxt.getText()));
                gvp.fillJList();
                gvp.updateSell();

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Introduzca una cantidad valida");
            }

        } else if (ae.getSource() == gvp.generarbtn) {
            System.out.println(gvp.venta.vendedor);

            try {
                gvp.venta._id = gvp.foliotxt.getText();
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                gvp.venta.setFecha(formato.format(gvp.dateChooser.getDate()));

                gvp.venta.setHora(gvp.horatxt.getText());
                gvp.venta.setSucursal(gvp.sucursaltxt.getText());
                gvp.venta.vendedor = gvp.vendedortxt.getText();
                System.out.println(gvp.vendedor);
                ArrayList<String> aux2 = new ArrayList<>();
                for (int i = 0; i < gvp.venta.getProductosList().size(); i++) {
                    aux2.add(gvp.venta.getProductosList().get(i)._id);
                }
                gvp.venta.setProductos(aux2);

                VentasCliente client = new VentasCliente("ventas");

                client.postVentas(gvp.venta);
                JOptionPane.showMessageDialog(null, "Venta generada correctamente");
                String msg = fillVentaTicket(gvp.venta, gvp.venta.getProductosList());
                ReciboVentaPanel rvp = new ReciboVentaPanel(msg);
                ModificarCustomDialog customDialog = new ModificarCustomDialog(rvp);

            } catch (ServiceException ex) {
                Logger.getLogger(ButtonGVentaListener.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(gvp, "Debes llenar todos los campos");

            } catch (JSONException ex) {
                Logger.getLogger(ButtonGVentaListener.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(gvp, "Ha ocurrido un error, intenta nuevamente");

            }

        }

    }

    private String fillVentaTicket(Venta venta, ArrayList<Producto> plist) {
        String msg = "";
        for (int j = 0; j < 2; j++) {

            msg += "VENTA DE PRODUCTOS ------ TICKET " + (j + 1)+"\n\n\n";
            msg += "Folio de Venta:  " + venta.getId() + " \n\n  Sucursal: " + venta.getSucursal()
                    + "\n  Fecha: " + venta.getFecha() + "\n  Hora; " + venta.getHora() + "\n\n\nProductos: \n\n";

            for (int i = 0; i < plist.size(); i++) {
                msg += "  Nombre: " + plist.get(i).getNombre() + "\n  Precio unitario" + plist.get(i).getPrecioVenta() + "\n  Cantidad:  " + cantlist.get(i) + "  \n\n";

            }
            msg += "  Iva: " + venta.getIva() + "\n  Subtototal: " + venta.getSubtotal()
                    + "\n  Total: " + venta.getTotal() + "\n  Vendedor:  " + venta._id + "\n\n"
                    + "============================================================================================================\n\n";

        }

        return msg;
    }
}
