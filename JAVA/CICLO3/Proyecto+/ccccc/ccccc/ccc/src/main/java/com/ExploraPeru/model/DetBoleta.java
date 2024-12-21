package com.ExploraPeru.model;

public class DetBoleta {
	private String num_bol;
    private int id_destino;
    private double preciovta;
    private int cantidad;
	public DetBoleta(String num_bol, int id_destino, double preciovta, int cantidad) {
		super();
		this.num_bol = num_bol;
		this.id_destino = id_destino;
		this.preciovta = preciovta;
		this.cantidad = cantidad;
	}
	public DetBoleta() {
		super();
	}
	public String getNum_bol() {
		return num_bol;
	}
	public void setNum_bol(String num_bol) {
		this.num_bol = num_bol;
	}
	public int getId_destino() {
		return id_destino;
	}
	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}
	public double getPreciovta() {
		return preciovta;
	}
	public void setPreciovta(double preciovta) {
		this.preciovta = preciovta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
    
    
}
