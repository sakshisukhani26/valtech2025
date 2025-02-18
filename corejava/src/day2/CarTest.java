package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void testhashcode() {
		Car car=new Car("Honda","City","VX",2024,7);
		int hash=car.hashCode();
		System.out.println(car+" "+car.hashCode());
		assertEquals(hash,car.hashCode());
		assertEquals(hash,new Car("Honda","City","VX",2024,7).hashCode());
//		assertEquals("Honda City VX 2024 Version 7",car.toString());
		car.setVariant("ZX");
		assertEquals("Honda City ZX 2024 Version 7",car.toString());
	}
	@Test
	void testToString() {
		Car car=new Car("Honda","City","VX",2024,7);
		assertEquals("Honda City VX 2024 Version 7",car.toString());
		car.setVariant("ZX");
		assertEquals("Honda City ZX 2024 Version 7",car.toString());
	}

}
