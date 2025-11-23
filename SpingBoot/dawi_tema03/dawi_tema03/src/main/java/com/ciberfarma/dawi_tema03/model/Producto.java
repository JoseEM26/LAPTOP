package com.ciberfarma.dawi_tema03.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_productos")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Producto {
    @Id
    private String id_prod;

    private String des_prod;
    private int stk_prod;
    private double pre_prod;

    private Integer idcategoria;
    private Integer idproveedor;
    private Integer est_prod = 1;

}