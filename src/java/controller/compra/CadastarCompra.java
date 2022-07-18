/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.compra;

import dao.CompraDAO;
import dao.ProdutoDAO;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Compra;
import model.Produto;

@WebServlet(name = "CadastarCompra", urlPatterns = {"/cadastro-compra"})
public class CadastarCompra extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String data = request.getParameter("data_compra");

            Integer quantidade_compra = Integer.parseInt(request.getParameter("quantidade_compra"));
            Date data_compra = formatter.parse(data);
            Integer valor_compra = Integer.parseInt(request.getParameter("valor_compra"));
            Integer id_fornecedor = Integer.parseInt(request.getParameter("id_fornecedor"));
            Integer id_produto = Integer.parseInt(request.getParameter("id_produto"));
            Integer id_funcionario = Integer.parseInt(request.getParameter("id_funcionario"));

            Compra compra = new Compra(quantidade_compra, data_compra, valor_compra, id_fornecedor, id_produto, id_funcionario);
            CompraDAO dao_compra = new CompraDAO();
            ProdutoDAO dao_produto = new ProdutoDAO();
            Produto produto = dao_produto.produtoPorId(id_produto);

            Integer quantidade_anterior = produto.getQuantidade_disponivel();
            Integer nova_quantidade = quantidade_anterior + quantidade_compra;
            request.setAttribute("chamou_cadastro", true);
            
            if (request.getSession(false).getAttribute("id_papel") != "2") {
                request.setAttribute("mensagem", "Somente compradores podem cadastrar a compra.");
            } else if (quantidade_compra <= 0) {
                request.setAttribute("mensagem", "A quantidade de itens comprados não podem ser menor ou igual a zero..");
            } else {
                request.setAttribute("chamou_cadastro", false);
                dao_compra.cadastrarCompra(compra);
                dao_produto.atualizarPrecoCompra(compra);
                dao_produto.incrementarQuantidade(id_produto, nova_quantidade);

                RequestDispatcher dis = request.getRequestDispatcher("compras.jsp");
                dis.forward(request, response);
            }

            RequestDispatcher dis = request.getRequestDispatcher("cadastrar-compra-produto.jsp");
            dis.forward(request, response);

        } catch (ParseException | SQLException ex) {
            Logger.getLogger(CadastarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
