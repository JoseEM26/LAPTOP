package com.moto.service.Service;

import com.moto.service.Entidades.Moto;
import com.moto.service.Repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository _MotoRepository;

    public List<Moto> listarCarro(){
        return _MotoRepository.findAll();
    }

    public Moto getCarroByID(Integer id){
        return _MotoRepository.findById(id).orElseThrow(null);
    }

    public Moto createCarro(Moto newCarro){
        Moto carro=_MotoRepository.save(newCarro);
        return carro;
    }

    public List<Moto> byUsuarioId(Integer usuarioId){
        return _MotoRepository.findByUsuarioId(usuarioId);
    }

}
