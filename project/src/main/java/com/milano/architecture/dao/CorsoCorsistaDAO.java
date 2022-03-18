package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.milano.architecture.dao.adapters.CorsoCorsistaDAOAdapter;
import com.milano.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO extends CorsoCorsistaDAOAdapter implements DAOConstants {
	private CachedRowSet rowSet;
	
	public static CorsoCorsistaDAO getFactory() throws DAOException {
		return new CorsoCorsistaDAO();
	}
	
	private CorsoCorsistaDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sqle) {
			throw new DAOException(sqle);
		}
	}
	
	
	
	@Override
	public void create(Connection conn, CorsoCorsista entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSOCORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			
			rowSet.updateLong(1, entity.getCodCorso());
			rowSet.updateLong(2, entity.getCodCorsista());
			rowSet.updateString(3, entity.getCommentiCorso());
			
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();//apre committa e chiude la connessione

		}catch (SQLException sqle) {
			throw new DAOException(sqle);
		}
		
	}
	
	
	
	@Override
	public void delete(Connection conn, CorsoCorsista entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSOCORSISTA);
			ps.setObject(1, entity.getCodCorso());
			ps.setObject(2, entity.getCodCorsista());
			ps.setObject(3, entity.getCommentiCorso());
			ps.execute();
			conn.commit();
		}catch (SQLException sqle) {
			throw new DAOException(sqle);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
