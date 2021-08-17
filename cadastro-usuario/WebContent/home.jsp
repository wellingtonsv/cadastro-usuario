<%@page import="com.well.service.impl.DeleteUserService"%>
<%@page import="com.well.service.IDeleteUserService"%>
<%@page import="java.util.List"%>
<%@page import="com.well.service.ILoginService"%>
<%@page import="com.well.service.impl.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.well.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<script>
function excluir()  
{  
	var r = confirm("Confirma a ação?");
    if(r) {
        document.form["excluir-registro"].submit();  
    }else {
    	document.form["excluir-registro"].close();
    }  
} 
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Resultado da Pagina</title>
</head>
<body>
	<center>
		<div id="container">
			<h1>Pagina Principal</h1>
			<%=new Date()%></br>
			<%
				 User user = (User) session.getAttribute("user");
			 %>
			<b>Bem Vindo <%= user.getFirstName() + " " + user.getLastName()%></b>
			<br /> <a href="logout.jsp">Sair</a>
			</p>

			<table>
				<thead>
					<tr>
						<th>Login</th>
						<th>Primeiro_Nome</th>
						<th>Sobre Nome</th>
						<th>Ultimo Nome</th>
						<th>Email</th>
						<th>Profile</th>
						<th>Acao</th>
					</tr>
				</thead>
				<tbody>
					<%
					 ILoginService loginService = LoginService.getInstanceLogin();
				 	 IDeleteUserService deleteUserService = new DeleteUserService();	
					 List<User> list = loginService.getListOfUsers();
					 for (User u : list) {
				 %>
					<tr>
						<td><%=u.getUserId()%></td>
						<td><%=u.getFirstName()%></td>
						<td><%=u.getMiddleName()%></td>
						<td><%=u.getLastName()%></td>
						<td><%=u.getEmail()%></td>
						<td><%=u.getProfile()%></td>
						<td><form name="excluir-registro" action="DeleteUserServlet" method="POST">
								<input type="hidden" name="login_hidden" value="<%=u.getUserId()%>"> 
								<input type="hidden" name="profile_hidden" value="<%=u.getProfile()%>"> 
								<input type="submit" value="Excluir" class="delete"	onclick="excluir()">
							</form>
							<form action="AlterUserServlet" method="POST">
								<input type="hidden" name="login_hidden" value="<%=u.getUserId()%>">
								<input type="hidden" name="profile_hidden" value="<%=u.getProfile()%>"/>
								<input type="hidden" name="user_logado_hidden" value="<%=user.getProfile()%>"/>
								<input type="hidden" name="tela_home" value="true"/>
								<input type="submit" value="Alterar" class="alterar"/> 
							</form></td>
					</tr>
					<%}%>
				</tbody>
			</table>
			<br />
		</div>
	</center>
</body>
</html>
