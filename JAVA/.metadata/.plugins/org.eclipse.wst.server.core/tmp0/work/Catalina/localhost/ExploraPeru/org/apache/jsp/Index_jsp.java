/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-21 04:05:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\" />\n");
      out.write("<meta name=\"viewport\"\n");
      out.write("	content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n");
      out.write("<title>Explora Perú</title>\n");
      out.write("<link rel=\"icon\" type=\"image/x-icon\" href=\"assets/favicon.ico\" />\n");
      out.write("<!-- Font Awesome icons -->\n");
      out.write("<script src=\"https://use.fontawesome.com/releases/v6.3.0/js/all.js\"\n");
      out.write("	crossorigin=\"anonymous\"></script>\n");
      out.write("<!-- Google Fonts -->\n");
      out.write("<link\n");
      out.write("	href=\"https://fonts.googleapis.com/css2?family=Tinos:wght@400;700&family=DM+Sans:wght@400;500;700&display=swap\"\n");
      out.write("	rel=\"stylesheet\" />\n");
      out.write("<!-- Core CSS (includes Bootstrap) -->\n");
      out.write("<link\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\n");
      out.write("	rel=\"stylesheet\"\n");
      out.write("	integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\n");
      out.write("	crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("<!-- CSS --> \n");
      out.write("<link href=\"css/prev.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"css/login_styles.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<!-- Background Video -->\n");
      out.write("	<video class=\"bg-video\" playsinline=\"playsinline\" autoplay=\"autoplay\"\n");
      out.write("		muted=\"muted\" loop=\"loop\">\n");
      out.write("		<source src=\"mp4/bg_p.mp4\" type=\"video/mp4\" />\n");
      out.write("	</video>\n");
      out.write("\n");
      out.write("	<!-- Masthead -->\n");
      out.write("	<div class=\"masthead\">\n");
      out.write("		<div class=\"masthead-content text-white\">\n");
      out.write("			<div class=\"container-fluid px-4 px-lg-0\">\n");
      out.write("				<h1 class=\"fst-italic lh-1 mb-4\">Explora Perú - La Aventura\n");
      out.write("					Comienza</h1>\n");
      out.write("				<p class=\"mb-5\">Desde las majestuosas cumbres de los Andes hasta\n");
      out.write("					los misterios de la Amazonía, podrás descubrir y planificar\n");
      out.write("					aventuras inolvidables. Inicia sesión para conocer nuestras ofertas\n");
      out.write("					exclusivas y tours personalizados.</p>\n");
      out.write("\n");
      out.write("				<!-- Boton de Modal -->\n");
      out.write("				<button class=\"btn btn-primary\" data-bs-toggle=\"modal\"\n");
      out.write("					data-bs-target=\"#loginModal\">Iniciar Sesión</button>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("\n");
      out.write("	<!-- Modal -->\n");
      out.write("	<div class=\"modal fade\" id=\"loginModal\" tabindex=\"-1\"\n");
      out.write("		aria-labelledby=\"loginModalLabel\" aria-hidden=\"true\">\n");
      out.write("		<div class=\"modal-dialog\">\n");
      out.write("			<div class=\"modal-content\">\n");
      out.write("				<div class=\"modal-body\">\n");
      out.write("					<div class=\"container\">\n");
      out.write("\n");
      out.write("						<!-- Panel que contiene login y registro -->\n");
      out.write("						<div class=\"panel-wrapper\">\n");
      out.write("\n");
      out.write("							<!-- Panel de Iniciar Sesión -->\n");
      out.write("							<div class=\"login-panel\">\n");
      out.write("								<div class=\"login-form\">\n");
      out.write("									<h2>Iniciar Sesión</h2>\n");
      out.write("									<div class=\"social-login\">\n");
      out.write("										<button class=\"btn-google\">\n");
      out.write("											<img src=\"img/iconos/g_icon.png\">\n");
      out.write("										</button>\n");
      out.write("										<button class=\"btn-facebook\">\n");
      out.write("											<img src=\"img/iconos/f_icon.png\">\n");
      out.write("										</button>\n");
      out.write("									</div>\n");
      out.write("									<p>o ingresa tu correo y contraseña</p>\n");
      out.write("\n");
      out.write("									<!-- Inicio formulario -->\n");
      out.write("									<form action=\"Login\" method=\"post\">\n");
      out.write("										<input type=\"email\" placeholder=\"Correo\" id=\"correoLogin\"\n");
      out.write("											name=\"email\" required> \n");
      out.write("										<input type=\"password\"\n");
      out.write("											placeholder=\"Contraseña\" id=\"contrasenaLogin\"\n");
      out.write("											name=\"contrasena\" required>\n");
      out.write("										<button type=\"submit\" class=\"btn-login\">Ingresar</button>\n");
      out.write("										");
      out.write("\n");
      out.write("									</form>\n");
      out.write("\n");
      out.write("									<!-- Fin formulario -->\n");
      out.write("\n");
      out.write("									<br> <a href=\"#\" class=\"forgot-password\">Olvidé mi\n");
      out.write("										contraseña</a>\n");
      out.write("								</div>\n");
      out.write("								<div class=\"login-info\">\n");
      out.write("									<h2>Hola, Explorador!</h2>\n");
      out.write("									<p>Registrate para utilizar todas las funciones del sitio\n");
      out.write("										web</p>\n");
      out.write("									<button class=\"btn-switch\" id=\"goToRegister\">Registrarse</button>\n");
      out.write("								</div>\n");
      out.write("							</div>\n");
      out.write("\n");
      out.write("							<!-- Panel de Registro -->\n");
      out.write("							<div class=\"register-panel\">\n");
      out.write("								<div class=\"register-info\">\n");
      out.write("									<h2>Bienvenido, Explorador!</h2>\n");
      out.write("									<p>Ingresa tus datos para utilizar todas las funciones del\n");
      out.write("										sitio web</p>\n");
      out.write("									<button class=\"btn-switch\" id=\"goToLogin\">Iniciar\n");
      out.write("										Sesión</button>\n");
      out.write("								</div>\n");
      out.write("								<div class=\"register-form\">\n");
      out.write("									<h2>Crear Cuenta</h2>\n");
      out.write("									<div class=\"social-login\">\n");
      out.write("										<button class=\"btn-google\">\n");
      out.write("											<img src=\"img/iconos/g_icon.png\">\n");
      out.write("										</button>\n");
      out.write("										<button class=\"btn-facebook\">\n");
      out.write("											<img src=\"img/iconos/f_icon.png\">\n");
      out.write("										</button>\n");
      out.write("									</div>\n");
      out.write("									<p>o usa tu correo para registrarte</p>\n");
      out.write("\n");
      out.write("									<!-- Inicio Formulario -->\n");
      out.write("									<form action=\"registro\" method=\"post\">\n");
      out.write("										<input type=\"text\" placeholder=\"Nombre\" id=\"nombre\"\n");
      out.write("											name=\"nombre\" required> <input type=\"email\"\n");
      out.write("											placeholder=\"Correo\" id=\"correo\" name=\"correo\" required>\n");
      out.write("										<input type=\"password\" placeholder=\"Contraseña\" id=\"clave\"\n");
      out.write("											name=\"clave\" required> <input type=\"tel\"\n");
      out.write("											placeholder=\"Número de Teléfono\" id=\"telefono\"\n");
      out.write("											name=\"telefono\" required pattern=\"[0-9]{9}\"> <input\n");
      out.write("											type=\"date\" id=\"fecha-nacimiento\" name=\"cumple\"\n");
      out.write("											placeholder=\"Fecha de Nacimiento\" required>\n");
      out.write("											<input type=\"text\" name=\"img\" placeholder=\"Perfil imagen en Url\" >\n");
      out.write("										<button type=\"submit\" class=\"btn-register\">Registrarse</button>\n");
      out.write("									\n");
      out.write("									</form>\n");
      out.write("									<!-- Fin formulario -->\n");
      out.write("								</div>\n");
      out.write("							</div>\n");
      out.write("							\n");
      out.write("	<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mensaje }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" </div>\n");
      out.write("						</div>\n");
      out.write("\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("	<!-- Bootstrap core JS -->\n");
      out.write("	<script\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("	<!-- JS -->\n");
      out.write("	<script src=\"js/script.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
