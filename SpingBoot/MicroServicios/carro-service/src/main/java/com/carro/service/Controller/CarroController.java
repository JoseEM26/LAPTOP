package com.carro.service.Controller;

import com.carro.service.Entidades.Carro;
import com.carro.service.Service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService _CarroService;

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarro(){
        List<Carro> lista=_CarroService.listarCarro();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> obtenerCarro(@PathVariable Integer id){
        Carro usuario=_CarroService.getCarroByID(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Carro> createCarro(@RequestBody Carro usuario){
        Carro usuarioDBB= _CarroService.createCarro(usuario);
        return ResponseEntity.ok(usuarioDBB);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarroByUsuario(@PathVariable Integer usuarioId){
        List<Carro> lista= _CarroService.byUsuarioId(usuarioId);
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }
}
