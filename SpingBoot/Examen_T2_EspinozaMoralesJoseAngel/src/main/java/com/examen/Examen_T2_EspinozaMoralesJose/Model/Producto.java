package com.examen.Examen_T2_EspinozaMoralesJose.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_productos")
@Data
public class Producto {

    @Id
    private String id_prod;

    private String des_prod;
    private Integer stk_prod;
    private Double pre_prod;
    private Integer est_prod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor")
    private Proveedor proveedor;

}