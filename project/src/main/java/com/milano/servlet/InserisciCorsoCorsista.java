package com.milano.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsoCorsistaBC;
import com.milano.businesscomponent.model.CorsoCorsista;

@WebServlet("/inseriscicorsocorsista")
public class InserisciCorsoCorsista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		CorsoCorsista cs = new CorsoCorsista();
		cs.setCodCorso(Long.parseLong(request.getParameter("corsi")));
		cs.setCodCorsista(Long.parseLong(request.getParameter("corsisti")));
		
		response.sendRedirect("inserimentoriuscito.jsp");
		try {
			CorsoCorsistaBC ccBC = new CorsoCorsistaBC();
			ccBC.create(cs);
		}catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
