package com.Trabajador.Conecction;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	public static Connection getConnection() {
		Connection con=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Formulario";
			String user="root";
			String password="mysql";
			
			con=DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			System.out.println("Ocurrio un error al conseguir la conexion");
		}
		
		return con;
	}
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println("Ocurrio un error al Cerrar la conexion");
		}
	}

}