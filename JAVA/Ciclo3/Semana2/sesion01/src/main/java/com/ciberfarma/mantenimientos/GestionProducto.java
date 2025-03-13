package com.ciberfarma.mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ciberfarma.conexion.MySQLConexion;
import com.ciberfarma.model.Producto;

public class GestionProducto {
	// --- procesos del CRUD ---
	
	// registrar
	public int registrar(Producto objProducto) throws Exception {
		int ok = 0;  // variable de control > 0 (Error) / != 0 > (Éxito)
		Connection con = null;  		// obtener la conexión con la BD 
		PreparedStatement pst = null;   // prepara las sentencias a ejecutar
		try {			
			con = MySQLConexion.getConexion();
			
			// sentencia sql
			// insert into tb_productos values ('P0031','Mascarilla KN95 cj 10',100,25.0,5,1)
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
		}catch(Exception e){
				System.out.println("Error: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}
	
	// eliminar
	public int eliminar(Producto objProducto) throws Exception {
		int ok = 0; 
		Connection con = null;  		 
		PreparedStatement pst = null;   
		try {			
			con = MySQLConexion.getConexion();
			
			// sentencia sql
			// delete from tb_productos where idprod = 'P0040'
			// String sql = "delete from tb_productos where idprod = ?";
			
			// update tb_productos set estado = 2, stock = 0 where idprod = 'P0019'
			String sql = "update tb_productos set estado = 2, stock = 0 where idprod = ?";
			
			// prepara la sentencia 
			pst = con.prepareStatement(sql);
			// parámetros (de ser necesario) 
			pst.setString(1, objProducto.getIdprod());
			 
			ok = pst.executeUpdate(); 
		}catch(Exception e){
				System.out.println("Error: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}
	
	// actualizar
	public int actualizar(Producto objProducto) throws Exception {
		int ok = 0;  
		Connection con = null;  		
		PreparedStatement pst = null;   
		try {			
			con = MySQLConexion.getConexion();
			
			// sentencia sql
			// update tb_productos set descripcion = '', stock = 0, precio = 0.0, idcategoria = 0, estado = 1 where idprod = 'P0019'
			// String sql = "update tb_productos set descripcion = ?, stock = ?, precio = ?, idcategoria = ?, estado = ? where idprod = ?";
			
			// call usp_actprod ('nuevo',90,90.90, 1, 1, 'P0019')
			String sql = "call usp_actprod (?,?,?,?,?,?)";
			
			// prepara la sentencia 
			pst = con.prepareStatement(sql);
			// parámetros (de ser necesario) 
			pst.setString(1, objProducto.getDescripcion());
			pst.setInt(2, objProducto.getStock());
			pst.setDouble(3, objProducto.getPrecio());
			pst.setInt(4, objProducto.getIdcategoria());
			pst.setInt(5, objProducto.getEstado());
			pst.setString(6, objProducto.getIdprod());
			 
			ok = pst.executeUpdate(); 
		}catch(Exception e){
				System.out.println("Error: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}
	// listar
	
	// buscar
	
	
	
}
