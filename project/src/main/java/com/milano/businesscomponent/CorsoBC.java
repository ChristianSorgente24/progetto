package com.milano.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.milano.architecture.dao.CorsoDAO;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.idgenerator.CodGeneratorCorso;
import com.milano.businesscomponent.model.Corso;

public class CorsoBC {

	private Connection conn;

	private boolean validazioneDate(Corso corso) {

		long diff = corso.getDataInizioCorso().getTime() - corso.getDataFineCorso().getTime();

		if (diff < 0)
			return true;
		else
			return false;
	}

	public CorsoBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public void createCorso(Corso corso) throws DAOException, IOException, ClassNotFoundException {
		
		corso.setCodCorso(CodGeneratorCorso.getInstance().getNextId());
		
		if (validazioneDate(corso))
			CorsoDAO.getFactory().create(conn, corso);
		else
			throw new IOException();
	}

	public void updateCorso(Corso corso) throws DAOException, IOException {
		if (validazioneDate(corso))
			CorsoDAO.getFactory().update(conn, corso);
		else
			throw new IOException();
	}

	public void deleteCorso(Corso corso) throws DAOException {
		CorsoDAO.getFactory().delete(conn, corso);
	}

	public Corso getByCodCorso(long codCorso) throws DAOException {
		return CorsoDAO.getFactory().getByCod(conn, codCorso);
	}

	public Corso[] getAll() throws DAOException {
		return CorsoDAO.getFactory().getAll(conn);
	}
}
