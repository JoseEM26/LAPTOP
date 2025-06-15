package com.proyecto.model;

public class Tipo {
    private int id_tipo;
    private String des_tipo_proy;

    // Constructor vacío
    public Tipo() {
    }

    // Constructor lleno
    public Tipo(int id_tipo, String des_tipo_proy) {
        this.id_tipo = id_tipo;
        this.des_tipo_proy = des_tipo_proy;
    }

    // Getter y Setter para id_tipo
    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    // Getter y Setter para des_tipo_proy
    public String getDes_tipo_proy() {
        return des_tipo_proy;
    }

    public void setDes_tipo_proy(String des_tipo_proy) {
        this.des_tipo_proy = des_tipo_proy;
    }
}
