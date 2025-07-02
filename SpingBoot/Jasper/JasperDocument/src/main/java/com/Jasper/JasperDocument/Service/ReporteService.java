package com.Jasper.JasperDocument.Service;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class ReporteService {

	@Autowired
	private DataSource dataSource;

	//Generar reporte sin tabla
	public byte[] generarReport(String reportName) throws JRException, SQLException {
		// Cargar el JRXML
		InputStream inputStream = this.getClass().getResourceAsStream("/templates/Report/" + reportName + ".jrxml");

		// Compilar el JRXML a JasperReport
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

		// Parámetros (puedes llenar si el reporte lo necesita)
		Map<String, Object> param = new HashMap<>();

		// Llenar el reporte con una fuente vacía (no hay datos)
		//JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, new JREmptyDataSource());

		// Llenar el reporte con una fuente vacía (con datos)
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource.getConnection());

		// Exportar a PDF
		return JasperExportManager.exportReportToPdf(jasperPrint);
	}
}

