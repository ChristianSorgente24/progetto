package com.milano.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Docente;
import com.milano.architecture.dao.*;

public class DocenteBC {

		private  Connection conn;
	
	public DocenteBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	public Docente getByCod(long codDocente) throws DAOException{
		try {	
		return DocenteDAO.getFactory().getByCod(conn, codDocente);
	}catch(SQLException sql) {
		throw new DAOException(sql);
	}
	}
	public Docente[] getAll() 
			throws DAOException {
		try {
			return DocenteDAO.getFactory().getAll(conn);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
}	
