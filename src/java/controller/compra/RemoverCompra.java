package controller.compra;

import controller.fornecedor.RemoverFornecedor;
import dao.CompraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Compra;

/**
 *
 * @author lucas
 */
@WebServlet(name = "RemoverCompra", urlPatterns = {"/RemoverCompra"})
public class RemoverCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            
            CompraDAO dao = new CompraDAO();
            
            int id_compra = Integer.parseInt(request.getParameter("id"));
            Compra compra = dao.compraPorId(id_compra);
            System.out.println(request.getSession(false).getAttribute("user_id"));
            if (request.getSession(false).getAttribute("id_papel") != "2") {
                request.setAttribute("chamou_cadastro", true);
                request.setAttribute("mensagem", "Somente compradores podem excluir uma compra.");
            }else if(compra.getId_funcionario() != request.getSession(false).getAttribute("user_id")) {
                request.setAttribute("chamou_cadastro", true);
                System.out.println(request.getSession(false).getAttribute("user_id"));
                request.setAttribute("mensagem", "So é possivel excluir a sua propria compra.");
            } else {
                dao.removerCompra(id_compra);                
            }
            RequestDispatcher dis = request.getRequestDispatcher("compras.jsp");
            dis.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(RemoverFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
