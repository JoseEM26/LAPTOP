package com.ciberfarma.service;

import com.ciberfarma.model.Usuario;
import com.ciberfarma.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private IUsuarioRepository repoUsua;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registrarUsuario(Usuario usuario) {
        String claveCodificada = passwordEncoder.encode(usuario.getClave());
        usuario.setClave(claveCodificada);
        return repoUsua.save(usuario);
    }

    public Usuario login(Usuario usuario){
        Usuario encontrado= repoUsua.findByCorreo(usuario.getCorreo())
                .orElseThrow(()->new RuntimeException("Usuario no encontrado"));
        if(!passwordEncoder.matches(usuario.getClave(),encontrado.getClave())){
            throw  new RuntimeException("Contraseña incorretca");
        }
        return encontrado;
    }
}
