package com.ExploraPeru.model;

public class Destinos {
	private int idDestino;
	private String destino; // Cambiado de 'origen' a 'destino'
	private String descripcion; // Agregado 'descripcion' para mayor detalle.

	// Constructor
	public Destinos(int idDestino, String destino, String descripcion) {
		this.idDestino = idDestino;
		this.destino = destino;
		this.descripcion = descripcion;
	}

	public Destinos() {
		// TODO Auto-generated constructor stub
	}

	// Getters y Setters
	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
