package com.examen.Examen_T2_EspinozaMoralesJose.repository;

import com.examen.Examen_T2_EspinozaMoralesJose.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,String> {
}
