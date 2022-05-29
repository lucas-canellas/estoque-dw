/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pages;

import controller.fornecedor.ListarFornecedores;
import dao.CategoriaDAO;
import dao.FornecedorDAO;
import dao.FuncionarioDAO;
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
@WebServlet(name = "CadastroCompra", urlPatterns = {"/cadastrar-compra-produto"})
public class CadastroCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            FornecedorDAO fornecedor_dao = new FornecedorDAO();
            request.getSession(true).setAttribute("fornecedores", fornecedor_dao.listarFornecedor());
            
            ProdutoDAO produto_dao = new ProdutoDAO();
            request.getSession(true).setAttribute("produtos", produto_dao.listarProduto());
            
            FuncionarioDAO funcionario_dao = new FuncionarioDAO();
            request.getSession(true).setAttribute("funcionarios", funcionario_dao.listarFuncionarios());

            response.sendRedirect("cadastrar-compra-produto.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ListarFornecedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
