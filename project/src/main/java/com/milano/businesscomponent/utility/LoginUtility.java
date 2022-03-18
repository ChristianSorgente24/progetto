package com.milano.businesscomponent.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.milano.architecture.dao.DAOConstants;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;

public class LoginUtility implements DAOConstants {
	private Connection conn;

	public LoginUtility() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	// Valore di ritorno se la password non viene recuperata = -1
	public long getCodice(String username) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ADMINPASS);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getLong(1);
			}
			return -1;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
