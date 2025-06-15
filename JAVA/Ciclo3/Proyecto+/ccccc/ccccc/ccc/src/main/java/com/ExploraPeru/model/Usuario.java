package com.ExploraPeru.model;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String email;
    private String contraseña;
    private int idRol;
    private String fechaCreacion;
    private String fechaCumpleaños;
    private String img;
    private String telefono;

    // Constructor vacío
    public Usuario() {
    }

   

    public Usuario(int idUsuario, String nombreUsuario, String email, String contraseña, int idRol,
			String fechaCreacion, String fechaCumpleaños, String img, String telefono) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contraseña = contraseña;
		this.idRol = idRol;
		this.fechaCreacion = fechaCreacion;
		this.fechaCumpleaños = fechaCumpleaños;
		this.img = img;
		this.telefono = telefono;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	// Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    public String getFechaCumpleaños() {
        return fechaCumpleaños;
    }

    public void setFechaCumpleaños(String fechaCumpleaños) {
        this.fechaCumpleaños = fechaCumpleaños;
    }

 
}

