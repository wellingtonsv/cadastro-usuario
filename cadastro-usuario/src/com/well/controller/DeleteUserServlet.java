package com.well.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.well.model.User;
import com.well.service.IDeleteUserService;
import com.well.service.ILoginService;
import com.well.service.impl.DeleteUserService;
import com.well.service.impl.LoginService;

/**
 * 
 * @author WVieira
 *
 */
public class DeleteUserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest requisicao, HttpServletResponse response)
			throws ServletException, IOException {
		
		String  longinUser  = requisicao.getParameter("login_hidden");
		String  profileUser  = requisicao.getParameter("profile_hidden");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		ILoginService loginService = LoginService.getInstanceLogin();
		User user = loginService.getUserByUserId(longinUser);
		
		IDeleteUserService deleteUserService = DeleteUserService.getIntance();
		
		out.println("<html>");
		out.println("<head>");
		
		if (null != user && null != profileUser) {
			if (profileUser.equalsIgnoreCase("Admin")) {
				deleteUserService.deleteUser(user);
				out.println("<title>Usuario deletado com Sucesso</title>");
			} else {
				//out.println("<title>Falha na exclução do usuario</title>");
				//out.println("Tente novamente <a href=error_delete.jsp>Click here</a>");
				response.sendRedirect("error_delete.jsp");
				return;
			}
		} else {
			out.println("<title>Falha na exclução do usuario</title>");
			out.println("Tente novamente <a href=home.jsp>Click here</a>");
		}
		
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("Para eftuar volta pagina anterior <a href=home.jsp>Click aqui !!!</a>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}
}