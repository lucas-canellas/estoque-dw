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
import model.Categoria;
import model.Compra;
import model.Venda;

/**
 *
 * @author lucas
 */
public class CompraDAO extends DAO {

    public void cadastrarCompra(Compra compra) throws SQLException {
        String sql = "INSERT INTO compras (quantidade_compra,data_compra, valor_compra, id_fornecedor, id_produto, id_funcionario ) " + "VALUES(?, ?,?,?,?,?)";

        conectar(sql);

        stm.setInt(1, compra.getQuantidade_compra());
        stm.setDate(2, new Date(compra.getData_compra().getTime()));
        stm.setInt(3, compra.getValor_compra());
        stm.setInt(4, compra.getId_fornecedor());
        stm.setInt(5, compra.getId_produto());
        stm.setInt(6, compra.getId_funcionario());

        stm.execute();
        fechar();
    }

    public List<Compra> listarCompras() throws SQLException {

        String sql = "SELECT * FROM compras";
        conectar(sql);

        List<Compra> lista = new ArrayList<>();
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            Compra c = new Compra();
            c.setId(rs.getInt("compras.id"));
            c.setQuantidade_compra(rs.getInt("compras.quantidade_compra"));
            c.setData_compra(rs.getDate("compras.data_compra"));
            c.setValor_compra(rs.getInt("compras.valor_compra"));
            c.setId_fornecedor(rs.getInt("compras.id_fornecedor"));
            c.setId_produto(rs.getInt("compras.id_produto"));
            c.setId_funcionario(rs.getInt("compras.id_funcionario"));

            lista.add(c);
        }
        return lista;

    }

    public void removerCompra(int id_compra) throws SQLException {
        String sql = "DELETE FROM compras WHERE id = ?;";
        conectar(sql);
        stm.setInt(1, id_compra);
        stm.execute();
        fechar();
    }

    public void editarCompra(Compra compra) throws SQLException {
        String sql = "UPDATE compras SET quantidade_compra = ?, data_compra = ?, valor_compra = ?, id_fornecedor = ?, "
                + "id_produto = ?, id_funcionario = ? WHERE id = ? ";

        conectar(sql);

        stm.setInt(1, compra.getQuantidade_compra());
        stm.setDate(2, new Date(compra.getData_compra().getTime()));
        stm.setInt(3, compra.getValor_compra());
        stm.setInt(4, compra.getId_fornecedor());
        stm.setInt(5, compra.getId_produto());
        stm.setInt(6, compra.getId_funcionario());

        stm.setInt(7, compra.getId());
        stm.execute();
        fechar();
    }

    public Compra compraPorId(int id_compra) throws SQLException {
        String sql = "SELECT * FROM compras "
                + "WHERE compras.id = ? ";
        conectar(sql);
        stm.setInt(1, id_compra);
        Compra c = new Compra();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            c.setId(rs.getInt("compras.id"));
            c.setQuantidade_compra(rs.getInt("compras.quantidade_compra"));
            c.setData_compra(rs.getDate("compras.data_compra"));
            c.setValor_compra(rs.getInt("compras.valor_compra"));
            c.setId_fornecedor(rs.getInt("compras.id_fornecedor"));
            c.setId_produto(rs.getInt("compras.id_produto"));
            c.setId_funcionario(rs.getInt("compras.id_funcionario"));

        }
        fechar();
        return c;
    }

}
