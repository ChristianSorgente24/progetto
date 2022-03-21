package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.milano.businesscomponent.model.Corsista;

public class CorsistaDAO implements GenericDAO<Corsista>, DAOConstants{
	private CachedRowSet rowSet;
	public static CorsistaDAO getFactory() throws DAOException {
		return new CorsistaDAO();
	}	
	
	private CorsistaDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	@Override
	public void create(Connection conn, Corsista entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, entity.getNomeCorsista());
			rowSet.updateString(2, entity.getCognomeCorsista());
			rowSet.updateLong(3, entity.getCodCorsista());
			rowSet.updateByte(4, entity.getPrecedentiFormativi());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	@Override
	public void update(Connection conn, Corsista entity) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(UPDATE_CORSISTA);
			ps.setString(1, entity.getNomeCorsista());
			ps.setString(2, entity.getCognomeCorsista());
			ps.setLong(3, entity.getCodCorsista());
			ps.setByte(4, entity.getPrecedentiFormativi());
			ps.execute();
			conn.commit();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void delete(Connection conn, Corsista entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSISTA);
			ps.setLong(1, entity.getCodCorsista());
			ps.execute();
			conn.commit();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Corsista getByCod(Connection conn, long id) throws DAOException {
		Corsista corsista = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSISTA_BYCOD);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				corsista = new Corsista();
				corsista.setNomeCorsista(rs.getString(1));
				corsista.setCognomeCorsista(rs.getString(2));
				corsista.setCodCorsista(rs.getLong(3));
				corsista.setPrecedentiFormativi(rs.getByte(4));
			}
		
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return corsista;
	}

	@Override
	public Corsista[] getAll(Connection conn) throws DAOException {
		Corsista[] corsisti = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTA);
			rs.last();
			corsisti = new Corsista[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Corsista c = new Corsista();
				c.setNomeCorsista(rs.getString(1));
				c.setCognomeCorsista(rs.getString(2));
				c.setCodCorsista(rs.getLong(3));
				c.setPrecedentiFormativi(rs.getByte(4));
				corsisti[i] = c;				
			}
			rs.close();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return corsisti;
	}
	
	public Corsista[] getAllByCodCorso(Connection conn, long codCorso) throws DAOException {
		Corsista[] corsisti = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_CORSISTI_BYCODCORSO,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ps.setLong(1, codCorso);
			ResultSet rs = ps.executeQuery();
			rs.last();
			corsisti = new Corsista[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Corsista c = new Corsista();
				c.setNomeCorsista(rs.getString(1));
				c.setCognomeCorsista(rs.getString(2));
				c.setCodCorsista(rs.getLong(3));
				c.setPrecedentiFormativi(rs.getByte(4));
				corsisti[i] = c;				
			}
			rs.close();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return corsisti;
	}
	
}
