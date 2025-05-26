package com.bus.Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bus.Connection.MySQLConnection;
import com.bus.Model.Rutas;

public class ComboBoxRutas {
	public List<Rutas> ComboBoxRut() {
		Connection con = null;
		PreparedStatement ps = null;
		String statement = "select * from tb_rutas";
		ResultSet rs = null;
		List<Rutas> lista =null;

		try {
			lista= new ArrayList<>();
			con = MySQLConnection.getConnection();
			ps = con.prepareStatement(statement);
			rs = ps.executeQuery();

			while (rs.next()) {
				Rutas r = new Rutas();
				r.setId_ruta(rs.getInt("id_ruta"));
				r.setNom_ruta(rs.getString("nom_ruta"));
				lista.add(r);
			}

		} catch (Exception e) {
			System.out.println("error en mantenimiento comboBox" + e.getMessage());
		}finally {
			MySQLConnection.CloseConnection(con);
		}
		return lista;
	}
}
