<%@page import="dao.AtracaoDao"%>
<%@page import="model.Atracao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="conexao.DbCon" %>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
User auth = (User)request.getSession().getAttribute("auth"); 
if(auth!=null){
   request.setAttribute("auth", auth);
   
}

AtracaoDao at = new AtracaoDao(DbCon.getConnection());

List<Atracao> atracao = at.getAllAtracao();

%>
<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="index.css">


<title>Carrinho</title>
<%@include file="includes/header.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<h2>Seu Carrinho</h2>

    
<%
/// Recupere o carrinho da sessão
List<Atracao> carrinho = (List<Atracao>) request.getSession().getAttribute("carrinho");

// Se o carrinho não existir (por exemplo, se esta for a primeira vez que o usuário adiciona um item), crie um novo carrinho
if (carrinho == null) {
    carrinho = new ArrayList<>();
}

// Defina o carrinho atualizado de volta na sessão
request.getSession().setAttribute("carrinho", carrinho);
%>

<style>
    .styled-table {
        border-collapse: collapse;
        margin: 25px 0;
        font-size: 0.9em;
        font-family: sans-serif;
        min-width: 400px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
    }
    .styled-table thead tr {
        background-color: #009879;
        color: #ffffff;
        text-align: left;
    }
    .styled-table th,
    .styled-table td {
        padding: 12px 15px;
    }
    .styled-table tbody tr {
        border-bottom: 1px solid #dddddd;
    }
    .styled-table tbody tr:nth-of-type(even) {
        background-color: #f3f3f3;
    }
    .styled-table tbody tr:last-of-type {
        border-bottom: 2px solid #009879;
    }
</style>

<table class="styled-table">
    <thead>
        <tr>
            <th>Produto</th>
            <th>Preço</th>
            <th>Quantidade</th>
            <th>Total</th>
            <th>Ação</th>
        </tr>
    </thead>
    <tbody>
        <% for (Atracao a : carrinho) { %>
            <tr>
                <td><%= a.getNome() %></td>
                <td><%= a.getPreco() %></td>
                <td><%= a.getQuantidade() %></td>
                <td><%=  a.getPreco() * a.getQuantidade() %></td>
                <td><a href="remover-do-carrinho?id=<%= a.getId() %>">Remover</a></td>
            </tr>
        <% } %>
    </tbody>
</table>



<a href="/checkout">Finalizar Compra</a>

<%@include file="includes/footer.jsp" %>
</body>
</html>
