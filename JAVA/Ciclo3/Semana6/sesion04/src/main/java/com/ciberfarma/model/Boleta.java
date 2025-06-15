package com.ciberfarma.model;

public class Boleta {
    private String num_bol;
    private String fch_bol;
    private int cod_cliente;

    // Constructor vacío
    public Boleta() {
    }

    // Constructor con parámetros
    public Boleta(String num_bol, String fch_bol, int cod_cliente) {
        this.num_bol = num_bol;
        this.fch_bol = fch_bol;
        this.cod_cliente = cod_cliente;
    }

    // Getters y Setters
    public String getNum_bol() {
        return num_bol;
    }

    public void setNum_bol(String num_bol) {
        this.num_bol = num_bol;
    }

    public String getFch_bol() {
        return fch_bol;
    }

    public void setFch_bol(String fch_bol) {
        this.fch_bol = fch_bol;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }
}
