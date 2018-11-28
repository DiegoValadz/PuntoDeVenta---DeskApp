/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author diego
 */
public class Producto {
    @JsonProperty("ID")
    private String ID;    
    
    @JsonProperty("nombre")
    private String nombre;
     
    @JsonProperty("existencia")
    private String existencia;
 
    @JsonProperty("prodState")
    private boolean prodState; 
    
    @JsonProperty("precioVenta")
    private String precioVenta;
 
    @JsonProperty("precioCompra")
    private String precioCompra;
 
    @JsonProperty("descripcion")
    private String descripcion;

    public Producto() {
        prodState = true;
    }
    
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


   
    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public boolean isProdState() {
        return prodState;
    }

    public void setProdState(boolean prodState) {
        this.prodState = prodState;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
}
           