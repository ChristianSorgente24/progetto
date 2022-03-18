package com.milano.architecture.dao.adapters;

import java.sql.Connection;

import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dao.GenericDAO;
import com.milano.businesscomponent.model.Docente;

public class DocenteDAOAdapter implements GenericDAO<Docente>{
	
	
	
	public void create(Connection conn, Docente docente) throws DAOException{
		
	}
	public void update(Connection conn, Docente docente) throws DAOException{
		
	}
	public void delete(Connection conn,  Docente docente) throws DAOException{
		
	}
	public Docente[] getAll(Connection conn) throws DAOException{
		return null;
	}
	public Docente getByCod(Connection conn, long id) throws DAOException{
		return null;
	}
}
