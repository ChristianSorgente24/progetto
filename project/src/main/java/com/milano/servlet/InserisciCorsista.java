package com.milano.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsistaBC;
import com.milano.businesscomponent.idgenerator.CodGeneratorCorsista;
import com.milano.businesscomponent.model.Corsista;


@WebServlet("/InserisciCorsista")
public class InserisciCorsista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Corsista corsista = new Corsista();
		
		corsista.setNomeCorsista(request.getParameter("nomeCorsista"));
		corsista.setCognomeCorsista(request.getParameter("cognomeCorsista"));
		try {
			corsista.setCodCorsista(CodGeneratorCorsista.getInstance().getNextId());
		} catch (ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		corsista.setPrecedentiFormativi(Byte.parseByte(request.getParameter("precedentiFormativi")));
		

		
		try {
			CorsistaBC cBC = new CorsistaBC();
			cBC.createCorsista(corsista);
			response.sendRedirect("inserimentoriuscito.jsp");
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	}
