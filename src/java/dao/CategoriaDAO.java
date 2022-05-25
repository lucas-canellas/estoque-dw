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
import model.Categoria;


/**
 *
 * @author lucas
 */
public class CategoriaDAO extends DAO {

    public void cadastrarCategoria(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categorias (nome_categoria) " + "VALUES(?)";

        conectar(sql);

        stm.setString(1, categoria.getNome_categoria());

        stm.execute();
        fechar();
    }

    public List<Categoria> listarCategoria() throws SQLException {

        String sql = "SELECT * FROM categorias";
        conectar(sql);

        List<Categoria> lista = new ArrayList<>();
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            Categoria c = new Categoria();
            c.setId(rs.getInt("categorias.id"));
            c.setNome_categoria(rs.getString("categorias.nome_categoria"));            

            lista.add(c);
        }
        return lista;

    }

    public void removerCategoria(int id_categoria) throws SQLException {
        String sql = "DELETE FROM categorias "
                + "WHERE id = ? ; ";
        conectar(sql);
        stm.setInt(1, id_categoria);
        stm.execute();
        fechar();
    }

    public void editarCategoria(Categoria categoria) throws SQLException {
        String sql = "UPDATE categorias SET nome_categoria = ? WHERE id = ? ";
        conectar(sql);
        stm.setString(1, categoria.getNome_categoria());
        

        stm.setInt(2, categoria.getId());
        stm.execute();
        fechar();
    }

    public Categoria categoriaPorId(int id_categoria) throws SQLException {
        String sql = "SELECT * FROM categorias "
                + "WHERE categorias.id = ? ";
        conectar(sql);
        stm.setInt(1, id_categoria);
        Categoria c = new Categoria();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            c.setId(rs.getInt("categorias.id"));
            c.setNome_categoria(rs.getString("categorias.nome_categoria"));


        }
        fechar();
        return c;
    }
}
