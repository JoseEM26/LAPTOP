package com.trabajador.mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.MysqlConnection;
import com.trabajador.connection.MySQLConnection;
import com.trabajador.model.Trabajador;

public class Mantenimiento {
	public List<Trabajador> ListaTrabajador() {
		List<Trabajador> lista =new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String statement = "select * from trabajador";

		try {
			con = MySQLConnection.getConnection();
			ps = con.prepareStatement(statement);
			rs = ps.executeQuery();

			while (rs.next()) {
				Trabajador t = new Trabajador();
				t.setId(rs.getInt("id"));
				t.setNombre(rs.getString("nombre"));
				t.setApellido(rs.getString("apellido"));
				lista.add(t);
			}

		} catch (Exception e) {
			System.out.println("Error en mantenimineto");
		} finally {
			MySQLConnection.CloseConection(con);
		}

		return lista;
	}
}
