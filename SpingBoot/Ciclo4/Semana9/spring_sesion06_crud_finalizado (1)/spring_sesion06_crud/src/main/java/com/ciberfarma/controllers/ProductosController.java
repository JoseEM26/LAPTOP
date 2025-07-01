package com.ciberfarma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ciberfarma.models.Producto;
import com.ciberfarma.repositories.ICategoriaRepository;
import com.ciberfarma.repositories.IProductoRepository;
import com.ciberfarma.repositories.IProveedorRepository;
import com.ciberfarma.utils.Alert;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	private IProductoRepository _productoRepository;
	
	@Autowired
	private ICategoriaRepository _categoriaRepository;
	
	@Autowired
	private IProveedorRepository _proveedorRepository;
	
	@GetMapping("/listado")
	public String listado(Model model) {
		List<Producto> lstProducto = _productoRepository.findAllByOrderByCodProductoDesc();
		model.addAttribute("lstProducto", lstProducto);
		return "productos/listado";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("categorias", _categoriaRepository.findAll());
		model.addAttribute("proveedores", _proveedorRepository.findAll());
		model.addAttribute("producto", new Producto());
		return "productos/nuevo";
	}
	
	@PostMapping("/registrar")
	public String registrar(@ModelAttribute Producto producto, Model model, RedirectAttributes flash) {
		model.addAttribute("categorias", _categoriaRepository.findAll());
		model.addAttribute("proveedores", _proveedorRepository.findAll());
		
		Producto registrado = _productoRepository.save(producto);
		String mensaje = Alert.sweetAlertSuccess("Producto con código "+ registrado.getCodProducto()+ " registrado.");
		flash.addFlashAttribute("alert", mensaje);
		return "redirect:/productos/listado";
	}
	
	@GetMapping("/edicion/{id}")
	public String edicion(@PathVariable String id , Model model) {
		model.addAttribute("categorias", _categoriaRepository.findAll());
		model.addAttribute("proveedores", _proveedorRepository.findAll());
		
		Producto producto = _productoRepository.findById(id).orElseThrow();
		model.addAttribute("producto", producto);
		return "productos/edicion";
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Producto producto, Model model, RedirectAttributes flash) {
		model.addAttribute("categorias", _categoriaRepository.findAll());
		model.addAttribute("proveedores", _proveedorRepository.findAll());
		
		Producto registrado = _productoRepository.save(producto);
		String mensaje = Alert.sweetAlertSuccess("Producto con código "+ registrado.getCodProducto()+ " actualizado.");
		flash.addFlashAttribute("alert", mensaje);
		return "redirect:/productos/listado";
	}
	
}
