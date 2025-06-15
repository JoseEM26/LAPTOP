package Model;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "tbl_actividad")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad", nullable = false)
    @EqualsAndHashCode.Include
    private int idActividad;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false) // FK
    private Categoria categoria;

    @Column(name = "fecha_inicio", nullable = true)
    private LocalDate fechaInicio=LocalDate.now();

    @Column(name = "nro_vacantes", nullable = false)
    private int numeroVacante = 100;

    @Override
    public String toString() {
        return this.descripcion;
    }
}
