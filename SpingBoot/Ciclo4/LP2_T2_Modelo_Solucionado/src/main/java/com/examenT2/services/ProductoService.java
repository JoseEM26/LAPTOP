package com.examenT2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenT2.models.Producto;
import com.examenT2.repositories.IProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private IProductoRepository _productoRepository;

	public List<Producto> getAll() {
		return _productoRepository.findAllByOrderByNombre();
	}
}
