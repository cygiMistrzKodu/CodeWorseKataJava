package com.java8.mySamples;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.junit.Ignore;
import org.junit.Test;

public class SomeEgyptianFractionsKata {

	@Test
	@Ignore
	public void commonDivisorTest() {

		long denominatorOne = 2;
		long denominator2 = 7;
		long denominator3 = 59;
		long denominator4 = 5163;

		long denominator5 = 100;

		long[] denominators = { denominatorOne, denominator2, denominator3, denominator4 };

		long LNW = leastCommonMultiple(denominators);

		System.out.println(LNW);

	}

	@Test
	@Ignore
	public void Congruence_test() {

		// (-15) mod 7 a mod b conqurence

		// int a = -15;
		double a = -3;
		// int b = 7;
		double b = 10;

		int result = (int) congruenceMod(a, b);

		System.out.println("-----------Congruence_test----------");
		System.out.println(result);
		System.out.println("----------------------------");

	}

	@Test
	public void test7_15() {

		assertEquals("[1/3, 1/8, 1/120]", decompose("7", "15"));

	}

	@Test
	public void test66_100() {

		assertEquals("[1/2, 1/7, 1/59, 1/5163, 1/53307975]", decompose("66", "100"));

	}

	@Test
	public void test5_121() {

		assertEquals("[1/25, 1/757, 1/763309, 1/873960180913, 1/1527612795642093418846225]", decompose("5", "121"));

	}

	@Test
	public void test22_23() {
		
		assertEquals("[1/2, 1/3, 1/9, 1/83, 1/34362]", decompose("22", "23"));

	}
	
	
	@Test
	public void test3_4() {
		
		assertEquals("[1/2, 1/4]", decompose("3", "4"));

	}
	
	@Test 
	public void test12_4() {
		
		assertEquals("[3]", decompose("12", "4"));

	}
	
	@Test 
	public void test1_0_2() {
		
		assertEquals("[]", decompose("0", "2"));

	}

	public static String decompose(String nrStr, String drStr) {

		Double numerator = Double.parseDouble(nrStr);
		Double denominator = Double.parseDouble(drStr);

		Double numeratorInBegin = numerator;
		Double denominatorInBegin = denominator;

		List<long[]> listOfFractions = new ArrayList<>();

		int numeratorFraction = 1;
		
		if (numeratorInBegin == 0) {
			
		 return	"[]";
			
		}
		
		if (numeratorInBegin >= denominatorInBegin) {
			
			return "[" + (numeratorInBegin.intValue()/denominatorInBegin.intValue())  + "]";
		}
		
		for (;;) {

			long denominatorFraction = (long) Math.ceil(denominator.doubleValue() / numerator.doubleValue());

			long[] fraction = { numeratorFraction, denominatorFraction };
			listOfFractions.add(fraction);

			long numeratorSecondFraction = (long) congruenceMod(-denominator, numerator);

			long denominatorSecondFraction = (long) (denominator * denominatorFraction);

			long[] reduceFraction = reduceFraction(new long[] { numeratorSecondFraction, denominatorSecondFraction });

			if (reduceFraction[0] > 1) {

				numerator = (double) reduceFraction[0];
				denominator = (double) reduceFraction[1];

			}

			if (reduceFraction[0] == 1) {

				long[] summedFractions = sumFractions(listOfFractions);

				long[] fractionInBegin = new long[] { numeratorInBegin.longValue(), denominatorInBegin.longValue() };

				long[] lastfraction = substractFractions(fractionInBegin, summedFractions);

				long[] lastfractionReduced = reduceFraction(lastfraction);

				listOfFractions.add(lastfractionReduced);

				break;

			}
		
		}

		return listOfFractions.stream()
				.map(f -> f[0] + "/" + f[1])
				.collect(Collectors.toList()).toString();

	}
	

