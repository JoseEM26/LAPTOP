package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Dem03 {

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
			
			StringBuilder sb = new StringBuilder();
			sb.append("Nombres...: "+ usuario.getNombres()+ "\n");
			sb.append("Apellidos.: "+ usuario.getApellidos()+ "\n");
			sb.append("Usuario...: "+ usuario.getUsuario()+ "\n");
			sb.append("Password..: "+ usuario.getPassword()+ "\n");
			sb.append("Id Tipo...: "+ usuario.getIdTipo()+ "\n");
			sb.append("Estado....: "+ usuario.getEstado()+ "\n");
			
			System.out.println(sb);
			
			System.out.println("Obtención exitosa del usuario " + codigo);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No se pudo realizar la transacción");
		} finally {
			fabrica.close();
			manager.close();
		}
	}

}
