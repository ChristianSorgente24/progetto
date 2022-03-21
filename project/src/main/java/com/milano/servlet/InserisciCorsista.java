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


@WebServlet("/InserisciCorsista")
public class InserisciCorsista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Corsista corsisti = new Corsista();
		
		corsisti.setNomeCorsista(request.getParameter("nomeCorsista"));
		corsisti.setCognomeCorsista(request.getParameter("cognomeCorsista"));
		corsisti.setCodCorsista(Long.parseLong(request.getParameter("codCorsista")));
		corsisti.setPrecedentiFormativi(Byte.parseByte(request.getParameter("PrecendentiFormativi")));
		
		
		
		try {
			CorsistaBC cBC = new CorsistaBC();
			cBC.createCorsista(corsisti);
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		response.sendRedirect("index.jsp");
	}

	}
