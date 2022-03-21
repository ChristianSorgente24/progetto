package com.milano.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.utility.LoginUtility;

@WebServlet("/controlloLogin")
public class ControlloLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("username");
		Long codAdmin = (Long) request.getAttribute("codadmin");
		HttpSession session = request.getSession();
		Long adminCheck;
		int count = (int) session.getAttribute("countLogin"); 
		
		if(count == 5) {
			session.setAttribute("countLogin", 0); 
			response.sendRedirect("accessonegato.jsp");
		}else {
			if (username != null && codAdmin != null) {
				try {
					LoginUtility lU = new LoginUtility();
					adminCheck = lU.getCodice(username);
					if(adminCheck != -1) {
						if(adminCheck == codAdmin) {
							session.setAttribute("username", username);
							response.sendRedirect("corsi.jsp");
						}else {
							session.setAttribute("countLogin", count++);
							response.sendRedirect("accessoerrato.jsp");
							
						}
					}
				}catch(DAOException | ClassNotFoundException exc) {
					exc.printStackTrace();
					throw new ServletException(exc.getMessage());
				}
			}
		}		
	}
}
