package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo06 {
	public static void main(String[] args) {
		// Instanciamos conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlconexion");

		// Instaciamos manejador de entidades
		EntityManager manager = fabrica.createEntityManager();

		// Iniciamos proceso
		try {
			String jpql = "select usu from Usuario usu";

			List<Usuario> lstUsuario = manager.createQuery(jpql, Usuario.class).getResultList();

			for (Usuario usuario : lstUsuario) {
				StringBuilder sb = new StringBuilder();
				sb.append("Código....: " + usuario.getIdUsuario()+ "\n");
				sb.append("Usuario...: " + usuario.getNombres() + " "+ usuario.getApellidos() + "\n");
				sb.append("Id Tipo...: " + usuario.getIdTipo() + "\n");
				sb.append("-----------------------------------------\n");
				System.out.println(sb);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No se pudo realizar la transacción");
		} finally {
			fabrica.close();
			manager.close();
		}
	}
}
