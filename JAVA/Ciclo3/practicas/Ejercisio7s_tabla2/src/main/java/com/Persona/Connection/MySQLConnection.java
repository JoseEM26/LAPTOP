package com.Persona.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ciberfarmaweb";
            String user = "root";
            String password = "mysql";
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Error al obtener la conexión: " + e.getMessage());
        }
        return con;
    }

    public static void CloseConnection(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
