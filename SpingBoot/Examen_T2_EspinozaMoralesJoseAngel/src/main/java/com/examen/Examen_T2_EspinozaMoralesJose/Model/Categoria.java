package com.examen.Examen_T2_EspinozaMoralesJose.Model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "tb_categorias")
@Data
public class Categoria {
    @Id
    private Integer idcategoria;
    private String descripcion;
}

