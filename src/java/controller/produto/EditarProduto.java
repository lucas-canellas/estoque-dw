/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.produto;

import controller.fornecedor.EditarFornecedor;
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
import model.Categoria;
import model.Produto;

/**
 *
 * @author lucas
 */
@WebServlet(name = "EditarProduto", urlPatterns = {"/EditarProduto"})
public class EditarProduto extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Produto produto = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        
        String id = request.getParameter("id");
        String liberado_venda = request.getParameter("liberado_venda");
        request.setAttribute("chamou_cadastro", true);        
        try {
            
            if (request.getSession(false).getAttribute("id_papel") != "2") {
                request.setAttribute("mensagem", "Somente compradores podem alterar o status de liberação do produto.");
            } else {
                request.setAttribute("mensagem", "Alteração realizada com sucesso.");
                produto.setId(Integer.parseInt(id));
                produto.setLiberado_venda(liberado_venda);            
                dao.alterarLiberacao(produto);
            }
            
            RequestDispatcher dis = request.getRequestDispatcher("produtos.jsp");
            dis.forward(request, response);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EditarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
