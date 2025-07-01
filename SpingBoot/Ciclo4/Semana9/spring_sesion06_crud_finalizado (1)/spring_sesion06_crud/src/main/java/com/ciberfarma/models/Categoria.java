package com.ciberfarma.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
	@Id
	@Column(name = "idcategoria")
	private int idCategoria;
	
	@Column(name = "descripcion")
	private String descripcion;
	
//    public String toString() {
//        return descripcion;
//    }
}
