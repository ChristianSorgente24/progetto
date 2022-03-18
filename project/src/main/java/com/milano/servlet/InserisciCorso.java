package com.milano.servlet;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.CorsoBC;
import com.milano.businesscomponent.model.Corso;

@WebServlet("/InserisciCorso")
public class InserisciCorso extends HttpServlet {

	private static final long serialVersionUID = -8861402462745469066L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GregorianCalendar inizio = new GregorianCalendar(2002, 1, 15, 0, 0, 0);
		GregorianCalendar fine = new GregorianCalendar(2002, 1, 21, 0, 0, 0);

		Corso corso = new Corso(1, "corso1", inizio.getTime(), fine.getTime(), 100.00, "1A", 1567);
		
		try {
			CorsoBC cBC = new CorsoBC();
			cBC.createCorso(corso);
		} catch (DAOException | ClassNotFoundException | IOException  e) {
			e.printStackTrace();
			throw new ServletException(e);	
		} 	
	}

}
