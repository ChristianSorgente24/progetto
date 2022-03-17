package test.com.milano.architecture.dbaccess;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.milano.architecture.dbaccess.DBAccess;

class DBAccessTest {

	@Test
	void testConnection() {
		try {
			DBAccess.getConnection();
		} catch(ClassNotFoundException | SQLException |IOException e) {
			e.printStackTrace();
			fail("Errore nell'apertura della connessione");
		} finally {
			try {
				DBAccess.closeConnection();
			} catch(SQLException sql) {
				sql.printStackTrace();
				fail("Errore nella chiusura della connessione");
			}
		}
	}

}
