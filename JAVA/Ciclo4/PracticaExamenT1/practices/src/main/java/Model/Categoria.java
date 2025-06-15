package Model;

import javax.persistence.*;

import lombok.*;
@Entity
@Table(name = "tbl_categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private int idCategoria;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Override
    public String toString() {
        return descripcion;
    }
}
