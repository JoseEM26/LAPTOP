package com.producto.Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.producto.connection.MySQLConnection;
import com.producto.model.Producto;

public class GestionProducto {
	public List<Producto> listaProducto() {
		List<Producto> lista = null;
		PreparedStatement ps = null;
		Connection con = null;
		String statement = "select *from Productos";
		ResultSet rs=null;

		try {
			lista=new ArrayList<Producto>();
			con=MySQLConnection.getConnection();
			ps=con.prepareStatement(statement);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Producto p= new Producto();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getDouble("precio"));
				
				lista.add(p);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}finally {
			MySQLConnection.CloseConection(con);
		}

		return lista;
	}
}
