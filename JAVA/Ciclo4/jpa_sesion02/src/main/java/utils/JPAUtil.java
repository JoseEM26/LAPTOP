package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class JPAUtil {
	// Nombre de tu unidad de persistencia en persistence.xml
	private static final String PERSISTENCE_UNIT = "mysqlconexion";
	private static EntityManagerFactory fabrica;

	// Lazy-init singleton del EMF
	private static EntityManagerFactory getFabrica() {
		if (fabrica == null)
			try {
				fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
			} catch (PersistenceException ex) {
				// aquí la conexión falló (credenciales, URL, driver, etc.)
				System.err.println("ERROR al crear EMF: " + ex.getMessage());
				// relanzar o devolver null, según tu manejo de errores
				throw ex;
			}

		return fabrica;
	}

	/**
	 * Te da un EntityManager nuevo
	 */
	public static EntityManager getEntityManager() {
		try {
			return getFabrica().createEntityManager();
		} catch (IllegalStateException | PersistenceException ex) {
			System.err.println("No se pudo obtener el EntityManager: " + ex.getMessage());
			throw ex;
		}
	}

	/**
	 * Llamar al final de la app (o en un hook de cierre) para liberar el
	 * EntityManagerFactory.
	 */
	public static void closeEmf() {
		if (fabrica != null && fabrica.isOpen())
			fabrica.close();
	}
}
