package com.carro.service.Service;

import com.carro.service.Entidades.Carro;
import com.carro.service.Repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository _caCarroRepository;

    public List<Carro> listarCarro(){
        return _caCarroRepository.findAll();
    }

    public Carro getCarroByID(Integer id){
        return _caCarroRepository.findById(id).orElseThrow(null);
    }

    public Carro createCarro(Carro newCarro){
        Carro carro=_caCarroRepository.save(newCarro);
        return carro;
    }

    public List<Carro> byUsuarioId(Integer usuarioId){
        return _caCarroRepository.findByUsuarioId(usuarioId);
    }

}
