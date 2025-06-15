package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		// Instanciamos conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlconexion");

		// Instaciamos manejador de entidades
		EntityManager manager = fabrica.createEntityManager();

		// Instanciamos un usuario nuevo
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(6);
		usuario.setNombres("Ernesto");
		usuario.setApellidos("Arbulú Chumbipuma");
		usuario.setUsuario("arbchumer");
		usuario.setPassword("12345");
		usuario.setIdTipo(2);
		usuario.setEstado(false);

		// Iniciamos proceso
		try {

			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();

			System.out.println("Actualización exitosa del usuario "+ usuario.getIdUsuario());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No se pudo realizar la transacción");
		} finally {
			fabrica.close();
			manager.close();
		}
	}

}
