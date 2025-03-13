package com.ExploraPeru.model;

public class Roles {
    private int idRol;
    private String nombreRol;

    // Constructor vacío
    public Roles() {
    }

    // Constructor con parámetros
    public Roles(int idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    // Getters y Setters
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

   
}
