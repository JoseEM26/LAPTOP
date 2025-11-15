package com.ciberfarma.app;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ciberfarma.model.Producto;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Demo04 {
	
	private static final Logger logger = LoggerFactory.getLogger(Producto.class);
	
	
	public static void main(String[] args) {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/ciberfarmadawi");
		config.setUsername("root");
		config.setPassword("mysql");
		
		config.setMaximumPoolSize(30);     // 30 conexiones como máximo
		config.setIdleTimeout(30000);      // 30s tiempo inactividad
		config.setConnectionTimeout(3000); // 3s tiempo espera
		
		HikariDataSource dataSource = new HikariDataSource(config);
		
		Properties properties = new Properties();
		properties.put("jakarta.persistence.dataSource", dataSource);
		
		EntityManagerFactory emf = Persistence.
				createEntityManagerFactory("HikariCPDemo", properties);
		EntityManager em = emf.createEntityManager();
		Producto p = new Producto();
		p.setId_prod("P0036");
		p.setDes_prod("Producto 33");
		p.setStk_prod(33);
		p.setPre_prod(33.30);
		p.setIdcategoria(3);
		p.setIdproveedor(2);
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			// System.out.println("Producto guardado");
			logger.info("Producto guardado");
		} catch (Exception e) {
			// System.out.println("Error al registrar");
			logger.error("Error al registrar: " + e);
			// e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}