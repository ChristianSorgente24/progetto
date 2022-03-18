package com.milano.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.milano.architecture.dao.DAOConstants;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;

public class CodGeneratorCorso implements IdGenerator, DAOConstants {

	private static CodGeneratorCorso istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private CodGeneratorCorso() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public static CodGeneratorCorso getInstance() throws DAOException, ClassNotFoundException, IOException {
		if (istanza == null)
			istanza = new CodGeneratorCorso();
		return istanza;
	}

	@Override
	public long getNextId() throws ClassNotFoundException, DAOException, IOException {
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSO_SEQ);
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return id;

	}

}
