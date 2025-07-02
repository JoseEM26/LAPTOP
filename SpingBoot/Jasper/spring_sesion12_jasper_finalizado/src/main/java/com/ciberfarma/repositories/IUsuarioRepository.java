package com.ciberfarma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.models.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	Usuario findByUsuarioAndPassword(String usuario, String password);
}
