package controller;

import dao.FuncionarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        try {
            response.setContentType("text/html;charset=UTF-8");
            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");
            Funcionario user = new Funcionario(cpf, senha);
            FuncionarioDAO dao = new FuncionarioDAO();

            if (dao.validarFuncionario(user)) {
                request.getSession(true).setAttribute("ativo", "ativo");
                Cookie papel = new Cookie("papel", String.valueOf(user.getPapel()));
                response.addCookie(papel);
                response.sendRedirect("painel.jsp");
            } else {                
                request.setAttribute("falha", "Erro de autenticação");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

            
        } catch (Exception e) {
        }


    }

}