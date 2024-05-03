<%@page import="conexao.DbCon" %>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

   <%
   User auth = (User)request.getSession().getAttribute("auth"); 
   if(auth!=null){
	   request.setAttribute("auth", auth);
   }
   %>   
   
<!DOCTYPE html>
<html>
<head>

<title>Pedidos</title>
<%@include file="includes/header.jsp" %>
</head>
<body>

<%@include file="includes/navbar.jsp" %>
<%@include file="includes/footer.jsp" %>
</body>
</html>