package com.milano.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.milano.architecture.dao.CorsoCorsistaDAO;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Corso;
import com.milano.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaBC {
	private Connection conn;

	public CorsoCorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	
	
	public void create(CorsoCorsista corsoCorsista) throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsoCorsistaDAO.getFactory().create(conn, corsoCorsista);
		}catch (SQLException sqle) {
			throw new DAOException(sqle);
		}
	}
	
	public void delete(CorsoCorsista corsoCorsista) throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsoCorsistaDAO.getFactory().delete(conn, corsoCorsista);
		}catch (SQLException sqle) {
			throw new DAOException(sqle);
		}
	}
	
	public Corso[] getCorsi(long codCorsista) throws DAOException, ClassNotFoundException, IOException {
		try {
			long[] corsiID = CorsoCorsistaDAO.getFactory().getCorsi(conn, codCorsista);
			Corso[] corsi = new Corso[corsiID.length];
			for(int i = 0; i < corsiID.length; i++) {
				CorsoBC cBC = new CorsoBC();
				corsi[i] = cBC.getByCodCorso(corsiID[i]);
			}
			return corsi;
		}catch (SQLException sqle) {
			throw new DAOException(sqle);
		}
	}
}
