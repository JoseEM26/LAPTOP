package com.examenT2.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.dtos.ResultadoResponse;
import com.examenT2.models.Inventario;
import com.examenT2.services.InventarioService;
import com.examenT2.services.ProductoService;
import com.examenT2.utils.Alert;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/inventarios")
public class InventariosController {

	@Autowired
	private InventarioService _inventarioService;

	@Autowired
	private ProductoService _productoService;

		@GetMapping("/listado")
	public String listado(Model model) {
		// Obtenemos y agregamos al modelo todos los inventarios
		List<Inventario> lstInventario = _inventarioService.getAll();
		model.addAttribute("lstInventario", lstInventario);
		return "inventarios/listado";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		// Agrega la lista de productos al modelo para poblar el <select> en el
		// formulario
		model.addAttribute("productos", _productoService.getAll());

		// Crea una nueva instancia de Inventario con la fecha actual por defecto
		Inventario inventario = new Inventario();
		inventario.setFechaVencimiento(LocalDate.now());

		// Agrega la instancia al modelo para enlazar con los campos del formulario
		model.addAttribute("inventario", inventario);
		return "inventarios/nuevo";
	}

	@PostMapping("/registrar")
	public String registrar(@ModelAttribute Inventario inventario, Model model, RedirectAttributes flash) {

		// Procesamos el inventario a registrar
		ResultadoResponse response = _inventarioService.create(inventario);

		// Si no fue exitoso, muestra mensaje de error y retorna al formulario
		if (!response.success) {
			// Recarga la lista de productos para que el <select> no aparezca vacío
			model.addAttribute("productos", _productoService.getAll());
			// Muestra alerta de error en la vista
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje));
			return "inventarios/nuevo";
		}

		// Si fue exitoso, redirige al listado mostrando un mensaje de éxito tipo toast
		flash.addFlashAttribute("alert", Alert.sweetToast(response.mensaje, "success", 5000));
		return "redirect:/inventarios/listado";
	}

	@GetMapping("/edicion/{id}")
	public String edicion(@PathVariable Integer id, Model model) {
		// Agrega la lista de productos al modelo para poblar el <select> en el
		// formulario
		model.addAttribute("productos", _productoService.getAll());

		// Obtiene el inventario por su ID para cargarlo en el formulario de edición
		Inventario inventario = _inventarioService.getOne(id);

		// Agrega el inventario obtenido al modelo para enlazar y enviar los datos al
		// formulario
		model.addAttribute("inventario", inventario);
		return "inventarios/edicion";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Inventario inventario, Model model, RedirectAttributes flash) {

		// Procesa la actualización del inventario
		ResultadoResponse response = _inventarioService.update(inventario);

		// Si no fue exitoso, muestra mensaje de error y retorna al formulario
		if (!response.success) {
			// Recarga la lista de productos para que el <select> no aparezca vacío
			model.addAttribute("productos", _productoService.getAll());
			// Muestra alerta de error en la vista
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje));
			return "inventarios/edicion";
		}

		// Si fue exitoso, redirige al listado mostrando un mensaje de éxito tipo toast
		flash.addFlashAttribute("alert", Alert.sweetToast(response.mensaje, "success", 5000));
		return "redirect:/inventarios/listado";
	}
}
