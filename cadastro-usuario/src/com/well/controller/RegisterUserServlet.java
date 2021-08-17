package com.well.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.well.model.User;
import com.well.service.IRegisterService;
import com.well.service.impl.RegisterService;

/**
 * 
 * @author WVieira
 *
 */
public class RegisterUserServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String profile = request.getParameter("profile");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		try {

			if (validateFields(firstName, middleName, lastName, email, profile,
					login, password)) {

				out.println("<html>");
				out.println("<head>");
				out.println("<title>Cadastro com Falha</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<center>");
				out.println("<h1>Falha ao se cadastrar</h1>");
				out.println("Tente novamente <a href=register.jsp>Click here</a>");
				return;
			}

			User user = new User(firstName, middleName, lastName, email, profile, login,
					password);

			IRegisterService registerService = RegisterService
					.getInstanceRegistro();
			boolean result = registerService.register(user);
			out.println("<html>");
			out.println("<head>");
			if (result) {
				out.println("<title>Cadastro com Sucesso</title>");
			} else {
				out.println("<title>Cadastro com Falha</title>");
			}
			out.println("</head>");
			out.println("<body>");
			out.println("<center>");
			if (result) {
				out.println("<h1>Obrigado por se cadastrar:</h1>");
				out.println("Para eftuar um novo Login e Senha <a href=login.jsp>Click aqui !!!</a>");
			} else {
				out.println("<h1>Campos obrigatórios ou usuário já cadastrado.</h1>");
				out.println("Tente novamente <a href=register.jsp>Click here</a>");
			}
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}

	private boolean validateFields(String firstName, String middleName,
			String lastName, String email, String profile, String login,
			String password) {

		if (firstName == null || firstName.isEmpty()) {
			return true;
		}

		if ((middleName == null || middleName.isEmpty())) {
			return true;
		}

		if ((lastName == null || lastName.isEmpty())) {
			return true;
		}
		
		if ((email == null || email.isEmpty())) {
			return true;
		}
		
		if ((profile == null || profile.isEmpty())) {
			return true;
		}
		
		if ((login == null || login.isEmpty())) {
			return true;
		}
		
		if ((password == null || password.isEmpty())) {
			return  true;
		}

		return false;
	}
}