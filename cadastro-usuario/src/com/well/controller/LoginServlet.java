package com.well.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.well.model.User;
import com.well.service.ILoginService;
import com.well.service.impl.LoginService;

/**
 * 
 * @author WVieira
 *
 */
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		
		//TODO - Criar uma classe util para ajudar nesse trecho de codigo.
		if ((loginId == null || loginId.isEmpty())
				&& (password == null || password.isEmpty())) {
			response.sendRedirect("error.jsp");
			return;
		}
		
		ILoginService loginService = LoginService.getInstanceLogin();
		
		boolean result = loginService.authenticateUser(loginId, password);
		User user = loginService.getUserByUserId(loginId);
		if (result == true) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("home.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}
}