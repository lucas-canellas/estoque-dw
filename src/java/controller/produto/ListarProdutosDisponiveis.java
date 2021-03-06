/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.produto;

import controller.fornecedor.ListarFornecedores;
import dao.ProdutoDAO;
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
@WebServlet(name = "ListarProdutosDisponiveis", urlPatterns = {"/ListarProdutosDisponiveis"})
public class ListarProdutosDisponiveis extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ProdutoDAO dao = new ProdutoDAO();
            request.getSession(true).setAttribute("produtos", dao.listarProdutoDisponivel());

            response.sendRedirect("produtos.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ListarFornecedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
