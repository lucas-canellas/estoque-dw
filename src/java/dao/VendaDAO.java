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
            v.setId_cliente(rs.getInt("vendas.id_cliente"));
            v.setId_produto(rs.getInt("vendas.id_produto"));
            v.setId_funcionario(rs.getInt("vendas.id_funcionario"));
            

            lista.add(v);
        }
        return lista;

    }

    

    public void removerVenda(int id_venda) throws SQLException {
        String sql = "DELETE FROM vendas WHERE id = ?;";
        conectar(sql);
        stm.setInt(1, id_venda);
        stm.execute();
        fechar();
    }

    public void editarVenda(Venda venda) throws SQLException {
        String sql = "UPDATE vendas SET quantidade_venda = ?, data_venda = ?, valor_venda = ?, id_cliente = ?, "
                + "id_produto = ?, id_funcionario = ? WHERE id = ? ";

        conectar(sql);

        stm.setInt(1, venda.getQuantidade_venda());
        stm.setDate(2, new Date(venda.getData_venda().getTime()));
        stm.setDouble(3, venda.getValor_venda());
        stm.setInt(4, venda.getId_cliente());
        stm.setInt(5, venda.getId_produto());
        stm.setInt(6, venda.getId_funcionario());

        stm.setInt(7, venda.getId());
        stm.execute();
        fechar();
    }

    public Venda vendaPorId(int id_venda) throws SQLException {
        String sql = "SELECT * FROM vendas "
                + "WHERE vendas.id = ? ";
        conectar(sql);
        stm.setInt(1, id_venda);
        Venda v = new Venda();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            v.setId(rs.getInt("vendas.id"));
            v.setQuantidade_venda(rs.getInt("vendas.quantidade_venda"));
            v.setData_venda(rs.getDate("vendas.data_venda"));
            v.setValor_venda(rs.getDouble("vendas.valor_venda"));
            v.setId_cliente(rs.getInt("vendas.id_cliente"));
            v.setId_produto(rs.getInt("vendas.id_produto"));
            v.setId_funcionario(rs.getInt("vendas.id_funcionario"));

        }
        fechar();
        return v;
    }

}
