package com.ciberfarma.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoSeleccionado {
	
	@NotEmpty(message = "Seleccione un producto")
	private String codProducto;
	private String descripcion;

	@NotNull(message = "El precio es requerido")
	@Positive(message = "El precio debe ser mayor a 0")
	private double precio;
	
	@NotNull(message = "La cantidad es requerida")
	@Positive(message = "Mínimo 1")
	private int cantidad;

	public Double getSubtotal() {
		return precio * cantidad;
	}
}
