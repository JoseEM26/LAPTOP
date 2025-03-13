package com.ExploraPeru.Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ExploraPeru.Connection.MySQLConnection;
import com.ExploraPeru.model.Contacto;

public class MantenimientoContactanos {
public Contacto filtroContactoPorId(Integer idContacto) {
    Contacto contacto = null;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {
        con = MySQLConnection.getConnection();
        
        // Consulta SQL para buscar por ID
        String sql = "SELECT * FROM CONTACTANOS WHERE idcontacto = ?";
        
        pst = con.prepareStatement(sql);
        pst.setInt(1, idContacto);  // Establecer el valor del ID

        rs = pst.executeQuery();

        if (rs.next()) {
            contacto = new Contacto();
            contacto.setIdContacto(rs.getInt("idcontacto"));
            contacto.setNombreContacto(rs.getString("nombreContacto"));
            contacto.setEmailContacto(rs.getString("emailContacto"));
            contacto.setNumeroContacto(rs.getString("numeroContacto"));
            contacto.setMensajeContacto(rs.getString("mensajeContacto"));
        }
    } catch (Exception e) {
        System.out.println("Error en filtro por ID: " + e.getMessage());
    } finally {
        MySQLConnection.CloseConection(con);
    }

    return contacto;  // Retorna un solo contacto o null si no se encuentra
}
	public int InsertarContactanos(Contacto c) {
		int ok = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String statement = "INSERT INTO CONTACTANOS (nombreContacto, emailContacto, numeroContacto, mensajeContacto)values (?,?,?,?)";

		try {

			con=MySQLConnection.getConnection();
			ps=con.prepareStatement(statement);
			ps.setString(1,c.getNombreContacto());
			ps.setString(2,c.getEmailContacto());
			ps.setString(3,c.getNumeroContacto());
			ps.setString(4,c.getMensajeContacto());
			
			ok=ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			System.out.println("Error en insertar contactanos");
		}finally {
			MySQLConnection.CloseConection(con);
		}

		return ok;
	}
	 // Eliminar
    public int eliminar(int idContacto) throws Exception {
        int ok = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "DELETE FROM CONTACTANOS WHERE idcontacto = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idContacto);
            ok = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return ok;
    }

    // Actualizar
    public int actualizar(Contacto objContacto) throws Exception {
        int ok = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "UPDATE CONTACTANOS SET nombreContacto = ?, emailContacto = ?, numeroContacto = ?, mensajeContacto = ? WHERE idcontacto = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, objContacto.getNombreContacto());
            pst.setString(2, objContacto.getEmailContacto());
            pst.setString(3, objContacto.getNumeroContacto());
            pst.setString(4, objContacto.getMensajeContacto());
            pst.setInt(5, objContacto.getIdContacto());

            ok = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return ok;
    }

    // Listar todos los contactos
    public List<Contacto> listado() {
        List<Contacto> lista =new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "SELECT * FROM CONTACTANOS";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Contacto c = new Contacto();
                c.setIdContacto(rs.getInt("idcontacto"));
                c.setNombreContacto(rs.getString("nombreContacto"));
                c.setEmailContacto(rs.getString("emailContacto"));
                c.setNumeroContacto(rs.getString("numeroContacto"));
                c.setMensajeContacto(rs.getString("mensajeContacto"));

                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error en listado: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return lista;
    }

    // Obtener contacto por ID
    public Contacto obtener(int idContacto) {
        Contacto c = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "SELECT * FROM CONTACTANOS WHERE idcontacto = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idContacto);
            rs = pst.executeQuery();

            if (rs.next()) {
                c = new Contacto();
                c.setIdContacto(rs.getInt("idcontacto"));
                c.setNombreContacto(rs.getString("nombreContacto"));
                c.setEmailContacto(rs.getString("emailContacto"));
                c.setNumeroContacto(rs.getString("numeroContacto"));
                c.setMensajeContacto(rs.getString("mensajeContacto"));
            }
        } catch (Exception e) {
            System.out.println("Error en obtener: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return c;
    }
}
