package com.java8.mySamples;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MyLambdaTest {
	
	@Test
	public void TestLambdaExpression() {
		
		List<Integer> someNumbers = new ArrayList<>();
		someNumbers.add(3);
		someNumbers.add(53);
		someNumbers.add(12);
		someNumbers.add(145);
		
		someNumbers.stream()
		.forEach(n -> System.out.println("Pupa jasiu ma lat: " +  n));
		
		
	}
	
}
    