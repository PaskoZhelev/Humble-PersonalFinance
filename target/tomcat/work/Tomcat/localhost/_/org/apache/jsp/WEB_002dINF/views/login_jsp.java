/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-07-13 07:21:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/../common/header.jspf", Long.valueOf(1499813213363L));
    _jspx_dependants.put("/WEB-INF/views/../common/footer.jspf", Long.valueOf(1499813784891L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--[if lt IE 7]> <html class=\"ie ie6 lt-ie9 lt-ie8 lt-ie7\" lang=\"en\"> <![endif]-->\r\n");
      out.write("<!--[if IE 7]>    <html class=\"ie ie7 lt-ie9 lt-ie8\"        lang=\"en\"> <![endif]-->\r\n");
      out.write("<!--[if IE 8]>    <html class=\"ie ie8 lt-ie9\"               lang=\"en\"> <![endif]-->\r\n");
      out.write("<!--[if IE 9]>    <html class=\"ie ie9\"                      lang=\"en\"> <![endif]-->\r\n");
      out.write("<!--[if !IE]><!-->\r\n");
      out.write("<html lang=\"en\" class=\"no-ie\">\r\n");
      out.write("<!--<![endif]-->\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("   <!-- Meta-->\r\n");
      out.write("   <meta charset=\"utf-8\">\r\n");
      out.write("   <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0\">\r\n");
      out.write("   <meta name=\"description\" content=\"\">\r\n");
      out.write("   <meta name=\"keywords\" content=\"\">\r\n");
      out.write("   <meta name=\"author\" content=\"\">\r\n");
      out.write("   <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("   <!--[if lt IE 9]><script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script><script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script><![endif]-->\r\n");
      out.write("   <!-- Bootstrap CSS-->\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"app/css/bootstrap.css\">\r\n");
      out.write("   <!-- Vendor CSS-->\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"vendor/fontawesome/css/font-awesome.min.css\">\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"vendor/animo/animate+animo.css\">\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"vendor/csspinner/csspinner.min.css\">\r\n");
      out.write("   <!-- START Page Custom CSS-->\r\n");
      out.write("   <!-- END Page Custom CSS-->\r\n");
      out.write("   <!-- App CSS-->\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"app/css/app.css\">\r\n");
      out.write("   <!-- Modernizr JS Script-->\r\n");
      out.write("   <script src=\"vendor/modernizr/modernizr.js\" type=\"application/javascript\"></script>\r\n");
      out.write("   <!-- FastClick for mobiles-->\r\n");
      out.write("   <script src=\"vendor/fastclick/fastclick.js\" type=\"application/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("   <title>Login Panel</title>\r\n");
      out.write("   </head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("   <!-- START Main wrapper-->\r\n");
      out.write("   <section class=\"wrapper\">\r\n");
      out.write("            \r\n");
      out.write("      <!-- START Main section-->\r\n");
      out.write("      <section>\r\n");
      out.write("         <!-- START Page content-->\r\n");
      out.write("         \r\n");
      out.write("                  \r\n");
      out.write("         <section class=\"main-content\">\r\n");
      out.write("         \r\n");
      out.write("         <div class=\"row\">\r\n");
      out.write("         <div class=\"col-lg-2\"></div>\r\n");
      out.write("         \r\n");
      out.write("         <div class=\"col-lg-5\">\r\n");
      out.write("         <!-- conditional display of a second password field -->\r\n");
      out.write("            \r\n");
      out.write("                ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("      \t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("      \t\t\t\r\n");
      out.write("            <div class=\"panel panel-info\">\r\n");
      out.write("                        <div class=\"panel-heading\">\r\n");
      out.write("                           <div class=\"panel-title\">Login Form</div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                       <form action=\"/login\" method=\"post\">\r\n");
      out.write("                        <div class=\"panel-body\">                          \r\n");
      out.write("                           <div class=\"form-group\">\r\n");
      out.write("                              <label class=\"control-label\">Username</label>\r\n");
      out.write("                              <input type=\"text\" name=\"username\" required class=\"form-control\">\r\n");
      out.write("                           </div>\r\n");
      out.write("                           <div class=\"form-group\">\r\n");
      out.write("                              <label class=\"control-label\">Password</label>\r\n");
      out.write("                              <input type=\"password\" name=\"password\" required class=\"form-control\">\r\n");
      out.write("                           </div>   \r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"panel-footer\">\r\n");
      out.write("                           <button type=\"submit\" class=\"btn btn-info\" >Login</button>\r\n");
      out.write("                           &nbsp; &nbsp;\r\n");
      out.write("                           <a href=\"/register\"><label class=\"control-label\">Register new account</label></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                       </form>\r\n");
      out.write("                     </div>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"col-lg-2\"></div>\r\n");
      out.write("         </div>\r\n");
      out.write("         </section>\r\n");
      out.write("         \r\n");
      out.write("         \r\n");
      out.write("         <!-- END Page content-->\r\n");
      out.write("      </section>\r\n");
      out.write("      <!-- END Main section-->\r\n");
      out.write("   </section>\r\n");
      out.write("   <!-- END Main wrapper-->\r\n");
      out.write("      <script src=\"vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("   <script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("   <!-- Plugins-->\r\n");
      out.write("   <script src=\"vendor/chosen/chosen.jquery.min.js\"></script>\r\n");
      out.write("   <script src=\"vendor/slider/js/bootstrap-slider.js\"></script>\r\n");
      out.write("   <script src=\"vendor/filestyle/bootstrap-filestyle.min.js\"></script>\r\n");
      out.write("   <!-- Animo-->\r\n");
      out.write("   <script src=\"vendor/animo/animo.min.js\"></script>\r\n");
      out.write("   <!-- Sparklines-->\r\n");
      out.write("   <script src=\"vendor/sparklines/jquery.sparkline.min.js\"></script>\r\n");
      out.write("   <!-- Slimscroll-->\r\n");
      out.write("   <script src=\"vendor/slimscroll/jquery.slimscroll.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   <!-- App Main-->\r\n");
      out.write("   <script src=\"app/js/app.js\"></script>\r\n");
      out.write("   <!-- END Scripts-->\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/views/login.jsp(22,16) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty unsuccessfulLogin}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("         \t\t\t<div class=\"alert alert-danger\">Username or Password is incorrect!</div>\r\n");
        out.write("      \t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/views/login.jsp(25,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty successfulRegistration}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("         \t\t\t<div class=\"alert alert-success\">The Registration is Successful!</div>\r\n");
        out.write("      \t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
