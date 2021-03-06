/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.funcionario;

import controller.fornecedor.ListarFornecedores;
import dao.FuncionarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
@WebServlet(name = "ListarFuncionarios", urlPatterns = {"/funcionarios"})
public class ListarFuncionarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {     
            FuncionarioDAO dao = new FuncionarioDAO();
            request.getSession(true).setAttribute("funcionarios", dao.listarFuncionarios());
            
            response.sendRedirect("funcionarios.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ListarFornecedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
