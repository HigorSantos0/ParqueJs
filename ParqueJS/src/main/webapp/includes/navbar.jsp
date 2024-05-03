

<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <a class="navbar-brand" href="index.jsp">PARQUE</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
        <li class="nav-link active" ><a class="nav-link" href="index.jsp">Home</a></li>
        <li class="nav-link"> <a class="nav-link" href="carrinho.jsp">Carrinho</a></li>
    
        
        
      
   		<%
if(auth != null){ %>
    <li class="nav-item"><a class="nav-link" href="pedidos.jsp">Pedidos</a></li>
   <li class="nav-item"><a class="nav-link" href="log-out">Sair</a></li>
 <!-- Altere este link para apontar para o LogoutServlet --> 		
<%}else{ %>
    <li class="nav-item"><a class="nav-link" href="login.jsp">Entrar</a></li>
<% }
%>

   
    </ul>
    
  </div>
</nav>
	
</div>