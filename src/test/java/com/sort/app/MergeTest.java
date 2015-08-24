package com.sort.app;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MergeTest

extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MergeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MergeTest.class );
    }
	public void testSort() {
		int[] testArray = { 5, 2, 3, 7, 1 };
		int[] expectedResult = { 1, 2, 3, 5, 7 };
		Merge testMerge = new Merge();

		assertTrue(Arrays.equals(expectedResult, testMerge.sort(testArray)));	}

}
