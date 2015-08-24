package com.sort.app;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class InsertionTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public InsertionTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void testSort() {
		int[] testArray = { 5, 2, 3, 7, 1 };
		int[] expectedResult = { 1, 2, 3, 5, 7 };
		Insertion testInsertion = new Insertion();

		assertTrue(Arrays.equals(expectedResult, testInsertion.sort(testArray)));
	}

}
