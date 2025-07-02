package com.ciberfarma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ciberfarma.dtos.AutentacionFilter;
import com.ciberfarma.models.Usuario;
import com.ciberfarma.services.AutenticacionService;
import com.ciberfarma.utils.Alert;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private AutenticacionService autenticacionService;

	@GetMapping({ "/", "/login" })
	public String login(Model model) {
		model.addAttribute("filter", new AutentacionFilter());
		return "login";
	}

	@PostMapping("/iniciar-sesion")
	public String iniciarSesion(@ModelAttribute AutentacionFilter filter, HttpSession session, Model model,
			RedirectAttributes flash) {
		Usuario usuarioValidado = autenticacionService.autenticar(filter);

		if (usuarioValidado == null) {
			model.addAttribute("filter", new AutentacionFilter());
			model.addAttribute("alert", Alert.sweetAlertError("Usuario y/o clave incorrecta"));
			return "login";
		}

		String nombreCompleto = String.format("%s %s", usuarioValidado.getNombres(), usuarioValidado.getApellidos());
		session.setAttribute("idUsuario", usuarioValidado.getCodUsuario());
		session.setAttribute("nombreCompleto", nombreCompleto);
		session.setAttribute("cuenta", usuarioValidado.getUsuario());

		String alert = Alert.sweetImageUrl("Bienvenido a Ciberfarma", nombreCompleto, "/imagenes/mapache_pedro.gif");
		flash.addFlashAttribute("alert", alert);
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		if (session.getAttribute("cuenta") == null)
			return "redirect:/login";
		return "home";
	}

	@GetMapping("/cerrar-sesion")
	public String cerrarSesion(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
