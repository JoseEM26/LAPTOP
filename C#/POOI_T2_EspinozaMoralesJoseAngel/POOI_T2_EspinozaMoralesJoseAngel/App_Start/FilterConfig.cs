using System.Web;
using System.Web.Mvc;

namespace POOI_T2_EspinozaMoralesJoseAngel
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
