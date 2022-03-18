package com.milano.architecture.dao.adapters;

import java.sql.Connection;

import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dao.GenericDAO;
import com.milano.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAOAdapter  implements GenericDAO<CorsoCorsista> {

	@Override
	public void create(Connection conn, CorsoCorsista entity) throws DAOException {

	}

	@Override
	public void update(Connection conn, CorsoCorsista entity) throws DAOException {

	}

	@Override
	public void delete(Connection conn, CorsoCorsista entity) throws DAOException {

	}

	@Override
	public CorsoCorsista getByCod(Connection conn, long id) throws DAOException {
		return null;
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) throws DAOException {
		return null;
	}

}
