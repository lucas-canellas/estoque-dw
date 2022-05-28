/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pages;

import controller.ListarFornecedores;
import dao.CategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CadastrarProduto", urlPatterns = {"/pagina-cadastrar-produto"})
public class CadastrarProduto extends HttpServlet {

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {     
            CategoriaDAO dao = new CategoriaDAO();
            request.getSession(true).setAttribute("categorias", dao.listarCategoria());
            
            response.sendRedirect("cadastrar-produto.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ListarFornecedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
