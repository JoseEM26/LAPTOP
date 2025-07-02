package com.ciberfarma.controllers;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ciberfarma.services.ReporteService;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping("/reportes")
public class ReportesController {

	@Autowired
	private ReporteService reporteService;

	@GetMapping("/boleta")
	public void boletaReporte(@RequestParam Integer numBol, HttpServletResponse response) throws Exception {
		// Ruta del reporte (en resources/reportes)
		String reportPath = "/reportes/tu_nombre_proyecto_jasper.jrxml";

		// Parámetros
		Map<String, Object> params = new HashMap<>();
		params.put("tu_parametro_de_jasper", numBol);
		
		//Get JasperPrint
		JasperPrint jasperPrint = reporteService.getJasperPrint(params, reportPath);

		// Configuración de respuesta HTTP
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", String.format("inline; filename=boleta-nro-%s.pdf", numBol));

		// Exportar a PDF
		OutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

		outputStream.flush();
		outputStream.close();
	}
}
