package com.ciberfarma.mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ciberfarma.conexion.MySQLConexion;
import com.ciberfarma.model.Producto;
import com.ciberfarma.model.Usuario;

public class GestionUsuario {
	// validar usuario
	public Usuario validar(String usuario, String clave) {
		Usuario u = null; // var. de control
		// proceso
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null; // almacenará el resultado del select
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "SELECT * FROM tb_usuarios where usuario = ? and clave = ?"; // sentencia
			
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, clave);
			
			rs = pst.executeQuery();
			
			if (rs.next()) { // if hay datos en la consulta
				u = new Usuario();
				// se trae los datos de la consulta
				u.setCodigo(rs.getInt("codigo"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setUsuario(rs.getString("usuario"));
				u.setClave(rs.getString("clave"));
				u.setFnacim(rs.getDate("fnacim"));
				u.setTipo(rs.getInt("tipo"));
				u.setEstado(rs.getInt("estado"));
			}
		} catch (Exception e) {
			System.out.println("Error en validar : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return u;
	}
	
	// registrar
	
	// eliminar
	
	// actualizar
	public int actualizar(Usuario u) {
		int ok = 0;
		// proceso...
		Connection con = null; // obtener la conexión con la BD
		PreparedStatement pst = null; // prepara las sentencias a ejecutar
		try {
			con = MySQLConexion.getConexion();

			String sql = "update tb_usuarios set nombre = ?, apellido = ?, clave = ? where codigo = ?";

			// prepara la sentencia
			pst = con.prepareStatement(sql);
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getClave());
			pst.setInt(4, u.getCodigo());

			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		
		return ok;
	}
	
	
	
	// listado
}
