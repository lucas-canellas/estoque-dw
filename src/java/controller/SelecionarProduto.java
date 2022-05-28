/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
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
@WebServlet(name = "SelecionarProduto", urlPatterns = {"/produto"})
public class SelecionarProduto extends HttpServlet {
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getServletPath();
            System.out.println(action);
            String id = request.getParameter("id");
            System.out.println("id= " + id);

            ProdutoDAO dao = new ProdutoDAO();
            int idCategoria = Integer.parseInt(request.getParameter("id"));

            request.setAttribute("id", dao.produtoPorId(idCategoria).getId());
            request.setAttribute("nome_produto", dao.produtoPorId(idCategoria).getNome_produto());
            request.setAttribute("liberado_venda",dao.produtoPorId(idCategoria).getLiberado_venda());


            RequestDispatcher rd = request.getRequestDispatcher("editar-produto.jsp");
            rd.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(SelecionarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
