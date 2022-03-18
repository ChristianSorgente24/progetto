package com.milano.businesscomponent.idgenerator;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.milano.architecture.dao.DAOConstants;
import com.milano.architecture.dao.DAOException;
import com.milano.architecture.dbaccess.DBAccess;

public class CodGeneratorCorsista implements IdGenerator, DAOConstants{
	
	private static CodGeneratorCorsista istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private CodGeneratorCorsista() throws DAOException, ClassNotFoundException, IOException{
		conn = DBAccess.getConnection();
	}
	
	public static CodGeneratorCorsista getInstance() throws DAOException, ClassNotFoundException, IOException{
		if(istanza == null)
			istanza = new CodGeneratorCorsista();
		return istanza;
	}
	
	
	@Override
	public long getNextId() throws ClassNotFoundException, DAOException, IOException {
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSISTA_SEQ);
			rs.next();
			id = rs.getLong(1);
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
		return id;
		
	}
	
}
