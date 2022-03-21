package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.milano.architecture.dao.adapters.DocenteDAOAdapter;
import com.milano.businesscomponent.model.Docente;

public class DocenteDAO extends DocenteDAOAdapter implements DAOConstants {

	public static DocenteDAO getFactory() throws DAOException {
		return new DocenteDAO();
	}
	
	private DocenteDAO() {
		
	}

	@Override
	public Docente getByCod(Connection conn, long codDocente) throws DAOException {
		Docente docente = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_DOCENTE_BYCOD);
			ps.setLong(1, codDocente);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				docente = new Docente();
				docente.setNomeDocente(rs.getString(1));
				docente.setCognomeDocente(rs.getString(2));
				docente.setCvDocente(rs.getString(3));
				docente.setCodDocente(rs.getLong(4));
			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return docente;
	}
	@Override
	public Docente[] getAll(Connection conn) throws DAOException {
		Docente[] docenti = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_DOCENTE);
			rs.last();
			docenti = new Docente[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Docente d = new Docente();
				d.setNomeDocente(rs.getString(1));
				d.setCognomeDocente(rs.getString(2));
				d.setCvDocente(rs.getString(3));
				d.setCodDocente(rs.getLong(4));
				docenti[i] = d;				
			}
			rs.close();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return docenti;
	}

}
