package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_tipos")
@Getter @Setter
public class Tipo {
	
	@Id
	@Column(name = "idtipo")
	private int idTipo;
	
	@Column(name = "descripcion")
	private String Descripcion;
}
