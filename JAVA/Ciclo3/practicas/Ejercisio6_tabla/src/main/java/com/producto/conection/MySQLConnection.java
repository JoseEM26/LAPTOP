package com.producto.conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	public static Connection getConnection() {
		Connection con = null;
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// ?useSSL=false&useTimezone=true&serverTimezone=UTC
			String url = "jdbc:mysql://localhost:3306/ciberfarmaweb";
			String usr = "root";
			String psw = "mysql";
			con = DriverManager.getConnection(url, usr, psw);
			
		} catch (Exception e) {
			System.out.println("Error al conseguir la connection");
		}

		return con;
	}
	
	public static void CloseConnection(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
		 System.out.println("Error al cerrar connection");
		}
	}
}
