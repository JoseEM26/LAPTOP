package com.producto.mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.producto.Interzas.Iproducto;
import com.producto.conection.MySQLConnection;
import com.producto.model.Producto;

public class Mantenimiento implements Iproducto {

	@Override
	public List<Producto> listarProducto() {
		List<Producto> lista = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String statement = "select * from Productos";

		try {
			con =MySQLConnection.getConnection();
			ps = con.prepareStatement(statement);
			rs = ps.executeQuery();

			while (rs.next()) {
				Producto p = new Producto();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setPrecio(rs.getInt("precio"));
				p.setStock(rs.getInt("stock"));
				p.setCategoria(rs.getString("categoria"));
				p.setFecha_creacion(rs.getDate("fecha_creacion"));

				lista.add(p);

			}

		} catch (Exception e) {
			System.out.println("Error en mantenimineto");
		} finally {
           MySQLConnection.CloseConnection(con);
		}

		return lista;
	}

}
