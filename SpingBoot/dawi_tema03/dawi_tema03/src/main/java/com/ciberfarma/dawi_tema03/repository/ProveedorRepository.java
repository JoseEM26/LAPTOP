package com.ciberfarma.dawi_tema03.repository;

import com.ciberfarma.dawi_tema03.model.Producto;
import com.ciberfarma.dawi_tema03.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Integer> {
}
