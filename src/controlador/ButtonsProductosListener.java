/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Producto;
import org.codehaus.jettison.json.JSONException;
import service.ProductosCliente;
import service.ServiceException;
import utilities.Utilities;
import vista.paneles.ModifiProdPanel;
import vista.ModificarCustomDialog;
import vista.VistaPrincipal;
import vista.paneles.ProductosPanel;
import utilities.Utilities;

/**
 *
 * @author diego
 */
public class ButtonsProductosListener implements ActionListener {

    private ProductosPanel pp;
    private ModificarCustomDialog dialog;
    private ModifiProdPanel app;

    public ButtonsProductosListener(ProductosPanel pp ) {
        this.pp = pp;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pp.btnAgregar) {
            app.s = ModifiProdPanel.ADD;
            app = new ModifiProdPanel("Introduzca los datos del producto");
            dialog = new ModificarCustomDialog(app);
        } else if (ae.getSource() == pp.btnActua) {
            ProductosCliente pc = new ProductosCliente("productos");
            try {
                Utilities.productos = pc.getProductos();
            } catch (ServiceException ex) {
                Logger.getLogger(ButtonsProductosListener.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ButtonsProductosListener.class.getName()).log(Level.SEVERE, null, ex);
            }

            Utilities.setUpTableData(pp);

        } else if (ae.getSource() == pp.btnEditar) {

            int filaseleccionada;
            try {
                //Guardamos en un entero la fila seleccionada.
                filaseleccionada = pp.tabla.getSelectedRow();
                if (filaseleccionada == -1) {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
                } else {
                    app.s = ModifiProdPanel.UPDATE;
                    app = new ModifiProdPanel("Modifique los datos del producto");
                    app.nombretxt.setText(pp.tabla.getValueAt(filaseleccionada, 1).toString());
                    app.idtxt.setText(pp.tabla.getValueAt(filaseleccionada, 0).toString());
                    app.pcompratxt.setText(pp.tabla.getValueAt(filaseleccionada, 2).toString());
                    app.pventatxt.setText(pp.tabla.getValueAt(filaseleccionada, 3).toString());
                    app.existxt.setText(pp.tabla.getValueAt(filaseleccionada, 4).toString());
                    app.desctxt.setText(pp.tabla.getValueAt(filaseleccionada, 5).toString());

                    app.idtxt.setEditable(false);
                    dialog = new ModificarCustomDialog(app);

                }

            } catch (Exception e) {

            }
        } else if (ae.getSource() == pp.btnEliminar) {
            int filaseleccionada;
            try {
                //Guardamos en un entero la fila seleccionada.
                filaseleccionada = pp.tabla.getSelectedRow();
                System.out.println("Fila a eliminar : "+filaseleccionada);
                if (filaseleccionada == -1) {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
                } else {
                    int s = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?", "Eliminar",JOptionPane.YES_NO_OPTION);
                    if(s==JOptionPane.YES_OPTION){
                        String id= pp.tabla.getValueAt(filaseleccionada, 0).toString();
                        System.out.println("El id es"+id);
                        ProductosCliente cliente = new ProductosCliente("productos");
                        cliente.deleteProductos(id);
                    }
                    
                   

                   
                }

            } catch (Exception e) {

            }
        }
    }

}
