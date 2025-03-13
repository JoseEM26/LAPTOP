using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WebEmpleadoCrud.Models;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Configuration;
using System.Web.Security;
namespace WebEmpleadoCrud.dao.daoImpl
{
    public class EmpleadoDaoImpl : IEmpleadoDao
    {
        public int operacionesEscritura(string indicador, Empleado e)
        {
            int procesar = -1;
           
            try
            {
                using (SqlConnection con = new SqlConnection(
                        ConfigurationManager.ConnectionStrings["cnx_bd_hr"].ConnectionString            
                    ))
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("usp_empleado_crud", con);
                    cmd.CommandType = System.Data.CommandType.StoredProcedure;
                    cmd.Parameters.Clear();
                    cmd.Parameters.AddWithValue("@indicador", indicador);
                    cmd.Parameters.AddWithValue("@employee_id", e.employee_id);
                    cmd.Parameters.AddWithValue("@first_name", e.first_name);
                    cmd.Parameters.AddWithValue("@last_name", e.last_name);
                    cmd.Parameters.AddWithValue("@email", e.email);
                    cmd.Parameters.AddWithValue("@phone_number", e.phone_number);
                    cmd.Parameters.AddWithValue("@hire_date", e.hire_date);
                    cmd.Parameters.AddWithValue("@job_id", e.job_id);
                    cmd.Parameters.AddWithValue("@salary", e.salary);
                    cmd.Parameters.AddWithValue("@manager_id", e.manager_id);
                    cmd.Parameters.AddWithValue("@department_id", e.department_id);
                    procesar = cmd.ExecuteNonQuery();
                }
            }
            catch (Exception ex)
            {
                Debug.WriteLine("operacionesEscritura- Error : " + ex);
            }
            return procesar;
        }

        public List<Empleado> operacionesLectura(string indicador, Empleado e)
        {
            List<Empleado> lista= new List<Empleado>();
            try
            {
                using (SqlConnection con = new SqlConnection(
                        ConfigurationManager.ConnectionStrings["cnx_bd_hr"].ConnectionString
                    ))
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("usp_empleado_crud", con);
                    cmd.CommandType = System.Data.CommandType.StoredProcedure;
                    cmd.Parameters.Clear();
                    cmd.Parameters.AddWithValue("@indicador", indicador);
                    cmd.Parameters.AddWithValue("@employee_id", e.employee_id);
                    cmd.Parameters.AddWithValue("@first_name", e.first_name);
                    cmd.Parameters.AddWithValue("@last_name", e.last_name);
                    cmd.Parameters.AddWithValue("@email", e.email);
                    cmd.Parameters.AddWithValue("@phone_number", e.phone_number);
                    cmd.Parameters.AddWithValue("@hire_date", e.hire_date);
                    cmd.Parameters.AddWithValue("@job_id", e.job_id);
                    cmd.Parameters.AddWithValue("@salary", e.salary);
                    cmd.Parameters.AddWithValue("@manager_id", e.manager_id);
                    cmd.Parameters.AddWithValue("@department_id", e.department_id);

                    using (SqlDataReader reader = cmd.ExecuteReader())
                    {
                        Empleado emp;
                        while (reader.Read())
                        {
                            emp= new Empleado();
                            emp.employee_id = reader.GetInt32(0);
                            emp.first_name = reader.GetString(1);
                            emp.last_name = reader.GetString(2);
                            emp.email = reader.GetString(3);
                            emp.phone_number = reader.GetString(4);
                            emp.hire_date = reader.GetDateTime(5);
                            emp.job_id = reader.GetInt32(6);
                            emp.salary= reader.GetDecimal(7);
                            emp.manager_id = reader.GetInt32(8);
                            emp.department_id = reader.GetInt32(9);
                            lista.Add(emp);
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                Debug.WriteLine("operacionesLectura- Error : " + ex.ToString());
            }
            return lista;
        }
    
        
    }
}