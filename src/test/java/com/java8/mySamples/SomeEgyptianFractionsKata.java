package com.java8.mySamples;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class SomeEgyptianFractionsKata {

//	private final static double ACCEPTABLE_TOLERANCE = 7.65790E-9;
	private final static double ACCEPTABLE_TOLERANCE = 0.1E-8;

	@Test
	public void test66_100() {
		
		assertEquals( "[1/2, 1/7, 1/59, 1/5163, 1/53307975]", decompose("66", "100"));  
		
	}
	
	
	@Test
	public void test22_23() {

		// System.out.println(convertDecimalToFraction(0.00395256916996047));

		// System.out.println(convertDecimalToFraction(0.00000155268413));
		// System.out.println(convertDecimalToFraction(0.0000015526841250));
		// System.out.println(convertDecimalToFraction(6.00000000000000));
		// System.out.println(convertDecimalToFraction(0.0833333333333333));
		// System.out.println(convertDecimalToFraction(6));

		// 0.00909090909090909

		// 0.00395256916996047

		// int[] numbers = toFractionPos(new BigDecimal("0.0090456"));
		//
		// System.out.println(numbers[0]+"/"+numbers[1]);
		
		long timeStart =  System.currentTimeMillis();
//		
//		System.out.println(timeStart/1000 % 60);
		
		String fractionsList;

//		 fractionsList = decompose("21", "23");
//		fractionsList =	 decompose("12", "4");
//		fractionsList =  decompose("0", "2");
//		fractionsList =  decompose("12", "2");
//		fractionsList =	 decompose("9", "10");
//		fractionsList =	 decompose("34", "645");
		// decompose("3", "4");
		// decompose("5", "8");
//		decompose("13", "12");
		// decompose("24", "12");
//		 decompose("11", "12");
//		 fractionsList =  decompose("66", "100");
//		 fractionsList =  decompose("22", "23");
		 
//		 fractionsList =  decompose("3000", "4187");
		 
//		 System.out.println(fractionsList);
//		 
//		 System.out.println((System.currentTimeMillis() - timeStart) /1000 % 60);
		 
//		 assertEquals( decompose("66", "100"), "[1/2, 1/7, 1/59, 1/5163, 1/53307975]");  
		 assertEquals("[1/2, 1/3, 1/9, 1/83, 1/34362]", decompose("22", "23"));  

	}

	public static String decompose(String nrStr, String drStr) {

        double numerator = Double.parseDouble(nrStr);
		double denominator = Double.parseDouble(drStr);

		double decimalFraction = numerator / denominator;

		double currentDenominator = 2;
		double currentFractionSum = 0;

		List<Double> listOfEgyptianFractionsInDecimal = new ArrayList<>();

		if (numerator%denominator == 0 && numerator != 0) {

			return "["+String.valueOf((int) decimalFraction)+"]";
		}

		double currentFractionAndCurrentFractionsSumDiffrence;

		do {

			double tmpFraction = 1 / currentDenominator ;
			currentFractionSum = currentFractionSum += tmpFraction;

			if (currentFractionSum <= decimalFraction) {

				listOfEgyptianFractionsInDecimal.add(tmpFraction);

			}

			if (currentFractionSum >= decimalFraction) {

				currentFractionSum = currentFractionSum -= tmpFraction;
			}

			currentDenominator = currentDenominator += 1;
			currentFractionAndCurrentFractionsSumDiffrence = decimalFraction - currentFractionSum;

		} while (currentFractionAndCurrentFractionsSumDiffrence > ACCEPTABLE_TOLERANCE);

		List<String> egyptianfractions = listOfEgyptianFractionsInDecimal.stream()
//				.map(df -> BigDecimal.valueOf(df).setScale(24,RoundingMode.UP).doubleValue())
				.peek(df -> System.out.println(df))
				.map(df -> convertDecimalToFraction(df))
				.collect(Collectors.toList());

		return egyptianfractions.toString();
	}

	static private String convertDecimalToFraction(double x) {
		if (x < 0) {
			return "-" + convertDecimalToFraction(-x);
		}
		double tolerance = 1.0E-6;
		double h1 = 1;
		double h2 = 0;

		double k1 = 0;
		double k2 = 1;
		double b = x;
		do {
			double a = Math.floor(b);
			double aux = h1;

			h1 = a * h1 + h2;
			h2 = aux;

			aux = k1;
			k1 = a * k1 + k2;

			k2 = aux;
			b = 1 / (b - a);

		} while (Math.abs(x - h1 / k1) > x * tolerance);

		return (int) h1 + "/" + (int) k1;
	}

	static int[] toFractionPos(BigDecimal x) {

		String[] parts = x.toString().split("\\.");

		System.out.println(parts[1].length());

		BigDecimal denominator = BigDecimal.TEN.pow(parts[1].length());

		System.out.println("denominator: " + denominator);
		// BigDecimal denominator = BigDecimal.TEN.pow(1);
		BigDecimal numerator = (new BigDecimal(parts[0]).multiply(denominator)).add(new BigDecimal(parts[1]));

		System.out.println("numerator: " + numerator);

		return reduceFraction(numerator.intValue(), denominator.intValue());
	}

	static int[] reduceFraction(int numerator, int denominator) {

		System.out.println("numerator: " + numerator + " denominator " + denominator);

		int gratestCommonDivisior = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator)).intValue();

		System.out.println("Gratest commond divisor: " + gratestCommonDivisior);

		int[] rf = { numerator / gratestCommonDivisior, denominator / gratestCommonDivisior };
		return rf;
	}

	static private String convertDecimalToFractionDebug(double x) {
		if (x < 0) {
			return "-" + convertDecimalToFractionDebug(-x);
		}
		double tolerance = 1.0E-6;
		double h1 = 1;
		double h2 = 0;

		double k1 = 0;
		double k2 = 1;
		double b = x;
		do {
			double a = Math.floor(b);
			System.out.println("a = Math.floor(b) : " + a);
			double aux = h1;
			System.out.println("aux = h1 : " + aux);
			h1 = a * h1 + h2;
			System.out.println("h1 = a*h1+h2 : " + h1);
			h2 = aux;
			System.out.println("h2 = aux: " + h2);
			aux = k1;
			System.out.println("aux = k1: " + aux);
			k1 = a * k1 + k2;
			System.out.println("k1 = a*k1+k2: " + k1);
			k2 = aux;
			System.out.println("k2 = aux: " + k2);
			b = 1 / (b - a);
			System.out.println("b = 1/(b-a): " + b);
			System.out.println("------------------------------------------------");
			System.out.println("Math.abs(x-h1/k1: " + Math.abs(x - h1 / k1));
			System.out.println("x*tolerance: " + x * tolerance);
			System.out.println("------------------------------------------------");
		} while (Math.abs(x - h1 / k1) > x * tolerance);

		return (int) h1 + "/" + (int) k1;
	}

}
