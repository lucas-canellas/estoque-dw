package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

public class FuncionarioDAO extends DAO {

    public boolean validarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "SELECT id, cpf, senha, nome, papel FROM funcionarios WHERE cpf = '" + funcionario.getCpf() + "'";
        conectar(sql);
        ResultSet rs = stm.executeQuery(sql);
        String password = null;
        while (rs.next()) {
            funcionario.setId(rs.getInt("id"));
            funcionario.setNome(rs.getString("nome"));
            password = (rs.getString("senha"));
            funcionario.setPapel(rs.getString("papel"));
        }
        fechar();
        return password != null && password.equals(funcionario.getSenha());
    }

    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionarios (nome, cpf, senha, papel) " + "VALUES(?, ?, ?, ?)";

        conectar(sql);

        stm.setString(1, funcionario.getNome());
        stm.setString(2, funcionario.getCpf());
        stm.setString(3, funcionario.getSenha());
        stm.setString(4, funcionario.getPapel());

        stm.execute();
        fechar();

    }

    public List<Funcionario> listarFuncionarios() throws SQLException {

        String sql = "SELECT * FROM funcionarios";
        conectar(sql);

        List<Funcionario> lista = new ArrayList<>();
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            Funcionario f = new Funcionario();
            f.setId(rs.getInt("funcionarios.id"));
            f.setNome(rs.getString("funcionarios.nome"));
            f.setCpf(rs.getString("funcionarios.cpf"));
            f.setSenha(rs.getString("funcionarios.senha"));
            f.setPapel(rs.getString("funcionarios.papel"));

            lista.add(f);
        }
        return lista;

    }

    public void editarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE funcionarios SET nome = ?, cpf = ?, senha = ?, papel = ? WHERE id = ? ";
        conectar(sql);
        stm.setString(1, funcionario.getNome());
        stm.setString(2, funcionario.getCpf());
        stm.setString(3, funcionario.getSenha());
        stm.setString(4, funcionario.getPapel());

        stm.setInt(5, funcionario.getId());
        stm.execute();
        fechar();
    }

    public Funcionario funcionarioPorId(Integer id_funcionario) throws SQLException {
        String sql = "SELECT * FROM funcionarios "
                + "WHERE funcionarios.id = ? ";
        conectar(sql);
        stm.setInt(1, id_funcionario);
        Funcionario f = new Funcionario();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            f.setId(rs.getInt("funcionarios.id"));
            f.setNome(rs.getString("funcionarios.nome"));
            f.setCpf(rs.getString("funcionarios.cpf"));
            f.setSenha(rs.getString("funcionarios.senha"));
            f.setPapel(rs.getString("funcionarios.papel"));
        }
        fechar();
        return f;
    }

    public Funcionario funcionarioPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM funcionarios "
                + "WHERE funcionarios.cpf = ? ";
        conectar(sql);
        stm.setString(1, cpf);
        Funcionario f = new Funcionario();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            f.setId(rs.getInt("funcionarios.id"));
            f.setNome(rs.getString("funcionarios.nome"));
            f.setCpf(rs.getString("funcionarios.cpf"));
            f.setSenha(rs.getString("funcionarios.senha"));
            f.setPapel(rs.getString("funcionarios.papel"));
        }
        fechar();
        return f;
    }

    public void removerFuncionario(int id_funcionario) throws SQLException {
        String sql = "DELETE FROM funcionarios "
                + "WHERE id = ? ; ";
        conectar(sql);
        stm.setInt(1, id_funcionario);
        stm.execute();
        fechar();
    }
}
