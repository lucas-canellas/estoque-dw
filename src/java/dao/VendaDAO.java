/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Compra;
import model.Produto;
import model.Venda;

/**
 *
 * @author lucas
 */
public class VendaDAO extends DAO {

    public void cadastrarVenda(Venda venda) throws SQLException {
        String sql = "INSERT INTO vendas (quantidade_venda,data_venda, valor_venda, id_cliente, id_produto, id_funcionario ) " + "VALUES(?, ?,?,?,?,?)";

        conectar(sql);

        stm.setInt(1, venda.getQuantidade_venda());
        stm.setDate(2, new Date(venda.getData_venda().getTime()));
        stm.setDouble(3, venda.getValor_venda());
        stm.setInt(4, venda.getId_cliente());
        stm.setInt(5, venda.getId_produto());
        stm.setInt(6, venda.getId_funcionario());

        stm.execute();
        fechar();
    }
    
    public List<Venda> listarVendas() throws SQLException {

        String sql = "SELECT * FROM vendas";
        conectar(sql);

        List<Venda> lista = new ArrayList<>();
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            Venda v = new Venda();
            v.setId(rs.getInt("vendas.id"));
            v.setQuantidade_venda(rs.getInt("vendas.quantidade_venda"));
            v.setData_venda(rs.getDate("vendas.data_venda"));
            v.setValor_venda(rs.getDouble("vendas.valor_venda"));

            lista.add(v);
        }
        return lista;

    }

    public void atualizarPrecoCompra(Compra compra) throws SQLException {

        String sql = "UPDATE produtos SET preco_compra = ? WHERE id = ? ";
        conectar(sql);
        stm.setInt(1, compra.getValor_compra());
        stm.setInt(2, compra.getId_produto());

        stm.execute();
        fechar();
    }

    public void incrementarQuantidade(Compra compra, int nova_quantidade) throws SQLException {

        String sql = "UPDATE produtos SET quantidade_disponível = ? WHERE id = ? ";
        conectar(sql);
        stm.setInt(1, nova_quantidade);
        stm.setInt(2, compra.getId_produto());

        stm.execute();
        fechar();
    }

    public void decrementarQuantidade(Venda venda, int nova_quantidade) throws SQLException {

        String sql = "UPDATE produtos SET quantidade_disponível = ? WHERE id = ? ";
        conectar(sql);
        stm.setInt(1, nova_quantidade);
        stm.setInt(2, venda.getId_produto());

        stm.execute();
        fechar();
    }

    public void removerProduto(int id_produto) throws SQLException {
        String sql = "DELETE FROM produtos "
                + "WHERE id = ? ; ";
        conectar(sql);
        stm.setInt(1, id_produto);
        stm.execute();
        fechar();
    }

    public void editarProduto(Produto produto) throws SQLException {
        String sql = "UPDATE produtos SET nome_produto = ?, descricao = ?, preco_compra = ?, preco_venda = ?, quantidade_disponível = ?, liberado_venda = ?, id_categoria = ? WHERE id = ? ";

        conectar(sql);

        stm.setString(1, produto.getNome_produto());
        stm.setString(2, produto.getDescricao());
        stm.setDouble(3, produto.getPreco_compra());
        stm.setDouble(4, produto.getPreco_venda());
        stm.setInt(5, produto.getQuantidade_disponivel());
        stm.setString(6, produto.getLiberado_venda());
        stm.setInt(7, produto.getId_categoria());

        stm.setInt(8, produto.getId());
        stm.execute();
        fechar();
    }

    public Produto produtoPorId(int id_produto) throws SQLException {
        String sql = "SELECT * FROM produtos "
                + "WHERE produtos.id = ? ";
        conectar(sql);
        stm.setInt(1, id_produto);
        Produto p = new Produto();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            p.setId(rs.getInt("produtos.id"));
            p.setNome_produto(rs.getString("produtos.nome_produto"));
            p.setDescricao(rs.getString("produtos.descricao"));
            p.setPreco_compra(rs.getDouble("produtos.preco_compra"));
            p.setPreco_venda(rs.getDouble("produtos.preco_venda"));
            p.setQuantidade_disponivel(rs.getInt("produtos.quantidade_disponível"));
            p.setLiberado_venda(rs.getString("produtos.liberado_venda"));
            p.setId_categoria(rs.getInt("produtos.id_categoria"));

        }
        fechar();
        return p;
    }

}
