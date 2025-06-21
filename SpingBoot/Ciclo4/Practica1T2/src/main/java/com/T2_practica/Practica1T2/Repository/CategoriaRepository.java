package com.T2_practica.Practica1T2.Repository;

import com.T2_practica.Practica1T2.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria ,Integer> {

}
