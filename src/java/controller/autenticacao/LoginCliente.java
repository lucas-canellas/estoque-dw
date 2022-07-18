/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.autenticacao;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;


/**
 *
 * @author lucas
 */
@WebServlet(name = "LoginCliente", urlPatterns = {"/logincliente"})
public class LoginCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            response.setContentType("text/html;charset=UTF-8");
            String cpf = request.getParameter("cpf");
            Cliente cliente = new Cliente(cpf);     
            ClienteDAO dao = new ClienteDAO();
            
            
            if (dao.validarCliente(cliente)) {
                request.getSession(true).setAttribute("ativo", "ativo");                        
                request.getSession(true).setAttribute("papel", "Cliente");
                request.getSession(true).setAttribute("nome", cliente.getNome());
                response.sendRedirect("area-cliente.jsp");
            } else {
                request.getRequestDispatcher("login-cliente.jsp").forward(request, response);
            }

            
        } catch (IOException | SQLException | ServletException e) {
        }
        
    }
}

    