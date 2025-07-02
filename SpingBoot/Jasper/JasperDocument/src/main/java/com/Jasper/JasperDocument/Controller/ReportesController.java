package com.Jasper.JasperDocument.Controller;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.Jasper.JasperDocument.Service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;


@RestController
@RequestMapping("/api")
public class ReportesController {

	@Autowired
	private ReporteService reporteService;

	@GetMapping("/report")
	public ResponseEntity<byte[]> generarReporte(){
		try {

			byte[] reporte= reporteService.generarReport("MyThrerReport");
			HttpHeaders httpHeaders= new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_PDF);
			httpHeaders.add("Content-disposition","inline; filename=report.pdf");

			return new ResponseEntity<>(reporte,httpHeaders,HttpStatus.OK);

		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	}
