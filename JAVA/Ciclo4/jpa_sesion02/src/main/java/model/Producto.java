package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	@Id
	@Column(name = "id_prod")
	private String idProducto;

	@Column(name = "des_prod")
	private String descripcion;

	@Column(name = "stk_prod")
	private int stock;

	@Column(name = "pre_prod")
	private double precio;

	@Column(name = "est_prod")
	private int estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategoria")
	private Categoria categoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproveedor")
	private Proveedor proveedor;
}
