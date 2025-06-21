package com.examenT2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

@Entity
@Table(name = "tbl_categoria")
@Getter @Setter
public class Categoria {
	
	@Id
	@Column(name = "id")
	private int Id;
	
	@Column(name = "descripcion")
	private String descripcion;
}
