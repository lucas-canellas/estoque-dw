/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FornecedorDAO;
import dao.FuncionarioDAO;
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
import model.Fornecedor;
import model.Funcionario;

/**
 *
 * @author lucas
 */
@WebServlet(name = "EditarFuncionario", urlPatterns = {"/EditarFuncionario"})
public class EditarFuncionario extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Funcionario funcionario = new Funcionario();
        FuncionarioDAO dao = new FuncionarioDAO();
        
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String papel = request.getParameter("papel");

            System.out.println(request.getParameter("id"));
            System.out.println(request.getParameter("nome"));
            System.out.println(request.getParameter("cpf"));
            System.out.println(request.getParameter("senha"));
            System.out.println(request.getParameter("papel"));
        try {
            funcionario.setId(Integer.parseInt(id));
            funcionario.setNome(nome);
            funcionario.setCpf(cpf);
            funcionario.setSenha(senha);
            funcionario.setPapel(papel);


            dao.editarFuncionario(funcionario);

            response.sendRedirect("funcionarios");
        } catch (SQLException ex) {
            Logger.getLogger(EditarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
