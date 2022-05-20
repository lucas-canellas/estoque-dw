package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO extends DAO {

    public boolean validarUsuario(Usuario usuario) throws SQLException {
        String sql = "SELECT id, cpf, senha, nome FROM funcionarios WHERE cpf = '" + usuario.getCpf() + "'";
        conectar(sql);
        ResultSet rs = stm.executeQuery(sql);
        String password = null;
        while (rs.next()) {
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            password = (rs.getString("senha"));
        }
//        fechar();
        return password != null && password.equals(usuario.getSenha());
    }
    
    
}
