<%@page import="model.Atracao"%>
<%@page import="java.util.List"%>
<%@page import="dao.AtracaoDao"%>

<%@page import="java.sql.SQLException" %>

<%@page import="conexao.DbCon" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="conexao.DbCon"%>
<%
   User auth = (User)request.getSession().getAttribute("auth"); 
   if(auth!=null){
	   request.setAttribute("auth", auth);
   }
   
  AtracaoDao at = new AtracaoDao(DbCon.getConnection());
  
  List<Atracao> atracao = at.getAllAtracao();
  
  int usuarioId = auth != null ? auth.getId() : 0; // Handle case if user is not logged in
  
  
  
%>

<!DOCTYPE html>
<html>
<head>
<%@page import="model.User"%>
<title>Index</title>
<%@include file="includes/header.jsp" %>
</head>

<body>
<%@include file="includes/navbar.jsp" %>

	<div class="container">
		<div class="card-header my-3"> Atração </div>
			<div class="row">
<% if(!atracao.isEmpty()){
   for(Atracao a: atracao){ %>
      <div class="col-md-3">
         <div class="card w-100" style="width: 18rem;">
            <img class="card-img-top" src="img/<%= a.getImg() %>" alt="Card image cap">
            <div class="card-body">
               <h5 class="card-title"><%= a.getNome() %></h5>
               <h6 class="preco">Preço: <%= a.getPreco() %></h6>
               <h6 class="categoria">Categoria: <%= a.getCategoria() %></h6>
		       <form method="post" action="comprar">
		        <input type="hidden" name="id" value="<%= a.getId() %>" />
		         <div class="form-group">
		          <label for="quantity">Quantidade:</label>
		          <input type="number" name="quantity" id="quantity" min="1" value="1" class="form-control" />
		        </div>
		    <button type="submit" class="btn btn-primary">Comprar</button>
		</form>

            </div>
         </div>
      </div>
      
<% }
} %>
		</div>
	
	</div>


<%@include file="includes/footer.jsp" %>
</body>
</html>
