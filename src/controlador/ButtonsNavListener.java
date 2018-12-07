/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;
import org.jgroups.protocols.CENTRAL_LOCK;
import vista.paneles.CustomTabbedPanel;
import utilities.Utilities;
import vista.paneles.ProductosPanel;
import vista.VistaPrincipal;
import vista.paneles.AjustesPanel;
import vista.paneles.DiarioDeVentasPanel;
import vista.paneles.GenerarVentasPanel;
import vista.paneles.UsuariosPanel;

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
            pp.tabla.setModel(Utilities.setUpTableData(pp));
            pp.tabla.repaint();

            vp.ventana.remove(vp.centerPanel);
            vp.ventana.remove(vp.tp);
            vp.ventana.repaint();

            vp.centerPanel = pp;
            vp.ventana.add(vp.centerPanel);
            vp.ventana.repaint();

        } else if (ae.getSource() == vp.btn2) {

            CustomTabbedPanel jtp = new CustomTabbedPanel(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

            vp.ventana.remove(vp.centerPanel);
            vp.ventana.remove(vp.tp);
            vp.ventana.repaint();

            vp.tp = jtp;
            vp.ventana.add(vp.tp);
            vp.ventana.repaint();

        } else if (ae.getSource() == vp.btn3) {

            UsuariosPanel up = new UsuariosPanel(0, 0, 1300, 1200, null);

            vp.ventana.remove(vp.centerPanel);
            vp.ventana.remove(vp.tp);

            vp.ventana.repaint();

            vp.centerPanel = up;
            vp.ventana.add(vp.centerPanel);
            vp.ventana.repaint();

        }
         else if (ae.getSource() == vp.btn4) {

            AjustesPanel ap = new AjustesPanel(0, 0, 1300, 1200, null,vp);
            vp.ventana.remove(vp.centerPanel);
            vp.ventana.remove(vp.tp);

            vp.ventana.repaint();

            vp.centerPanel = ap;
            vp.ventana.add(vp.centerPanel);
            vp.ventana.repaint();

        }

    }

}
