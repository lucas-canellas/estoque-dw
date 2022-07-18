package controller.fornecedor;


import controller.cliente.CadastrarCliente;
import dao.FornecedorDAO;
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
import model.Fornecedor;


@WebServlet(name = "CadastrarFornecedor", urlPatterns = {"/CadastrarFornecedor"})
public class CadastrarFornecedor extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");       
        
       try {
        String razao_social = request.getParameter("razao_social");
        String cnpj = request.getParameter("cnpj");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        
       Fornecedor fornecedor = new Fornecedor(razao_social, cnpj, endereco, bairro, cidade, uf,cep,telefone, email);
       FornecedorDAO dao = new FornecedorDAO();
       
       request.setAttribute("chamou_cadastro", true);
       
       if (request.getSession(false).getAttribute("id_papel") != "2") {
           request.setAttribute("mensagem", "Somente compradores podem cadastrar a compra.");            
       } else {
           request.setAttribute("mensagem", "Cadastro efetuado com sucesso.");   
           dao.cadastrarFornecedor(fornecedor);
       }
            RequestDispatcher dis = request.getRequestDispatcher("fornecedores.jsp");
            dis.forward(request, response);

        

        } catch (SQLException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
