package com.ExploraPeru.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	public static Connection getConnection() {
		Connection con = null;

		try {
               Class.forName("com.mysql.jdbc.Driver");
               String url="jdbc:mysql://localhost:3306/ExploraPeru";
               String user="root";
               String pass="mysql";
               
               con=DriverManager.getConnection(url,user,pass);
			
		} catch (Exception e) {
			System.out.println("Conseguir la connection");
		}

		return con;
	}
	
	public static void CloseConection(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println("Close la CloseConection");
		}
	}
}