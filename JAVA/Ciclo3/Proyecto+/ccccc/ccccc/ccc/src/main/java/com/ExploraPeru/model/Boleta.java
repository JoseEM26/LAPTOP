package com.ExploraPeru.model;

public class Boleta {
	private String num_bol;
	private String fch_bol;
	private int id_usuario;
	public Boleta(String num_bol, String fch_bol, int id_usuario) {
		super();
		this.num_bol = num_bol;
		this.fch_bol = fch_bol;
		this.id_usuario = id_usuario;
	}
	
	
	public Boleta() {
		super();
	}


	public String getNum_bol() {
		return num_bol;
	}
	public void setNum_bol(String num_bol) {
		this.num_bol = num_bol;
	}
	public String getFch_bol() {
		return fch_bol;
	}
	public void setFch_bol(String fch_bol) {
		this.fch_bol = fch_bol;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	
}
