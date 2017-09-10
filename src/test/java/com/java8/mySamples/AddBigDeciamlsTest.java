package com.java8.mySamples;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class AddBigDeciamlsTest {

	@Test
	public void test() {
		
		BigDecimal test = new BigDecimal(0.50000000000000);
		test = test.add(new BigDecimal(0.14285714285714));
		test = test.add(new BigDecimal(0.01694915254237));
		test = test.add(new BigDecimal(0.00019368584156));
		
		System.out.println(test);
		
		
	}

}
