package com.trabajador.model;

public class Trabajador {
	   private int dni;
	   private String nombre;
	   private String apellido;
	   private int edad;
	   private String direccion;
	   private String fechaNacimiento;
	public Trabajador() {
		super();
	}
	public Trabajador(int dni, String nombre, String apellido, int edad, String direccion, String fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	   
	   
}
