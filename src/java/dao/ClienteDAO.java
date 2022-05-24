package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Fornecedor;


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

    public List<Cliente> listarCliente() throws SQLException {

        String sql = "SELECT * FROM clientes";
        conectar(sql);

        List<Cliente> lista = new ArrayList<Cliente>();
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            Cliente c = new Cliente();
            c.setId(rs.getInt("clientes.id"));
            c.setNome(rs.getString("clientes.nome"));
            c.setCpf(rs.getString("clientes.cpf"));
            c.setEndereco(rs.getString("clientes.endereco"));
            c.setBairro(rs.getString("clientes.bairro"));
            c.setCidade(rs.getString("clientes.cidade"));
            c.setUf(rs.getString("clientes.uf"));
            c.setCep(rs.getString("clientes.cep"));
            c.setTelefone(rs.getString("clientes.telefone"));
            c.setEmail(rs.getString("clientes.email"));

            lista.add(c);
        }
        return lista;

    }
       public void removerCliente(int id_cliente) throws SQLException {
        String sql = "DELETE FROM clientes "
                + "WHERE id = ? ; ";
        conectar(sql);
        stm.setInt(1, id_cliente);
        stm.execute();
        fechar();
    }
       
       public Cliente clientePorId(int id_cliente) throws SQLException {
        String sql = "SELECT * FROM clientes "
                + "WHERE clientes.id = ? ";
        conectar(sql);
        stm.setInt(1, id_cliente);
        Cliente c = new Cliente();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            c.setId(rs.getInt("clientes.id"));
            c.setNome(rs.getString("clientes.nome"));
            c.setCpf(rs.getString("clientes.cpf")); 
            c.setEndereco(rs.getString("clientes.endereco"));
            c.setCidade(rs.getString("clientes.cidade"));
            c.setBairro(rs.getString("clientes.bairro"));
            c.setTelefone(rs.getString("clientes.telefone"));
            c.setUf(rs.getString("clientes.uf"));
            c.setEmail(rs.getString("clientes.email"));
            c.setCep(rs.getString("clientes.cep"));           

            
        }
        fechar();
        return c;
    }
       
       public void editarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, cpf = ?, endereco = ?, cidade = ?, bairro = ?, telefone = ?, uf = ?, email = ?, cep = ? WHERE id = ? ";
        conectar(sql);
        stm.setString(1, cliente.getNome());
        stm.setString(2, cliente.getCpf());
        stm.setString(3, cliente.getEndereco());
        stm.setString(4, cliente.getCidade());
        stm.setString(5, cliente.getBairro());
        stm.setString(6, cliente.getTelefone());
        stm.setString(7, cliente.getUf());
        stm.setString(8, cliente.getEmail());
        stm.setString(9, cliente.getCep());
        

        stm.setInt(10, cliente.getId());
        stm.execute();
        fechar();
    }
    

}
