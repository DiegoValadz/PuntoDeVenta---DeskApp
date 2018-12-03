/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ButtonsProductosListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JFrame;
import utilities.Utilities;
import vista.paneles.ModifiProdPanel;
import vista.paneles.ModifiUserPanel;

/**
 *
 * @author diego
 */
public class ModificarProductosDialog {

    public JDialog ventana;
    public ModifiProdPanel p;
    private ButtonsProductosListener bpl;
    private ModifiUserPanel mup;
    private VistaPrincipal vp;

    public ModificarProductosDialog(ModifiUserPanel mup) {
        this.mup = mup;
        ventana = new JDialog(Utilities.frameGlobal, false);
        ventana.add(mup);
        launchDialog();
    }

    public ModificarProductosDialog(ModifiProdPanel p) {
        this.p = p;
        //Frame
        ventana = new JDialog(Utilities.frameGlobal, false);
        ventana.add(p);

        launchDialog();
    }

    public void launchDialog() {
        ventana.setSize(700, 550);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

}
