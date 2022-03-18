package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.CorsoDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.businesscomponent.model.Corso;

class CorsoDAOTest {

	@Test
	void test() {
		try {
			Corso corso = new Corso(1, "corso1", new Date(), new Date(), 100.00, "Bello", "1A", 1567L);
			CorsoDAO.getInstance().create(DBAccess.getConnection(), corso);
			System.out.println("Corso Creato");
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
