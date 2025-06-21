package com.ciberfarma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.models.Producto;

public interface IProductoRepository extends JpaRepository<Producto, String> {
	List<Producto> findAllByOrderByCodProductoDesc();
}
