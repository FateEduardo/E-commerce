package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<div>\r\n");
      out.write("<!-- \t\t\t\t<form class=\"well\" name=\"myForm\" data-ng-submit=\"editUser()\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t<div class=\"container\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t<div class=\"form-group\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t<div class=\"col-sm-6\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control input-group-lg\" -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t\tplaceholder=\"User Name\" data-ng-required=\"true\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-ng-value=\"\" data-ng-model=\"user.password\" name=\"password\" -->\r\n");
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t\t\t</div> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t</div> -->\r\n");
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t\t<br /> <br /> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t<div class=\"form-group\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t<div class=\"col-sm-6\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control input-group-lg\" -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t\tdata-ng-value=\"\" data-ng-model=\"user.password\" name=\"password\" -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t\tplaceholder=\"Password*\" data-ng-required=\"true\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t</div> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t\t</div> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t<br /> <br /> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t<div class=\"form-group\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t<div class=\"col-sm-6\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-info\" -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t\tdata-ng-click=\"submitted= true;\" -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t\tdata-ng-disabled=\"myForm.$invalid\">Submit</button> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t\t</div> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t\t</div> -->\r\n");
      out.write("<!-- \t\t\t\t\t</div> -->\r\n");
      out.write("<!-- \t\t\t\t</form> -->\r\n");
      out.write("\r\n");
      out.write("    <div class=\"wrapper\">\r\n");
      out.write("    <form class=\"form-signin\">       \r\n");
      out.write("      <h2 class=\"form-signin-heading\">Please login</h2>\r\n");
      out.write("      <input type=\"text\" class=\"form-control\" name=\"username\" placeholder=\"Email Address\" required=\"\" autofocus=\"\" />\r\n");
      out.write("      <input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Password\" required=\"\"/>      \r\n");
      out.write("      <label class=\"checkbox\">\r\n");
      out.write("        <input type=\"checkbox\" value=\"remember-me\" id=\"rememberMe\" name=\"rememberMe\"> Remember me\r\n");
      out.write("      </label>\r\n");
      out.write("      <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Login</button>   \r\n");
      out.write("    </form>\r\n");
      out.write("  </div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
