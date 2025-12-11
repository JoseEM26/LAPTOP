package com.examen.Examen_T2_EspinozaMoralesJose.service;

import com.examen.Examen_T2_EspinozaMoralesJose.Model.Categoria;
import com.examen.Examen_T2_EspinozaMoralesJose.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository _CategoriaRepository;

    public List<Categoria> listarCategoria(){
        return _CategoriaRepository.findAll();
    }
}
