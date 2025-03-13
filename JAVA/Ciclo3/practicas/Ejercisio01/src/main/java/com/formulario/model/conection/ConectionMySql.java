package com.formulario.model.conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionMySql {
   
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Clase del Driver para versiones recientes
            String url = "jdbc:mysql://localhost:3306/Formulario"; // URL corregida
            String user = "root";
            String password = "mysql";
            
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al obtener la conexión: " + e.getMessage());
        }
        return con;
    }
    
    public static void CloseConnection(Connection con) {
        try {
            if (con != null) con.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
        }
    }
}
