/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.venda;

import controller.compra.CadastarCompra;
import controller.fornecedor.EditarFornecedor;
import dao.ProdutoDAO;
import dao.VendaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

import model.Venda;

/**
 *
 * @author lucas
 */
@WebServlet(name = "EditarVenda", urlPatterns = {"/EditarVenda"})
public class EditarVenda extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Venda venda = new Venda();
        VendaDAO dao = new VendaDAO();

        ProdutoDAO dao_produto = new ProdutoDAO();
        

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String id = request.getParameter("id");
        String quantidade_venda = request.getParameter("quantidade_venda");
        String data_venda = request.getParameter("data_venda");
        String valor_venda = request.getParameter("valor_venda");
        String id_cliente = request.getParameter("id_cliente");
        String id_produto = request.getParameter("id_produto");
        String id_funcionario = request.getParameter("id_funcionario");

        try {
            Venda venda_tmp = dao.vendaPorId(Integer.parseInt(id));
            Produto produto = dao_produto.produtoPorId(Integer.parseInt(id_produto));
            Integer qtd_disponivel = produto.getQuantidade_disponivel();
            
            // FUNÇÃO QUE RECALCULA A QUANTIDADE DE PRODUTOS DISPONIVEIS
            // CASO A NOVA QUANTIDADE DE PRODUTOS VENDIDOS SEJA ALTERADA, A FUNÇÃO TAMBEM ALTERA
            // A  QUANTIDADE DE PRODUTOS DISPONIVEIS
            
            if (venda_tmp.getQuantidade_venda() != Integer.parseInt(quantidade_venda)) {
                Integer diferença_quantidade = venda_tmp.getQuantidade_venda() - Integer.parseInt(quantidade_venda);
                dao_produto.incrementarQuantidade(Integer.parseInt(id_produto), qtd_disponivel - diferença_quantidade);                
            }

            venda.setId(Integer.parseInt(id));
            venda.setQuantidade_venda(Integer.parseInt(quantidade_venda));
            venda.setData_venda(formatter.parse(data_venda));
            venda.setValor_venda(Double.parseDouble(valor_venda));
            venda.setId_cliente(Integer.parseInt(id_cliente));
            venda.setId_produto(Integer.parseInt(id_produto));
            venda.setId_funcionario(Integer.parseInt(id_funcionario));

            dao.editarVenda(venda);

            response.sendRedirect("vendas");
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(CadastarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
