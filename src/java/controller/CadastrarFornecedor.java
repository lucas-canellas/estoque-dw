package controller;


import dao.FornecedorDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        try {
            dao.cadastrarFornecedor(fornecedor);
            response.sendRedirect("fornecedores");
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
