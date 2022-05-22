package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;
import model.Funcionario;

public class FuncionarioDAO extends DAO {

    public boolean validarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "SELECT id, cpf, senha, nome FROM funcionarios WHERE cpf = '" + funcionario.getCpf() + "'";
        conectar(sql);
        ResultSet rs = stm.executeQuery(sql);
        String password = null;
        while (rs.next()) {
            funcionario.setId(rs.getInt("id"));
            funcionario.setNome(rs.getString("nome"));
            password = (rs.getString("senha"));
        }
        fechar();
        return password != null && password.equals(funcionario.getSenha());
    }



}
