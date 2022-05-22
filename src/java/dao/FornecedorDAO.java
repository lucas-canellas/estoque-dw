/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;

/**
 *
 * @author lucas
 */
public class FornecedorDAO extends DAO {

    public void cadastrarFornecedor(Fornecedor fornecedor) throws SQLException {
        String sql = "INSERT INTO fornecedores (razao_social, cnpj, endereco, bairro, cidade, uf, cep, telefone, email) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        conectar(sql);

        stm.setString(1, fornecedor.getRazao_social());
        stm.setString(2, fornecedor.getCnpj());
        stm.setString(3, fornecedor.getEndereco());
        stm.setString(4, fornecedor.getBairro());
        stm.setString(5, fornecedor.getCidade());
        stm.setString(6, fornecedor.getUf());
        stm.setString(7, fornecedor.getCep());
        stm.setString(8, fornecedor.getTelefone());
        stm.setString(9, fornecedor.getEmail());

        stm.execute();
        fechar();

    }

    public List<Fornecedor> listarFornecedor() throws SQLException {

        String sql = "SELECT * FROM fornecedores";
        conectar(sql);

        List<Fornecedor> lista = new ArrayList<Fornecedor>();
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            Fornecedor f = new Fornecedor();
            f.setId(rs.getInt("fornecedores.id"));
            f.setRazao_social(rs.getString("fornecedores.razao_social"));

            lista.add(f);

        }
        return lista;

    }
}
