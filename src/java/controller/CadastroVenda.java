/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import dao.VendaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import model.Venda;

@WebServlet(name = "CadastroVenda", urlPatterns = {"/cadastro-venda"})
public class CadastroVenda extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String data = request.getParameter("data_venda");

            Integer quantidade_venda = Integer.parseInt(request.getParameter("quantidade_venda"));
            Date data_venda = formatter.parse(data);
            Double valor_compra = Double.parseDouble(request.getParameter("valor_venda"));
            Integer id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
            Integer id_produto = Integer.parseInt(request.getParameter("id_produto"));
            Integer id_funcionario = Integer.parseInt(request.getParameter("id_funcionario"));

            Venda venda = new Venda(quantidade_venda, data_venda, valor_compra, id_cliente, id_produto, id_funcionario);
            VendaDAO dao_venda = new VendaDAO();
            ProdutoDAO dao_produto = new ProdutoDAO();
            Produto produto = dao_produto.produtoPorId(id_produto);
            request.setAttribute("chamou_cadastro", true);

            Integer quantidade_anterior = produto.getQuantidade_disponivel();
            Integer nova_quantidade = quantidade_anterior - quantidade_venda;

            if (produto.getQuantidade_disponivel() <= 0 && request.getSession(false).getAttribute("id_papel") == "1") {

                request.setAttribute("mensagem", "Não existe produto disponível.");

            } else if ("N".equals(produto.getLiberado_venda()) && request.getSession(false).getAttribute("id_papel") == "1") {

                request.setAttribute("mensagem", "Produto não liberado para venda.");

            } else if (request.getSession(false).getAttribute("id_papel") != "1") {

                request.setAttribute("mensagem", "Somente vendedores podem vender.");

            } else {
                try {
                    dao_venda.cadastrarVenda(venda);
                    dao_produto.decrementarQuantidade(venda, nova_quantidade);
                    request.setAttribute("mensagem", "Dados da venda cadastrado com sucesso");

                } catch (SQLException ex) {
                    Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            RequestDispatcher dis = request.getRequestDispatcher("cadastrar-venda-produto.jsp");
            dis.forward(request, response);

        } catch (ParseException | SQLException ex) {
            Logger.getLogger(CadastarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
