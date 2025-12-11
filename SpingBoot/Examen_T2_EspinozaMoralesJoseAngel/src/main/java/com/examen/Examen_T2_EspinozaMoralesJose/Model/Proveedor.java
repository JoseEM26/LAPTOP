package com.examen.Examen_T2_EspinozaMoralesJose.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_proveedor")
@Data
public class Proveedor {
    @Id
    private Integer idproveedor;
    private String nombre_rs;
    private String telefono;
    private String email;
}
