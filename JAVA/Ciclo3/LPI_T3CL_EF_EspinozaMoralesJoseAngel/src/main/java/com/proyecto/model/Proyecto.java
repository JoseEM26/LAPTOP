package com.proyecto.model;

public class Proyecto {
    private int cod_proyecto;
    private String nom_proyecto;
    private int id_tipo;
    private double presupuesto;
    private String fecha_inicio;
    private int duracion;

    // Constructor vacío
    public Proyecto() {
    }

    // Constructor lleno
    public Proyecto(int cod_proyecto, String nom_proyecto, int id_tipo, double presupuesto, String fecha_inicio, int duracion) {
        this.cod_proyecto = cod_proyecto;
        this.nom_proyecto = nom_proyecto;
        this.id_tipo = id_tipo;
        this.presupuesto = presupuesto;
        this.fecha_inicio = fecha_inicio;
        this.duracion = duracion;
    }

    // Getter y Setter para cod_proyecto
    public int getCod_proyecto() {
        return cod_proyecto;
    }

    public void setCod_proyecto(int cod_proyecto) {
        this.cod_proyecto = cod_proyecto;
    }

    // Getter y Setter para nom_proyecto
    public String getNom_proyecto() {
        return nom_proyecto;
    }

    public void setNom_proyecto(String nom_proyecto) {
        this.nom_proyecto = nom_proyecto;
    }

    // Getter y Setter para id_tipo
    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    // Getter y Setter para presupuesto
    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    // Getter y Setter para fecha_inicio
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    // Getter y Setter para duracion
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
