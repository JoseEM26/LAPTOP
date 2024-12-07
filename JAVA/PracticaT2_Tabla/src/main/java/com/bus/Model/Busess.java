package com.bus.Model;

public class Busess {
	private int id_bus;
	private String nom_choferes;
	private String Ape_choferes;
	private int num_choferes;
	
	
	
	public Busess() {
		super();
	}



	public Busess(int id_bus, String nom_choferes, String ape_choferes, int num_choferes) {
		super();
		this.id_bus = id_bus;
		this.nom_choferes = nom_choferes;
		Ape_choferes = ape_choferes;
		this.num_choferes = num_choferes;
	}



	public int getId_bus() {
		return id_bus;
	}



	public void setId_bus(int id_bus) {
		this.id_bus = id_bus;
	}



	public String getNom_choferes() {
		return nom_choferes;
	}



	public void setNom_choferes(String nom_choferes) {
		this.nom_choferes = nom_choferes;
	}



	public String getApe_choferes() {
		return Ape_choferes;
	}



	public void setApe_choferes(String ape_choferes) {
		Ape_choferes = ape_choferes;
	}



	public int getNum_choferes() {
		return num_choferes;
	}



	public void setNum_choferes(int num_choferes) {
		this.num_choferes = num_choferes;
	}
	
	
}
