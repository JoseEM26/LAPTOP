package com.ciberfarma.mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ciberfarma.conexion.MySQLConexion;
import com.ciberfarma.model.Producto;

public class GestionProducto {
	// --- procesos del CRUD ---

	// registrar
	public int registrar(Producto objProducto) throws Exception {
		int ok = 0; // variable de control > 0 (Error) / != 0 > (Éxito)
		Connection con = null; // obtener la conexión con la BD
		PreparedStatement pst = null; // prepara las sentencias a ejecutar
		try {
			con = MySQLConexion.getConexion();

			// sentencia sql
			// insert into tb_productos values ('P0031','Mascarilla KN95 cj
			// 10',100,25.0,5,1)
			String sql = "insert into tb_productos values (?,?,?,?,?,1)";

			// prepara la sentencia
			pst = con.prepareStatement(sql);
			// parámetros (de ser necesario)
			pst.setString(1, objProducto.getIdprod());
			pst.setString(2, objProducto.getDescripcion());
			pst.setInt(3, objProducto.getStock());
			pst.setDouble(4, objProducto.getPrecio());
			pst.setInt(5, objProducto.getIdcategoria());

			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}

	// eliminar
	public int eliminar(Producto objProducto) throws Exception {
		int ok = 0;
		return ok;
	}

	// actualizar
	public int actualizar(Producto objProducto) throws Exception {
		int ok = 0;
		return ok;
	}

	// listar TODOS los Productos
	public List<Producto> listado() {
		List<Producto> lista = null; // variable a retornar
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null; // almacenará el resultado del select
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "select * from tb_productos"; // sentencia
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<Producto>();
			while (rs.next()) { // lee fila x fila hasta el final
				Producto p = new Producto();
				// se trae los datos de la consulta
				p.setIdprod(rs.getString("idprod"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setStock(rs.getInt("stock"));
				p.setPrecio(rs.getDouble("precio"));
				p.setIdcategoria(rs.getInt("idcategoria"));
				p.setEstado(rs.getInt("estado"));
				lista.add(p); // Agrega el producto al listado
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

	public List<Producto> filtro(int categoria) {
		List<Producto> lista = null; 
		
		return lista;
	}
	
	
	// buscar

}
