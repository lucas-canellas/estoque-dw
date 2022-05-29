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
        try {
            FornecedorDAO dao = new FornecedorDAO();
            int fornecedor = Integer.parseInt(request.getParameter("id"));
            dao.removerFornecedor(fornecedor);
            response.sendRedirect("fornecedores");
        } catch (SQLException ex) {
            Logger.getLogger(RemoverFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}