package com.T2_practica.Practica1T2.Model;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "nombre" , nullable = false)
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_categoria" ,nullable = false)
    private Categoria categoria;
    @Column(name = "stock_maximo")
    private int stockMaximo;
    @Column(name = "stock_actual")
    private int stockActual;

}
