package com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Repository;

import com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias,Integer> {
}
