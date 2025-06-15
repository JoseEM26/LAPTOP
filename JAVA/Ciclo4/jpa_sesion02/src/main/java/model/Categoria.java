package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_categorias")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Categoria {
	@Id
	@Column(name = "idcategoria")
	@EqualsAndHashCode.Include
	private int idCategoria;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Override
	public String toString() {
		return descripcion;
	}
}
