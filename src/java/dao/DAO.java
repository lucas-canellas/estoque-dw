package dao;

import connection.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    protected PreparedStatement stm;

    protected void conectar(String sql) {
        try {
            stm = Conexao.criaConexao().prepareStatement(sql);
        } catch (SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
    } 
    
        protected void fechar() {
        try {
            if(Conexao.criaConexao() == null ){
            stm.close();
            Conexao.criaConexao().close();
            System.out.println("Conexão Fechada");
            }
        } catch (SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
