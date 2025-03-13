package com.ExploraPeru.Mantenimiento;

import java.lang.annotation.Retention;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ExploraPeru.Connection.MySQLConnection;
import com.ExploraPeru.Interfaz.MantenimientoCrud;
import com.ExploraPeru.model.Roles;
import com.ExploraPeru.model.Usuario;
import com.ExploraPeru.model.Vuelos;

public class MantenimientoUsuario {

  
    // Obtener lista de usuarios
    public List<Usuario> listado() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "SELECT * FROM Usuarios";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setIdRol(rs.getInt("id_rol"));
                usuario.setFechaCreacion(rs.getTimestamp("fecha_creacion").toString());
                usuario.setFechaCumpleaños(rs.getDate("fecha_cumpleaños") != null ? rs.getDate("fecha_cumpleaños").toString() : null);
                usuario.setImg(rs.getString("img"));
                listaUsuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error en listado de usuarios: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return listaUsuarios;
    }


    // Eliminar Usuario
    public int eliminar(int idUsuario) {
        int resultado = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "DELETE FROM Usuarios WHERE id_usuario = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            resultado = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return resultado;
    }

    // Obtener Usuario por ID
    public Usuario obtener(int idUsuario) {
        Usuario usuario = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "SELECT * FROM Usuarios WHERE id_usuario = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setIdRol(rs.getInt("id_rol"));
                usuario.setFechaCreacion(rs.getTimestamp("fecha_creacion").toString());
                usuario.setFechaCumpleaños(rs.getDate("fecha_cumpleaños") != null ? rs.getDate("fecha_cumpleaños").toString() : null);
                usuario.setImg(rs.getString("img"));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener usuario: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return usuario;
    }
	public Usuario ValidacionLogin(String email,String clave) {
		Usuario u = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConnection.getConnection();

			String sql = "SELECT * FROM Usuarios where email = ? and contraseña = ?"; // sentencia

			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, clave);

			rs = pst.executeQuery();

			if (rs.next()) { // if hay datos en la consulta
				u = new Usuario();
				// se trae los datos de la consulta
				u.setIdUsuario(rs.getInt("id_usuario"));
				u.setNombreUsuario(rs.getString("nombre_usuario"));
				u.setEmail(rs.getString("email"));
				u.setContraseña(rs.getString("contraseña"));
				u.setIdRol(rs.getInt("id_rol"));
				u.setFechaCreacion(rs.getString("fecha_creacion"));
				u.setFechaCumpleaños(rs.getString("fecha_cumpleaños"));
				u.setImg(rs.getString("img"));
				u.setTelefono(rs.getString("telefono"));
				
			}
		} catch (Exception e) {
			System.out.println("Error en validar : " + e.getMessage());
		} finally {
			MySQLConnection.CloseConection(con);
		}
		return u;
	}
	public int registrar(Usuario objUsuario) throws Exception {
		int ok = 0; // variable de control > 0 (Éxito) / == 0 (Error)
		Connection con = null; // obtener la conexión con la BD
		PreparedStatement pst = null; // prepara las sentencias a ejecutar
		try {
			con =MySQLConnection.getConnection();

			// Sentencia SQL con las columnas explícitamente especificadas
			String sql = "insert into Usuarios (nombre_usuario, email, contraseña, telefono, id_rol, fecha_cumpleaños, img) values (?, ?, ?, ?, ?, ?, ?)";

			// prepara la sentencia
			pst = con.prepareStatement(sql);

			// asigna los valores a los placeholders
			pst.setString(1, objUsuario.getNombreUsuario());
			pst.setString(2, objUsuario.getEmail());
			pst.setString(3, objUsuario.getContraseña());
			pst.setString(4, objUsuario.getTelefono());
			pst.setInt(5, objUsuario.getIdRol());
			pst.setString(6, objUsuario.getFechaCumpleaños());
			pst.setString(7, objUsuario.getImg());

			// ejecuta la sentencia y devuelve el resultado
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en registrar: " + e.getMessage());
		} finally {
			MySQLConnection.CloseConection(con);
		}
		return ok;
	}
	public int actualizar(Usuario objVuelo) throws Exception {
		int ok = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConnection.getConnection();
			String sql = "CALL ActualizarUsuario (?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, objVuelo.getIdUsuario());
			pst.setString(2, objVuelo.getNombreUsuario());
			pst.setString(3, objVuelo.getEmail());
			pst.setString(4, objVuelo.getContraseña());
			pst.setString(5, objVuelo.getTelefono());
			pst.setString(6, objVuelo.getFechaCumpleaños()); // Asignar lugar
			pst.setString(7, objVuelo.getImg()); // ID vuelo para la actualización
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar: " + e.getMessage());
		} finally {
			MySQLConnection.CloseConection(con);
		}
		return ok;
	}
}
