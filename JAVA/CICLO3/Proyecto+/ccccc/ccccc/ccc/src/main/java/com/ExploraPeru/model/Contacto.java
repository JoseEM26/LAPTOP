package com.ExploraPeru.model;

public class Contacto {
	// Atributos
    private int idContacto;
    private String nombreContacto;
    private String emailContacto;
    private String numeroContacto;
    private String mensajeContacto;

    // Constructor vacío
    public Contacto() {
    }

    // Constructor lleno
    public Contacto(int idContacto, String nombreContacto, String emailContacto, String numeroContacto, String mensajeContacto) {
        this.idContacto = idContacto;
        this.nombreContacto = nombreContacto;
        this.emailContacto = emailContacto;
        this.numeroContacto = numeroContacto;
        this.mensajeContacto = mensajeContacto;
    }

    // Getters y Setters
    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getMensajeContacto() {
        return mensajeContacto;
    }

    public void setMensajeContacto(String mensajeContacto) {
        this.mensajeContacto = mensajeContacto;
    }
}
