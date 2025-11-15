package com.moto.service.Repository;

import com.moto.service.Entidades.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto,Integer> {

    List<Moto> findByUsuarioId(Integer usuarioId);
}
