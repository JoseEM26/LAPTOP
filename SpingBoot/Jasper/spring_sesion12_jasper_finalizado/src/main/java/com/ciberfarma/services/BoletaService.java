package com.ciberfarma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciberfarma.dtos.ResultadoResponse;
import com.ciberfarma.models.Boleta;
import com.ciberfarma.models.DetalleBoleta;
import com.ciberfarma.models.Producto;
import com.ciberfarma.repositories.IBoletaRepository;
import com.ciberfarma.repositories.IProductoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoletaService {

	@Autowired
	private IBoletaRepository _boletaRepository;

	@Autowired
	private IProductoRepository _productoRepository;

	public List<Boleta> search() {
		return _boletaRepository.findAllByOrderByNumBoletaDesc();
	}

	@Transactional
	public ResultadoResponse create(Boleta boleta) {
		try {
			StringBuilder errores = new StringBuilder();

			//Validamos si hay stock suficiente con cada item del detalle
			for (DetalleBoleta item : boleta.getLstDetalleBoleta()) {
				String codProducto = item.getProducto().getCodProducto();
				Producto prod = _productoRepository.findById(codProducto).orElseThrow();

				if (prod.getStock() < item.getCantidad())
					errores.append(String.format("Stock insuficiente para %s <br>", prod.getDescripcion()));
			}

			if (errores.length() > 0)
				return new ResultadoResponse(false, errores.toString());

			// Si todo OK, actualizamos stock de cada producto
			boleta.getLstDetalleBoleta().forEach(detalle -> {
				Producto prod = _productoRepository.findById(detalle.getProducto().getCodProducto()).orElseThrow();
				prod.setStock(prod.getStock() - detalle.getCantidad());
				_productoRepository.save(prod);
			});

			//Registramos la boleta
			Boleta registrado = _boletaRepository.save(boleta);
			String mensaje = String.format("Boleta con número %s registrada", registrado.getNumBoleta());
			return new ResultadoResponse(true, mensaje);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResultadoResponse(false, "Error al registrar: " + ex.getMessage());
		}
	}
}
