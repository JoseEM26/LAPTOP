using System.Web;
using System.Web.Mvc;

namespace GuiaMVC2_intento3
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
