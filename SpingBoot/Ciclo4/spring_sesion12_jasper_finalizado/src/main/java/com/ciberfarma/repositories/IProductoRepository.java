package com.ciberfarma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ciberfarma.models.Producto;

public interface IProductoRepository extends JpaRepository<Producto, String> {

	List<Producto> findAllByOrderByCodProductoDesc();

	List<Producto> findAllByCategoria_IdCategoriaOrderByCodProductoDesc(Integer idCategoria);

	@Query("""
			select p from Producto p
			where 
				(:idCategoria is null or p.categoria.idCategoria = :idCategoria)
				and
				(:idProveedor is null or p.proveedor.idProveedor = :idProveedor)
			order by
				p.codProducto desc
			""")
	List<Producto> findAllWithFilters(@Param("idCategoria") Integer idCategoria, @Param("idProveedor") Integer idProveedor);
	
	List<Producto> findAllByIdEstado(Boolean idEstado);
}
