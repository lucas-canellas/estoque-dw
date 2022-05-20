package controller;

import connection.Conexao;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        try {
            response.setContentType("text/html;charset=UTF-8");
            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");
            Usuario user = new Usuario(cpf, senha);
            UsuarioDAO dao = new UsuarioDAO();

            if (dao.validarUsuario(user)) {
                request.getSession(true).setAttribute("user_id", user.getNome());
                Cookie userName = new Cookie("username", user.getCpf());
                response.addCookie(userName);
//                request.getRequestDispatcher("painel.jsp").forward(request, response);
                response.sendRedirect("painel.jsp");
            } else {                
                request.setAttribute("falha", "Erro de autenticação");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

//            }
        } catch (Exception e) {
        }


    }

}
