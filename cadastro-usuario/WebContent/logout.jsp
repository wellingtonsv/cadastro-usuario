
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>logout Page</title>
</head>
<body>
	<%
		session.removeAttribute("userId");
		session.removeAttribute("password");
		session.invalidate();
	%>
	<center>
		<h1>Você saiu com sucesso.</h1>
		Para fazer login novamente <a href="login.jsp">click aqui</a>.
	</center>
</body>
</html>