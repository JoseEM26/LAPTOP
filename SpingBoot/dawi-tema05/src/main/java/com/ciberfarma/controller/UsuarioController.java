package com.ciberfarma.controller;

import com.ciberfarma.config.JwtUtil;
import com.ciberfarma.model.Usuario;
import com.ciberfarma.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService _UsuarioService;
    private final JwtUtil _util;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario){
        try {
            Usuario nuevo=_UsuarioService.registrarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario){
        try {
            Usuario encontrado=_UsuarioService.login(usuario);

            String rol=(encontrado.getIdtipo()==1)?"ADMIN":"USER";
            String token=_util.generarToken(encontrado.getCorreo(),rol);

            return ResponseEntity.ok(Map.of(
                    "TOKEN : ",token,
                    "USUARIO: ",usuario.getCorreo(),
                    "ROL" , rol
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NO EXISTE EL USUARIO!!! CHAUUU BEBE!!");
        }
    }



}
