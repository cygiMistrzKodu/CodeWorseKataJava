package com.java8.mySamples;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.junit.Test;

public class IntegersRecreationOne {
	
//	list_squared(42, 250) --> [[42, 2500], [246, 84100]]

	@Test
	public void test() {
		
		String result = "[[1, 1], [42, 2500], [246, 84100]]"; 
		
//		42, 250
		
//		5000 10000
		
//		listSquared(1, 6250);
//		System.out.println(listSquared(1, 250));
		System.out.println(listSquared(5000, 10000));
//		listSquared(42, 250);
//		listSquared(250,500);
		
	}
	
	
	public static String listSquared(long m, long n) {
		
		Map<Long, Long> numberAndDivisorSquareSumMap = new  TreeMap<>();
		
		LongStream.rangeClosed(m, n).boxed()
		.flatMap(i -> LongStream.rangeClosed(1, i)
				.filter(j -> i%j == 0)
				.map(j -> j*j)
         		.mapToObj(j -> numberAndDivisorSquareSumMap.containsKey(i) ? 
         				numberAndDivisorSquareSumMap.put(i, numberAndDivisorSquareSumMap.get(i) + j) 
         				: numberAndDivisorSquareSumMap.put(i, j)))		
		.count();
		
	 String	numberAndSquareDivisiorSumText =  numberAndDivisorSquareSumMap.entrySet().stream()
		.filter(i -> Math.sqrt(i.getValue()) %2 == 0 || i.getKey() == 1 )
		.map(i -> "["+ i.getKey() +", "+i.getValue()+ "]")
		.collect(Collectors.joining(", "));
		
		return "["+numberAndSquareDivisiorSumText+"]";
	}

}
