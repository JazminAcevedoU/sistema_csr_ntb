package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class frmLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("    <link href=\"css/bootstrap_4/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <title>Document</title>\n");
      out.write("    <style>\n");
      out.write("            html, body, .container-position-center{\n");
      out.write("                height: 100% !important;\n");
      out.write("                position: relative;\n");
      out.write("                background-color: #2E5287;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <section class=\"container-position-center d-flex align-items-center justify-content-center\">\n");
      out.write("            <div class=\"card p-4 col-4\">\n");
      out.write("                <div class=\"col-12 d-flex justify-content-center\">\n");
      out.write("                    <div class=\"col-6 d-flex justify-content-end\">\n");
      out.write("                        <img src=\"css/img/usuario3.png\" width=\"100%\" height=\"100%\">\n");
      out.write("                    </div> \n");
      out.write("                </div>\n");
      out.write("                    <div class=\" col-12 d-flex justify-content-center mt-5\">\n");
      out.write("                        <form class=\"form-signin\" action=\"sesion\" method=\"POST\">\n");
      out.write("                            <!--USUARIO-->\n");
      out.write("                            <div class=\"form-group row\">\n");
      out.write("                                <label class=\"col-sm-4 col-form-label px-0\">Usuario</label>\n");
      out.write("                                <div class=\"col-sm-8 p-0\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" name=\"correo\" placeholder=\"usuario\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group row\">\n");
      out.write("                                <label class=\"col-sm-4 col-form-label px-0\">Clave</label>\n");
      out.write("                                <div class=\"col-sm-8 p-0\">\n");
      out.write("                                    <input type=\"Password\" class=\"form-control\" name=\"contrasenia\" placeholder=\"clave\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                            <div class=\"form-group row d-flex align-items-center justify-content-center mt-5\">\n");
      out.write("                                <button class=\"btn btn-primary mb-2 form-control\">Ingresar</button>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group row d-flex align-items-center justify-content-center mt-5 text-center\">\n");
      out.write("                                <a href=\"persona\">Crear Cuenta</a>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
