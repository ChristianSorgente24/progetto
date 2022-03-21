package com.milano.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.milano.architecture.dao.CorsistaDAO;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.idgenerator.CodGeneratorCorsista;
import com.milano.businesscomponent.model.Corsista;

public class CorsistaBC {
	private static Connection conn;
	
	public CorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void createCorsista(Corsista corsista) 
			throws DAOException, ClassNotFoundException, IOException {
		try {
			corsista.setCodCorsista(CodGeneratorCorsista.getInstance().getNextId());
			CorsistaDAO.getFactory().create(conn, corsista);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void updateCorsista(Corsista corsista) 
			throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsistaDAO.getFactory().update(conn, corsista);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static void deleteCorsista(Corsista corsista) 
			throws DAOException {
		try {
			CorsistaDAO.getFactory().delete(conn, corsista);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Corsista[] getAll() 
			throws DAOException {
		try {
			return CorsistaDAO.getFactory().getAll(conn);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static Corsista getByCodCorsista(Long codCorsista) 
			throws DAOException {
		try {
			return CorsistaDAO.getFactory().getByCod(conn, codCorsista);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
