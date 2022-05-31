/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.compra;

import controller.fornecedor.SelecionarFornecedor;
import dao.ClienteDAO;
import dao.CompraDAO;
import dao.FornecedorDAO;
import dao.FuncionarioDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
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
@WebServlet(name = "SelecionarCompra", urlPatterns = {"/compra"})
public class SelecionarCompra extends HttpServlet {
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {     
            
            FornecedorDAO fornecedor_dao = new FornecedorDAO();
            request.setAttribute("fornecedores", fornecedor_dao.listarFornecedor()); 
            
            ProdutoDAO produto_dao = new ProdutoDAO();
            request.setAttribute("produtos", produto_dao.listarProduto());
            
            FuncionarioDAO funcionario_dao = new FuncionarioDAO();
            request.setAttribute("funcionarios", funcionario_dao.listarFuncionarios());

            CompraDAO dao = new CompraDAO();
            int idCompra = Integer.parseInt(request.getParameter("id")); 

            request.setAttribute("id", dao.compraPorId(idCompra).getId());
            request.setAttribute("quantidade_compra", dao.compraPorId(idCompra).getQuantidade_compra());
            request.setAttribute("data_compra", dao.compraPorId(idCompra).getData_compra());
            request.setAttribute("valor_compra", dao.compraPorId(idCompra).getValor_compra());
            request.setAttribute("id_fornecedor", dao.compraPorId(idCompra).getId_fornecedor());
            request.setAttribute("id_produto", dao.compraPorId(idCompra).getId_produto());
            request.setAttribute("id_funcionario", dao.compraPorId(idCompra).getId_funcionario());
  
            RequestDispatcher rd = request.getRequestDispatcher("editar-compra.jsp");
            rd.forward(request, response);
            


        } catch (SQLException ex) {
            Logger.getLogger(SelecionarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
