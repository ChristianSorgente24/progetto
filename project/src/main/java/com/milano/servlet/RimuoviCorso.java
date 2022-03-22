package com.milano.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsoBC;

@WebServlet("/rimuovicorso")
public class RimuoviCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		long cod = Long.parseLong(request.getParameter("corso"));
		try {
			CorsoBC cBC = new CorsoBC();
			CorsoBC.deleteCorso(cBC.getByCodCorso(cod));
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServletException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		response.sendRedirect("corsi.jsp");
	}
}
