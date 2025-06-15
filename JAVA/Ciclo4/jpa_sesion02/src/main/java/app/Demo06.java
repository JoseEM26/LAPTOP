package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Tipo;
import model.Usuario;

public class Demo06 {

	public static void main(String[] args) {
		// Instanciamos conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlconexion");

		// Implementamos manejador de entidades
		EntityManager manager = fabrica.createEntityManager();

		try {

			String jpql = "select u, t from Usuario u join u.tipo t";

			List<Object[]> resultados = manager.createQuery(jpql, Object[].class).getResultList();

			for (Object[] fila : resultados) {
				Usuario usuario = (Usuario) fila[0];
				Tipo tipo = (Tipo) fila[1];

				StringBuilder sb = new StringBuilder();
				sb.append("Código....: " + usuario.getCodigo() + "\n");
				sb.append("Nombre....: " + usuario.getNombres() + " " + usuario.getApellidos() + "\n");
				sb.append("Tipo......: " + tipo.getIdTipo() + " - " + tipo.getDescripcion() + "\n");
				sb.append("-------------------------------------------\n");

				System.out.println(sb);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No se pudo obtener al usuario");
		}
	}

}
