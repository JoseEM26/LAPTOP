package com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    private String id_prod;
    private String des_prod;
    private Integer est_prod;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    private Categorias categoria;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor")
    private Proveedor proveedor;
    private Double pre_prod;
    private Integer stk_prod;
}
