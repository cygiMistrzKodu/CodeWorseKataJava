package com.java8.mySamples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciStreamingKata {

    private static int currentNumber = 0;
    private static int previousNumber = 1;
    private static int index = 0;

    public static IntStream generateFibonacciSequence() {

	// int b = 3;

	// IntStream a = IntStream.generate(() -> nextFibonaciNumber(index++));
	// IntStream a = IntStream.generate( () -> b += 1);

	// int[] tmp = a.limit(20).toArray();

	// IntStream.of(tmp).forEach(i -> System.out.println(i));

	List<Integer> list = new ArrayList<>();

	int[] array = new int[] { 1, 1 };

	UnaryOperator<int[]> f = x -> new int[] { x[1], x[0] + x[1] };

	Object[] aTest = Stream.iterate(array, f).map(x -> x[0]).limit(20).toArray();
	
	
	Stream.of(aTest)
	.forEach(h -> System.out.println(h));
	


	// IntUnaryOperator f = x -> new int[] {x[1], x[0] + x[1]};

	// IntStream.iterate(array, f).map(x -> x[0]);

	return IntStream.of(1, 1, 2, 3, 5, 8, 13);
    }

    // private static int nextFibonaciNumber(int index) {
    //
    // // System.out.println(index);
    //
    // if (index == 0) {
    // previousNumber = 1;
    //
    // return 1;
    // }
    //
    // currentNumber += previousNumber;
    //
    // return currentNumber;
    // }

}
