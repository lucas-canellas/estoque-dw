/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
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


@WebServlet(name = "SelecionarVenda", urlPatterns = {"/venda"})
public class SelecionarVenda extends HttpServlet {

     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {     
            
            ClienteDAO cliente_dao = new ClienteDAO();
            request.setAttribute("clientes", cliente_dao.listarCliente());         
     
            
            ProdutoDAO produto_dao = new ProdutoDAO();
            request.setAttribute("produtos", produto_dao.listarProduto());
            
            FuncionarioDAO funcionario_dao = new FuncionarioDAO();
            request.setAttribute("funcionarios", funcionario_dao.listarFuncionarios());

            VendaDAO dao = new VendaDAO();
            int idVenda = Integer.parseInt(request.getParameter("id")); 

            request.setAttribute("id", dao.vendaPorId(idVenda).getId());
            request.setAttribute("quantidade_venda", dao.vendaPorId(idVenda).getQuantidade_venda());
            request.setAttribute("data_venda", dao.vendaPorId(idVenda).getData_venda());
            request.setAttribute("valor_venda", dao.vendaPorId(idVenda).getValor_venda());
            request.setAttribute("id_cliente", dao.vendaPorId(idVenda).getId_cliente());
            request.setAttribute("id_produto", dao.vendaPorId(idVenda).getId_produto());
            request.setAttribute("id_funcionario", dao.vendaPorId(idVenda).getId_funcionario());
  
            RequestDispatcher rd = request.getRequestDispatcher("editar-venda.jsp");
            rd.forward(request, response);
            


        } catch (SQLException ex) {
            Logger.getLogger(SelecionarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
