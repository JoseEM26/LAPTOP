package com.ExploraPeru.model;

public class TipoTarjeta {
	private int idTipo;
	private String nombreTipo;
	public TipoTarjeta(int idTipo, String nombreTipo) {
		super();
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
	}
	public TipoTarjeta() {
		super();
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getNombreTipo() {
		return nombreTipo;
	}
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
	
}
