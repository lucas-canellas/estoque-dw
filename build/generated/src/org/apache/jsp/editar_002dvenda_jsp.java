package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;

public final class editar_002dvenda_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/navbar.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Editar Venda</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">    \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/painel.css\">\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"image/icons8-produto-16.png\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"d-flex\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("        \n");
      out.write("            <div class=\"w-100\">\n");
      out.write("                ");
      out.write("<header class=\"navbar d-flex \">\n");
      out.write("    <div class=\"d-flex ml-auto\">        \n");
      out.write("        <a class=\"ml-2\" href=\"LogoutServlet\" style=\"color: #FFF\">               \n");
      out.write("            Sair\n");
      out.write("        </a>\n");
      out.write("    </div>    \n");
      out.write("</header>");
      out.write("\n");
      out.write("                <div class=\"w-100\">\n");
      out.write("                    <div class=\"card container mt-5\">               \n");
      out.write("                        <form class=\"form-group\" method=\"POST\" action=\"cadastro-venda\" >\n");
      out.write("                            <input type=\"hidden\" name=\"id\" value=\"");
out.print(request.getAttribute("id"));
      out.write("\"  />\n");
      out.write("                            <input type=\"hidden\" id=\"teste\" value=\"");
out.print(request.getAttribute("id_funcioanrio"));
      out.write("\"  />\n");
      out.write("                            <div>\n");
      out.write("                                <label for=\"quantidade_venda\">Quantidade:</label>\n");
      out.write("                                <input class=\"form-control\" value=\"");
out.print(request.getAttribute("quantidade_venda"));
      out.write("\" type=\"text\" name=\"quantidade_venda\" id=\"quantidade_venda\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <label for=\"data_venda\">Data da compra:</label>\n");
      out.write("                                <input class=\"form-control\" value=\"");
out.print(request.getAttribute("data_venda"));
      out.write("\" type=\"text\" name=\"data_venda\" id=\"data_venda\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <label for=\"valor_venda\">Valor da compra::</label>\n");
      out.write("                                <input class=\"form-control\" type=\"text\" value=\"");
out.print(request.getAttribute("valor_venda"));
      out.write("\" name=\"valor_venda\"  id=\"valor_venda\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <label for=\"id_cliente\">Cliente:</label>\n");
      out.write("                                <select class=\"form-control\" name=\"id_cliente\" aria-label=\"Default select example\">\n");
      out.write("                                    <option selected>Selecione o cliente</option>                                \n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("  \n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <label for=\"id_produto\">Produto:</label>\n");
      out.write("                                <select class=\"form-control\" name=\"id_produto\" aria-label=\"Default select example\">\n");
      out.write("                                    <option selected>Selecione o produto</option>                                \n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("  \n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <label for=\"id_funcionario\">Funcionário:</label>\n");
      out.write("                                <select class=\"form-control\" name=\"id_funcionario\" aria-label=\"Default select example\">                                                                  \n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("  \n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\" mt-3\">\n");
      out.write("                                <div>\n");
      out.write("                                    <button type=\"submit\" class=\"button-entrar-login\">Enviar</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"jquery-3.4.1.min.js\"></script>\n");
      out.write("        <script src=\"popper.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.mask.js\"></script>\n");
      out.write("        <script src=\"js/validacao.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            const val = document.querySelector('.teste').value;\n");
      out.write("            function teste(valor) {\n");
      out.write("                var select_clie = document.querySelectorAll('.clie_value');\n");
      out.write("                var select_prod = document.querySelectorAll('.prod_value');\n");
      out.write("                var select_func = document.querySelectorAll('.func_value');\n");
      out.write("                var option;\n");
      out.write("                \n");
      out.write("                                for (var i = 0; i < select_func.options.length; i++) {\n");
      out.write("                    option = select_func.options[i];\n");
      out.write("\n");
      out.write("                    if (option.value == valor) {\n");
      out.write("                        option.selected = true;\n");
      out.write("                        return;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                for (var i = 0; i < select_func.options.length; i++) {\n");
      out.write("                    option = select_func.options[i];\n");
      out.write("\n");
      out.write("                    if (option.value == valor) {\n");
      out.write("                        option.selected = true;\n");
      out.write("                        return;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            teste(val);\n");
      out.write("            \n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("cliente");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientes}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVarStatus("id");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                        <option class=\"clie_value\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cliente.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cliente.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>                                    \n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("produto");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produtos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVarStatus("id");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                        <option class=\"prod_value\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.nome_produto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>                                    \n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setVar("funcionario");
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${funcionarios}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVarStatus("id");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                        <option class=\"func_value\"  value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${funcionario.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${funcionario.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>                                    \n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
}
