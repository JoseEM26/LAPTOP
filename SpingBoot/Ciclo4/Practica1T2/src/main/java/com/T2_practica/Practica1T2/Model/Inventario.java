package com.T2_practica.Practica1T2.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_inventario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventario {
    @Id
    @Column(name = "numero")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    @Column(name = "fecha_vencimiento")
    private LocalDate fechaNacimiento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @Column(name = "costo_ingreso")
    private Double costoIngreso;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "lote")
    private String lote;
    @Column(name = "cod_estado")
    private String codEstado;

}
