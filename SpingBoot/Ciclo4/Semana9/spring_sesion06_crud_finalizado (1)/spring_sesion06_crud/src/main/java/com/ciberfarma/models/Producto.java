package com.ciberfarma.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_productos")
public class Producto {
	
	@Id
	@Column(name = "id_prod")
	private String codProducto;
	
	@Column(name = "des_prod", nullable = false)
	private String descripcion;
	
	@Column(name = "stk_prod", nullable = false)
	private int stock;
	
	@Column(name = "pre_prod", nullable = false)
	private double precio;
	
	@Column(name = "est_prod", nullable = false)
	private int idEstado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategoria")
	private Categoria categoria;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproveedor")
	private Proveedor proveedor;

}
