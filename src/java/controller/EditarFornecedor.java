/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FornecedorDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;

/**
 *
 * @author lucas
 */
@WebServlet(name = "EditarFornecedor", urlPatterns = {"/EditarFornecedor"})
public class EditarFornecedor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        

        Fornecedor fornecedor = new Fornecedor();
        FornecedorDAO dao = new FornecedorDAO();
        
        String id = request.getParameter("id");
        String razao_social = request.getParameter("razao_social");
        String cnpj = request.getParameter("cnpj");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        
        try {
            fornecedor.setId(Integer.parseInt(id));
            fornecedor.setRazao_social(razao_social);
            fornecedor.setCnpj(cnpj);
            fornecedor.setEndereco(endereco);
            fornecedor.setBairro(bairro);
            fornecedor.setCidade(cidade);
            fornecedor.setUf(uf);
            fornecedor.setCep(cep);
            fornecedor.setTelefone(telefone);
            fornecedor.setEmail(email);

            dao.editarFornecedor(fornecedor);
            response.sendRedirect("fornecedores");
        } catch (SQLException ex) {
            Logger.getLogger(EditarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
