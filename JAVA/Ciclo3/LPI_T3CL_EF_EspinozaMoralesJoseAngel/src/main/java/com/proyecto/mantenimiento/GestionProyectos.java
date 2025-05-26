package com.proyecto.mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.Connection.MySQLConnection;
import com.proyecto.model.Proyecto;
import com.proyecto.model.Tipo;



public class GestionProyectos {
	// registrar
		public int registrar(Proyecto proyecto){
			int ok = 0; // variable de control > 0 (Error) / != 0 > (Éxito)
			Connection con = null; // obtener la conexión con la BD
			PreparedStatement pst = null; // prepara las sentencias a ejecutar
			try {
				con = MySQLConnection.getConexion();

				String sql = "insert into tb_proyecto (nom_proyecto, id_tipo, presupuesto, fecha_inicio, duracion) values (?,?,?,?,?)";

				// prepara la sentencia
				pst = con.prepareStatement(sql);
				// parámetros (de ser necesario)
				pst.setString(1, proyecto.getNom_proyecto());
				pst.setInt(2, proyecto.getId_tipo());
				pst.setDouble(3, proyecto.getPresupuesto());
				pst.setString(4, proyecto.getFecha_inicio());
				pst.setInt(5, proyecto.getDuracion());

				ok = pst.executeUpdate();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			} finally {
				MySQLConnection.closeConexion(con);
			}
			return ok;
		}
		
		public int Eliminar(int codigo){
			int ok = 0; // variable de control > 0 (Error) / != 0 > (Éxito)
			Connection con = null; // obtener la conexión con la BD
			PreparedStatement pst = null; // prepara las sentencias a ejecutar
			try {
				con = MySQLConnection.getConexion();

				String sql = "delete from tb_proyecto where cod_proyecto=?";

				// prepara la sentencia
				pst = con.prepareStatement(sql);
				// parámetros (de ser necesario)
				pst.setInt(1, codigo);
				

				ok = pst.executeUpdate();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			} finally {
				MySQLConnection.closeConexion(con);
			}
			return ok;
		}
		
		public int Actualizr(Proyecto proyecto){
			int ok = 0; // variable de control > 0 (Error) / != 0 > (Éxito)
			Connection con = null; // obtener la conexión con la BD
			PreparedStatement pst = null; // prepara las sentencias a ejecutar
			try {
				con = MySQLConnection.getConexion();

				String sql = "call sp_actualizar_proyecto(?,?,?,?,?,?)";

				// prepara la sentencia
				pst = con.prepareStatement(sql);
				// parámetros (de ser necesario)
				pst.setInt(1, proyecto.getCod_proyecto());
				pst.setString(2, proyecto.getNom_proyecto());
				pst.setInt(3, proyecto.getId_tipo());
				pst.setDouble(4, proyecto.getPresupuesto());
				pst.setString(5, proyecto.getFecha_inicio());
				pst.setInt(6, proyecto.getDuracion());

				ok = pst.executeUpdate();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			} finally {
				MySQLConnection.closeConexion(con);
			}
			return ok;
		}
		
		
	public List<Tipo> ComboBox() {
		List<Tipo> lista = null; // variable a retornar
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null; // almacenará el resultado del select
		try {
			con = MySQLConnection.getConexion();
			
			String sql = "select * from tb_tipo"; // sentencia
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<Tipo>();
			while (rs.next()) { // lee fila x fila hasta el final
				Tipo p = new Tipo();
				// se trae los datos de la consulta
				p.setId_tipo(rs.getInt("id_tipo"));
				p.setDes_tipo_proy(rs.getString("des_tipo_proy"));
				
				lista.add(p); // Agrega el producto al listado
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConnection.closeConexion(con);
		}
		return lista;
	}
	public Proyecto Buscar(int codigo) {
		Proyecto p = null; // variable a retornar
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null; // almacenará el resultado del select
		try {
			con = MySQLConnection.getConexion();
			
			String sql = "select * from tb_proyecto where cod_proyecto=? "; // sentencia
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, codigo);
			
			rs = pst.executeQuery();
			
			p =new Proyecto();
			while (rs.next()) { // lee fila x fila hasta el final
				p = new Proyecto();
				// se trae los datos de la consulta
				p.setCod_proyecto(rs.getInt("cod_proyecto"));
				p.setNom_proyecto(rs.getString("nom_proyecto"));
				p.setId_tipo(rs.getInt("id_tipo"));
				p.setPresupuesto(rs.getDouble("presupuesto"));
				p.setFecha_inicio(rs.getString("fecha_inicio"));
				p.setDuracion(rs.getInt("duracion"));
				
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConnection.closeConexion(con);
		}
		return p;
	}
	public List<Proyecto> ListadoProyecto() {
		List<Proyecto> lista = null; // variable a retornar
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null; // almacenará el resultado del select
		try {
			con = MySQLConnection.getConexion();
			
			String sql = "select * from tb_proyecto"; // sentencia
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<Proyecto>();
			while (rs.next()) { // lee fila x fila hasta el final
				Proyecto p = new Proyecto();
				// se trae los datos de la consulta
				p.setCod_proyecto(rs.getInt("cod_proyecto"));
				p.setNom_proyecto(rs.getString("nom_proyecto"));
				p.setId_tipo(rs.getInt("id_tipo"));
				p.setPresupuesto(rs.getDouble("presupuesto"));
				p.setFecha_inicio(rs.getString("fecha_inicio"));
				p.setDuracion(rs.getInt("duracion"));
				
				lista.add(p); // Agrega el producto al listado
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConnection.closeConexion(con);
		}
		return lista;
	}

}