	static private double congruenceMod(double a, double b) {
		
		return ((a % b) + b) % b;
		
	}
	
	
	private static long[] reduceFraction(long[] fraction) {

		long gratestCommonDivisiorSecondFraction = gratestCommonDivisor(fraction[0], fraction[1]);

		long numeratorFractionReduced = fraction[0] / gratestCommonDivisiorSecondFraction;
		long denominatorFractionReduced = fraction[1] / gratestCommonDivisiorSecondFraction;

		return new long[] { numeratorFractionReduced, denominatorFractionReduced };
	}

	static private long[] sumFractions(List<long[]> fractions) {

		long[] fractionsDenominators = new long[fractions.size()];

		LongStream.range(0, fractions.size())
				.map(index -> fractionsDenominators[(int) index] = fractions.get((int) index)[1])
				.count();

		long commonDenominatorFromFractions = leastCommonMultiple(fractionsDenominators);

		long numeratorsSum = fractions.stream()
				.map(f -> (commonDenominatorFromFractions / f[1]) * f[0])
				.collect(Collectors.summingLong(Long::longValue));

		long[] fractionsSum = { numeratorsSum, commonDenominatorFromFractions };

		return fractionsSum;
	}

	static private long[] substractFractions(long[] minuendFraction, long[] subtrahendFraction) {

		long commonDenominator = leastCommonMultiple(minuendFraction[1], subtrahendFraction[1]);

		long lastFractionNumerator = (commonDenominator / minuendFraction[1] * minuendFraction[0])
				- (commonDenominator / subtrahendFraction[1] * subtrahendFraction[0]);

		return new long[] { lastFractionNumerator, commonDenominator };
	}

	static private long gratestCommonDivisor(long a, long b) {

		while (b > 0) {

			long temp = b;
			b = a % b;
			a = temp;
		}

		return a;

	}


	private static long leastCommonMultiple(long a, long b) {
		return a * (b / gratestCommonDivisor(a, b));
	}

	private static long leastCommonMultiple(long[] input) {

		long result = input[0];
		for (int i = 1; i < input.length; i++)
			result = leastCommonMultiple(result, input[i]);

		return result;
	}
	
	
	
	

	private static long gratestCommonDivisor(long[] input) {

		long result = input[0];
		for (int i = 1; i < input.length; i++) {

			result = gratestCommonDivisor(result, input[i]);
		}
		return result;

	}

	@Test
	@Ignore
	public void reduceFractionTest() {

		long[] fraction = new long[] { 4, 213231900 };

		long[] fractionReduced = reduceFraction(fraction);

		System.out.println("Reduce Fraction: " + fractionReduced[0] + " " + fractionReduced[1]);

	}

	@Test
	@Ignore
	public void sumFractionTest() {

		List<long[]> fractionTest = new ArrayList<>();
		fractionTest.add(new long[] { 1, 2 });
		fractionTest.add(new long[] { 1, 7 });
		fractionTest.add(new long[] { 1, 59 });
		fractionTest.add(new long[] { 1, 5163 });

		long[] fractionsSum = sumFractions(fractionTest);

		System.out.println("Suma: " + fractionsSum[0] + " " + fractionsSum[1]);

	}

	@Test
	@Ignore
	public void substractFractionTest() {

		long[] fractionFirst = new long[] { 66, 100 };

		long[] fractionSecond = new long[] { 2814661, 4264638 };

		long[] fractionLast = substractFractions(fractionFirst, fractionSecond);

		System.out.println("Last Fraction: " + fractionLast[0] + " " + fractionLast[1]);

	}
	
	
	 private static void testing(String actual, String expected) {
	        assertEquals(expected, actual);
	    }
	 
	 @Test
	    public void test1() {
	        testing(decompose("3", "4"), "[1/2, 1/4]");
	        testing(decompose("12", "4"), "[3]");
	        testing(decompose("0", "2"), "[]"); 
	        testing(decompose("9", "10"), "[1/2, 1/3, 1/15]");
	    }
	

}
