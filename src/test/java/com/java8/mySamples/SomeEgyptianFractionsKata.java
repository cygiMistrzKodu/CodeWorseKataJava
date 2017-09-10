package com.java8.mySamples;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SomeEgyptianFractionsKata {
	
	private final static double ACCEPTABLE_TOLERANCE = 7.65790E-9 ;

	@Test
	public void test() {

		// System.out.println(convertDecimalToFraction(0.00395256916996047));

		// System.out.println(convertDecimalToFraction(0.00000155268413));
//		 System.out.println(convertDecimalToFraction(0.0000015526841250));
//		 System.out.println(convertDecimalToFraction(6.00000000000000));
//		 System.out.println(convertDecimalToFraction(0.0833333333333333));

		// 0.00909090909090909

		// 0.00395256916996047

		// int[] numbers = toFractionPos(new BigDecimal("0.0090456"));
		//
		// System.out.println(numbers[0]+"/"+numbers[1]);

		 decompose("21", "23");
//		 decompose("12", "4");
//		 decompose("0", "2");
//		 decompose("12", "2");
//		 decompose("9", "10");
//		 decompose("34", "645");
		// decompose("3", "4");
		// decompose("5", "8");
//		 decompose("13", "12");
//		decompose("24", "12");
//		decompose("11", "12");

	}

	public static String decompose(String nrStr, String drStr) {

		BigDecimal numerator = new BigDecimal(nrStr);
		BigDecimal denominator = new BigDecimal(drStr);

		BigDecimal decimalFraction = numerator.divide(denominator, 16, RoundingMode.HALF_UP);

		BigDecimal currentDenominator = new BigDecimal(2);
		BigDecimal currentFractionSum = new BigDecimal(0);

		List<BigDecimal> ListOfEgyptianFractions = new ArrayList<>();

		if (numerator.remainder(denominator).compareTo(BigDecimal.ZERO) == 0 && numerator.compareTo(BigDecimal.ZERO)  != 0) {

			ListOfEgyptianFractions.add(decimalFraction.setScale(0));
			System.out.println("currentFractionSum: " + ListOfEgyptianFractions);

			return "";
		}
		
		BigDecimal diffrentCurrentFractionAndCurrentFractionsSum;

		do {

			BigDecimal tmpFraction = BigDecimal.ONE.divide(currentDenominator, 16, RoundingMode.HALF_UP);
			currentFractionSum = currentFractionSum.add(tmpFraction);

			if (currentFractionSum.compareTo(decimalFraction) <= 0) {

				ListOfEgyptianFractions.add(tmpFraction);

			}

			if (currentFractionSum.compareTo(decimalFraction) > 0) {

				currentFractionSum = currentFractionSum.subtract(tmpFraction);
			}

			currentDenominator = currentDenominator.add(BigDecimal.ONE);

			System.out.println("currentFractionSum: " + currentFractionSum);
			System.out.println("   decimalFraction: " + decimalFraction);
			System.out.println("currentDenominator: " + currentDenominator);
			System.out.println("ListOfEgyptianFractions: " + ListOfEgyptianFractions);
			
			 diffrentCurrentFractionAndCurrentFractionsSum = decimalFraction.subtract(currentFractionSum);
			
						System.out.println("diffrentCurrentFractionAndCurrentFractionSum: " + diffrentCurrentFractionAndCurrentFractionsSum);
						
//						diffrentCurrentFractionAndCurrentFractionSum.compareTo(val)
			

//		} while (currentFractionSum.compareTo(decimalFraction) < 0
//				&& currentDenominator.compareTo(new BigDecimal(1000000)) != 0);
//	} while (currentFractionSum.compareTo(decimalFraction) < 0
//			&& diffrentCurrentFractionAndCurrentFractionsSum.compareTo(new BigDecimal(ACCEPTABLE_TOLERANCE)) > 0 );
	} while (diffrentCurrentFractionAndCurrentFractionsSum.compareTo(new BigDecimal(ACCEPTABLE_TOLERANCE)) > 0 );
		// } while (currentDenominator.compareTo(new BigDecimal(644049)) < 0);

		System.out.println(decimalFraction.toString());

		return null;
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
