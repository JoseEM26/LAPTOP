package com.bus.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bd_Espinoza";
			String user = "root";
			String Pass = "mysql";

			con = DriverManager.getConnection(url, user, Pass);

		} catch (Exception e) {
			System.out.println("Error en la connection" + e.getMessage());
		}

		return con;
	}

	public static void CloseConnection(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println("Error en la cerrar connection" + e.getMessage());
		}
	}
}
