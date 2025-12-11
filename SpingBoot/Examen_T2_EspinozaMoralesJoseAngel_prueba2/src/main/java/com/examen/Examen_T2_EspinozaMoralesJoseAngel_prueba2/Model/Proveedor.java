package com.examen.Examen_T2_EspinozaMoralesJoseAngel_prueba2.Model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "tb_proveedor")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproveedor;
    private String email;
    private String nombre_rs;
    private String telefono;
}
