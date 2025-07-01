package com.ciberfarma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.models.Proveedor;

public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {

}
