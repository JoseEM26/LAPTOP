package com.ciberfarma.model;

public class DetalleBoleta {
    private String idprod;
    private double preciovta;
    private int cantidad;
    // Campos auxiliares
    private String nomprod;
    private double importe;

    // Constructor vacío
    public DetalleBoleta() {}

    // Constructor con parámetros
    public DetalleBoleta(String idprod, double preciovta, int cantidad, String nomprod, double importe) {
        this.idprod = idprod;
        this.preciovta = preciovta;
        this.cantidad = cantidad;
        this.nomprod = nomprod;
        this.importe = importe;
    }

    // Getters y Setters
    public String getIdprod() {
        return idprod;
    }

    public void setIdprod(String idprod) {
        this.idprod = idprod;
    }

    public double getPreciovta() {
        return preciovta;
    }

    public void setPreciovta(double preciovta) {
        this.preciovta = preciovta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
