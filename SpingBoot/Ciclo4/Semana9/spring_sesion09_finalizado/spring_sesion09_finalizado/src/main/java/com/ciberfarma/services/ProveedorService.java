package com.ciberfarma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciberfarma.models.Proveedor;
import com.ciberfarma.repositories.IProveedorRepository;

@Service
public class ProveedorService {

	@Autowired
	IProveedorRepository _proveedorRepository;

	public List<Proveedor> getAll() {
		return _proveedorRepository.findAll();
	}
}
