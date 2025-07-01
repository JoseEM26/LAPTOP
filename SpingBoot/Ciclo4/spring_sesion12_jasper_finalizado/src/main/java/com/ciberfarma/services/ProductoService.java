package com.ciberfarma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciberfarma.dtos.ProductoFilter;
import com.ciberfarma.dtos.ResultadoResponse;
import com.ciberfarma.models.Producto;
import com.ciberfarma.repositories.IProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private IProductoRepository _productoRepository;

	public List<Producto> getAll() {
		return _productoRepository.findAllByOrderByCodProductoDesc();
	}

	public List<Producto> search(ProductoFilter filtro) {
		return _productoRepository.findAllWithFilters(filtro.getIdCategoria(), filtro.getIdProveedor());
	}

	public ResultadoResponse create(Producto producto) {
		try {
			Producto registrado = _productoRepository.save(producto);

			String mensaje = String.format("Producto con código %s registrado", registrado.getCodProducto());
			return new ResultadoResponse(true, mensaje);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResultadoResponse(false, "Error al registrar: " + ex.getMessage());
		}
	}

	public Producto getOne(String id) {
		return _productoRepository.findById(id).orElseThrow();
	}

	public ResultadoResponse update(Producto producto) {
		try {
			Producto registrado = _productoRepository.save(producto);

			String mensaje = String.format("Producto con código %s actualizado", registrado.getCodProducto());
			return new ResultadoResponse(true, mensaje);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResultadoResponse(false, "Error al actualizar: " + ex.getMessage());
		}
	}

	public ResultadoResponse cambiarEstado(String id) {

		Producto producto = this.getOne(id);
		String accion = producto.getIdEstado() ? "desactivado" : "activado";

		producto.setIdEstado(!producto.getIdEstado());

		try {
			Producto registrado = _productoRepository.save(producto);

			String mensaje = String.format("Producto con código %s %s", registrado.getCodProducto(), accion);
			return new ResultadoResponse(true, mensaje);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResultadoResponse(false, "Error al cambiar de estado: " + ex.getMessage());
		}
	}
	
	public List<Producto> getActivos() {
		return _productoRepository.findAllByIdEstado(true);
	}
}
