package com.Persona.Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Persona.Connection.MySQLConnection;
import com.Persona.Controller.model.Persona;

public class Mantenimiento {
	public List<Persona> listaPersona() {
		List<Persona> lista = new ArrayList<Persona>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = MySQLConnection.getConnection();
			String statement = "select * from trabajador";
			ps = con.prepareStatement(statement);

			rs = ps.executeQuery();

			while (rs.next()) {
				Persona p = new Persona();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				lista.add(p);
			}

		} catch (Exception e) {
			System.out.println("Error en el mantenimiento");
		}finally {
			MySQLConnection.CloseConnection(con);
		}

		return lista;

	}

}
