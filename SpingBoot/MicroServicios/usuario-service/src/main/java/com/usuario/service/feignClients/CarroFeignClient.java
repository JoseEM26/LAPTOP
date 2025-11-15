package com.usuario.service.feignClients;

import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "carro-service" , url = "http://localhost:8082")
public interface CarroFeignClient {
    @PostMapping("/carro")
    public Carro save(@RequestBody Carro carro);
    @GetMapping("/carro/usuario/{usuarioId}")
    public List<Carro> getCarros(@PathVariable Integer usuarioId);
}
