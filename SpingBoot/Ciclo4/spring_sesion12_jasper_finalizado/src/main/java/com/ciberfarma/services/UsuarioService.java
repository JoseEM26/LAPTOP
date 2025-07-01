package com.ciberfarma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciberfarma.models.Usuario;
import com.ciberfarma.repositories.IUsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository _usuarioRepository;

	public Usuario getOne(Integer id) {
		return _usuarioRepository.findById(id).orElseThrow();
	}
}
