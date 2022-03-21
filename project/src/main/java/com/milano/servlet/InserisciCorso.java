package com.milano.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Corso corso = new Corso();
		corso.setCodCorso(Long.parseLong(request.getParameter("codCorso")));
		corso.setNomeCorso(request.getParameter("nomeCorso"));
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			corso.setDataInizioCorso(format.parse(request.getParameter("dataInizioCorso")));
			corso.setDataFineCorso(format.parse(request.getParameter("dataFineCorso")));
		} catch (ParseException exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		corso.setCostoCorso(Double.parseDouble(request.getParameter("costoCorso")));
		corso.setAulaCorso(request.getParameter("aulaCorso"));
		corso.setCodDocente(Long.parseLong(request.getParameter("codDocente")));
		
		try {
			CorsoBC cBC = new CorsoBC();
			cBC.createCorso(corso);
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		response.sendRedirect("index.jsp");
	}

}
