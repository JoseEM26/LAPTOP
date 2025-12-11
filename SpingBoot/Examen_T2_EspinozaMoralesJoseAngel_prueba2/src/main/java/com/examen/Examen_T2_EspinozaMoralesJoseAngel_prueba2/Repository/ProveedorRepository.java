package com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Repository;

import com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Integer> {
}
