package com.examenT2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenT2.dtos.ResultadoResponse;
import com.examenT2.models.Inventario;
import com.examenT2.repositories.IInventarioRepository;

@Service
public class InventarioService {

	@Autowired
	private IInventarioRepository _inventarioRepository;

	public List<Inventario> getAll() {
		return _inventarioRepository.findAllByOrderByNumeroDesc();
	}

	public ResultadoResponse create(Inventario inventario) {
		try {
			Inventario registrado = _inventarioRepository.save(inventario);

			String mensaje = String.format("Inventario nro. %s registrado", registrado.getNumero());
			return new ResultadoResponse(true, mensaje);

		} catch (Exception ex) {
			return new ResultadoResponse(false, "Error al registrar: " + ex.getMessage());
		}
	}

	public Inventario getOne(int id) {
		return _inventarioRepository.findById(id).orElseThrow();
	}
	
	public ResultadoResponse update(Inventario inventario) {
		try {
			Inventario registrado = _inventarioRepository.save(inventario);

			String mensaje = String.format("Inventario nro. %s actualizado", registrado.getNumero());
			return new ResultadoResponse(true, mensaje);

		} catch (Exception ex) {
			return new ResultadoResponse(false, "Error al actualizar: " + ex.getMessage());
		}
	}
}
