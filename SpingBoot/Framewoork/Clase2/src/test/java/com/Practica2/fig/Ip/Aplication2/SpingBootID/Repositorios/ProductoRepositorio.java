package com.Practica2.fig.Ip.Aplication2.SpingBootID.Repositorios;

import java.util.ArrayList;
import java.util.List;

import com.Practica2.fig.Ip.Aplication2.SpingBootID.Model.Productos;

public interface ProductoRepositorio {

    List<Productos> findAll();

    Productos BuscarID(Long idProducto);


}
