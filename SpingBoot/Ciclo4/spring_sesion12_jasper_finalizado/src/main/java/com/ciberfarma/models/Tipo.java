package com.ciberfarma.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_tipos")
@Getter
@Setter
public class Tipo {
	@Id
	@Column(name = "idtipo")
	private int idtipo;

	@Column(name = "descripcion")
	private String descripcion;
}
