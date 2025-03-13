package com.ExploraPeru.Mantenimiento;

import com.ExploraPeru.Connection.MySQLConnection;
import com.ExploraPeru.model.Boleta;
import com.ExploraPeru.model.DetalleBoleta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MantenimientoBoleta {
    // --- procesos del CRUD ---
	public String generarNumBoleta() {
		String codigo = "B0001"; // valor x default
		// Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConnection.getConnection();
			String sql = "select substr(max(NUM_BOL),2) from tb_cab_boleta";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				codigo = String.format("B%04d", rs.getInt(1) + 1);
			}
		} catch (Exception e) {
			System.out.println("Error en generaNumBoleta : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return codigo;
	}

	public int RealizarVenta(Boleta b, List<DetalleBoleta> d) {
		int rs = 0;
		// Plantilla
		Connection con = null;
		PreparedStatement pst1 = null; // REGISTRAR LA CABECERA DE BOLETA
		PreparedStatement pst2 = null; // REGISTRAR LA TABLA DETALLE BOLETA
		PreparedStatement pst3 = null; // ACTUALIZAR LOS PRODUCTOS
		try {
			con = MySQLConnection.getConnection();

			con.setAutoCommit(false);

			String sql1 = "insert into tb_cab_boleta values (?,curdate(),?)";
			pst1 = con.prepareStatement(sql1);

			b.setNum_bol(generarNumBoleta());
			pst1.setString(1, b.getNum_bol());
			pst1.setInt(2, b.getId_usuario());
			rs = pst1.executeUpdate();

			String sql2 = "insert into tb_det_boleta values (?,?,?,?)";
			String sql3 = "update VUELOS set plazas_disponibles = plazas_disponibles - ? where id_vuelo = ?";
			for (DetalleBoleta boleta : d) {
				pst2 = con.prepareStatement(sql2);
				pst2.setString(1, b.getNum_bol()); // mismo dato de la cabecera
				pst2.setInt(2, boleta.getIdViaje());
				pst2.setInt(3, boleta.getCantidad());
				pst2.setDouble(4, boleta.getPrecio());
				rs += pst2.executeUpdate();

				pst3 = con.prepareStatement(sql3);
				pst3.setInt(1, boleta.getCantidad());
				pst3.setInt(2, boleta.getIdViaje());

				rs += pst3.executeUpdate();
			}

			con.commit();
		} catch (Exception e) {
			System.out.println("Error en realizar Venta : " + e.getMessage());
			rs = 0;
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al cerrar : " + e1.getMessage());
			}
		} finally {
			MySQLConnection.CloseConection(con);
		}
		return rs;
	}
    // Registrar boleta (encabezado de boleta)
    public int registrar(Boleta objBoleta) throws Exception {
        int ok = 0; // variable de control
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "INSERT INTO tb_cab_boleta (num_bol, fch_bol, id_usuario) VALUES (?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objBoleta.getNum_bol());
            pst.setDate(2, Date.valueOf(objBoleta.getFch_bol()));  // Convertir String a Date
            pst.setInt(3, objBoleta.getId_usuario());

            ok = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al registrar boleta: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return ok;
    }

    // Eliminar boleta
    public int eliminar(String numBol) throws Exception {
        int ok = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "DELETE FROM tb_cab_boleta WHERE num_bol = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, numBol);
            ok = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar boleta: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return ok;
    }

    // Actualizar boleta
    public int actualizar(Boleta objBoleta) throws Exception {
        int ok = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "UPDATE tb_cab_boleta SET fch_bol = ?, id_usuario = ? WHERE num_bol = ?";
            pst = con.prepareStatement(sql);
            pst.setDate(1, Date.valueOf(objBoleta.getFch_bol()));  // Convertir String a Date
            pst.setInt(2, objBoleta.getId_usuario());
            pst.setString(3, objBoleta.getNum_bol());  // Número de boleta para la actualización
            ok = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar boleta: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return ok;
    }

    // Listar todas las boletas
    public List<Boleta> listado() {
        List<Boleta> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "SELECT * FROM tb_cab_boleta";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Boleta b = new Boleta();
                b.setNum_bol(rs.getString("num_bol"));
                b.setFch_bol(rs.getString("fch_bol"));
                b.setId_usuario(rs.getInt("id_usuario"));

                lista.add(b);
            }
        } catch (Exception e) {
            System.out.println("Error en listado de boletas: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return lista;
    }

    // Obtener boleta por número de boleta
    public Boleta obtener(String numBol) {
        Boleta b = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySQLConnection.getConnection();
            String sql = "SELECT * FROM tb_cab_boleta WHERE num_bol = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, numBol);
            rs = pst.executeQuery();

            if (rs.next()) {
                b = new Boleta();
                b.setNum_bol(rs.getString("num_bol"));
                b.setFch_bol(rs.getString("fch_bol"));
                b.setId_usuario(rs.getInt("id_usuario"));
            }
        } catch (Exception e) {
            System.out.println("Error en obtener boleta: " + e.getMessage());
        } finally {
            MySQLConnection.CloseConection(con);
        }
        return b;
    }
}
