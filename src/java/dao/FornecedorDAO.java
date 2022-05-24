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
            f.setCnpj(rs.getString("fornecedores.cnpj"));
            f.setEndereco(rs.getString("fornecedores.endereco"));
            f.setBairro(rs.getString("fornecedores.bairro"));
            f.setCidade(rs.getString("fornecedores.cidade"));
            f.setUf(rs.getString("fornecedores.uf"));
            f.setCep(rs.getString("fornecedores.cep"));
            f.setTelefone(rs.getString("fornecedores.telefone"));
            f.setEmail(rs.getString("fornecedores.email"));

            lista.add(f);
        }
        return lista;

    }

    public void removerFornecedor(int id_produto) throws SQLException {
        String sql = "DELETE FROM fornecedores "
                + "WHERE id = ? ; ";
        conectar(sql);
        stm.setInt(1, id_produto);
        stm.execute();
        fechar();
    }

    public void editarFornecedor(Fornecedor fornecedor) throws SQLException {
        String sql = "UPDATE fornecedores SET razao_social = ?, cnpj = ?, endereco = ?, cidade = ?, bairro = ?, telefone = ?, uf = ?, email = ?, cep = ? WHERE id = ? ";
        conectar(sql);
        stm.setString(1, fornecedor.getRazao_social());
        stm.setString(2, fornecedor.getCnpj());
        stm.setString(3, fornecedor.getEndereco());
        stm.setString(4, fornecedor.getCidade());
        stm.setString(5, fornecedor.getBairro());
        stm.setString(6, fornecedor.getTelefone());
        stm.setString(7, fornecedor.getUf());
        stm.setString(8, fornecedor.getEmail());
        stm.setString(9, fornecedor.getCep());
        

        stm.setInt(10, fornecedor.getId());
        stm.execute();
        fechar();
    }

    public Fornecedor fornecedorPorId(int id_fornecedor) throws SQLException {
        String sql = "SELECT * FROM fornecedores "
                + "WHERE fornecedores.id = ? ";
        conectar(sql);
        stm.setInt(1, id_fornecedor);
        Fornecedor f = new Fornecedor();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            f.setId(rs.getInt("fornecedores.id"));
            f.setRazao_social(rs.getString("fornecedores.razao_social"));
            f.setCnpj(rs.getString("fornecedores.cnpj")); 
            f.setEndereco(rs.getString("fornecedores.endereco"));
            f.setCidade(rs.getString("fornecedores.cidade"));
            f.setBairro(rs.getString("fornecedores.bairro"));
            f.setTelefone(rs.getString("fornecedores.telefone"));
            f.setUf(rs.getString("fornecedores.uf"));
            f.setEmail(rs.getString("fornecedores.email"));
            f.setCep(rs.getString("fornecedores.cep"));           

            
        }
        fechar();
        return f;
    }



}
