package Model;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "tbl_solicitud")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_solicitud", nullable = false)
    private int nroSolicitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_actividad", nullable = false) // <-- relación correcta
    @EqualsAndHashCode.Include
    private Actividad actividad;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "archivo_adjunto", nullable = false)
    private String archivo;

    @Column(name = "fecha_reg", nullable = false)
    private LocalDate fecha=LocalDate.now();
}
