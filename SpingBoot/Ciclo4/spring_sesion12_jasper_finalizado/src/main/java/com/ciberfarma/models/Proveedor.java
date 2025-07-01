package com.ciberfarma.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "tb_proveedor")
public class Proveedor {
	
	@Id
	@Column(name = "idproveedor")
	private int idProveedor;
	
	@Column(name = "nombre_rs")
	private String razonSocial;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String correo;

//	@Override
//    public String toString() {
//        return razonSocial;
//    }
}
