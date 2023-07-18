
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyGFATest {
	Property sampleProperty;
	ManagementCompany mangementCo ; 
	
	@Before
	public void setUp() throws Exception {
		mangementCo= new ManagementCompany("Railey", "555555555",6);
	}

	@After
	public void tearDown() throws Exception {
		mangementCo=null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
	}
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	
		assertEquals(mangementCo.getPropertiesCount(), 1);
	}

	@Test
	public void testToString() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613.0, "BillyBob Wilson",2,5,2,2);
		assertEquals(mangementCo.addProperty(sampleProperty), 0);	//property has been successfully added to index 0
		String expectedString = "List of the properties for Railey, taxID: 555555555\n_____________________________________________\n"
				+ "Property Name: Sunsational\nLocated in: Beckman\nBelongs to: BillyBob Wilson\nRent Amount: 2613.0\n\n_____________________________________________\n\ntotal management Fee: 6.0";
		assertEquals(expectedString, mangementCo.toString());
				
	}


 
}