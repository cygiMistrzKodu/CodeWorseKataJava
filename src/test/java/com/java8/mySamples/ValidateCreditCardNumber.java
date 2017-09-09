package com.java8.mySamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class ValidateCreditCardNumber {

	@Test
	public void test() {

		 String creditCardNumber = "1714";
//		String creditCardNumber = "891";

		boolean isValid = validate(creditCardNumber);

		System.out.println("is card valid: " + isValid);

	}

	public static boolean validate(String n) {

		List<Integer> digitsAfterDoubled;

		List<Integer> listOfDigits = Arrays.stream(n.split("")).map(Integer::parseInt).collect(Collectors.toList());

		if (listOfDigits.size() % 2 == 0) {

			digitsAfterDoubled = IntStream.range(0, listOfDigits.size())
					// .map(index -> index%2 == 0 ? listOfDigits.get(index)*2 :
					// listOfDigits.get(index))
					.map(index -> doubleDigits(listOfDigits, index, d -> d % 2 == 0))
//					.map(digit -> digit > 9 ? digit - 9 : digit)
					.map(digit -> minus9IfDigitBiggerThan9(digit, d -> d > 9))
					.mapToObj(i -> i).collect(Collectors.toList());

			digitsAfterDoubled.stream().forEach(System.out::println);

		} else {

			digitsAfterDoubled = IntStream.range(0, listOfDigits.size())
					// .map(index -> index%2 == 1 ? listOfDigits.get(index)*2 :
					// listOfDigits.get(index))
					.map(index -> doubleDigits(listOfDigits, index, d -> d % 2 == 1))
//					.map(digit -> digit > 9 ? digit - 9 : digit)
					.map(digit -> minus9IfDigitBiggerThan9(digit, d -> d > 9))
					.mapToObj(i -> i).collect(Collectors.toList());

			digitsAfterDoubled.stream().forEach(System.out::println);

		}

		int sumOfDigits = digitsAfterDoubled.stream().collect(Collectors.summingInt(Integer::intValue));

		System.out.println(sumOfDigits);

		return sumOfDigits % 10 == 0;

		// digitsAfterDoubled.stream()
		// .forEach(System.out::println);

		// return true; // it's is for the moment only
	}

	private static Integer doubleDigits(final List<Integer> digitList, int index, Predicate<Integer> p) {

		// Predicate<Boolean> predicate = null; // ale dziwo mi tu wyszlo

		if (p.test(index)) {
			int digit = digitList.get(index) * 2;

			return digit;

		} else {

			return digitList.get(index);
		}

		// ? digitList.get(index)*2 : digitList.get(index));

	}
	
	private static Integer minus9IfDigitBiggerThan9(int digit, Predicate<Integer> p) {

		// Predicate<Boolean> predicate = null; // ale dziwo mi tu wyszlo

		if (p.test(digit)) {

			return digit - 9;

		} else {

			return digit;
		}

		// ? digitList.get(index)*2 : digitList.get(index));

	}

}
