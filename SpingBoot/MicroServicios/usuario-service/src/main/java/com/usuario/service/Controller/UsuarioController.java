package com.usuario.service.Controller;

import com.usuario.service.Entidades.Usuario;
import com.usuario.service.Service.UsuarioService;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService _UsuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> lista=_UsuarioService.listarUsuario();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Integer id){
        Usuario usuario=_UsuarioService.getUsuarioByID(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        Usuario usuarioDBB= _UsuarioService.createUsuario(usuario);
        return ResponseEntity.ok(usuarioDBB);
    }

    @GetMapping("/carro/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarros(@PathVariable Integer usuarioId){
        List<Carro> carros=_UsuarioService.getCarros(usuarioId);
        if(carros.isEmpty() || carros ==null){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/moto/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotos(@PathVariable Integer usuarioId){
        List<Moto> motos=_UsuarioService.getMotos(usuarioId);
        if(motos.isEmpty() || motos == null){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

    @PostMapping("/carro/{usuarioId}")
    public ResponseEntity<Carro> createCarro(@PathVariable Integer usuarioId, @RequestBody Carro carro){
        Carro carroDB=_UsuarioService.saveCarro(usuarioId,carro);
        return ResponseEntity.ok(carroDB);
    }
    @PostMapping("/moto/{usuarioId}")
    public ResponseEntity<Moto> createMoto(@PathVariable Integer usuarioId, @RequestBody Moto moto){
        Moto motoDB=_UsuarioService.saveMoto(usuarioId,moto);
        return ResponseEntity.ok(motoDB);
    }


    @GetMapping("/vehiculos/{usuarioId}")
    public ResponseEntity<Map<String,Object>> getVehiculoAndUsuario(@PathVariable Integer usuarioId){
        Map<String ,Object> resultado=_UsuarioService.getUsuarioAndVahiculo(usuarioId);
        return  ResponseEntity.ok(resultado);
    }



}

















