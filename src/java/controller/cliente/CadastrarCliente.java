/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cliente;

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
import model.Cliente;

/**
 *
 * @author lucas
 */
@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastrarCliente"})
public class CadastrarCliente extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");

        Cliente cliente = new Cliente(nome, cpf, endereco, bairro, cidade, uf, cep, telefone, email);
        ClienteDAO dao = new ClienteDAO();
        request.setAttribute("chamou_cadastro", true);

        try {
            Cliente c_temp = dao.clientePorCpf(cpf);

            if (request.getSession(false).getAttribute("id_papel") != "1") {
                request.setAttribute("mensagem", "Somente vendedores podem cadastrar um cliente.");
            } else {
                if (c_temp.getCpf() == null) {
                    request.setAttribute("mensagem", "Cliente cadastrado com sucesso");
                    dao.cadastrarCliente(cliente);
                } else {
                    request.setAttribute("mensagem", "CPF j?? cadastrado.");
                }
            }

            RequestDispatcher dis = request.getRequestDispatcher("clientes.jsp");
            dis.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
