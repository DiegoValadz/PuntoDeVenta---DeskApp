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
    @JsonProperty("_id")
    public String _id;
     
    @JsonProperty("ID_PROD")
    private String ID_PROD;    
    
    @JsonProperty("nombre")
    private String nombre;
     
    @JsonProperty("existencia")
    private double existencia;
 
    @JsonProperty("prodState")
    private boolean prodState; 
    
    @JsonProperty("precioVenta")
    private double precioVenta;
 
    @JsonProperty("precioCompra")
    private double precioCompra;
 
    @JsonProperty("descripcion")
    private String descripcion;

    public Producto() {
        prodState = true;
    }

    public String getID_PROD() {
        return ID_PROD;
    }

    public void setID_PROD(String ID_PROD) {
        this.ID_PROD = ID_PROD;
    }

    public double getExistencia() {
        return existencia;
    }

    public void setExistencia(double existencia) {
        this.existencia = existencia;
    }
    
    public boolean isProdState() {
        return prodState;
    }

    public void setProdState(boolean prodState) {
        this.prodState = prodState;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
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
           