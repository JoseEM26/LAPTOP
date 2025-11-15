package com.moto.service.Controller;

import com.moto.service.Entidades.Moto;
import com.moto.service.Service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoService _MotoService;

    @GetMapping
    public ResponseEntity<List<Moto>> listarMoto(){
        List<Moto> lista=_MotoService.listarCarro();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Moto> obtenerMoto(@PathVariable Integer usuarioId){
        Moto usuario=_MotoService.getCarroByID(usuarioId);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Moto> createMoto(@RequestBody Moto usuario){
        Moto usuarioDBB= _MotoService.createCarro(usuario);
        return ResponseEntity.ok(usuarioDBB);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotoByUsuario(@PathVariable Integer usuarioId){
        List<Moto> lista= _MotoService.byUsuarioId(usuarioId);
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }
}
