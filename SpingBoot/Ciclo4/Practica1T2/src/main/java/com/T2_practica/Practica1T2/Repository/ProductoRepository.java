package com.T2_practica.Practica1T2.Repository;

import com.T2_practica.Practica1T2.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
