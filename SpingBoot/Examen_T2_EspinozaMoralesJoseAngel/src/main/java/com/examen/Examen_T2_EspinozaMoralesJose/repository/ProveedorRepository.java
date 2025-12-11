package com.examen.Examen_T2_EspinozaMoralesJose.repository;

import com.examen.Examen_T2_EspinozaMoralesJose.Model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Integer> {
}
