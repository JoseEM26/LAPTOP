package com.Security21.SpringSecurity.JWT.Service;

import com.Security21.SpringSecurity.JWT.Model.UserEntity;
import com.Security21.SpringSecurity.JWT.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {  // ✅ Nombre corregido


    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no se encontró"));

        // ✅ Se corrige el tipo de datos: Set<GrantedAuthority>
        Set<GrantedAuthority> authorities = userEntity.getRoles().stream()
                .map(roleEntity -> new SimpleGrantedAuthority(
                        String.format("ROLE_%s", roleEntity.getName().name()) // ✅ Corrección en la concatenación
                ))
                .collect(Collectors.toSet());

        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                true, true, true, true,
                authorities // ✅ Se usa el Set de roles correctamente
        );
    }
}
