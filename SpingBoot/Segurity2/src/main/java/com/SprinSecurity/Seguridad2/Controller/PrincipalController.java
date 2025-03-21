package com.SprinSecurity.Seguridad2.Controller;

import com.SprinSecurity.Seguridad2.Controller.Request.CreateUserDTO;
import com.SprinSecurity.Seguridad2.Model.ERole;
import com.SprinSecurity.Seguridad2.Model.RoleEntity;
import com.SprinSecurity.Seguridad2.Model.UserEntity;
import com.SprinSecurity.Seguridad2.Repository.UserRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PrincipalController {

    @Autowired
    UserRespository userRespository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/helloSecurity")
    public String helloSecurited() {
        return "Hello World Securited";
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(createUserDTO.getEmail());
        userEntity.setPassword(createUserDTO.getPassword());
        userEntity.setUsername(createUserDTO.getUsername());

        Set<RoleEntity> roles = createUserDTO.getRole().stream()
                    .map(role -> new RoleEntity(ERole.valueOf(role)))
                .collect(Collectors.toSet());

        userEntity.setRoles(roles);

        userRespository.save(userEntity);

        return ResponseEntity.ok("Usuario creado correctamente" + userEntity);
    }

    @DeleteMapping("/delete")
    public String Delete(@RequestParam String id){
        userRespository.deleteById(Long.valueOf(id));
        return "Se a borrado corerectamente";
    }
}
