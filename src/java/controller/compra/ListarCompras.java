/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.compra;

import controller.fornecedor.ListarFornecedores;
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
@WebServlet(name = "ListarCompras", urlPatterns = {"/compras"})
public class ListarCompras extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            CompraDAO dao = new CompraDAO();
            request.setAttribute("compras", dao.listarCompras());

            FornecedorDAO fornecedores_dao = new FornecedorDAO();
            ProdutoDAO produto_dao = new ProdutoDAO();
            FuncionarioDAO funcionario_dao = new FuncionarioDAO();

            request.setAttribute("fornecedores", fornecedores_dao);
            request.setAttribute("produtos", produto_dao);
            request.setAttribute("funcionarios", funcionario_dao);

            RequestDispatcher disp = request.getRequestDispatcher("compras.jsp");
            disp.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ListarFornecedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
