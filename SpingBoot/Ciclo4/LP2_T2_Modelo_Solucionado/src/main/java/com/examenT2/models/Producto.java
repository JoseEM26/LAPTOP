package com.examenT2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "tbl_producto")
@Getter @Setter
public class Producto {
	
	@Id
	@Column(name = "id")
	private int Id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@JoinColumn(name = "id_categoria")
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;
	
	@Column(name = "stock_maximo")
	private int stockMaximo;
	
	@Column(name = "stock_actual")
	private int stockActual;
}
