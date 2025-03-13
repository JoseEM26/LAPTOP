package com.Trabajador.mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Trabajador.conection.MySQLConecction;
import com.Trabajador.interfaz.ITrabajador;
import com.Trabajador.modelo.Trabajador;
import com.mysql.cj.MysqlConnection;

public class Mantenimiento implements ITrabajador {

	@Override
	public int Insertar(Trabajador t) {
		int ok = 0;
		Connection con = null;
		PreparedStatement pst = null;
		String statment = "INSERT INTO trabajador VALUES (?,?,?,?,?,?)";

		try {
			con = new MySQLConecction().getConnection();
			pst = con.prepareStatement(statment);
			pst.setInt(1, t.getDni());
			pst.setString(2, t.getNombre());
			pst.setString(3, t.getApellido());
			pst.setInt(4, t.getEdad());
			pst.setString(5, t.getDireccion());
			pst.setString(6, t.getFechaNacimiento());

			ok = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en el mantenimineto");
		} finally {
			try {
				con.close();
                MySQLConecction.CloseConnection(con);
			} catch (Exception e2) {
				System.out.println("Error al cerrar mantenimineto");
			}
		}

		return ok;
	}

	@Override
	public int actualizar(Trabajador t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(int codigo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
