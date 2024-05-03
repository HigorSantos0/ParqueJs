package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Atracao;

@WebServlet("/remover-do-carrinho")
public class RemoverDoCarrinhoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Obtenha o ID da atração do parâmetro da solicitação
            int id = Integer.parseInt(request.getParameter("id"));

            // Obtenha o carrinho da sessão
            List<Atracao> carrinho = (List<Atracao>) request.getSession().getAttribute("carrinho");

            // Se o carrinho não existir, redirecione para a página do carrinho
            if (carrinho == null) {
                response.sendRedirect("carrinho.jsp");
                return;
            }

            // Encontre a atração no carrinho e remova-a
            for (Iterator<Atracao> iterator = carrinho.iterator(); iterator.hasNext();) {
                Atracao atracao = iterator.next();
                if (atracao.getId() == id) {
                    iterator.remove();
                    break;
                }
            }

            // Redirecione o usuário para a página do carrinho
            response.sendRedirect("carrinho.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("Erro ao remover atração do carrinho: " + e.getMessage());
        }
    }
}
