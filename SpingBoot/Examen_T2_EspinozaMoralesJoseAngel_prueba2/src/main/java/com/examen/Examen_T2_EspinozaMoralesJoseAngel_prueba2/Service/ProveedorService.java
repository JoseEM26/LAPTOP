package com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Service;

import com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Model.Categorias;
import com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Model.Proveedor;
import com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Repository.CategoriasRepository;
import com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    private final ProveedorRepository _ProveedorRepository;

    public List<Proveedor> listaProducto(){
        return _ProveedorRepository.findAll();
    }
}
