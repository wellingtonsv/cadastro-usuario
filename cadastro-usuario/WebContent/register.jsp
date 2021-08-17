<html>
<head>
<title>Formulário de Registro</title>
<style type="text/css">
h3 {
	font-family: Calibri;
	font-size: 22pt;
	font-style: normal;
	font-weight: bold;
	color: SlateBlue;
	text-align: center;
	text-decoration: underline
}

table {
	font-family: Calibri;
	color: white;
	font-size: 11pt;
	font-style: normal;
	width: 50%;
	text-align:;
	background-color: SlateBlue;
	border-collapse: collapse;
	border: 2px solid navy
}

table.inner {
	border: 0px
}
</style>
</head>


<body>
	<h3>Formulario de Registro de Usuário</h3>
	<form action="RegisterUserServlet" method="POST">

		<table align="center" cellpadding="10">
			<tr>
				<td>Primeiro Nome:</td>
				<td><input type="text" name="firstName" maxlength="30" /> (max
					30 caracteres a-z e A-Z)</td>
			</tr>
			<tr>
				<td>Sobre Nome:</td>
				<td><input type="text" name="middleName" maxlength="30" />
					(max 30 caracteres a-z e A-Z)</td>
			</tr>

			<tr>
				<td>Ultimo Nome:</td>
				<td><input type="text" name="lastName" maxlength="30" /> (max
					30 caracteres a-z e A-Z)</td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" maxlength="100" /></td>
			</tr>

			<tr>
				<td>Profile:</td>
				<td><input type="text" name="profile" maxlength="7" /></td>
			</tr>

			<tr>
				<td>Login:</td>
				<td><input type="text" name="login" maxlength="100" /></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="text" name="password" maxlength="100" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Registar"> <input type="reset" value="Limpar">
				</td>
			</tr>
		</table>

	</form>
</body>
</html>