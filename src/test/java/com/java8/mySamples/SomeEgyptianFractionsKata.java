package com.java8.mySamples;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
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
	public void testFractionLook() {

		System.out.println("--------No i jaki ulamek----------------");
		System.out.println(convertDecimalToFraction(0.133333333333333));
		System.out.println("------------------------");

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
				
//		System.out.println(Double.MAX_VALUE);

		assertEquals("[1/25, 1/757, 1/763309, 1/873960180913, 1/1527612795642093418846225]", decompose("5", "121"));

	}

	@Test
	public void test22_23() {

		assertEquals("[1/2, 1/3, 1/9, 1/83, 1/34362]", decompose("22", "23"));

	}

	public static String decompose(String nrStr, String drStr) {

		Double numerator = Double.parseDouble(nrStr);
		Double denominator = Double.parseDouble(drStr);

		Double numeratorInBegin = numerator;
		Double denominatorInBegin = denominator;

		List<long[]> listOfFractions = new ArrayList<>();

		int numeratorFraction = 1;

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

			if (numeratorSecondFraction == 1) {

//				System.out.println("------------------PRZED OStatnim------------------------------");
//				listOfFractions.forEach(f -> System.out.println(f[0] + "/" + f[1]));
//				System.out.println("------------------------------------------------");

				long[] summedFractions = sumFractions(listOfFractions);

				long[] fractionInBegin = new long[] { numeratorInBegin.longValue(), denominatorInBegin.longValue() };

				long[] lastfraction = substractFractions(fractionInBegin, summedFractions);
				
				long[] lastfractionReduced = reduceFraction(lastfraction);
				
				listOfFractions.add(lastfractionReduced);

//				System.out.println("------------------------------------------------");
//				listOfFractions.forEach(f -> System.out.println(f[0] + "/" + f[1]));
//				System.out.println("------------------------------------------------");

				break;

			}

		}

		return listOfFractions.stream().map(f -> f[0] + "/" + f[1]).collect(Collectors.toList()).toString();

	}

	@Test
	@Ignore
	public void reduceFractionTest() {

		long[] fraction = new long[] { 4, 213231900 };

		long[] fractionReduced = reduceFraction(fraction);

		System.out.println("Reduce Fraction: " + fractionReduced[0] + " " + fractionReduced[1]);

	}

	private static long[] reduceFraction(long[] fraction) {

		long gratestCommonDivisiorSecondFraction = gratestCommonDivisor(fraction[0], fraction[1]);

		long numeratorFractionReduced = fraction[0] / gratestCommonDivisiorSecondFraction;
		long denominatorFractionReduced = fraction[1] / gratestCommonDivisiorSecondFraction;

		return new long[] { numeratorFractionReduced, denominatorFractionReduced };
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

	static private long[] sumFractions(List<long[]> fractions) {

		long[] fractionsDenominators = new long[fractions.size()];

		LongStream.range(0, fractions.size())
				.map(index -> fractionsDenominators[(int) index] = fractions.get((int) index)[1]).count();

		long commonDenominatorFromFractions = leastCommonMultiple(fractionsDenominators);

		long numeratorsSum = fractions.stream().map(f -> (commonDenominatorFromFractions / f[1]) * f[0])
				.collect(Collectors.summingLong(Long::longValue));

		long[] fractionsSum = { numeratorsSum, commonDenominatorFromFractions };

		return fractionsSum;
	}

	@Test
	@Ignore
	public void substractFractionTest() {

		long[] fractionFirst = new long[] { 66, 100 };

		long[] fractionSecond = new long[] { 2814661, 4264638 };

		long[] fractionLast = substractFractions(fractionFirst, fractionSecond);

		System.out.println("Last Fraction: " + fractionLast[0] + " " + fractionLast[1]);

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

	private static long gratestCommonDivisor(long[] input) {

		long result = input[0];
		for (int i = 1; i < input.length; i++) {

			result = gratestCommonDivisor(result, input[i]);
		}
		return result;

	}

	static private double congruenceMod(double a, double b) {

		return ((a % b) + b) % b;

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
