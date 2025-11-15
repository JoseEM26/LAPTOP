package com.ciberfarma.app;

import com.ciberfarma.model.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Demo01 {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HikariCPDemo");
		EntityManager em = emf.createEntityManager();
		Producto p = new Producto();
		p.setId_prod("P0034");
		p.setDes_prod("Producto 33");
		p.setStk_prod(33);
		p.setPre_prod(33.30);
		p.setIdcategoria(3);
		p.setIdproveedor(2);
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			System.out.println("Producto guardado");
		} catch (Exception e) {
			System.out.println("Error al registrar");
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}