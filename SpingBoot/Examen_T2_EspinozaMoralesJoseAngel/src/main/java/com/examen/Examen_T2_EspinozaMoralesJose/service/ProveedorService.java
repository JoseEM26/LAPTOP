package com.examen.Examen_T2_EspinozaMoralesJose.service;

import com.examen.Examen_T2_EspinozaMoralesJose.Model.Proveedor;
import com.examen.Examen_T2_EspinozaMoralesJose.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    private final ProveedorRepository _ProveedorRepository;

    public List<Proveedor> listaProveedor(){
        return _ProveedorRepository.findAll();
    }
}
