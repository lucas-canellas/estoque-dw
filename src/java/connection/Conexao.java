
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name = "Conexao", urlPatterns = {"/Conexao"})
public class Conexao extends HttpServlet {

    private static Connection conexao = null;

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/estoque";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection criaConexao() throws SQLException {
        if (conexao == null) {
            try {
                Class.forName(DRIVER);
                System.out.println("Driver foi carregado");
                conexao = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexão realizada com sucesso");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver não localizado.");
            }
        }

        return conexao;
    }
}
