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
		long codAdmin = Long.parseLong(request.getParameter("codadmin"));
		HttpSession session = request.getSession();
		long adminCheck;

		int count = 0;
		if (session.getAttribute("countLogin") != null)
			count = (int) session.getAttribute("countLogin");

		/*System.out.println("Count=" + count);

		System.out.println("Username="+username);
		System.out.println("CodAdmin="+codAdmin);*/
		
		
		if (count == 5) {
			session.setAttribute("countLogin", 0);
			response.sendRedirect("accessonegato.jsp");
		} else if (username != null) {
			try {
				LoginUtility lU = new LoginUtility();
				adminCheck = lU.getCodice(username);
				if (adminCheck != -1) {
					if (adminCheck == codAdmin) {
						session.setAttribute("username", username);
						response.sendRedirect("corsi.jsp");
					} else {
						session.setAttribute("countLogin", count++);
						response.sendRedirect("accessoerrato.jsp");

					}
				}
			} catch (DAOException | ClassNotFoundException exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}
		
		response.sendRedirect("accessonegato.jsp");
		

	}
}
