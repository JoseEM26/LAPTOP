package com.ciberfarma.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usua")
	private int codUsuario;

	@Column(name = "nom_usua", nullable = false)
	private String nombres;

	@Column(name = "ape_usua", nullable = false)
	private String apellidos;

	@Column(name = "user_usua", nullable = false)
	private String usuario;

	@Column(name = "pswd_usua", nullable = false)
	private String password;

	@Column(name = "fnac_usua", nullable = false)
	private LocalDate fechaNacimiento;

	@ManyToOne
	@JoinColumn(name = "idtipo", columnDefinition = "INT NOT NULL DEFAULT 2")
	private Tipo tipo;

	@Column(name = "est_usua", columnDefinition = "BIT NOT NULL DEFAULT 1")
	private Boolean estado;

	public String getFullUsuario() {
		return String.format("%s - %s %s", usuario, nombres, apellidos);
	}
}
