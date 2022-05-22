package dao;

import connection.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;

public class ClienteDAO extends DAO {

    public void cadastrarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nome, cpf, endereco, bairro, cidade, uf, cep, telefone, email) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        conectar(sql);
        
        stm.setString(1, cliente.getNome());
        stm.setString(2, cliente.getCpf());
        stm.setString(3, cliente.getEndereco());
        stm.setString(4, cliente.getBairro());
        stm.setString(5, cliente.getCidade());
        stm.setString(6, cliente.getUf());
        stm.setString(7, cliente.getCep());
        stm.setString(8, cliente.getTelefone());
        stm.setString(9, cliente.getEmail());
        
        stm.execute();
        fechar();
    }

}
