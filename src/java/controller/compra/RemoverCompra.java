package controller.compra;

import controller.fornecedor.RemoverFornecedor;
import dao.CompraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            dao.removerCompra(id_compra);
            response.sendRedirect("compras");
        } catch (SQLException ex) {
            Logger.getLogger(RemoverFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
