package com.ciberfarma.dawi_tema03.service;

import com.ciberfarma.dawi_tema03.model.Proveedor;
import com.ciberfarma.dawi_tema03.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    private final ProveedorRepository _ProveedorRepository;

    public List<Proveedor> cboProveedor(){
    return _ProveedorRepository.findAll();
    }
}
