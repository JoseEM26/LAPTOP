package com.ciberfarma.model;

public class Producto {
    private String idprod;
    private String descripcion;
    private int stock;
    private double precio;
    private int idcategoria;
    private int estado;

    // Constructor vacío
    public Producto() {}

    // Constructor con parámetros
    public Producto(String idprod, String descripcion, int stock, double precio, int idcategoria, int estado) {
        this.idprod = idprod;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.idcategoria = idcategoria;
        this.estado = estado;
    }

    // Getters y Setters
    public String getIdprod() {
        return idprod;
    }

    public void setIdprod(String idprod) {
        this.idprod = idprod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
