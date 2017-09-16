package com.java8.mySamples;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindTheUnknownDigitKataTest {

	// assertEquals( "Answer for expression '1+1=?' " , 2 ,
	// Runes.solveExpression("1+1=?") );
	// assertEquals( "Answer for expression '123*45?=5?088' " , 6 ,
	// Runes.solveExpression("123*45?=5?088") );
	// assertEquals( "Answer for expression '-5?*-1=5?' " , 0 ,
	// Runes.solveExpression("-5?*-1=5?") );
	// assertEquals( "Answer for expression '19--45=5?' " , -1 ,
	// Runes.solveExpression("19--45=5?") );
	// assertEquals( "Answer for expression '??*??=302?' " , 5 ,
	// Runes.solveExpression("??*??=302?") );
	// assertEquals( "Answer for expression '?*11=??' " , 2 ,
	// Runes.solveExpression("?*11=??") );

	@Test
	public void test1() {

		FindTheUnknownDigitKata.solveExpression("1+1=?");

		assertEquals(2, FindTheUnknownDigitKata.solveExpression("1+1=?"));

	}

	@Test
	public void test2() {

		assertEquals(6, FindTheUnknownDigitKata.solveExpression("123*45?=5?088"));

	}

	@Test
	public void test3() {

		assertEquals(-1, FindTheUnknownDigitKata.solveExpression("19--45=5?"));

	}

	@Test
	public void test4() {

		assertEquals(0, FindTheUnknownDigitKata.solveExpression("-5?*-1=5?"));

	}

	@Test
	public void test5() {

		assertEquals(5, FindTheUnknownDigitKata.solveExpression("??*??=302?"));

	}

	@Test
	public void test6() {

		assertEquals(2, FindTheUnknownDigitKata.solveExpression("?*11=??"));

	}

	@Test
	public void test7() {

		assertEquals(0, FindTheUnknownDigitKata.solveExpression("?*123?45=?"));

	}

	@Test
	public void test8() {

		assertEquals(9, FindTheUnknownDigitKata.solveExpression("?8?170-1?6256=7?2?14"));

	}

	@Test
	public void test9() {
			
		assertEquals(1, FindTheUnknownDigitKata.solveExpression("??605*-63=-73???5"));
		
	}

}
