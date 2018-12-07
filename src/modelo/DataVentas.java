/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
/**
 *
 * @author diego
 */
public class DataVentas {
 
    @JsonProperty("ok")
    public boolean ok;

    @JsonProperty("ventas")
    public ArrayList<VentaDW> ventas;

    @JsonProperty("total_ventas")
    public int total_ventas;

 

}
