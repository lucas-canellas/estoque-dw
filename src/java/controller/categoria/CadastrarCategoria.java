/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.categoria;

import controller.cliente.CadastrarCliente;
import dao.CategoriaDAO;
import dao.ClienteDAO;
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

/**
 *
 * @author lucas
 */
@WebServlet(name = "CadastrarCategoria", urlPatterns = {"/CadastrarCategoria"})
public class CadastrarCategoria extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String nome_categoria = request.getParameter("nome_categoria");

            Categoria categoria = new Categoria(nome_categoria);
            CategoriaDAO dao = new CategoriaDAO();
            request.setAttribute("chamou_cadastro", true);

            if (request.getSession(false).getAttribute("id_papel") != "2") {
                request.setAttribute("mensagem", "Somente compradores podem cadastrar a compra.");
            } else {
                request.setAttribute("mensagem", "Categoria cadastrada com sucesso.");
                dao.cadastrarCategoria(categoria);                
            }
            
            RequestDispatcher dis = request.getRequestDispatcher("categorias.jsp");
            dis.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
