package com.ExploraPeru.model;

public class Vuelos {
	private int idVuelo;
	private int idDestino; // Se mantiene el atributo idDestino para la relación con DESTINOS
	private String fechaSalida;
	private String fechaLlegada;
	private double precio;
	private int plazasDisponibles;
	private String imagenUrl; // Nueva propiedad para la URL de la imagen del vuelo
	private String lugar; // Nueva propiedad para el lugar o ciudad de destino

	// Constructor con todos los parámetros, incluyendo idDestino, imagenUrl y lugar
	public Vuelos(int idVuelo, int idDestino, String fechaSalida, String fechaLlegada, double precio,
			int plazasDisponibles, String imagenUrl, String lugar) {
		this.idVuelo = idVuelo;
		this.idDestino = idDestino;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.precio = precio;
		this.plazasDisponibles = plazasDisponibles;
		this.imagenUrl = imagenUrl;
		this.lugar = lugar;
	}

	// Constructor sin parámetros
	public Vuelos() {
		// Constructor vacío
	}

	// Getters y Setters
	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPlazasDisponibles() {
		return plazasDisponibles;
	}

	public void setPlazasDisponibles(int plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
}
