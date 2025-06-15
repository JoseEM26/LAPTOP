package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {

	public static void main(String[] args) {
		// Instanciamos conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlconexion");

		// Instaciamos manejador de entidades
		EntityManager manager = fabrica.createEntityManager();

		// Indicamos un código a obtener
		int codigo = 6;

		// Iniciamos proceso
		try {
			Usuario usuario = manager.find(Usuario.class, codigo);

			if (usuario == null) {
				System.out.println("Usuario no existe");
				return;
			}

			manager.getTransaction().begin();
			manager.remove(usuario);
			manager.getTransaction().commit();

			System.out.println("Eliminación exitosa del usuario " + codigo);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No se pudo realizar la transacción");
		} finally {
			fabrica.close();
			manager.close();
		}

	}

}
