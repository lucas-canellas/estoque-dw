/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.fornecedor;

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
@WebServlet(name = "RemoverFornecedor", urlPatterns = {"/RemoverFornecedor"})
public class RemoverFornecedor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        request.setAttribute("chamou_cadastro", true);
        try {

            if (request.getSession(false).getAttribute("id_papel") != "2") {
                request.setAttribute("mensagem", "Somente compradores podem remover um fornecedor.");
            } else {
                request.setAttribute("mensagem", "Fornecedor removido com sucesso.");
                FornecedorDAO dao = new FornecedorDAO();
                int fornecedor = Integer.parseInt(request.getParameter("id"));
                dao.removerFornecedor(fornecedor);
            }

        } catch (SQLException ex) {
            request.setAttribute("mensagem", "Não é possivel deletar um fornecedor caso ele tenha algum registro ativo no sistema.");
        }

        RequestDispatcher dis = request.getRequestDispatcher("fornecedores.jsp");
        dis.forward(request, response);

    }

}
