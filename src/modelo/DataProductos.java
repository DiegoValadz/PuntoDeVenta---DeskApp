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
public class DataProductos{

    @JsonProperty("ok")
    public boolean ok;

    @JsonProperty("productos")
    public ArrayList<Producto> productos;

    @JsonProperty("total_productos")
    public int totalProd;

    @Override
    public String toString() {
        return "DataProductos{" + "ok=" + ok + ", prod=" + productos + ", totalProd=" + totalProd + '}';
    }

   

}
