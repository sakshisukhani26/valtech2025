package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void test() {
		String s="Hello";
		String s1="Hello";
		assertSame(s,s1);
		String s2=new String("Hello");
		assertNotSame(s1,s2);
		String s3="Hell"+"o";//Here both are constants
		assertSame(s,s3);
		String s4="o";
		String s5="Hell"+s4;
		assertNotSame(s3,s5); //here s5 includes one compile time string and one run time string.
		final String s6="o";// We made it final so it wont create new reference
		String s7="Hell"+s6;//will return true as s6 is compile time string
		assertSame(s,s7);
	}

}
