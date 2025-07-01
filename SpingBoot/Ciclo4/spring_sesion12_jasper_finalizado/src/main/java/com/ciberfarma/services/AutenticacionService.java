package com.ciberfarma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciberfarma.dtos.AutentacionFilter;
import com.ciberfarma.models.Usuario;
import com.ciberfarma.repositories.IUsuarioRepository;

@Service
public class AutenticacionService {

	@Autowired
	private IUsuarioRepository _usuarioRepository;

	public Usuario autenticar(AutentacionFilter filter) {
		return _usuarioRepository.findByUsuarioAndPassword(filter.getUsuario(), filter.getPassword());
	}
}
