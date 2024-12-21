package com.ExploraPeru.Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ExploraPeru.Connection.MySQLConnection;
import com.ExploraPeru.Interfaz.MantenimientoCrud;
import com.ExploraPeru.model.Tarjeta;
import com.ExploraPeru.model.TipoTarjeta;
import com.ExploraPeru.model.Vuelos;

public class MantenimientoTarjetaCredito implements MantenimientoCrud<Tarjeta> {

	@Override
	public List<Tarjeta> getLista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tarjeta Details() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Actualizar() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Eliminar() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Insertar() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Tarjeta obtener(Tarjeta t) {
		Tarjeta v = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConnection.getConnection();
			String sql = "select*from TarjetasVisa where numeroTarjeta=? and FechaValidacion=? and CVV=? and idTipo=?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, t.getNumeroTarjeta());
			pst.setString(2, t.getFechaValidacion());
			pst.setInt(3, t.getCVV());
			pst.setInt(4, t.getIdTipo());
			rs = pst.executeQuery();

			if (rs.next()) {
				v = new Tarjeta();
				v.setNumeroTarjeta(rs.getString("numeroTarjeta"));
				v.setFechaValidacion(rs.getString("fechaValidacion"));
				v.setCVV(rs.getInt("CVV"));
				v.setIdTipo(rs.getInt("idTipo"));
			
			}
		} catch (Exception e) {
			System.out.println("Error en obtener: " + e.getMessage());
		} finally {
			MySQLConnection.CloseConection(con);
		}
		return v;
	}

	public List<TipoTarjeta> ComboBox() {

		List<TipoTarjeta> lista = new ArrayList<TipoTarjeta>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConnection.getConnection();
			String sql = "SELECT * FROM tipoTarjeta";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TipoTarjeta t = new TipoTarjeta();
				t.setIdTipo(rs.getInt("idTipo"));
				t.setNombreTipo(rs.getString("nombreTipo"));
				lista.add(t);
			}
		} catch (Exception e) {
			System.out.println("Error en filtro: " + e.getMessage());
		} finally {
			MySQLConnection.CloseConection(con);
		}
		return lista;
	}
}
