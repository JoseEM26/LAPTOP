/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-21 04:07:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FormActUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"Estilos/boostrap.css\">\n");
      out.write("<link\n");
      out.write("	href=\"https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css\"\n");
      out.write("	rel=\"stylesheet\">\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"Estilos/FormActUsuario.css\"><script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "fragmetos/Nav.jsp", out, false);
      out.write("\n");
      out.write("<body>\n");
      out.write("	<div class=\"registration-form\">\n");
      out.write("		<form action=\"ActualizarUsuario\" method=\"post\">\n");
      out.write("			<div class=\"form-icon\"\n");
      out.write("				style=\"display: flex; justify-content: center; align-items: center; width: 120px; height: 120px; background-color: white; border-radius: 50%; padding: 5px;\">\n");
      out.write("				<img alt=\"Error al encontrar img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.img}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" onerror=\"this.src='https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_640.png'\"\n");
      out.write("					style=\"width: 100px; height: 100px; border-radius: 50%; object-fit: cover;\">\n");
      out.write("			</div>\n");
      out.write("\n");
      out.write("			<div class=\"form-group\">\n");
      out.write("				<label>Nombre Usuario:</label> <input type=\"text\" name=\"nombre\"\n");
      out.write("					class=\"form-control item\" id=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.nombreUsuario }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("					placeholder=\"Nombre Usuario\">\n");
      out.write("			</div>\n");
      out.write("			<div class=\"form-group\">\n");
      out.write("				<label>Email:</label> <input type=\"text\" class=\"form-control item\" name=\"email\"\n");
      out.write("					id=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.email }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Correo Electronico\">\n");
      out.write("			</div>\n");
      out.write("			<div class=\"form-group\">\n");
      out.write("				<label>Contraseña:</label> <input type=\"password\" name=\"contrasena\"\n");
      out.write("					class=\"form-control item\" id=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.contraseña }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("					placeholder=\"Antigua Contraseña\">\n");
      out.write("			</div>\n");
      out.write("\n");
      out.write("			<div class=\"form-group\">\n");
      out.write("				<label>Fecha Nacimiento:</label> <input type=\"date\" name=\"fecha\"\n");
      out.write("					class=\"form-control item\" id=\"birth-date\"\n");
      out.write("					value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.fechaCumpleaños }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Fecha Nacimiento\">\n");
      out.write("			</div>\n");
      out.write("			<div class=\"form-group\">\n");
      out.write("				<label>Telefono:</label> <input type=\"number\" name=\"telefono\"\n");
      out.write("					class=\"form-control item\" id=\"birth-date\"\n");
      out.write("					value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.telefono }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"999-999-999\">\n");
      out.write("			</div>\n");
      out.write("			<div class=\"form-group\">\n");
      out.write("				<label>Url Imagen:</label> <input type=\"text\" name=\"img\"\n");
      out.write("					class=\"form-control item\" id=\"birth-date\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.img }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("					placeholder=\"Url Imagen\">\n");
      out.write("			</div>\n");
      out.write("			<div class=\"form-group\">\n");
      out.write("				<button type=\"submit\" class=\"btn btn-block create-account\">Actualizar</button>\n");
      out.write("			</div>\n");
      out.write("		</form>\n");
      out.write("		<div class=\"social-media\">\n");
      out.write("			<h5>Siguenos en nuestras redes sociales</h5>\n");
      out.write("			<div class=\"social-icons\">\n");
      out.write("				<a href=\"#\"><i class=\"icon-social-facebook\" title=\"Facebook\"></i></a>\n");
      out.write("				<a href=\"#\"><i class=\"icon-social-google\" title=\"Google\"></i></a> <a\n");
      out.write("					href=\"#\"><i class=\"icon-social-twitter\" title=\"Twitter\"></i></a>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("	<script type=\"text/javascript\"\n");
      out.write("		src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n");
      out.write("	<script type=\"text/javascript\"\n");
      out.write("		src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js\"></script>\n");
      out.write("	<script src=\"assets/js/script.js\"></script>\n");
      out.write("	\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("	<script\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
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
