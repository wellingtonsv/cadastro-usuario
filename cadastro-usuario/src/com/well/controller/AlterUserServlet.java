package com.well.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.well.model.User;
import com.well.service.IAlterUserService;
import com.well.service.ILoginService;
import com.well.service.impl.AlterUserService;
import com.well.service.impl.LoginService;

/**
 * 
 * @author WVieira
 *
 */
public class AlterUserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String loginAlter = request.getParameter("login_hidden");
		String profileAlter = request.getParameter("profile_hidden");
		String profileUserLogado = request.getParameter("user_logado_hidden");
		boolean tela_home = Boolean.parseBoolean(request.getParameter("tela_home"));
		
//		if(!"Admin".equalsIgnoreCase(profileUserLogado) || !"Admin".equalsIgnoreCase(profileAlter)){
//			response.sendRedirect("error_alter.jsp");
//			return;
//		}

		if(tela_home){
			ILoginService loginService = LoginService.getInstanceLogin();
			User user = loginService.getUserByUserId(loginAlter);
			request.getSession().setAttribute("user2", user);
			response.sendRedirect("alter_user.jsp");
			return;
		}
		
		User userAlter = (User) request.getSession().getAttribute("user2");
		
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String profile = request.getParameter("profile");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		userAlter.setFirstName(firstName);
		userAlter.setMiddleName(middleName);
		userAlter.setLastName(lastName);
		userAlter.setEmail(email);
		userAlter.setProfile(profile);
		userAlter.setUserId(login);
		userAlter.setPassword(password);
		
		if(validateFields(firstName, middleName, lastName, email, profile,
				login, password)){
			
			response.sendRedirect("error_alter.jsp");
			return;
		}
		
		IAlterUserService alterUserService = AlterUserService.getInstanceAlter();
		
		try {
			alterUserService.alterUser(userAlter);
		} catch (Exception e) {
			response.sendRedirect("error_alter.jsp");
			return;
		}
		
		response.sendRedirect("sucesso_alter.jsp");
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