package text.com.milano.businesscomponent;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.milano.businesscomponent.CorsoCorsistaBC;
import com.milano.businesscomponent.model.Corso;
import com.milano.businesscomponent.model.CorsoCorsista;

class CorsoCorsistaBCTest {
	private static CorsoCorsista corsoCorsista;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corsoCorsista = new CorsoCorsista();
		corsoCorsista.setCodCorso(1494);
		corsoCorsista.setCodCorsista(2);
		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	@Test
	void test() {
		try {
			
			CorsoCorsistaBC ccBC = new CorsoCorsistaBC();
			ccBC.delete(corsoCorsista);
			ccBC.create(corsoCorsista);
			
			Corso[] corsi = ccBC.getCorsi(2);
			assertNotNull(corsi);
			for(Corso c: corsi)
				System.out.println(c);
			
			ccBC.delete(corsoCorsista);

		} catch(Exception e) {
			e.printStackTrace();
			fail("Errore");
		}
	}

}
