/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cliente;

import controller.fornecedor.RemoverFornecedor;
import dao.ClienteDAO;
import dao.FornecedorDAO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author lucas
 */
@WebServlet(name = "RemoverCliente", urlPatterns = {"/RemoverCliente"})
public class RemoverCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("chamou_cadastro", true);
        try {
            if (request.getSession(false).getAttribute("id_papel") != "1") {
                request.setAttribute("mensagem", "Somente vendedores podem excluir um cliente.");
            } else {
                request.setAttribute("mensagem", "Cliente removido com sucesso.");
                ClienteDAO dao = new ClienteDAO();
                int cliente = Integer.parseInt(request.getParameter("id"));
                dao.removerCliente(cliente);
            }

        } catch (SQLException ex) {
            request.setAttribute("mensagem", "Não é possivel deletar um cliente caso ele tenha algum registro ativo no sistema.");
        }

        RequestDispatcher dis = request.getRequestDispatcher("clientes.jsp");
        dis.forward(request, response);

    }
}
