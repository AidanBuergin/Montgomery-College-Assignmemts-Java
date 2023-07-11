import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	GradeBook g1;
	GradeBook g2;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g1.addScore(10);
		g1.addScore(12);
		g2.addScore(4);
		g2.addScore(6);
		g2.addScore(8);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		assertEquals("10.0 12.0 0.0 0.0 0.0 ", g1.toString());
		assertEquals(2, g1.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(22.0, g1.sum());
		assertEquals(18.0, g2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(10.0, g1.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(12.0, g1.finalScore());
		assertEquals(14.0, g2.finalScore());
	}

//	@Test
//	void testGetScoreSize() {
//		
//	}
//
//	@Test
//	void testToString() {
//		fail("Not yet implemented");
//	}

}
