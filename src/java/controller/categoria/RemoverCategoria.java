/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.categoria;

import controller.fornecedor.RemoverFornecedor;
import dao.CategoriaDAO;
import java.io.IOException;
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
@WebServlet(name = "RemoverCategoria", urlPatterns = {"/RemoverCategoria"})
public class RemoverCategoria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        try {
            CategoriaDAO dao = new CategoriaDAO();
            int categoria = Integer.parseInt(request.getParameter("id"));
            dao.removerCategoria(categoria);            
        } catch (SQLException ex) {
            request.setAttribute("chamou_cadastro", true);
            request.setAttribute("mensagem", "Não é possivel deletar uma categoria caso ela tenha algum registro ativo no sistema.");
            Logger.getLogger(RemoverFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dis = request.getRequestDispatcher("categorias.jsp");
        dis.forward(request, response);
    }
}
