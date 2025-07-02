package com.Jasper.JasperDocument.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private int edad;
}
