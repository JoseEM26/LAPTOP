package com.Trabajador.Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Trabajador.Conecction.ConnectionMySQL;
import com.Trabajador.interfaz.ITrabjador;
import com.Trabajador.model.Trabajador;

public class Mantenimiento implements ITrabjador {

	@Override
	public int Insertar(Trabajador e) {
		int ok = 0;
		PreparedStatement ps = null;
		Connection con = null;

		try {
			con = new ConnectionMySQL().getConnection();
			String statement = "insert into trabajador values(?,?,?,?,?,?)";
			ps = con.prepareStatement(statement);
			ps.setInt(1, e.getDni());
			ps.setString(2, e.getNombre());
			ps.setString(3, e.getApellido());
			ps.setInt(4, e.getEdad());
			ps.setString(5, e.getDireccion());
			ps.setString(6, e.getFechaNacimiento());

			ok = ps.executeUpdate();
		} catch (Exception e2) {
			System.out.println("Ocurrio un error en el Mantenimiento Insert");
		} finally {
			try {
				con.close();
				ConnectionMySQL.closeConnection(con);
			} catch (Exception e3) {
				System.out.println("Error al cerrar los Statements");
			}
		}

		return ok;
	}

	@Override
	public int actualizar(Trabajador e) {
		int ok = 0;
		PreparedStatement ps = null;
		Connection con = null;

		try {
			con = new ConnectionMySQL().getConnection();
			String statement = "CALL ActualizarTrabajador(?,?,?,?,?,?)";
			ps = con.prepareStatement(statement);
			ps.setInt(1, e.getDni());
			ps.setString(2, e.getNombre());
			ps.setString(3, e.getApellido());
			ps.setInt(4, e.getEdad());
			ps.setString(5, e.getDireccion());
			ps.setString(6, e.getFechaNacimiento());

			ok = ps.executeUpdate();
		} catch (Exception e2) {
			System.out.println("Ocurrio un error en el Mantenimiento update");
		} finally {
			try {
				con.close();
				ConnectionMySQL.closeConnection(con);
			} catch (Exception e3) {
				System.out.println("Error al cerrar los Statements");
			}
		}

		return ok;
	}

	@Override
	public int eliminar(int codigo) {
		int ok = 0;
		PreparedStatement ps = null;
		Connection con = null;

		try {
			con = new ConnectionMySQL().getConnection();
			String statement = "delete from trabajador where dni=?";
			ps = con.prepareStatement(statement);
			ps.setInt(1, codigo);

			ok = ps.executeUpdate();
		} catch (Exception e2) {
			System.out.println("Ocurrio un error en el Mantenimiento Eliminar");
		} finally {
			try {
				con.close();
				ConnectionMySQL.closeConnection(con);
			} catch (Exception e3) {
				System.out.println("Error al cerrar los Statements");
			}
		}

		return ok;
	}

}
