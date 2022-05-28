/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.SQLException;
import model.Categoria;
import model.Compra;

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
     
     
     
}
