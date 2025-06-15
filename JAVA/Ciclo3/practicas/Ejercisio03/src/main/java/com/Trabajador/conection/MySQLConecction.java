package com.Trabajador.conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConecction {
	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Formulario";
			String user = "root";
			String passwrod = "mysql";
			
			con=DriverManager.getConnection(url,user,passwrod);
			
		} catch (Exception e) {
			System.out.println("Ocurrio un error al conseguir la connection");
		}

		return con;
	}

	public static void CloseConnection(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar la connection");
		}
	}
}
