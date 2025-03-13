using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebEmpleadoCrud.Models
{
    public class Empleado
    {
        public int employee_id { get; set; }
        public string first_name {  get; set; }
        public string last_name { get; set; }   
        public string email { get; set; }
        public string phone_number { get; set; }
        public DateTime hire_date { get; set; }
        public int job_id { get; set; }
        public decimal salary { get; set; }
        public int manager_id {  get; set; }
        public int department_id {  get; set; }

        public Empleado()
        {
            this.first_name = "";
            this.last_name = "";
            this.email = "";
            this.phone_number = "";
            this.hire_date = DateTime.Now;
            this.job_id = 0;
            this.salary = 0;
            this.manager_id = 0;
            this.department_id = 0;   
        }
        public Empleado(int codigoEmpleado)
        {
            this.employee_id= codigoEmpleado;
            this.first_name = "";
            this.last_name = "";
            this.email = "";
            this.phone_number = "";
            this.hire_date = DateTime.Now;
            this.job_id = 0;
            this.salary = 0;
            this.manager_id = 0;
            this.department_id = 0;
        }


    }
}