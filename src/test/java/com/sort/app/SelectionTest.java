package com.sort.app;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SelectionTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public SelectionTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(SelectionTest.class);
	}

	public void testSort() {
		int[] testArray = { 5, 2, 3, 7, 1 };
		int[] expectedResult = { 1, 2, 3, 5, 7 };
		Selection testSelection = new Selection();

		assertTrue(Arrays.equals(expectedResult, testSelection.sort(testArray)));
	}
}
