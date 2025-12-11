package com.ciberfarma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciberfarma.model.Producto;
import com.ciberfarma.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@GetMapping
	public ResponseEntity<List<Producto>> listarTodos(){
		
		List<Producto> productos = service.listarTodos(); 
		// validar
		if (productos.isEmpty()) {
			return ResponseEntity.noContent().build(); // solo envía status
		}
		return ResponseEntity.ok(productos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> obtenerPorId(@PathVariable String id) {
		Producto producto = service.obtenerPorId(id);
		if (producto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(producto);
	}
	
	@PostMapping("/grabar")
	public Producto agregarProducto(@RequestBody Producto nuevo) {
		return service.agregarProducto(nuevo);
	}
	
	
	
}





