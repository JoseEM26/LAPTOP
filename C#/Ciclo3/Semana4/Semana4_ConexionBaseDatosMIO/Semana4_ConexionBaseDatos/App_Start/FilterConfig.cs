﻿using System.Web;
using System.Web.Mvc;

namespace Semana4_ConexionBaseDatos
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
