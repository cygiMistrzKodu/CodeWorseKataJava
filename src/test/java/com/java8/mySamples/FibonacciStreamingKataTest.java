package com.java8.mySamples;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciStreamingKataTest {

    @Test
    public void test() {
	
	 assertArrayEquals("The first twenty elements are incorrect!",
	          new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765},
	          FibonacciStreamingKata.generateFibonacciSequence().limit(20).toArray());
    }

}
