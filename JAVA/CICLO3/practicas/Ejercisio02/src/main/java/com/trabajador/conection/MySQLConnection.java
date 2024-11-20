package com.trabajador.conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    public static Connection getConnection() {
    	Connection con=null;
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Formulario";
			String user="root";
			String password="mysql";
			
			con=DriverManager.getConnection(url,user,password);
			
    		
		} catch (Exception e) {
			System.out.println("Ocurrio un error al conseguir una conexion");
		}
		return con;

    }
    
    public static void CloseConnection(Connection con) {
    	try {
			con.close();
		} catch (Exception e) {
			System.out.println("Ocurrio un error al cerrar la conection");
		}
    }
}
