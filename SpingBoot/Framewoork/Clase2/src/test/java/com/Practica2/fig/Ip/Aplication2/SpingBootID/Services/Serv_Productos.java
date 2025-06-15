package com.Practica2.fig.Ip.Aplication2.SpingBootID.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Practica2.fig.Ip.Aplication2.SpingBootID.Model.Productos;
import com.Practica2.fig.Ip.Aplication2.SpingBootID.Repositorios.Repo_Productos;

@Component
public class Serv_Productos {

   // ✅ Pasamos una lista vacía al constructor de Repo_Productos
   @Autowired
   private Repo_Productos Repositorio;

   public List<Productos> FindALL() {
    return Repositorio.FindALL().stream()
        .map(p -> {
            Double valor = p.getPrecio() * 1.50d;
            p.setPrecio(valor.intValue()); // ✅ Conversión correcta de double a int
            return p;
        }).collect(Collectors.toList()); // ✅ Corrección en `.collect()`
}

    public Productos BuscaID(Long idProducto) {
        return Repositorio.BuscaID(idProducto);
    }
}
