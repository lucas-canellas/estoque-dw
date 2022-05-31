/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.compra;

import dao.CompraDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
import model.Compra;
import model.Produto;
import model.Venda;

/**
 *
 * @author lucas
 */
@WebServlet(name = "EditarCompra", urlPatterns = {"/EditarCompra"})
public class EditarCompra extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Compra compra = new Compra();
        CompraDAO dao = new CompraDAO();

        ProdutoDAO dao_produto = new ProdutoDAO();
        

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String id = request.getParameter("id");
        String quantidade_compra = request.getParameter("quantidade_compra");
        String data_compra = request.getParameter("data_compra");
        String valor_compra = request.getParameter("valor_compra");
        String id_fornecedor = request.getParameter("id_fornecedor");
        String id_produto = request.getParameter("id_produto");
        String id_funcionario = request.getParameter("id_funcionario");

        try {
//            Venda venda_tmp = dao.vendaPorId(Integer.parseInt(id));
//            Produto produto = dao_produto.produtoPorId(Integer.parseInt(id_produto));
//            Integer qtd_disponivel = produto.getQuantidade_disponivel();
            
            // FUNÇÃO QUE RECALCULA A QUANTIDADE DE PRODUTOS DISPONIVEIS
            // CASO A NOVA QUANTIDADE DE PRODUTOS VENDIDOS SEJA ALTERADA, A FUNÇÃO TAMBEM ALTERA
            // A  QUANTIDADE DE PRODUTOS DISPONIVEIS
            
//            if (venda_tmp.getQuantidade_venda() != Integer.parseInt(quantidade_venda)) {
//                Integer diferença_quantidade = venda_tmp.getQuantidade_venda() - Integer.parseInt(quantidade_venda);
//                dao_produto.incrementarQuantidade(Integer.parseInt(id_produto), qtd_disponivel - diferença_quantidade);                
//            }

            compra.setId(Integer.parseInt(id));
            compra.setQuantidade_compra(Integer.parseInt(quantidade_compra));
            compra.setData_compra(formatter.parse(data_compra));
            compra.setValor_compra(Integer.parseInt(valor_compra));
            compra.setId_fornecedor(Integer.parseInt(id_fornecedor));
            compra.setId_produto(Integer.parseInt(id_produto));
            compra.setId_funcionario(Integer.parseInt(id_funcionario));

            dao.editarCompra(compra);

            response.sendRedirect("compras");
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(CadastarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
