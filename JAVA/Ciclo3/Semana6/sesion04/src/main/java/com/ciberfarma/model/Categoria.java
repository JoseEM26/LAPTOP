package com.ciberfarma.model;

public class Categoria {
    private int idcategoria;
    private String descripcion;

    // Constructor vacío
    public Categoria() {}

    // Constructor con parámetros
    public Categoria(int idcategoria, String descripcion) {
        this.idcategoria = idcategoria;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
