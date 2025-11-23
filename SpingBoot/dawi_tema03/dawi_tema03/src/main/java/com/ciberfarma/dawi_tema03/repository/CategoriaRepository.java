package com.ciberfarma.dawi_tema03.repository;

import com.ciberfarma.dawi_tema03.model.Categoria;
import com.ciberfarma.dawi_tema03.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
