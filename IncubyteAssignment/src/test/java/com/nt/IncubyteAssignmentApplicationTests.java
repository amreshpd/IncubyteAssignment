package com.nt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.nt.service.Addition;

@SpringBootTest
class IncubyteAssignmentApplicationTests {

	private static Addition addition;
	
	@BeforeAll
	public static void beforeTest() {
		addition=new Addition();
	}
	
	@Test
    public void testEmptyString() throws Exception {
        int actual=addition.add("");
        int expected=0;
        assertEquals(expected, actual);
    }
	
}
