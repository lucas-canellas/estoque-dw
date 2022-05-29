/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.categoria;

import controller.fornecedor.SelecionarFornecedor;
import dao.CategoriaDAO;
import dao.FuncionarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SelecionarCategoria", urlPatterns = {"/categoria"})
public class SelecionarCategoria extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getServletPath();
            System.out.println(action);
            String id = request.getParameter("id");
            System.out.println("id= " + id);

            CategoriaDAO dao = new CategoriaDAO();
            int idCategoria = Integer.parseInt(request.getParameter("id"));

            request.setAttribute("id", dao.categoriaPorId(idCategoria).getId());
            request.setAttribute("nome_categoria", dao.categoriaPorId(idCategoria).getNome_categoria());


            RequestDispatcher rd = request.getRequestDispatcher("editar-categoria.jsp");
            rd.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(SelecionarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
