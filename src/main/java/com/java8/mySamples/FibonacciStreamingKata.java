package com.java8.mySamples;

import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciStreamingKata {

   
    public static IntStream generateFibonacciSequence() {

	UnaryOperator<int[]> fibonacciCalculation = x -> new int[] { x[1], x[0] + x[1] };
	
	return Stream.iterate(new int[] { 1, 1 }, fibonacciCalculation)
		.mapToInt(x -> x[0]);
	

    }

   

}
