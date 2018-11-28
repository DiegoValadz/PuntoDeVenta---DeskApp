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
import javax.swing.table.DefaultTableModel;
import org.codehaus.jettison.json.JSONException;
import service.ProductosCliente;
import service.ServiceException;
import utilities.MyLists;
import vista.paneles.ProductosPanel;
import vista.VistaPrincipal;

/**
 *
 * @author diego
 */
public class ButtonsNavListener implements ActionListener {

    private VistaPrincipal vp;

    public ButtonsNavListener(VistaPrincipal vp) {
        this.vp = vp;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vp.btn1) {
            ProductosPanel pp = new ProductosPanel(0, 0, 1300, 1200, null);
            pp.tabla.setModel(MyLists.setUpTableData(pp));
            pp.tabla.repaint();
            /**
             * additional code.
    *
             */
          //  tableModel.fireTableDataChanged();
           
            vp.ventana.remove(vp.centerPanel);
            vp.centerPanel = pp;
            vp.ventana.add(vp.centerPanel);
            vp.ventana.repaint();

        }

    }

    


}
