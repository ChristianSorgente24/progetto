package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.milano.businesscomponent.model.Corso;

public class CorsoDAO implements GenericDAO<Corso>, DAOConstants {

	public static CorsoDAO getInstance() throws DAOException {
		return new CorsoDAO();
	}

	private CachedRowSet rowSet;

	private CorsoDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void create(Connection conn, Corso entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();

			rowSet.updateLong(1, entity.getCodCorso());
			rowSet.updateString(2, entity.getNomeCorso());
			rowSet.updateDate(3, new java.sql.Date(entity.getDataInizioCorso().getTime()));
			rowSet.updateDate(4, new java.sql.Date(entity.getDataFineCorso().getTime()));
			rowSet.updateDouble(5, entity.getCostoCorso());
			rowSet.updateString(6, entity.getCommentiCorso());
			rowSet.updateString(7, entity.getAulaCorso());
			rowSet.updateLong(8, entity.getCodDocente());

			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Corso entity) throws DAOException {

	}

	@Override
	public void delete(Connection conn, Corso entity) throws DAOException {
		try {
			rowSet.setCommand(DELETE_CORSO);
			rowSet.setLong(1, entity.getCodCorso());
			rowSet.execute(conn); 

		} catch (SQLException sql) {
			throw new DAOException(sql);
		} 
	}

	@Override
	public Corso getByCod(Connection conn, long id) throws DAOException {

		Corso corso = null;
		try {
			rowSet.setCommand(null);
			rowSet.setLong(1, id);
			rowSet.execute();

			if (rowSet != null) {
				corso.setCodCorso(rowSet.getInt(1));
			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return corso;
	}

	@Override
	public Corso[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
