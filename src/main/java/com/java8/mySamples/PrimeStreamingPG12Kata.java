package com.java8.mySamples;

import java.util.stream.IntStream;

public class PrimeStreamingPG12Kata {

    public static IntStream stream() {
	
	
	
	System.out.println(isPrime(59879));
	
	
	
	return IntStream.of(2, 3, 5, 7, 11, 13, 17);
    }
    
    
    public static boolean isPrime(int number) {


	    if (number % 2 == 0) {
	        return number == 2;
	    }
	    
	    int limit = (int)(0.1 + Math.sqrt(number));
	    for (int i = 3; i <= limit; i += 2) {
	        if (number % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

}
