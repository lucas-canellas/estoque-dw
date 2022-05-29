/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.funcionario;

import controller.fornecedor.SelecionarFornecedor;
import dao.FuncionarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
@WebServlet(name = "SelecionarFuncionario", urlPatterns = {"/funcionario"})
public class SelecionarFuncionario extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getServletPath();
            System.out.println(action);
            String id = request.getParameter("id");
            System.out.println("id= " + id);

            FuncionarioDAO dao = new FuncionarioDAO();
            int idFuncionario = Integer.parseInt(request.getParameter("id"));

            request.setAttribute("id", dao.funcionarioPorId(idFuncionario).getId());
            request.setAttribute("nome", dao.funcionarioPorId(idFuncionario).getNome());
            request.setAttribute("cpf", dao.funcionarioPorId(idFuncionario).getCpf());
            request.setAttribute("senha", dao.funcionarioPorId(idFuncionario).getSenha());
            request.setAttribute("papel", dao.funcionarioPorId(idFuncionario).getPapel());
  
            RequestDispatcher rd = request.getRequestDispatcher("editar-funcionario.jsp");
            rd.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(SelecionarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
