/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author diego
 */
public class DiarioDeVenta {

    public static final int VENDEDOR = 0;
    public static final int SUCURSAL = 1;
    public static final int PRODUCTO = 2;
    private ArrayList<VentaDW> listaVentasIN,listaVentasOUT;
    private int filtro;
    private String fecha1, fecha2;

  

    public DiarioDeVenta(String fecha1, String fecha2,ArrayList<VentaDW> listaVentasIN) throws ParseException {
       /* String[] parts1 = fecha1.split("-");
        String [] parts2 = fecha2.split("-");
        this.fecha1 = ""+parts1[0]+"/"+parts1[1]+"/"+parts1[2];
        this.fecha2 = ""+parts2[0]+"/"+parts2[1]+"/"+parts2[2];*/
       this.fecha1 = fecha1;
       this.fecha2 = fecha2;
        this.listaVentasIN =listaVentasIN;
        listaVentasOUT = validadorFechas();

    }
    public static ArrayList<VentaDW> buscarPorProducto( ArrayList<VentaDW> in,String compare){
         ArrayList<VentaDW> out = new ArrayList<>();
         for (int i = 0; i < in.size(); i++) {
             for (int j = 0; j < in.get(i).getProductos().size(); j++) {
                 if(in.get(i).getProductos().get(j)._id.equals(compare)){
                out.add(in.get(i));
            }
             }
             
        }
         return out;
    }

  

    private ArrayList<VentaDW> validadorFechas() throws ParseException {
        
              ArrayList<VentaDW> out = new ArrayList<>();   
        DateFormat f = DateFormat.getDateInstance(DateFormat.SHORT);
        Date date1 = f.parse(fecha1);
        Date date2 = f.parse(fecha2);
        Calendar cal1 = new GregorianCalendar();
        cal1.setTime(date1);
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(date2);
        Date date3;
       
        
        for (int i = 0; i < listaVentasIN.size(); i++) {
            String [] parts3 = listaVentasIN.get(i).getFecha().split("-");
            date3 = f.parse(""+parts3[0]+"/"+parts3[1]+"/"+parts3[2]);
            Calendar cal3 = new GregorianCalendar();
            cal3.setTime(date3);

            if (cal3.after(cal1) && cal3.before(cal2)) {
                    out.add(listaVentasIN.get(i));
            } 
        }
        return out;
       
    }

    public ArrayList<VentaDW> getListaVentasIN() {
        return listaVentasIN;
    }

    public void setListaVentasIN(ArrayList<VentaDW> listaVentasIN) {
        this.listaVentasIN = listaVentasIN;
    }

    public ArrayList<VentaDW> getListaVentasOUT() {
        return listaVentasOUT;
    }

    public void setListaVentasOUT(ArrayList<VentaDW> listaVentasOUT) {
        this.listaVentasOUT = listaVentasOUT;
    }

    public int getFiltro() {
        return filtro;
    }

    public void setFiltro(int filtro) {
        this.filtro = filtro;
    }

    public String getFecha1() {
        return fecha1;
    }

    public void setFecha1(String fecha1) {
        this.fecha1 = fecha1;
    }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }



    
}
