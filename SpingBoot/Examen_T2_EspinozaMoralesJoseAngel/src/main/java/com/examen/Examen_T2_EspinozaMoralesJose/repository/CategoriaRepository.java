package com.examen.Examen_T2_EspinozaMoralesJose.repository;

import com.examen.Examen_T2_EspinozaMoralesJose.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria,Integer> {
}
