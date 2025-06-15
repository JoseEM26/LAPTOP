package com.Practica2.fig.Ip.Aplication2.SpingBootID.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Practica2.fig.Ip.Aplication2.SpingBootID.Model.Productos;
import com.Practica2.fig.Ip.Aplication2.SpingBootID.Services.Serv_Productos;


@RestController
@RequestMapping("/api")
public class ProductoController {
 
    @Autowired
    private Serv_Productos servicio ;

    @GetMapping()
    public List<Productos> listaProductos() {
        return servicio.FindALL();
    }

    @GetMapping("/{idProducto}")
    public Productos Mostrar(@PathVariable Long idProducto) {

        return servicio.BuscaID(idProducto);
    }

}
