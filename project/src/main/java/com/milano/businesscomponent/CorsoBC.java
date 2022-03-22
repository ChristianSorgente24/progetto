package com.milano.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.milano.architecture.dao.CorsoDAO;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.idgenerator.CodGeneratorCorso;
import com.milano.businesscomponent.model.Corso;

public class CorsoBC {

	private static Connection conn;

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
		try {
			corso.setCodCorso(CodGeneratorCorso.getInstance().getNextId());
			
			if (validazioneDate(corso))
				CorsoDAO.getFactory().create(conn, corso);
			else
				throw new IOException();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void updateCorso(Corso corso) throws DAOException, IOException {
		try {
			if (validazioneDate(corso))
				CorsoDAO.getFactory().update(conn, corso);
			else
				throw new IOException();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public static void deleteCorso(Corso corso) throws DAOException {
		try {
			CorsoDAO.getFactory().delete(conn, corso);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

	public Corso getByCodCorso(long codCorso) throws DAOException {

		try {
			return CorsoDAO.getFactory().getByCod(conn, codCorso);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Corso[] getAll() throws DAOException {

		try {
			return CorsoDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Corso[] searchCorso(String query) throws DAOException {
		ArrayList<Corso> lista = new ArrayList<Corso>();
		String[] criterioRicerca = query.toLowerCase().split(" ");
		
		for(Corso c: getAll())
			for(String s: criterioRicerca)
				if(c.getNomeCorso().toLowerCase().contains(s))
					lista.add(c);
		Corso[] corsi = new Corso[lista.size()];
		for(int i = 0; i < lista.size(); i++)
			corsi[i] = lista.get(i);
		return corsi;
	}
}
