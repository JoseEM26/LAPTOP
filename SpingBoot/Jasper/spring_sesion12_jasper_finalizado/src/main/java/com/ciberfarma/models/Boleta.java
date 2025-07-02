package com.ciberfarma.models;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cab_boleta")
@Getter
@Setter
@DynamicInsert
public class Boleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_bol")
	private int numBoleta;

	@Column(name = "fch_bol")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	@JoinColumn(name = "cod_usua", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	@OneToMany(mappedBy = "boleta", cascade = CascadeType.ALL)
	private List<DetalleBoleta> lstDetalleBoleta;

	public Double getTotal() {
		return lstDetalleBoleta.stream().mapToDouble(d -> d.getPrecioVenta() * d.getCantidad()).sum();
	}
}
