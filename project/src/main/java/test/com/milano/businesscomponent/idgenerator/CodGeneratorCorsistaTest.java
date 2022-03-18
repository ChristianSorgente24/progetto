package test.com.milano.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.idgenerator.CodGeneratorCorsista;

class CodGeneratorCorsistaTest {

	@Test
	void test() {
		try {
			CodGeneratorCorsista idGen = CodGeneratorCorsista.getInstance();
			assertNotNull("Instanza non creata correttamente");
			long valore = idGen.getNextId();
			assertEquals(valore, idGen.getNextId()-1);
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
	


