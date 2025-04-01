using System.Web;
using System.Web.Mvc;

namespace GuiaMVC4_EntityWithSQL
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
