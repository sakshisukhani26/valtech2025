package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArithmeticTest {
	private Arithmetic ari=(Arithmetic)new ArithmeticTest();

	@Test
	void testAdd() {
		
		fail("Not yet implemented");
	}

	@Test
	void testSub() {
		fail("Not yet implemented");
	}

	@Test
	void testMul() {
		fail("Not yet implemented");
	}

	@Test
	void testDiv() {
		fail("Not yet implemented");
	}
	
	@Test
	void testDivWithDouble() {
//		assertEquals(double.POSITIVE_INFINITY,ari.div(5, 3),0.001);
	}
	
	@Test
	void testDivWithInt() {
		assertEquals(2,ari.div(4,2));
		assertEquals(3,ari.div(7, 2));
	}
	
	@Test
	void testDivWithIntDenomIsZero() {
		try {
			ari.div(3, 0);
			fail("Exception was expected");
		}catch(Exception e){
			
		}
		
	}

}
