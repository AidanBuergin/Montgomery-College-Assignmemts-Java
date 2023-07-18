import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: The plot of land that a property takes up.
 * Due: 7/17/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Aidan Buergin_________
*/

/**
 * @author Aidan Buergin
 *
 */
class ManagementCompanyTestStudent {
	
	ManagementCompany mgm1;
	ManagementCompany mgm2;
	ManagementCompany mgm3;
	Property prop1;
	Property prop2;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		mgm1 = new ManagementCompany();
		mgm2 = new ManagementCompany("company2", "544455", 2);
		mgm3 = new ManagementCompany("company3", "221555", 4, 0, 0, 10, 10);
		prop1 = new Property("333 lane", "Frederick", 33, "me");
		prop2 = new Property();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		mgm1 = null;
		mgm2 = null;
		mgm3 = null;
		prop1 = null;
		prop2 = null;
	}
	
	/**
	 * @summary ensures that the addProperty method is functional
	 */

	@Test
	void testAddProperty() {
		assertEquals(mgm1.addProperty(prop1), 0);
		assertEquals(mgm1.addProperty(prop2), -4);
	}
	
	@Test
	void testAddProperty2() {
		assertEquals(mgm1.addProperty("myHouse", "Frederick", 20, "me"), 0);
	}
	
	@Test
	void testAddProperty3() {
		assertEquals(mgm1.addProperty("myHouse", "Frederick", 20, "me", 0, 0, 1, 1), 0);
	}
	
	@Test
	void testGetName() {
		assertEquals(mgm2.getName(), "company2");
	}
	
	@Test
	void testGetTaxID() {
		assertEquals(mgm2.getTaxID(), "544455");
	}
	
	@Test
	void testGetMgmFeePer() {
		assertEquals(mgm2.getMgmFeePer(), 2.0, 2.0);
	}
	
	@Test
	void testGetProperties() {
		Property[] p = new Property[5];
		mgm2.addProperty(prop1);
		p = mgm2.getProperties();
		assertEquals(p.toString(), mgm2.getProperties().toString());
	}
	
	@Test
	void testGetPlot() {
		assertEquals(mgm3.getPlot().toString(), "0,0,10,10");
	}
	
	@Test
	void testGetTotalRent() {
		mgm2.addProperty(prop1);
		assertEquals(mgm2.getTotalRent(), 33.0, 33.0);
	}
	
	@Test
	void testGetHighestRentPropperty() {
		mgm2.addProperty(prop1);
		mgm2.addProperty(prop2);
		assertEquals(mgm2.getHighestRentPropperty(), prop1);
	}
	
	@Test
	void testRemoveLastProperty() {
		Property[] p = new Property[5];
		mgm2.addProperty(prop1);
		mgm2.removeLastProperty();
		p = mgm2.getProperties();
		assertEquals(p.toString(), mgm2.getProperties().toString());
	}
	
	@Test
	void testIsPropertiesFull() {
		assertEquals(mgm2.isPropertiesFull(), false);
	}
	
	@Test
	void testGetPropertiesCount() {
		mgm2.addProperty(prop1);
		assertEquals(mgm2.getPropertiesCount(), 1);
	}
	
	@Test
	void testIsManagementFeeValid() {
		mgm3.setMgmFee(1000);
		assertEquals(mgm2.isManagementFeeValid(), true);
		assertEquals(mgm3.isManagementFeeValid(), false);
	}
	
	@Test
	void testToString() {
		prop1 = new Property ("Sunsational", "Beckman", 2613.0, "BillyBob Wilson",2,5,2,2);
		assertEquals(mgm1.addProperty(prop1), 0);	//property has been successfully added to index 0
		String expectedString = "List of the properties for , taxID: \n_____________________________________________\n"
				+ "Property Name: Sunsational\nLocated in: Beckman\nBelongs to: BillyBob Wilson\nRent Amount: 2613.0\n\n_____________________________________________\n\ntotal management Fee: 0.0";
		assertEquals(expectedString, mgm1.toString());
	}
	
	//Author: Aidan Buergin

}
