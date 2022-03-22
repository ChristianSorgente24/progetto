package com.milano.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsistaBC;
import com.milano.businesscomponent.model.Corsista;

@WebServlet("/ModificaCorsisti")
public class ModificaCorsisti extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Corsista corsista = new Corsista();
		corsista.setCodCorsista(Long.parseLong(request.getParameter("codice")));
		corsista.setNomeCorsista(request.getParameter("nome"));
		corsista.setCognomeCorsista(request.getParameter("cognome"));
		corsista.setPrecedentiFormativi(Byte.parseByte(request.getParameter("precedentiFormativi")));
		try {
			CorsistaBC cBC = new CorsistaBC();
			cBC.createCorsista(corsista);
			response.sendRedirect("modificariuscita.jsp");
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
