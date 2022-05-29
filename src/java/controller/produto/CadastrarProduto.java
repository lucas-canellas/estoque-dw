/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.produto;

import controller.cliente.CadastrarCliente;
import dao.ProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

/**
 *
 * @author lucas
 */
@WebServlet(name = "CadastrarProduto2", urlPatterns = {"/CadastrarProduto2"})
public class CadastrarProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nome_produto = request.getParameter("nome_produto");
        String descricao  = request.getParameter("descricao");
        Double preco_compra = Double.parseDouble(request.getParameter("preco_compra"));
        Double preco_venda = Double.parseDouble(request.getParameter("preco_venda"));
        Integer quantidade_disponível = Integer.parseInt(request.getParameter("quantidade_disponivel"));
        String liberado_venda = request.getParameter("liberado_venda");
        Integer id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
        
        System.out.println(nome_produto);
        System.out.println(descricao);
        System.out.println(preco_compra);
        System.out.println(preco_venda);
        System.out.println(quantidade_disponível);
        System.out.println(liberado_venda);
        System.out.println(id_categoria);        
        
        Produto produto = new Produto(nome_produto,descricao,preco_compra,preco_venda, quantidade_disponível,liberado_venda, id_categoria );
        ProdutoDAO dao = new ProdutoDAO();

        try { 
            dao.cadastrarProduto(produto);
            response.sendRedirect("painel.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
