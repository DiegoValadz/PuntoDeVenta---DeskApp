/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

/**
 *
 * @author diego
 */
public class CustomTabbedPanel extends JTabbedPane {

    private GenerarVentasPanel gvp;
    private DiarioDeVentasPanel dvp;
    private Icon gv, gvx, dv, dvx,bg;
    private JLabel gvlb, gvxlb, dvlb, dvxlb;
    private String URL;

    public CustomTabbedPanel(int i, int i1) {
        super(i, i1);
        setBounds(300, 0, 1500, 1200);
        //Icons
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\gv.png";
        gv = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\gvx.png";
        gvx = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\dv.png";
        dv = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\dvx.png";
        dvx = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\center_fondo.jpg";
        
        //Labels
        gvlb = new JLabel(gv);
        gvxlb = new JLabel(gvx);
        dvlb = new JLabel(dv);
        dvxlb = new JLabel(dvx);

        //Paneles        
        gvp = new GenerarVentasPanel(0, 0, 1300, 1200, null);
        gvp.setImageBackground(URL);
        dvp = new DiarioDeVentasPanel(0, 0, 1300, 1200, null);
        dvp.setImageBackground(URL);

        
        addTab("Administrar Ventas", gvp);
        addTab("Diario de Ventas", dvp);
        
      //  setDisabledIconAt(0, gv);
      //  setDisabledIconAt(1, dv);
        setIconAt(0, gv);
        setIconAt(1, dv);
        

    }

}
