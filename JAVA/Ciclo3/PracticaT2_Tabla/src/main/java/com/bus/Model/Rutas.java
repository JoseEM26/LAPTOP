package com.bus.Model;

public class Rutas {
	  private int id_ruta;
	  private String nom_ruta;
	public Rutas(int id_ruta, String nom_ruta) {
		super();
		this.id_ruta = id_ruta;
		this.nom_ruta = nom_ruta;
	}
	public Rutas() {
		super();
	}
	public int getId_ruta() {
		return id_ruta;
	}
	public void setId_ruta(int id_ruta) {
		this.id_ruta = id_ruta;
	}
	public String getNom_ruta() {
		return nom_ruta;
	}
	public void setNom_ruta(String nom_ruta) {
		this.nom_ruta = nom_ruta;
	}
	  
	  
}
