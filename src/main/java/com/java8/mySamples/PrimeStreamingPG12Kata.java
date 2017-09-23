package com.java8.mySamples;

import java.util.stream.IntStream;

public class PrimeStreamingPG12Kata {

    public static IntStream stream() {

	return IntStream.iterate(2, n -> n < 3 ? n + 1 : n + 2)
		.filter( oddNumber ->  isPrime(oddNumber));

    }

    public static boolean isPrime(int oddNumber) {

	int limit = (int) (0.1 + Math.sqrt(oddNumber));
	for (int i = 3; i <= limit; i += 2) {
	    if (oddNumber % i == 0) {
		return false;
	    }
	}
	return true;
    }

}
