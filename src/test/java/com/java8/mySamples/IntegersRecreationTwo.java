package com.java8.mySamples;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class IntegersRecreationTwo {

	@Test
	public void test() {
		//
//		long a = 1;
//		long b = 2;
//		long c = 1;
//		long d = 3;

//		long a = 67;
//		long b = 13;
//		long c = 82;
//		long d = 180;
//		
//		10 11 12 13
		
//		long a = 10;
//		long b = 11;
//		long c = 12;
//		long d = 13;

		// long a = 2;
		// long b = 3;
		// long c = 4;
		// long d = 5;

//		 long a = 1;
//		 long b = 1;
//		 long c = 3;
//		 long d = 5;
		 
//		 177 29 0 102
		 
		 long a = 177;
		 long b = 29;
		 long c = 0;
		 long d = 102;
		 
//		 long a = 100;
//		 long b = 100;
//		 long c = 100;
//		 long d = 100;
//		 
		 
//		 long a = 136;
//		 long b = 0;
//		 long c = 27;
//		 long d = 141;

		List<long[]> prodSUm = prod2Sum(a, b, c, d);
		
		System.out.println("----------------------------------------");
		System.out.println(prodSUm.size());
		prodSUm.forEach(t -> System.out.println(t[0] + " " + t[1]));

	}

	public static List<long[]> prod2Sum(long a, long b, long c, long d) {

//		Double sumN = (Math.pow(a, 2) + Math.pow(b, 2)) * (Math.pow(c, 2) + Math.pow(d, 2));
		
//		Double sumN = Math.pow(a*c+b*d, 2) + Math.pow(a*d-b*c, 2);
		
		long firstSetProductONe = Math.abs(b*c - a*d);
		long firstSetProductTwo = Math.abs( a*c + b*d);
		
		long secondSetProductONe = Math.abs( b*d - a*c);
		long secondSetProductTwo = Math.abs( a*d + b*c);
		
		List<long[]> baseProductList = new LinkedList<>();
		baseProductList.add(new long[] { firstSetProductONe,firstSetProductTwo });
		
		if (firstSetProductONe != secondSetProductONe && firstSetProductONe != secondSetProductTwo ) {
			
			baseProductList.add(new long[] { secondSetProductONe,secondSetProductTwo });
		}
		
		return	baseProductList.stream()
		.map(i -> sortArray(i))
		.collect(Collectors.toList());
		
//		List<Long[]> baseProductListSorted =	baseProductList.stream()
//				.map(i -> sortArray(i))
//				.collect(Collectors.toList());
		
		
//		baseProductList.stream()
//		.forEach(i -> System.out.println("Tut; "+i[0]+ " "+ i[1] ));
//		
//		
//		
//		System.out.println("-----------------------------------");
//		System.out.println(firstSetProductONe+" "+ firstSetProductTwo);
//		System.out.println(secondSetProductONe+" "+ secondSetProductTwo);
//		System.out.println("-----------------------------------");
//		
//		
//		System.out.println(sumN);
//
//		int limit = (int) Math.floor(Math.sqrt(sumN));
//		
//		System.out.println(limit);
//
//		return LongStream
//				.rangeClosed(0, limit).boxed()
//				.flatMap(firstBase -> LongStream.rangeClosed(firstBase, limit)
//						.filter(secondBase -> (firstBase * firstBase) + (secondBase * secondBase) == sumN)
//						.mapToObj(secondBase -> new long[] { firstBase, secondBase }))
//				.collect(Collectors.toList());

	}
	
	
	private static long[] sortArray (long [] arrayToSort) {
		
	    Arrays.sort(arrayToSort);
		
	  return arrayToSort;
	}

}
