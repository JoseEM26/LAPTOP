package com.ciberfarma.dawi_tema03.service;

import com.ciberfarma.dawi_tema03.model.Categoria;
import com.ciberfarma.dawi_tema03.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository _CategoriaRepository;

    public List<Categoria> cboCategoria(){
        return _CategoriaRepository.findAll();
    }
}
