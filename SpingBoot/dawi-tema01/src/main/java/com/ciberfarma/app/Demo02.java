package com.ciberfarma.app;

import java.sql.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ciberfarma.model.Producto;
import com.ciberfarma.model.Usuario;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Demo02 {
	
	private static final Logger logger = LoggerFactory.getLogger(Usuario.class);
	
	
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
		
		Usuario u = new Usuario();
		u.setNom_usua("Dina");
		u.setApe_usua("Boluarte");
		u.setCorreo("cofrecito@mail.com");
		u.setClave("Rolex2025");
		u.setFna_usua(Date.valueOf("1900-10-31"));
		
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			logger.info("Usuario registrado");
		} catch (Exception e) {
			logger.error("Error al registrar: " + e);
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}