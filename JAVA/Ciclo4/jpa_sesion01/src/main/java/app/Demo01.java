package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {

		// Instanciamos conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlconexion");

		// Instaciamos manejador de entidades
		EntityManager manager = fabrica.createEntityManager();

		// Instanciamos un usuario nuevo
		Usuario usuario = new Usuario();
		usuario.setNombres("Ernesto");
		usuario.setApellidos("Arbulú");
		usuario.setUsuario("arbchumer");
		usuario.setPassword("12345");
//		usuario.setIdTipo(2);
//		usuario.setEstado(true);

		// Iniciamos proceso
		try {

			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();

			System.out.println("Registro exitoso del nuevo usuario");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No se pudo realizar la transacción");
		} finally {
			fabrica.close();
			manager.close();
		}

	}

}
