/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pages;

import controller.CadastarCompra;
import controller.CadastrarCliente;
import controller.ListarFornecedores;
import dao.ClienteDAO;
import dao.CompraDAO;
import dao.FornecedorDAO;
import dao.FuncionarioDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Compra;
import model.Produto;
import model.Venda;

/**
 *
 * @author lucas
 */
@WebServlet(name = "CadastrarVenda", urlPatterns = {"/pagina-cadastrar-venda"})
public class CadastrarVenda extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ClienteDAO cliente_dao = new ClienteDAO();
            request.getSession(true).setAttribute("clientes", cliente_dao.listarCliente());
            
            ProdutoDAO produto_dao = new ProdutoDAO();
            request.getSession(true).setAttribute("produtos", produto_dao.listarProduto());
            
            FuncionarioDAO funcionario_dao = new FuncionarioDAO();
            request.getSession(true).setAttribute("funcionarios", funcionario_dao.listarFuncionarios());

            response.sendRedirect("cadastrar-venda-produto.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ListarFornecedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
