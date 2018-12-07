/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DiarioDeVenta;
import modelo.VentaDW;
import org.codehaus.jettison.json.JSONException;
import service.ServiceException;
import service.VentasCliente;
import vista.paneles.DiarioDeVentasPanel;
import utilities.Utilities;
/**
 *
 * @author diego
 */
public class ButtonsDiarioDVListener implements ActionListener {

    private DiarioDeVentasPanel ddvp;
    private DiarioDeVenta diarioDeVenta;

    public ButtonsDiarioDVListener(DiarioDeVentasPanel ddvp) {
        this.ddvp = ddvp;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ArrayList<VentaDW> listVentas = new ArrayList<>();
        VentasCliente cliente;
        try{
        if (ddvp.rbtnSucursal.isSelected()) {
            
                cliente = new VentasCliente("ventas/sucursal/");
                listVentas = cliente.getVentasSucursal(ddvp.buscartxt.getText());
            

        } else if (ddvp.rbtnVendedor.isSelected()) {
            cliente = new VentasCliente("ventas/vendedor/");
            listVentas = cliente.getVentasVendedor(ddvp.buscartxt.getText());

        } else if (ddvp.rbtnProducto.isSelected()) {
            cliente = new VentasCliente("ventas");
             ArrayList<VentaDW> aux =cliente.getVentas();
            listVentas = DiarioDeVenta.buscarPorProducto(aux, ddvp.buscartxt.getText());
        }
        } catch (ServiceException ex) {
                Logger.getLogger(ButtonsDiarioDVListener.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ButtonsDiarioDVListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        String fecha1 = null;
              String fecha2 = null; 
       try{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

         fecha1 = formato.format(ddvp.fecha1.getDate());
         fecha2 = formato.format(ddvp.fecha2.getDate());
       } catch(NullPointerException e){
           
       }
        
        if (fecha1 != null && fecha2 != null) {
            try {
                diarioDeVenta = new DiarioDeVenta(fecha1, fecha2, listVentas);
                Utilities.ventas = diarioDeVenta.getListaVentasOUT();
                Utilities.setUpTableData(ddvp);
            } catch (ParseException ex) {
                Logger.getLogger(ButtonsDiarioDVListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Utilities.ventas = listVentas;
                Utilities.setUpTableData(ddvp);
        }

    }
}
