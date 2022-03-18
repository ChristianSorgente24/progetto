package test.com.milano.businesscomponent.utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.milano.businesscomponent.model.Corsista;
import com.milano.businesscomponent.utility.StatsUtility;


@TestMethodOrder(OrderAnnotation.class)
class StatsUtilityTest {

	@Test
	@Order(1)
	void testNumeroCorsistiTotali() {
		try {
			StatsUtility st = new StatsUtility();
			int n = st.numeroCorsistiTotali();
			System.out.println("il numero totale di corsisti è: "+n);
			
		} catch(Exception exc) {
			exc.printStackTrace();
			fail("Not yet implemented");
		}
		
	}
	
	@Test
	@Order(2)
	void testelencoCorsisti() {
		try {
			StatsUtility st = new StatsUtility();
			Corsista[] c = st.elencoCorsisti();
			for(int i=0; i< c.length;i++)
				System.out.println(c[i] + " |");
			
		} catch(Exception exc) {
			exc.printStackTrace();
			fail("Not yet implemented");
		}
		
	}
	@Test
	@Order(3)
	void testcorsoPiuFrequentato() {
		try {
			StatsUtility st = new StatsUtility();
			String c = st.corsoPiuFrequentato();
				System.out.println(c);
			
		} catch(Exception exc) {
			exc.printStackTrace();
			fail("Not yet implemented");
		}
		
	}
	@Test
	@Order(4)
	void testdurataMediaCorsi() {
		try {
			StatsUtility st = new StatsUtility();
			double c = st.durataMediaCorsi();
				System.out.println(c);
			
		} catch(Exception exc) {
			exc.printStackTrace();
			fail("Not yet implemented");
		}
		
	}
}
