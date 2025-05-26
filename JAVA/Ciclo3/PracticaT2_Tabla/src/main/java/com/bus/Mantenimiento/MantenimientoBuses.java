package com.bus.Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bus.Connection.MySQLConnection;
import com.bus.Model.Busess;
import com.bus.Model.Rutas;

public class MantenimientoBuses {

	public List<Busess> ListaBus(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		String statement = "call listarTodo (?);";
		ResultSet rs = null;
		List<Busess> lista = null;

		try {
			lista=new ArrayList<>();
			con = MySQLConnection.getConnection();
			ps = con.prepareStatement(statement);
			ps.setInt(1,id);
			rs = ps.executeQuery();

			while (rs.next()) {
				Busess b=new Busess();
				b.setId_bus(rs.getInt("id_bus"));
				b.setNom_choferes(rs.getString("nom_choferes"));
				b.setApe_choferes(rs.getString("Ape_choferes"));
				b.setNum_choferes(rs.getInt("num_choferes"));
				lista.add(b);
			}

		} catch (Exception e) {
			System.out.println("error en mantenimiento Lista" + e.getMessage());
		}finally {
			MySQLConnection.CloseConnection(con);
		}
		return lista;
	}
}
