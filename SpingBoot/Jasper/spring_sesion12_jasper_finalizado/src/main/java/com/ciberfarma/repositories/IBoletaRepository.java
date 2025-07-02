package com.ciberfarma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.models.Boleta;

public interface IBoletaRepository extends JpaRepository<Boleta, Integer> {
	List<Boleta> findAllByOrderByNumBoletaDesc();
}
