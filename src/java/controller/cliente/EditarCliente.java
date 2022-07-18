package controller.cliente;

import controller.fornecedor.EditarFornecedor;
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
import model.Cliente;



@WebServlet(name = "EditarCliente", urlPatterns = {"/EditarCliente"})
public class EditarCliente extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        request.setAttribute("chamou_cadastro", true);
        
        try {
            cliente.setId(Integer.parseInt(id));
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setEndereco(endereco);
            cliente.setBairro(bairro);
            cliente.setCidade(cidade);
            cliente.setUf(uf);
            cliente.setCep(cep);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);
            
             if (request.getSession(false).getAttribute("id_papel") != "1") {
                request.setAttribute("mensagem", "Somente vendedores podem editar um cliente.");
            } else {
                 request.setAttribute("mensagem", "Cliente editado com sucesso.");
                 dao.editarCliente(cliente);
            }
             
            RequestDispatcher dis = request.getRequestDispatcher("clientes.jsp");
            dis.forward(request, response);

            
            
        } catch (SQLException ex) {
            Logger.getLogger(EditarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
