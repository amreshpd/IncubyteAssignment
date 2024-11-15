package com.nt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.nt.exception.NegativeNumberException;
import com.nt.service.Addition;

@SpringBootTest
class IncubyteAssignmentApplicationTests {

	private static Addition addition;

	@BeforeAll
	public static void stepOnce() {
		addition = new Addition();
	}

	@Test
	public void testEmptyString() throws Exception {
		int actual = addition.add("");
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSingleNumber() throws Exception {
		int actual = addition.add("1");
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testTwoNumbers() throws Exception {
		assertEquals(9, addition.add("4,5"));
	}

	@Test
	public void testUnlimitedAmountOfNumbers() throws Exception {
		assertEquals(17, addition.add("8,2,3,4"));
	}

	@Test
	public void testNewlineAsSeparator() throws Exception {
		assertEquals(11, addition.add("1\n2,3\n5"));
	}

	@Test
    public void testCustomDelimiter() throws Exception {
        assertEquals(3, addition.add("//;\n1;2"));
    }
	@Test
    public void testNegativeNumberException() {
        Exception exception = assertThrows(NegativeNumberException.class, () -> addition.add("1,-2"));
        assertEquals("negative numbers not allowed [-2]", exception.getMessage());
    }
	@Test
    public void testMultipleNegativeNumbersException() {
        Exception exception = assertThrows(NegativeNumberException.class, () -> addition.add("1,-2,-3"));
        assertEquals("negative numbers not allowed [-2, -3]", exception.getMessage());
    }
	@AfterAll
	public static void stepDown() {
		addition = null;
	}

}
