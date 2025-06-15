package com.ExploraPeru.Mantenimiento;

import com.ExploraPeru.Connection.MySQLConnection;
import com.ExploraPeru.model.Vuelos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MantenimientoVuelos {
	// --- procesos del CRUD ---

	// Registrar
	public int registrar(Vuelos objVuelo) throws Exception {
		int ok = 0; // variable de control
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConnection.getConnection();
			String sql = "INSERT INTO VUELOS (fecha_salida, fecha_llegada, precio, plazas_disponibles, id_destino, imagen_url, lugar) VALUES (?, ?, ?, ?, ?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, objVuelo.getFechaSalida());
			pst.setString(2, objVuelo.getFechaLlegada());
			pst.setDouble(3, objVuelo.getPrecio());
			pst.setInt(4, objVuelo.getPlazasDisponibles());
			pst.setInt(5, objVuelo.getIdDestino());
			pst.setString(6, objVuelo.getImagenUrl()); // Asignar imagenUrl
			pst.setString(7, objVuelo.getLugar()); // Asignar lugar

			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al registrar: " + e.getMessage());
		} finally {
			MySQLConnection.CloseConection(con);
		}
		return ok;
	}

	// Eliminar
	public int eliminar(int idVuelo) throws Exception {
		int ok = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConnection.getConnection();
			String sql = "DELETE FROM VUELOS WHERE id_vuelo = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, idVuelo);
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al eliminar: " + e.getMessage());
		} finally {
			MySQLConnection.CloseConection(con);
		}
		return ok;
	}

	// Actualizar
	public int actualizar(Vuelos objVuelo) throws Exception {
		int ok = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConnection.getConnection();
			String sql = "UPDATE VUELOS SET fecha_salida = ?, fecha_llegada = ?, precio = ?, plazas_disponibles = ?, id_destino = ?, imagen_url = ?, lugar = ? WHERE id_vuelo = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, objVuelo.getFechaSalida());
			pst.setString(2, objVuelo.getFechaLlegada());
			pst.setDouble(3, objVuelo.getPrecio());
			pst.setInt(4, objVuelo.getPlazasDisponibles());
			pst.setInt(5, objVuelo.getIdDestino());
			pst.setString(6, objVuelo.getImagenUrl()); // Asignar imagenUrl
			pst.setString(7, objVuelo.getLugar()); // Asignar lugar
			pst.setInt(8, objVuelo.getIdVuelo()); // ID vuelo para la actualización
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar: " + e.getMessage());
		} finally {
			MySQLConnection.CloseConection(con);
		}
		return ok;
	}

	// Listar todos los vuelos
	public List<Vuelos> listado() {
		List<Vuelos> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConnection.getConnection();
			String sql = "SELECT * FROM VUELOS";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Vuelos v = new Vuelos();
				v.setIdVuelo(rs.getInt("id_vuelo"));
				v.setFechaSalida(rs.getString("fecha_salida"));
				v.setFechaLlegada(rs.getString("fecha_llegada"));
				v.setPrecio(rs.getDouble("precio"));
				v.setPlazasDisponibles(rs.getInt("plazas_disponibles"));
				v.setIdDestino(rs.getInt("id_destino"));
				v.setImagenUrl(rs.getString("imagen_url")); // Obtener imagenUrl
				v.setLugar(rs.getString("lugar")); // Obtener lugar

				lista.add(v);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConnection.CloseConection(con);
		}
		return lista;
	}

	// Filtro de vuelos por destino
	public List<Vuelos> filtro(int destinoId) {
		List<Vuelos> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConnection.getConnection();
			String sql = "SELECT * FROM VUELOS WHERE id_destino = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, destinoId);
			rs = pst.executeQuery();

			while (rs.next()) {
				Vuelos v = new Vuelos();
				v.setIdVuelo(rs.getInt("id_vuelo"));
				v.setFechaSalida(rs.getString("fecha_salida"));
				v.setFechaLlegada(rs.getString("fecha_llegada"));
				v.setPrecio(rs.getDouble("precio"));
				v.setPlazasDisponibles(rs.getInt("plazas_disponibles"));
				v.setIdDestino(rs.getInt("id_destino"));
				v.setImagenUrl(rs.getString("imagen_url")); // Obtener imagenUrl
				v.setLugar(rs.getString("lugar")); // Obtener lugar

				lista.add(v);
			}
		} catch (Exception e) {
			System.out.println("Error en filtro: " + e.getMessage());
		} finally {
			MySQLConnection.CloseConection(con);
		}
		return lista;
	}

	// Obtener vuelo por ID
	public Vuelos obtener(int idVuelo) {
		Vuelos v = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConnection.getConnection();
			String sql = "SELECT * FROM VUELOS WHERE id_vuelo = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, idVuelo);
			rs = pst.executeQuery();

			if (rs.next()) {
				v = new Vuelos();
				v.setIdVuelo(rs.getInt("id_vuelo"));
				v.setFechaSalida(rs.getString("fecha_salida"));
				v.setFechaLlegada(rs.getString("fecha_llegada"));
				v.setPrecio(rs.getDouble("precio"));
				v.setPlazasDisponibles(rs.getInt("plazas_disponibles"));
				v.setIdDestino(rs.getInt("id_destino"));
				v.setImagenUrl(rs.getString("imagen_url")); // Obtener imagenUrl
				v.setLugar(rs.getString("lugar")); // Obtener lugar
			}
		} catch (Exception e) {
			System.out.println("Error en obtener: " + e.getMessage());
			System.out.println(v.getFechaLlegada());
		} finally {
			MySQLConnection.CloseConection(con);
		}
		return v;
	}
}
