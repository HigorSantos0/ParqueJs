<%@page import="conexao.DbCon" %>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%
   User auth = (User)request.getSession().getAttribute("auth"); 
   if(auth!=null){
	   response.sendRedirect("index.jsp");
   }
   %>
    
    
<!DOCTYPE html>
<html>
<head>

<title>Login</title>
<%@include file="includes/header.jsp" %>
</head>
<body>

<div class="container">
	<div class="card w-50 mx-auto my-5">
		<div class="card-header text-center">Login</div>
		<div class="card-body">
		<form action="user-login" method ="post">
		
			<div class="form-group">
				<label>Nome</label>
				<input type="text" class="form-control" name="name" placeholder="Entre com seu nome" required>
 
			</div> 
			
			<div class="form-group">
				<label>Email</label>
				<input type="email" class="form-control" name="email" placeholder="Entre com seu email"required> 
			</div>
			
			<div class="form-group">
				<label>Senha</label>
				<input type="password" class="form-control" name="password" placeholder="Entre com sua senha"required> 
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-success"> Entrar </button> 
			</div>
		</form>	
		</div>
	</div>
	
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>