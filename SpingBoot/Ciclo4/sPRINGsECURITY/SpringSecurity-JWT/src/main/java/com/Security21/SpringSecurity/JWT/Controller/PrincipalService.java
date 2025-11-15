package com.Security21.SpringSecurity.JWT.Controller;

import com.Security21.SpringSecurity.JWT.Model.ERole;
import com.Security21.SpringSecurity.JWT.Model.Request.CreateUserDTO;
import com.Security21.SpringSecurity.JWT.Model.RoleEntity;
import com.Security21.SpringSecurity.JWT.Model.UserEntity;
import com.Security21.SpringSecurity.JWT.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PrincipalService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository repository;

    @GetMapping("/hello")
    public String Hello(){
        return "HelloWord";
    }

    @PostMapping("/verCreate")
    public CreateUserDTO VerCreate(@Valid @RequestBody CreateUserDTO createUserDTO){
        return createUserDTO;

    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){
        UserEntity userEntity=new UserEntity();
        userEntity.setEmail(createUserDTO.getEmail());
        userEntity.setPassword(passwordEncoder.encode(createUserDTO.getPassword() ));
        userEntity.setUsername(createUserDTO.getUsername());

        Set<RoleEntity> roleEntities = createUserDTO.getRole().stream()
                .map(role -> new RoleEntity(ERole.valueOf(role)))
                .collect(Collectors.toSet());

        userEntity.setRoles(roleEntities);

        repository.save(userEntity);
        return ResponseEntity.ok("Se creo correctamente el Usuario");
    }
    @DeleteMapping("/delete")
    public String Delete(@RequestParam String id){
        repository.deleteById(Long.valueOf(id));
        return "Se a borrado corerectamente";
    }
}

