package SpringSecurity_lll.Security_lll.Controller;

import SpringSecurity_lll.Security_lll.Model.CreateUserDTO;
import SpringSecurity_lll.Security_lll.Model.ERole;
import SpringSecurity_lll.Security_lll.Model.RolEntity;
import SpringSecurity_lll.Security_lll.Model.UserEntity;
import SpringSecurity_lll.Security_lll.Repository.RoleRepository;
import SpringSecurity_lll.Security_lll.Repository.UserRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PrincipalController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/hello")
    public String hello(){
        return "Hello WORD";
    }
    @GetMapping("/helloWithoutSecurity")
    public String helloSInSeguridad(){
        return "Hello WORD without Security";
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> CreateNewUsur(@Valid @RequestBody CreateUserDTO createUserDTO){
        UserEntity user= new UserEntity();
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        user.setUsername(createUserDTO.getUsername());

        Set<RolEntity> roles= createUserDTO.getRoles().stream()
                .map(role -> roleRepository.findByName(ERole.valueOf(role))
                        .orElseThrow(() -> new RuntimeException("Error: Rol " + role + " no encontrado."))).collect(Collectors.toSet());
        user.setRoles(roles);

        userRepository.save(user);
        return ResponseEntity.ok("Se Creo correctamente el usuario");
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> DeleteUser(@PathVariable Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
          return ResponseEntity.ok("Se Elimino Correctamente");
        }else{
            return ResponseEntity.badRequest().body("No se Encontro El id");
        }

    }
}
