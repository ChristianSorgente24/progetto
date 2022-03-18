package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.milano.businesscomponent.model.Docente;

public class DocenteDAO extends DocenteDAOAdapter  implements DAOConstants {
	private CachedRowSet rowSet;
	
	public static DocenteDAO getFactory() throws DAOException {
		return new DocenteDAO();
	}
	private DocenteDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Docente getByCod(Connection conn,Long codDocente) throws DAOException {
		Docente docente = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_DOCENTE_BYCOD);
			ps.setLong(1, codDocente);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				docente = new Docente();
				docente.setNomeDocente(rs.getString(1));
				docente.setCognomeDocente(rs.getString(2));
				docente.setCvDocente(rs.getString(3));
				docente.setCodDocente(rs.getLong(4));
			}
			
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return docente;
	}
	
}
