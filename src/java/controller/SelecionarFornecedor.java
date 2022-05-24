/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.Fornecedor;
import model.Funcionario;

/**
 *
 * @author lucas
 */
@WebServlet(name = "SelecionarFornecedor", urlPatterns = {"/fornecedor"})
public class SelecionarFornecedor extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getServletPath();
            System.out.println(action);
            String id = request.getParameter("id");
            System.out.println("id= " + id);

            FornecedorDAO dao = new FornecedorDAO();
            int idFornecedor = Integer.parseInt(request.getParameter("id"));

            request.setAttribute("id", dao.fornecedorPorId(idFornecedor).getId());
            request.setAttribute("bairro", dao.fornecedorPorId(idFornecedor).getBairro());
            request.setAttribute("razao_social", dao.fornecedorPorId(idFornecedor).getRazao_social());
            request.setAttribute("cnpj", dao.fornecedorPorId(idFornecedor).getCnpj());
            request.setAttribute("endereco", dao.fornecedorPorId(idFornecedor).getEndereco());
            request.setAttribute("bairro", dao.fornecedorPorId(idFornecedor).getBairro());
            request.setAttribute("cidade", dao.fornecedorPorId(idFornecedor).getCidade());
            request.setAttribute("uf", dao.fornecedorPorId(idFornecedor).getUf());
            request.setAttribute("cep", dao.fornecedorPorId(idFornecedor).getCep());
            request.setAttribute("telefone", dao.fornecedorPorId(idFornecedor).getTelefone());
            request.setAttribute("email", dao.fornecedorPorId(idFornecedor).getEmail());

            RequestDispatcher rd = request.getRequestDispatcher("editar-fornecedor.jsp");
            rd.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(SelecionarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
