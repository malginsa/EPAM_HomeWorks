package HomeWork151027;

// This is the "JUnit test case" file
// and should be moved to ../../test/HomeWork151027 folder

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RomanTest {

	private Roman roman;

	@Before
	public void before() {
		roman = new Roman();
	}

	@Test
	public void clazz() throws Exception {
		assertTrue(roman instanceof Roman);
	}
	
	@Test
	public void returnType() throws Exception {
		String result = roman.convert(1);
		assertTrue(result instanceof String);
	}
	
	@Test
	public void paramType() throws Exception {
		try {
			roman.convert(-1);
			roman.convert(0);
			roman.convert(1001);
			fail("Out of range");
		} catch (Exception e) {
		}
	}

	@Test
	public void test1000() throws Exception {
		assertEquals("M", roman.convert(1_000));
	}
	
	@Test
	public void testUnits() throws Exception {
		assertEquals("I", roman.convert(1));
		assertEquals("II", roman.convert(2));
		assertEquals("III", roman.convert(3));
		assertEquals("IV", roman.convert(4));
		assertEquals("V", roman.convert(5));
		assertEquals("VI", roman.convert(6));
		assertEquals("VII", roman.convert(7));
		assertEquals("VIII", roman.convert(8));
		assertEquals("IX", roman.convert(9));
	}
	
	@Test
	public void testDozens() throws Exception {
		assertEquals("XI", roman.convert(11));
		assertEquals("XXIII", roman.convert(23));
		assertEquals("XLIV", roman.convert(44));
		assertEquals("XLIX", roman.convert(49));
		assertEquals("LII", roman.convert(52));
		assertEquals("LXXVI", roman.convert(76));
		assertEquals("XCIX", roman.convert(99));
	}
	
	@Test
	public void testHundreds() throws Exception {
		assertEquals("CI", roman.convert(101));
		assertEquals("CCIX", roman.convert(209));
		assertEquals("CDLIII", roman.convert(453));
		assertEquals("DCLXXIX", roman.convert(679));
		assertEquals("DCCLXXXVIII", roman.convert(788));
		assertEquals("CMXCIX", roman.convert(999));
	}
}
