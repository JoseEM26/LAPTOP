using System.Web;
using System.Web.Mvc;

namespace GuiaMVC3_EntityDataModel
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
