package com.sort.app;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	public void testStringToIntArray() {
		String testString = "2,5,7 , 6";
		int[] expectedResult = { 2, 5, 7, 6 };

		assertTrue(Arrays.equals(expectedResult,
				App.stringToIntArray(testString)));

	}

	public void testValidateInput() {
		assertTrue(App.validateInput("2,3,4,5"));
		assertTrue(App.validateInput("2,  3,4,5"));
		assertTrue(App.validateInput("2,  3    ,4,5"));
		assertTrue(App.validateInput("      2,  3    ,4,5"));
		assertTrue(App.validateInput("      2,  3    ,4,5      "));
	}

	public void testStringToInt() {
		String testString = "  6   ";
		int expectedResult = 6;

		assertTrue(expectedResult == App.stringToInt(testString));

	}

	public void testValidateInputForSwitch() {
		assertTrue(App.validateInputForSwitch("7"));
		assertTrue(App.validateInputForSwitch("     7"));
		assertTrue(App.validateInputForSwitch("7     "));
		assertTrue(App.validateInputForSwitch("   7   "));
	}
}
