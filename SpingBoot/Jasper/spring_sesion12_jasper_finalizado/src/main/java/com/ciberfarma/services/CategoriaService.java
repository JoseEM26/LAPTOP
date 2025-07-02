package com.ciberfarma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciberfarma.models.Categoria;
import com.ciberfarma.repositories.ICategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private ICategoriaRepository _categoriaRepository;

	public List<Categoria> getAll() {
		return _categoriaRepository.findAll();
	}
}
