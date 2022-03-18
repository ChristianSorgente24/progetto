package test.com.milano.businesscomponent.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.utility.LoginUtility;

class LoginUtilityTest {

	@Test
	void test() {
		try {
		LoginUtility lu = new LoginUtility();
		long password = lu.getCodice("user");
		assert(password > 0);
		System.out.println(password);
		} catch(DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			fail("Errore nel recupero del codice");
		}
	}

}
