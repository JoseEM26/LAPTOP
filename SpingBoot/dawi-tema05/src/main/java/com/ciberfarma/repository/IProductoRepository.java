package com.ciberfarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciberfarma.model.Producto;

@Repository
public interface IProductoRepository 
	extends JpaRepository<Producto, String>{

	
}
