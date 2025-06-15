package com.ExploraPeru.model;

public class Tarjeta {
	private String numeroTarjeta;
	private String fechaValidacion;
	private int CVV;
	private int idTipo;
	public Tarjeta(String numeroTarjeta, String fechaValidacion, int cVV, int idTipo) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.fechaValidacion = fechaValidacion;
		CVV = cVV;
		this.idTipo = idTipo;
	}
	public Tarjeta() {
		super();
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getFechaValidacion() {
		return fechaValidacion;
	}
	public void setFechaValidacion(String fechaValidacion) {
		this.fechaValidacion = fechaValidacion;
	}
	public int getCVV() {
		return CVV;
	}
	public void setCVV(int cVV) {
		CVV = cVV;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	

}
