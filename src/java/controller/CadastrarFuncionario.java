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
@WebServlet(name = "CadastrarFuncionario", urlPatterns = {"/CadastrarFuncionario"})
public class CadastrarFuncionario extends HttpServlet {

     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");       
        
       
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String papel = request.getParameter("papel");
        
       Funcionario funcionario = new Funcionario(nome, cpf, senha,papel );
       FuncionarioDAO dao = new FuncionarioDAO();
         System.out.println(nome);
         System.out.println(cpf);
         System.out.println(senha);
         System.out.println(papel);
        try {
            dao.cadastrarFuncionario(funcionario);
            response.sendRedirect("funcionarios");
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
