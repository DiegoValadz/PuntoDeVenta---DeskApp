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
import javax.swing.JOptionPane;
import modelo.Producto;
import org.codehaus.jettison.json.JSONException;
import service.ProductosCliente;
import service.ServiceException;
import utilities.MyLists;
import vista.paneles.ModifiProdPanel;

/**
 *
 * @author diego
 */
public class ButtonWinListener implements ActionListener {

    private ModifiProdPanel addProd;
    private int s;

    public ButtonWinListener(ModifiProdPanel addProd, int s) {
        this.addProd = addProd;
        this.s = s;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Producto prod = new Producto();
        if (ae.getSource() == addProd.prodbtn) {

            try {
                prod.setID(addProd.idtxt.getText());
                prod.setNombre(addProd.nombretxt.getText());
                prod.setPrecioCompra(addProd.pcompratxt.getText());
                prod.setPrecioVenta(addProd.pventatxt.getText());
                prod.setExistencia(addProd.existxt.getText());
                prod.setDescripcion(addProd.desctxt.getText());

                ProductosCliente client = new ProductosCliente("productos");
                client.postProductos(prod);
                JOptionPane.showMessageDialog(addProd, "Producto Agegado Correctamente");

            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(addProd, "Debes llenar todos los campos");
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(addProd, "Debes llenar todos los campos");
            } catch (ServiceException ex) {
                Logger.getLogger(ButtonsProductosListener.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(addProd, "Error de conexión");
            } catch (JSONException ex) {
                Logger.getLogger(ButtonsProductosListener.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(addProd, "Error de conexión");

            }

        } else if (ae.getSource() == addProd.prodbtn2 ) {
             try {
                prod.setNombre(addProd.nombretxt.getText());
                prod.setPrecioCompra(addProd.pcompratxt.getText());
                prod.setPrecioVenta(addProd.pventatxt.getText());
                prod.setExistencia(addProd.existxt.getText());
                prod.setDescripcion(addProd.desctxt.getText());

                ProductosCliente client = new ProductosCliente("productos");
                client.putProductos(prod,addProd.idtxt.getText());
                JOptionPane.showMessageDialog(addProd, "Producto Modificado Correctamente");

            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(addProd, "Debes llenar todos los campos");
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(addProd, "Debes llenar todos los campos");
            } catch (ServiceException ex) {
                Logger.getLogger(ButtonsProductosListener.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(addProd, "Error de conexión");
            } catch (JSONException ex) {
                Logger.getLogger(ButtonsProductosListener.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(addProd, "Error de conexión");

            }
        }
    }

}
