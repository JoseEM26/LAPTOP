package com.ciberfarma.model;

import java.util.Date;

import lombok.Data;

@Data
public class Usuario {
	private int codigo;
	private String nombre;
	private String apellido;
	private String usuario;
	private String clave;
	private Date fnacim;
	private int tipo;
	private int estado; 
}
