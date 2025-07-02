package com.ciberfarma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ciberfarma.dtos.ProductoFilter;
import com.ciberfarma.dtos.ResultadoResponse;
import com.ciberfarma.models.Producto;
import com.ciberfarma.services.CategoriaService;
import com.ciberfarma.services.ProductoService;
import com.ciberfarma.services.ProveedorService;
import com.ciberfarma.utils.Alert;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	private ProductoService productoService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ProveedorService proveedorService;

	@GetMapping("/listado")
	public String listado(Model model) {
		List<Producto> lstProducto = productoService.getAll();
		model.addAttribute("lstProducto", lstProducto);
		return "productos/listado";
	}
	
	@GetMapping("/filtrado")
	public String filtrado(@ModelAttribute ProductoFilter filtro, Model model) {
		
		List<Producto> lstProducto = productoService.search(filtro);
		
		model.addAttribute("categorias", categoriaService.getAll());
		model.addAttribute("proveedores", proveedorService.getAll());
		model.addAttribute("filtro", filtro);
		model.addAttribute("lstProducto", lstProducto);
		
		return "productos/filtrado";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("categorias", categoriaService.getAll());
		model.addAttribute("proveedores", proveedorService.getAll());
		model.addAttribute("producto", new Producto());
		return "productos/nuevo";
	}

	@PostMapping("/registrar")
	public String registrar(@Valid @ModelAttribute Producto producto, BindingResult bindingResult, Model model,
			RedirectAttributes flash) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("categorias", categoriaService.getAll());
			model.addAttribute("proveedores", proveedorService.getAll());
			model.addAttribute("alert", Alert.sweetAlertInfo("Falta completar información"));
			return "productos/nuevo";
		}

		ResultadoResponse response = productoService.create(producto);

		if (!response.success) {
			model.addAttribute("categorias", categoriaService.getAll());
			model.addAttribute("proveedores", proveedorService.getAll());
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje));
			return "productos/nuevo";
		}

		String toast = Alert.sweetToast(response.mensaje, "sucess", 5000);
		flash.addFlashAttribute("toast", toast);
		return "redirect:/productos/filtrado";
	}

	@GetMapping("/edicion/{id}")
	public String edicion(@PathVariable String id, Model model) {
		model.addAttribute("categorias", categoriaService.getAll());
		model.addAttribute("proveedores", proveedorService.getAll());

		Producto producto = productoService.getOne(id);
		model.addAttribute("producto", producto);
		return "productos/edicion";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute Producto producto, BindingResult bindingResult, Model model,
			RedirectAttributes flash) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("categorias", categoriaService.getAll());
			model.addAttribute("proveedores", proveedorService.getAll());
			model.addAttribute("alert", Alert.sweetAlertInfo("Falta completar información"));
			return "productos/edicion";
		}

		ResultadoResponse response = productoService.update(producto);

		if (!response.success) {
			model.addAttribute("categorias", categoriaService.getAll());
			model.addAttribute("proveedores", proveedorService.getAll());
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje));
			return "productos/edicion";
		}

		String toast = Alert.sweetToast(response.mensaje, "success", 5000);
		flash.addFlashAttribute("toast", toast);
		return "redirect:/productos/filtrado";
	}

	@PostMapping("/cambiar-estado/{id}")
	public String cambiarEstado(@PathVariable String id, RedirectAttributes flash) {

		ResultadoResponse response = productoService.cambiarEstado(id);
		
		String toast = Alert.sweetToast(response.mensaje, "success", 5000);
		flash.addFlashAttribute("toast", toast);
		return "redirect:/productos/filtrado";
	}

}
