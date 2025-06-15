package com.formulario.mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.formulario.Intefaz.Crud;
import com.formulario.model.Trabajador;
import com.formulario.model.conection.ConectionMySql;

public class GestionProductos implements Crud {

    @Override
    public int Insertar(Trabajador t) {
        Connection con = null;
        PreparedStatement ps = null;
        int estado = 0;

        try {
            con = ConectionMySql.getConnection();
            String sentencia = "INSERT INTO trabajador (dni, nombre, apellido, edad, direccion, fecha) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sentencia);

            ps.setInt(1, t.getDni());  // Asegúrate de usar el método correcto según el tipo de dato
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido());
            ps.setInt(4, t.getEdad());
            ps.setString(5, t.getDireccion());
            ps.setString(6, t.getFecha()); // Suponiendo que fecha es un String; si es otro tipo, cambia el método

            estado = ps.executeUpdate(); // Ejecuta el comando y devuelve el número de filas afectadas

        } catch (Exception e) {
            System.out.println("Ocurrió un error en el CRUD Insertar: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                ConectionMySql.CloseConnection(con);
            } catch (Exception e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return estado;
    }

    @Override
    public int update(Trabajador t) {
    	 Connection con = null;
         PreparedStatement ps = null;
         int estado = 0;

         try {
             con = ConectionMySql.getConnection();
             String sentencia = "CALL ActualizarTrabajador(?,?,?,?,?,?)";
             ps = con.prepareStatement(sentencia);

             ps.setInt(1, t.getDni());  // Asegúrate de usar el método correcto según el tipo de dato
             ps.setString(2, t.getNombre());
             ps.setString(3, t.getApellido());
             ps.setInt(4, t.getEdad());
             ps.setString(5, t.getDireccion());
             ps.setString(6, t.getFecha()); // Suponiendo que fecha es un String; si es otro tipo, cambia el método

             estado = ps.executeUpdate(); // Ejecuta el comando y devuelve el número de filas afectadas

         } catch (Exception e) {
             System.out.println("Ocurrió un error en el CRUD Insertar: " + e.getMessage());
         } finally {
             try {
                 if (ps != null) ps.close();
                 ConectionMySql.CloseConnection(con);
             } catch (Exception e) {
                 System.out.println("Error al cerrar recursos: " + e.getMessage());
             }
         }
         return estado;
    }

    @Override
    public int Eliminar(Trabajador t) {
    	 Connection con = null;
         PreparedStatement ps = null;
         int estado = 0;

         try {
             con = ConectionMySql.getConnection();
             String sentencia = "delete from trabajador where dni=?";
             ps = con.prepareStatement(sentencia);

             ps.setInt(1, t.getDni());  // Asegúrate de usar el método correcto según el tipo de dato
        

             estado = ps.executeUpdate(); // Ejecuta el comando y devuelve el número de filas afectadas

         } catch (Exception e) {
             System.out.println("Ocurrió un error en el CRUD Insertar: " + e.getMessage());
         } finally {
             try {
                 if (ps != null) ps.close();
                 ConectionMySql.CloseConnection(con);
             } catch (Exception e) {
                 System.out.println("Error al cerrar recursos: " + e.getMessage());
             }
         }
         return estado;
    }
}
