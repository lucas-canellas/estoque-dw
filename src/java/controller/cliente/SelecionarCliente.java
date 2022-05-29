
package controller.cliente;

import controller.fornecedor.SelecionarFornecedor;
import dao.ClienteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SelecionarCliente", urlPatterns = {"/cliente"})
public class SelecionarCliente extends HttpServlet {

     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getServletPath();
            System.out.println(action);
            String id = request.getParameter("id");
            System.out.println("id= " + id);

            ClienteDAO dao = new ClienteDAO();
            int idCliente = Integer.parseInt(request.getParameter("id"));

            request.setAttribute("id", dao.clientePorId(idCliente).getId());
            request.setAttribute("bairro", dao.clientePorId(idCliente).getBairro());
            request.setAttribute("nome", dao.clientePorId(idCliente).getNome());
            request.setAttribute("cpf", dao.clientePorId(idCliente).getCpf());
            request.setAttribute("endereco", dao.clientePorId(idCliente).getEndereco());
            request.setAttribute("bairro", dao.clientePorId(idCliente).getBairro());
            request.setAttribute("cidade", dao.clientePorId(idCliente).getCidade());
            request.setAttribute("uf", dao.clientePorId(idCliente).getUf());
            request.setAttribute("cep", dao.clientePorId(idCliente).getCep());
            request.setAttribute("telefone", dao.clientePorId(idCliente).getTelefone());
            request.setAttribute("email", dao.clientePorId(idCliente).getEmail());

            RequestDispatcher rd = request.getRequestDispatcher("editar-cliente.jsp");
            rd.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(SelecionarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
