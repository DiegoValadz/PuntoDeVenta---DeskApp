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
import vista.paneles.ModifiProdPanel;

/**
 *
 * @author diego
 */
public class ButtonWinProdListener implements ActionListener {

    private ModifiProdPanel addProd;
    private int s;

    public ButtonWinProdListener(ModifiProdPanel addProd, int s) {
        this.addProd = addProd;
        this.s = s;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Producto prod = new Producto();
        if (ae.getSource() == addProd.prodbtn) {

            try {
                prod._id = addProd.idtxt.getText();
                prod.setNombre(addProd.nombretxt.getText());
                prod.setPrecioCompra(Double.parseDouble(addProd.pcompratxt.getText()));
                prod.setPrecioVenta(Double.parseDouble(addProd.pventatxt.getText()));
                prod.setExistencia(Double.parseDouble(addProd.existxt.getText()));
                prod.setDescripcion(addProd.desctxt.getText());

                ProductosCliente client = new ProductosCliente("productos");
                client.postProductos(prod);
                JOptionPane.showMessageDialog(addProd, "Producto agegado correctamente");
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(addProd, "Los precios y la existencia deben ser datos numericos");
            }catch (NullPointerException | IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(addProd, "Debes llenar todos los campos");
            }catch (ServiceException | JSONException ex) {
                Logger.getLogger(ButtonsProductosListener.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(addProd, "Ha ocurrido un error, intenta nuevamente");
            }

    }

    else if (ae.getSource () 
        == addProd.prodbtn2) {
            try {
            prod.setNombre(addProd.nombretxt.getText());
            prod.setPrecioCompra(Double.parseDouble(addProd.pcompratxt.getText()));
            prod.setPrecioVenta(Double.parseDouble(addProd.pventatxt.getText()));
            prod.setExistencia(Double.parseDouble(addProd.existxt.getText()));
            prod.setDescripcion(addProd.desctxt.getText());

            ProductosCliente client = new ProductosCliente("productos");
            client.putProductos(prod, addProd.idtxt.getText());
            JOptionPane.showMessageDialog(addProd, "Producto modificado correctamente");
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(addProd, "Los precios y la existencia deben ser datos numericos");
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(addProd, "Debes llenar todos los campos");
        } catch (ServiceException | JSONException ex) {
            Logger.getLogger(ButtonsProductosListener.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(addProd, "Ha ocurrido un error, intenta nuevamente");
        }
    }
}

}
