package com.ciberfarma.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "tb_usuarios")
@Data
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_usua;
	@Column(length = 15, nullable = false)
	private String nom_usua;
	@Column(length = 25, nullable = false)
	private String ape_usua;
	@Column(name = "usr_usua", length = 45, nullable = false, unique = true)
	private String correo;
	@Column(name = "cla_usua", length = 100, nullable = false)
	private String clave;
	@Temporal(TemporalType.DATE)
	private Date fna_usua;
	private int idtipo = 2;
	private int est_usua = 1;
}