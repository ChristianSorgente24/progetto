package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		try {
			PreparedStatement stmt = conn.prepareStatement(UPDATE_CORSO);
			stmt.setString(1, entity.getNomeCorso());
			stmt.setDate(2, new java.sql.Date(entity.getDataInizioCorso().getTime()));
			stmt.setDate(3, new java.sql.Date(entity.getDataFineCorso().getTime()));
			stmt.setDouble(4, entity.getCostoCorso());
			stmt.setString(5, entity.getCommentiCorso());
			stmt.setString(6, entity.getAulaCorso());
			stmt.setLong(7, entity.getCodDocente());

			stmt.setLong(8, entity.getCodCorso());

			stmt.execute();
			conn.commit();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
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
			PreparedStatement stmt = conn.prepareStatement(SELECT_CORSO_BYCOD);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				corso = new Corso();
				corso.setCodCorso(rs.getLong(1));
				corso.setNomeCorso(rs.getString(2));
				corso.setDataInizioCorso(rs.getDate(3));
				corso.setDataFineCorso(rs.getDate(4));
				corso.setCostoCorso(rs.getDouble(5));
				corso.setCommentiCorso(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setCodDocente(rs.getLong(8));
			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return corso;
	}

	@Override
	public Corso[] getAll(Connection conn) throws DAOException {
		Corso[] corsi = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_CORSO, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery();

			rs.last();
			corsi = new Corso[rs.getRow()];
			rs.beforeFirst();

			for (int i = 0; i < corsi.length; i++) {

				rs.next();
				Corso corso = new Corso();
				corso.setCodCorso(rs.getLong(1));
				corso.setNomeCorso(rs.getString(2));
				corso.setDataInizioCorso(rs.getDate(3));
				corso.setDataFineCorso(rs.getDate(4));
				corso.setCostoCorso(rs.getDouble(5));
				corso.setCommentiCorso(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setCodDocente(rs.getLong(8));

				corsi[i] = corso;
			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return corsi;
	}

}
