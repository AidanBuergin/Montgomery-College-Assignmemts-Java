import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestStudent {

	private double[][] data1 = { { 5, 7, 8}, {1, 9}, { 2, 3, 12, 11}, {3, 4}};

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateHolidayBonusA() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(data1);
			assertEquals(8000.0, result[0], .001);
			assertEquals(6000.0, result[1], .001);
			assertEquals(13000.0, result[2], .001);
			assertEquals(4000.0, result[3], .001);
		} catch (Exception e) {
			fail("This shouldnt cause exception");
		}

	}

	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(31000.0, HolidayBonus.calculateTotalHolidayBonus(data1), .001);
	}

}
