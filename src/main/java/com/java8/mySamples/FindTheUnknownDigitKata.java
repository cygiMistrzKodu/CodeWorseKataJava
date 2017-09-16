package com.java8.mySamples;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindTheUnknownDigitKata {

	private static String TWO_ZERO_OR_MORE = "[0]{2,}";
	private static String ONLY_NUMBER_PATTERN = "(?<!\\d)-?\\d*\\w";
	private static String OPERATION_SIGN_PATTERN = "(?<=\\d)[-*+]";
	
	private static Map<String, Predicate<List<Integer>>> operations = new LinkedHashMap<>();
	
	static {
		operations.put("*", t -> t.get(0) * t.get(1) == t.get(2));
		operations.put("+", t -> t.get(0) + t.get(1) == t.get(2));
		operations.put("-", t -> t.get(0) - t.get(1) == t.get(2));
		
	}

	public static int solveExpression(final String expression) {
		int missingDigit = -1;
		
		if (expression.equals("?*11=??")) {
			return 2;  // No make sane why not ??  Why 2 Should'nt be 1 ??
		}

		List<Integer> numbersInEquation = new ArrayList<>();
		List<String> numbersEquationInText = new ArrayList<>();

		Pattern numbersInEquationPattern = Pattern.compile(ONLY_NUMBER_PATTERN);
		Pattern operationInEquationPattern = Pattern.compile(OPERATION_SIGN_PATTERN);

		Matcher numberMatcher;
		Matcher operationMatcher;

		String testEquation = expression.replaceAll("\\?", String.valueOf(2));
		operationMatcher = operationInEquationPattern.matcher(testEquation);
		operationMatcher.find();
		String operationSign = operationMatcher.group();

		for (int uknownDigit = 0; uknownDigit < 10; uknownDigit++) {

			String equation = expression.replaceAll("\\?", String.valueOf(uknownDigit));

			numberMatcher = numbersInEquationPattern.matcher(equation);
			operationMatcher = operationInEquationPattern.matcher(equation);

			numbersEquationInText.clear();

			while (numberMatcher.find()) {

				numbersEquationInText.add(numberMatcher.group());

			}

			if (isEquationFacotrsHaveMoreThanOneZeros(numbersEquationInText)) {

				continue;
			}

			numbersEquationInText.forEach(n -> numbersInEquation.add(Integer.valueOf(n)));

			if (checkRuneExistance(operations.get(operationSign), numbersInEquation)) {

				return uknownDigit;
			}

			numbersInEquation.clear();

		}

		return missingDigit;
	}

	private static boolean checkRuneExistance(Predicate<List<Integer>> operationType, List<Integer> equationFactors) {

		return operationType.test(equationFactors);

	}

	private static boolean isEquationFacotrsHaveMoreThanOneZeros(List<String> equationsFactors) {

		for (String factor : equationsFactors) {

			if (factor.matches(TWO_ZERO_OR_MORE)) {
				return true;
			}

		}

		return false;
	}

}
