package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexao.DbCon;
import dao.AtracaoDao;
import model.Atracao;

@WebServlet("/comprar")
public class CompraServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Obtenha o ID da atração do parâmetro da solicitação
            int id = Integer.parseInt(request.getParameter("id"));
            int quantidade = Integer.parseInt(request.getParameter("quantity"));

            // Obtenha uma conexão com o banco de dados
            Connection con = DbCon.getConnection();

            // Obtenha a instância do AtracaoDao
            AtracaoDao atracaoDao = new AtracaoDao(con);

            // Obtenha a atração pelo ID
            Atracao atracao = atracaoDao.getAtracaoById(id);

            if (atracao == null) {
                out.print("Atração não encontrada com o ID: " + id);
                return;
            }

            // Adicione a atração ao carrinho
            atracaoDao.addToCart(request.getSession(), atracao.getId(), atracao.getNome(), atracao.getCategoria(), atracao.getPreco(), quantidade);

            // Redirecione o usuário para a página do carrinho
            response.sendRedirect("carrinho.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("Erro ao adicionar atração ao carrinho: " + e.getMessage());
        }
    }
}





