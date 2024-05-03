package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexao.DbCon;
import dao.DaoUser;
import model.User;

@WebServlet("/user-login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			response.sendRedirect("login.jsp");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    try (PrintWriter out = response.getWriter()) {
	        String name = request.getParameter("name");
	       
	        if (name == null || name.isEmpty()) {
	            // Handle empty name situation (e.g., display error message)
	            out.print("Por favor, insira seu nome.");
	            return; // Or redirect to form with error message
	        }
	        String nome =  request.getParameter("nome");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        User newUser = new User();
	        newUser.setNome(name); // Assuming your User class has 'nome' property
	        newUser.setEmail(email);
	        newUser.setPassword(password);
	        

	        try {
	            DaoUser udao = new DaoUser(DbCon.getConnection());
	            boolean added = udao.addUser(newUser);

	            if (added) {
	                // Redireciona para a página index.jsp após a adição bem-sucedida do usuário
	                request.getSession().setAttribute("auth", newUser); // Adicione esta linha
	                response.sendRedirect("index.jsp");
	            } else {
	                out.print("Falha ao adicionar usuário");
	            }

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            out.print("Erro ao conectar ao banco de dados");
	        }
	    }
	}
	
}


