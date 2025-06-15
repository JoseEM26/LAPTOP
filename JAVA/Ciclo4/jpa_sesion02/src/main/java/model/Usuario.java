package model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_usuarios")
@DynamicInsert
@Getter @Setter
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usua")
	private int codigo;

	@Column(name = "nom_usua", nullable = false)
	private String nombres;

	@Column(name = "ape_usua", nullable = false)
	private String apellidos;

	@Column(name = "user_usua", nullable = false)
	private String usuario;

	@Column(name = "pswd_usua", nullable = false)
	private String password;

	@Column(name = "fnac_usua")
	private LocalDate fechaNac;

	@Column(name = "est_usua", columnDefinition = "BIT NOT NULL DEFAULT 1")
	private Boolean estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtipo")
	private Tipo tipo;

}
