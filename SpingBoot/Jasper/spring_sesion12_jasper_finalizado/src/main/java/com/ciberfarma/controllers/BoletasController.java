package com.ciberfarma.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ciberfarma.dtos.ProductoSeleccionado;
import com.ciberfarma.dtos.ResultadoResponse;
import com.ciberfarma.models.Boleta;
import com.ciberfarma.models.DetalleBoleta;
import com.ciberfarma.models.Usuario;
import com.ciberfarma.services.BoletaService;
import com.ciberfarma.services.ProductoService;
import com.ciberfarma.services.UsuarioService;
import com.ciberfarma.utils.Alert;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/boletas")
@SessionAttributes("seleccionados")
public class BoletasController {

	@Autowired
	ProductoService productoService;

	@Autowired
	BoletaService boletaService;

	@Autowired
	UsuarioService usuarioService;

	@ModelAttribute("seleccionados")
	public List<ProductoSeleccionado> inicializarSeleccionados() {
		return new ArrayList<>();
	}

	@GetMapping("/filtrado")
	public String filtrado(Model model) {
		List<Boleta> lstBoletas = boletaService.search();
		model.addAttribute("lstBoletas", lstBoletas);
		return "boletas/filtrado";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("productos", productoService.getActivos());
		model.addAttribute("productoSeleccionado", new ProductoSeleccionado());
		return "boletas/nuevo";
	}

	@PostMapping("/agregar")
	public String agregar(@Valid @ModelAttribute ProductoSeleccionado seleccionado, BindingResult bindingResult,
			@ModelAttribute("seleccionados") List<ProductoSeleccionado> seleccionados, Model model) {
		model.addAttribute("productos", productoService.getActivos());
		model.addAttribute("productoSeleccionado", seleccionado);

		if (bindingResult.hasErrors()) {
			String mensaje = obtenerMensajeValidacionAgregar(bindingResult);
			model.addAttribute("alert", Alert.sweetAlertInfo(mensaje));
			return "boletas/nuevo";
		}

		// validamos si ya existe producto
		boolean existe = seleccionados.stream().anyMatch(p -> p.getCodProducto().equals(seleccionado.getCodProducto()));

		if (existe) {
			model.addAttribute("alert", Alert.sweetAlertInfo("El producto se encuentra en la lista"));
			return "boletas/nuevo";
		}

		seleccionados.add(seleccionado);
		model.addAttribute("productoSeleccionado", new ProductoSeleccionado());
		return "boletas/nuevo";
	}

	private String obtenerMensajeValidacionAgregar(BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors("codProducto"))
			return bindingResult.getFieldError("codProducto").getDefaultMessage();

		if (bindingResult.hasFieldErrors("precio"))
			return bindingResult.getFieldError("precio").getDefaultMessage();

		if (bindingResult.hasFieldErrors("codProducto"))
			return bindingResult.getFieldError("codProducto").getDefaultMessage();
		return null;
	}

	@PostMapping("/quitar")
	public String quitar(@RequestParam String codigo,
			@ModelAttribute("seleccionados") List<ProductoSeleccionado> seleccionados, Model model) {

		seleccionados.removeIf(p -> p.getCodProducto().equals(codigo));

		model.addAttribute("productos", productoService.getActivos());
		model.addAttribute("productoSeleccionado", new ProductoSeleccionado());
		return "boletas/nuevo";
	}

	@PostMapping("/registrar")
	public String registrar(@Valid @ModelAttribute Boleta boleta, BindingResult bindingResult,
			@ModelAttribute("seleccionados") List<ProductoSeleccionado> seleccionados, Model model,
			RedirectAttributes flash, HttpSession session) {
		model.addAttribute("productos", productoService.getActivos());
		model.addAttribute("productoSeleccionado", new ProductoSeleccionado());

		Integer idUsuario = (Integer) session.getAttribute("idUsuario");

		// Validamos sesión
		if (idUsuario == null) {
			flash.addFlashAttribute("alert", Alert.sweetAlertError("Sesión expirada"));
			return "redirect:/login";
		}

		// obtenemos al usuario y lo seteamos
		Usuario usuario = usuarioService.getOne(idUsuario);

		boleta.setUsuario(usuario);

		// Validamos seleccionados
		if (seleccionados.stream().count() == 0) {
			model.addAttribute("alert", Alert.sweetAlertInfo("Agregue por lo menos 1 producto"));
			return "boletas/nuevo";
		}

		// Mapeamos los datos seleccionados a DetalleBoleta y lo seteamos
		List<DetalleBoleta> lstDetalle = seleccionados.stream().map(item -> new DetalleBoleta(boleta,
				productoService.getOne(item.getCodProducto()), item.getCantidad(), item.getPrecio())).toList();

		boleta.setLstDetalleBoleta(lstDetalle);

		if (bindingResult.hasErrors()) {
			model.addAttribute("alert", Alert.sweetAlertInfo("Falta completar información"));
			return "boletas/nuevo";
		}

		//Iniciamos proceso
		try {
			ResultadoResponse response = boletaService.create(boleta);

			if (!response.success) {
				model.addAttribute("alert", Alert.sweetAlertErrorHtml(response.mensaje));
				return "boletas/nuevo";
			}

			flash.addFlashAttribute("toast", Alert.sweetToast(response.mensaje, "success", 5000));
			session.removeAttribute("seleccionados");
			return "redirect:/boletas/filtrado";

		} catch (RuntimeException ex) {
			model.addAttribute("alert", Alert.sweetAlertError(ex.getMessage()));
			return "boletas/nuevo";
		}
	}
}
