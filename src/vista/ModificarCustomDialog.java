/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.toedter.calendar.JCalendar;
import controlador.ButtonsProductosListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JFrame;
import utilities.Utilities;
import vista.paneles.GenerarVentasPanel;
import vista.paneles.ModifiProdPanel;
import vista.paneles.ModifiUserPanel;
import vista.paneles.ReciboVentaPanel;

/**
 *
 * @author diego
 */
public class ModificarCustomDialog {

    public JDialog ventana;
    public ModifiProdPanel p;
    private ButtonsProductosListener bpl;
    private ModifiUserPanel mup;
    private ReciboVentaPanel rvp; 
    private VistaPrincipal vp;

    public ModificarCustomDialog(ModifiUserPanel mup) {
        this.mup = mup;
        ventana = new JDialog(Utilities.frameGlobal, false);
        ventana.add(mup);
        launchDialog();
    }

    public ModificarCustomDialog(ModifiProdPanel p) {
        this.p = p;
        //Frame
        ventana = new JDialog(Utilities.frameGlobal, false);
        ventana.add(p);

        launchDialog();
    }
    
    public ModificarCustomDialog(ReciboVentaPanel rvp) {
        this.rvp = rvp;
        ventana = new JDialog(Utilities.frameGlobal, false);
        ventana.add(rvp);

       launchDialog();
    }
    
    
    public void launchDialog() {
        ventana.setSize(600, 550);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
    
}
