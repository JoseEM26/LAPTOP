using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Linq;
using System.Web;
using WebEmpleadoCrud.Models;

namespace WebEmpleadoCrud.dao.daoImpl
{
    public class FormularioDaoImpl : FormularioDao
    {
        public List<Combo> listadoCombo(string indicador)
        {
            List<Combo> lista = new List<Combo>();
            try
            {
                using (SqlConnection con= new SqlConnection(ConfigurationManager.ConnectionStrings["cnx_bd_hr"].ConnectionString))
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("usp_formulario_combo", con );
                    cmd.CommandType = System.Data.CommandType.StoredProcedure;
                    cmd.Parameters.Clear();
                    cmd.Parameters.AddWithValue("@indicador", indicador);
                    using (SqlDataReader reader = cmd.ExecuteReader())
                    {
                        Combo objCombo;
                        while (reader.Read())
                        {
                            objCombo = new Combo();
                            objCombo.indicador = reader.GetString(0);
                            objCombo.combo_id = reader.GetInt32(1);
                            objCombo.combo_name= reader.GetString(2);
                            lista.Add(objCombo);
                        }
                    }

                }
            }catch (Exception ex)
            {
                Debug.WriteLine("listadoCombo - Error : " + ex.Message);
            }
            return lista;
        }
    }
}