package com.Jasper.JasperDocument.Repository;

import com.Jasper.JasperDocument.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Integer> {
    List<Persona> findByNombreContainingIgnoreCase(String nombre);

}
