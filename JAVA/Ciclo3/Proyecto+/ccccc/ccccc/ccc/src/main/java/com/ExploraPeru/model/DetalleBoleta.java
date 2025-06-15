package com.ExploraPeru.model;

public class DetalleBoleta {
	private int idViaje;
	private double precio;
	private int cantidad;
	private String nombreViaje;
	private double importe;
	private String fechaSalida;
	private String urlImg;
	private String num_bol;
	public DetalleBoleta(int idViaje, double precio, int cantidad, String nombreViaje, double importe,
			String fechaSalida, String urlImg, String num_bol) {
		super();
		this.idViaje = idViaje;
		this.precio = precio;
		this.cantidad = cantidad;
		this.nombreViaje = nombreViaje;
		this.importe = importe;
		this.fechaSalida = fechaSalida;
		this.urlImg = urlImg;
		this.num_bol = num_bol;
	}
	public DetalleBoleta() {
		super();
	}
	public int getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombreViaje() {
		return nombreViaje;
	}
	public void setNombreViaje(String nombreViaje) {
		this.nombreViaje = nombreViaje;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	public String getNum_bol() {
		return num_bol;
	}
	public void setNum_bol(String num_bol) {
		this.num_bol = num_bol;
	}
	
}