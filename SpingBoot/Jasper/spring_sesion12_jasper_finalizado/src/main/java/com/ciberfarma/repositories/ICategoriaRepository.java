package com.ciberfarma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.models.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
