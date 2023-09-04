import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	GradeBook g1;
	GradeBook g2;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		
		g1.addScore(7);
		g1.addScore(14);
		g2.addScore(8);
		g2.addScore(15);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		assertEquals(g1.toString(), "7.0 14.0 0.0 0.0 0.0 ");
		assertEquals(g1.getScoreSize(), 2, .0001);
	}
	
	@Test
	void testSum() {
		assertEquals(g1.sum(), 21, .001);
	}
	
	@Test
	void testMinimum() {
		assertEquals(g1.minimum(), 0, .001);
	}
	
	@Test
	void testFinalScore() {
		assertEquals(g1.finalScore(), 21, .001);
	}

}
