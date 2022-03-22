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


@WebServlet("/rimuovicorsocorsista")
public class RimuoviCorsoCorsista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CorsoCorsista corsoC = new CorsoCorsista();
		corsoC.setCodCorsista(Long.parseLong(request.getParameter("corsista")));
		corsoC.setCodCorso(Long.parseLong(request.getParameter("corso")));
		CorsoCorsistaBC corsoCorsistaBC;
		try {
			corsoCorsistaBC = new CorsoCorsistaBC();
			corsoCorsistaBC.delete(corsoC);
		} catch (ClassNotFoundException | DAOException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}	
		response.sendRedirect("corsi.jsp");
			
		
	}

}
