package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {

	@Test
	void testSquare() {
		Square sq=new Square() {

			@Override
			public double squareNow(double x) {
				// TODO Auto-generated method stub
				return x*x;
			}
			
		};
		Square square = (a) -> a*a;
		assertEquals(0,square.squareNow(0));
		assertEquals(0,square.squareNow(-0));
		assertEquals(1,square.squareNow(1));
		assertEquals(1,square.squareNow(-1));
	}

}
