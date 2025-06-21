package com.examenT2.models;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "tbl_inventario")
@Getter
@Setter
@DynamicInsert
public class Inventario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero")
	private int numero;

	@Column(name = "fecha_vencimiento", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaVencimiento;

	@JoinColumn(name = "id_producto", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Producto producto;

	@Column(name = "costo_ingreso", nullable = false)
	private Double costoIngreso;

	@Column(name = "cantidad")
	private Integer cantidad;

	@Column(name = "lote")
	private String lote;

	@Column(name = "cod_estado", nullable = false)
	private String codEstado;

	public String getNomEstado() {
		switch (codEstado) {
		case "A":
			return "Activo";
		case "V":
			return "Vencido";
		case "T":
			return "En tránsito";
		case "B":
			return "Bloqueado";
		default:
			return "Desconocido";
		}
	}
}
