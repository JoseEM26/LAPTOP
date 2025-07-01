package com.ciberfarma.models;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@Table(name = "tb_productos")
public class Producto {

	@Id
	@Column(name = "id_prod")
	@Pattern(regexp = "P[0-9]{4}", message = "El código no tiene el formato correcto")
	private String codProducto;

	@Column(name = "des_prod", nullable = false)
	@NotBlank(message = "La descripción es requerida")
	private String descripcion;

	@Column(name = "stk_prod", nullable = false)
	@NotNull(message = "El stock es requerido")
	@PositiveOrZero(message = "El stock no puede ser negativo")
	private Integer stock;

	@Column(name = "pre_prod", nullable = false)
	@NotNull(message = "El precio es requerido")
	@Positive(message = "El precio debe ser mayor que 0")
	private Double precio;

	@Column(name = "est_prod")
	private Boolean idEstado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategoria", nullable = false)
	@NotNull(message = "Seleccione una categoría")
	private Categoria categoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproveedor", nullable = false)
	@NotNull(message = "Seleccione un proveedor")
	private Proveedor proveedor;

}
