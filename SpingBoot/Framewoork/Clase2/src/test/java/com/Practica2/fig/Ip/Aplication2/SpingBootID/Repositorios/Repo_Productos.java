package com.Practica2.fig.Ip.Aplication2.SpingBootID.Repositorios;

import java.util.ArrayList;
import java.util.List;
import com.Practica2.fig.Ip.Aplication2.SpingBootID.Model.Productos;

public class Repo_Productos{
    private List<Productos> datos;

    public Repo_Productos() {
        this.datos = new ArrayList<>(); // Se inicializa como lista dinámica
        datos.add(new Productos(11L, "Jose", 100));
        datos.add(new Productos(12L, "USB", 111));
        datos.add(new Productos(13L, "Laptop", 200));
        datos.add(new Productos(14L, "Monitor", 11200));
    }

    public List<Productos> FindALL() {
        return datos;
    }

    public Productos BuscaID(Long idProducto) {
        return datos.stream()
                    .filter(p -> p.getIdProducto() == idProducto)
                    .findFirst()
                    .orElse(null);
    }
}
