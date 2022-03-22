package com.milano.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsistaBC;

@WebServlet("/rimuoviCorsista")
public class RimuoviCorsista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		long cod = Long.parseLong(request.getParameter("codCorsista"));
		try {
			CorsistaBC cBC = new CorsistaBC();
			cBC.deleteCorsista(CorsistaBC.getByCodCorsista(cod));
			response.sendRedirect("corsisti.jsp");
		}catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}	
	}
}


