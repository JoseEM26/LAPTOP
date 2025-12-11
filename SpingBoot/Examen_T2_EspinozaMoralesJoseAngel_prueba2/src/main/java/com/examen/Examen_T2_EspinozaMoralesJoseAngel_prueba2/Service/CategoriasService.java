package com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Service;

import com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Model.Categorias;
import com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Model.Producto;
import com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Repository.CategoriasRepository;
import com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriasService {
    private final CategoriasRepository _CategoriasRepository;

    public List<Categorias> listaProducto(){
        return _CategoriasRepository.findAll();
    }
}
