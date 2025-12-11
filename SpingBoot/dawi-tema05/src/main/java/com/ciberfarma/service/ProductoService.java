package com.ciberfarma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciberfarma.model.Producto;
import com.ciberfarma.repository.IProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private IProductoRepository repoProd;
	
	public List<Producto> listarTodos(){
		return repoProd.findAll();
	}
	
	public Producto obtenerPorId(String id) {
		return repoProd.findById(id).orElse(null);
	}
	
	public Producto agregarProducto(Producto nuevo) {
		return repoProd.save(nuevo);
	}
	
}
