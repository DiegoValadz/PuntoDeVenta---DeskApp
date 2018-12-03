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
import org.codehaus.jettison.json.JSONException;
import service.ProductosCliente;
import service.ServiceException;
import service.UsuariosClient;
import utilities.Utilities;
import vista.ModificarProductosDialog;
import vista.paneles.ModifiProdPanel;
import vista.paneles.ModifiUserPanel;
import vista.paneles.ProductosPanel;
import vista.paneles.UsuariosPanel;

/**
 *
 * @author diego
 */
public class ButtonsUsuariosListener implements ActionListener {

    private UsuariosPanel up;
    private ModificarProductosDialog dialog;
    private ModifiUserPanel mup;

    public ButtonsUsuariosListener(UsuariosPanel up) {
        this.up = up;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == up.btnAgregar) {
            mup.s = ModifiProdPanel.ADD;
            mup = new ModifiUserPanel("Introduzca los datos del usuario");
            dialog = new ModificarProductosDialog(mup);

        } else if (ae.getSource() == up.btnActua) {
            UsuariosClient pc = new UsuariosClient("usuarios");
            try {
                Utilities.usuarios = pc.getUsuarios();
            } catch (ServiceException ex) {
                Logger.getLogger(ButtonsProductosListener.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ButtonsProductosListener.class.getName()).log(Level.SEVERE, null, ex);
            }

            Utilities.setUpTableData(up);

        } else if (ae.getSource() == up.btnEditar) {
            int filaseleccionada;
          //  try {
                //Guardamos en un entero la fila seleccionada.
                filaseleccionada = up.tabla.getSelectedRow();

                if (filaseleccionada == -1) {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
                } else {
                    System.out.println(filaseleccionada);

                    mup.s = ModifiUserPanel.UPDATE;
                    mup = new ModifiUserPanel("Modifique los datos del Usuario");
                    mup.idtxt.setText(up.tabla.getValueAt(filaseleccionada, 0).toString());
                    mup.nombretxt.setText(up.tabla.getValueAt(filaseleccionada, 1).toString());
                    mup.usuariotxt.setText(up.tabla.getValueAt(filaseleccionada, 2).toString());
                    // mup.tipo.setText(up.tabla.getValueAt(filaseleccionada, 3).toString());
                    mup.direcctxt.setText(up.tabla.getValueAt(filaseleccionada, 4).toString());
                    mup.ciudadtxt.setText(up.tabla.getValueAt(filaseleccionada, 5).toString());
                    mup.estadotxt.setText(up.tabla.getValueAt(filaseleccionada, 6).toString());
                    mup.cptxt.setText(up.tabla.getValueAt(filaseleccionada, 7).toString());
                    mup.teltxt.setText(up.tabla.getValueAt(filaseleccionada, 8).toString());
                    mup.emailtxt.setText(up.tabla.getValueAt(filaseleccionada, 9).toString());

                    mup.idtxt.setEditable(false);
                    dialog = new ModificarProductosDialog(mup);

                }
          //  } catch (Exception e) {

           // }
        } else if (ae.getSource() == up.btnEliminar) {
            int filaseleccionada;
            try {
                //Guardamos en un entero la fila seleccionada.
                filaseleccionada = up.tabla.getSelectedRow();
                System.out.println("Fila a eliminar : " + filaseleccionada);
                if (filaseleccionada == -1) {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
                } else {
                    int s = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?", "Eliminar", JOptionPane.YES_NO_OPTION);
                    if (s == JOptionPane.YES_OPTION) {
                        String id = up.tabla.getValueAt(filaseleccionada, 0).toString();
                        System.out.println("El id es" + id);
                        UsuariosClient cliente = new UsuariosClient("usuarios");
                        cliente.deleteProductos(id);
                    }

                }

            } catch (Exception e) {

            }
        }
    }
}
