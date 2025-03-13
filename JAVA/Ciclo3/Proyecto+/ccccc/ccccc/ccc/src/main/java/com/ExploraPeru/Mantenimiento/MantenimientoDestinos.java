package com.ExploraPeru.Mantenimiento;

import com.ExploraPeru.Connection.MySQLConnection;
import com.ExploraPeru.model.Destinos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MantenimientoDestinos {

	// Método para listar todos los destinos
	public List<Destinos> listado() {
		List<Destinos> lista = new ArrayList<>(); // Lista de destinos
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null; // Almacenará el resultado del SELECT

		try {
			con = MySQLConnection.getConnection(); // Obtiene la conexión

			String sql = "SELECT * FROM DESTINOS"; // Consulta SQL

			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) { // Recorre el ResultSet
				Destinos d = new Destinos();
				// Rellena los atributos del objeto Destinos
				d.setIdDestino(rs.getInt("id_destino"));
				d.setDestino(rs.getString("destino"));
				d.setDescripcion(rs.getString("descripcion"));

				// Agrega el destino a la lista
				lista.add(d);
			}
		} catch (SQLException e) {
			System.out.println("Error en listado de destinos: " + e.getMessage());
		} finally {
			MySQLConnection.CloseConection(con); // Cierra la conexión
		}
		return lista;
	}
}
