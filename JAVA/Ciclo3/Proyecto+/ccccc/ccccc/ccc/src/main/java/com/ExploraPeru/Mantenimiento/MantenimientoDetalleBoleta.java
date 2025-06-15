
package com.ExploraPeru.Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ExploraPeru.Connection.MySQLConnection;
import com.ExploraPeru.model.DetBoleta;

public class MantenimientoDetalleBoleta {

    // Registrar un detalle de boleta
  

    // Listar todos los detalles de las boletas
    public List<DetBoleta> listadoCompleto() {
        List<DetBoleta> lista = new ArrayList<DetBoleta>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "SELECT * FROM tb_det_boleta";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                DetBoleta det = new DetBoleta();
                det.setNum_bol(rs.getString("num_bol"));
                det.setId_destino(rs.getInt("id_destino"));
                det.setCantidad(rs.getInt("cantidad"));
                det.setPreciovta(rs.getDouble("preciovta"));
                lista.add(det);
            }
        } catch (Exception e) {
            System.out.println("Error en listado completo detalle boleta: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return lista;
    }

    // Eliminar detalle de boleta
    public int eliminar(String numBol, int idDestino) throws Exception {
        int ok = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "DELETE FROM tb_det_boleta WHERE num_bol = ? AND id_destino = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, numBol);
            pst.setInt(2, idDestino);
            ok = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar detalle boleta: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return ok;
    }

    // Actualizar detalle de boleta
    public int actualizar(DetBoleta objDetBoleta) throws Exception {
        int ok = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "UPDATE tb_det_boleta SET cantidad = ?, preciovta = ? WHERE num_bol = ? AND id_destino = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, objDetBoleta.getCantidad());
            pst.setDouble(2, objDetBoleta.getPreciovta());
            pst.setString(3, objDetBoleta.getNum_bol());
            pst.setInt(4, objDetBoleta.getId_destino());

            ok = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar detalle boleta: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return ok;
    }

	/*
	 * // Listar detalles de boletas por número de boleta public List<DetBoleta>
	 * listadoPorNumBoleta(String numBol) { List<DetBoleta> lista = new
	 * ArrayList<DetBoleta>(); Connection con = null; PreparedStatement pst = null;
	 * ResultSet rs = null; try { con = MySQLConnection.getConnection(); String sql
	 * = "SELECT * FROM tb_det_boleta WHERE num_bol = ?"; pst =
	 * con.prepareStatement(sql); pst.setString(1, numBol); rs = pst.executeQuery();
	 * 
	 * while (rs.next()) { DetBoleta det = new DetBoleta();
	 * det.setNum_bol(rs.getString("num_bol")); det.set(rs.getInt("id_destino"));
	 * det.setCantidad(rs.getInt("cantidad"));
	 * det.setPrecio(rs.getDouble("preciovta")); lista.add(det); } } catch
	 * (Exception e) { System.out.println("Error en listado detalle boleta: " +
	 * e.getMessage()); } finally { MySQLConnection.CloseConection(con); } return
	 * lista; }
	 */

    // Obtener detalle de boleta por número de boleta y destino
    public DetBoleta obtener(String numBol, int idDestino) {
        DetBoleta det = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "SELECT * FROM tb_det_boleta WHERE num_bol = ? AND id_destino = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, numBol);
            pst.setInt(2, idDestino);
            rs = pst.executeQuery();

            if (rs.next()) {
                det = new DetBoleta();
                det.setNum_bol(rs.getString("num_bol"));
                det.setId_destino(rs.getInt("id_destino"));
                det.setCantidad(rs.getInt("cantidad"));
                det.setPreciovta(rs.getDouble("preciovta"));
            }
            System.out.println("estamos en el obtener");
        } catch (Exception e) {
            System.out.println("Error al obtener detalle boleta: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return det;
    }
}