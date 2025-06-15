package com.trabajador.mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.MysqlConnection;
import com.trabajador.conection.MySQLConnection;
import com.trabajador.intefaz.IMantenimiento;
import com.trabajador.model.Trabajador;

public class CrudTrabajador implements IMantenimiento {

	@Override
	public int Insert(Trabajador t) {
		Connection con = null;
		PreparedStatement pst = null;
		int estado = 0;
		String sentencia = "INSERT INTO trabajador VALUES (?,?,?,?,?,?)";

		try {
			con = new MySQLConnection().getConnection();
			pst = con.prepareStatement(sentencia);

			pst.setInt(1, t.getDni());
			pst.setString(2, t.getNombre());
			pst.setString(3, t.getApellido());
			pst.setInt(4, t.getEdad());
			pst.setString(5, t.getDireccion());
			pst.setString(6, t.getFechaNacimiento());

			estado = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Ocurrio un error en el Mantnimiento Insertar");
		} finally {
			try {
				pst.close();
				MySQLConnection.CloseConnection(con);
			} catch (Exception e2) {
				System.out.println("Ocurrio un error en el Mantnimiento Insertar Close");
			}
		}

		return estado;
	}

	@Override
	public int update(Trabajador t) {
		Connection con = null;
		PreparedStatement pst = null;
		int estado = 0;
		String sentencia = "CALL ActualizarTrabajador(?,?,?,?,?,?)";

		try {
			con = new MySQLConnection().getConnection();
			pst = con.prepareStatement(sentencia);

			pst.setInt(1, t.getDni());
			pst.setString(2, t.getNombre());
			pst.setString(3, t.getApellido());
			pst.setInt(4, t.getEdad());
			pst.setString(5, t.getDireccion());
			pst.setString(6, t.getFechaNacimiento());

			estado = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Ocurrio un error en el Mantnimiento update");
		} finally {
			try {
				pst.close();
				MySQLConnection.CloseConnection(con);
			} catch (Exception e2) {
				System.out.println("Ocurrio un error en el Mantnimiento update Close");
			}
		}

		return estado;
	}

	@Override
	public int delete(int codigo) {
		Connection con = null;
		PreparedStatement pst = null;
		int estado = 0;
		String sentencia = "delete from trabajador where dni=?";

		try {
			con = new MySQLConnection().getConnection();
			pst = con.prepareStatement(sentencia);

			pst.setInt(1,codigo);
		

			estado = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Ocurrio un error en el Mantnimiento Eliminar");
		} finally {
			try {
				pst.close();
				MySQLConnection.CloseConnection(con);
			} catch (Exception e2) {
				System.out.println("Ocurrio un error en el Mantnimiento Eliminar Close");
			}
		}

		return estado;
	}

}
