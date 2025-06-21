package com.T2_practica.Practica1T2.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "descripcion",nullable = false)
    private String descripcion;
    @Column(name = "frecuencia_compra")
    private String frecuencia;

}
