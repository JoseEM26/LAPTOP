package com.trabajador.mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.trabajador.conexion.ConnectionMySQL;
import com.trabajador.interfaz.ITrabajador;
import com.trabajador.model.Trabajador;

public class MantenimientoTrabajador implements ITrabajador {

	@Override
	public int Registrar(Trabajador t) {
		Connection con = null;
		PreparedStatement ps = null;
		String statement = "insert into Trabajador values (?,?,?,?,?,?)";
		int ok = 0;

		try {
			con = new ConnectionMySQL().getConnection();
			ps = con.prepareStatement(statement);
			ps.setInt(1, t.getDni());
			ps.setString(2, t.getNombre());
			ps.setString(3, t.getApellido());
			ps.setInt(4, t.getEdad());
			ps.setString(5, t.getDireccion());
			ps.setString(6, t.getFechaNacimiento());

			ok = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en el mantenimiento Insert");
		}

		return ok;
	}

	@Override
	public int actualizar(Trabajador t) {
		Connection con = null;
		PreparedStatement ps = null;
		String statement = "CALL ActualizarTrabajador(?,?,?,?,?,?)";
		int ok = 0;

		try {
			con = new ConnectionMySQL().getConnection();
			ps = con.prepareStatement(statement);
			ps.setInt(1, t.getDni());
			ps.setString(2, t.getNombre());
			ps.setString(3, t.getApellido());
			ps.setInt(4, t.getEdad());
			ps.setString(5, t.getDireccion());
			ps.setString(6, t.getFechaNacimiento());

			ok = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en el mantenimiento Update");
		}

		return ok;
	}

	@Override
	public int eliminar(int codigo) {
		Connection con = null;
		PreparedStatement ps = null;
		String statement = "delete from trabajador where dni=?";
		int ok = 0;

		try {
			con = new ConnectionMySQL().getConnection();
			ps = con.prepareStatement(statement);
			ps.setInt(1, codigo);
		

			ok = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en el mantenimiento DELETE");
		}

		return ok;
	}

}
