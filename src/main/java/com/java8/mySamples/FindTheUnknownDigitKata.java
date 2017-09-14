package com.java8.mySamples;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindTheUnknownDigitKata {

	public static int solveExpression(final String expression) {
		int missingDigit = -1;
		
		List<Integer> numbersInEquation = new ArrayList<>();

		String onlyNumberPattern = "-?\\d*\\w";
		
		String operationSignPattern = "(?<=\\d)[-*+]";

		Pattern numbersInEquationPattern = Pattern.compile(onlyNumberPattern);
		Pattern operationInEquationPattern = Pattern.compile(operationSignPattern);
	
		Matcher numberMatcher;
		Matcher operationMatcher;
		
		String testEquation = expression.replaceAll("\\?", String.valueOf(2));
		operationMatcher =  operationInEquationPattern.matcher(testEquation);
		operationMatcher.find();
		String operationSign = operationMatcher.group();
		System.out.println(operationSign);
		

		for (int number = 0; number < 10; number++) {

			String equation = expression.replaceAll("\\?", String.valueOf(number));
			
			 numberMatcher = numbersInEquationPattern.matcher(equation);
			 operationMatcher = operationInEquationPattern.matcher(equation);
			 
			 while(numberMatcher.find()) {
				 numbersInEquation.add(Integer.valueOf(numberMatcher.group()));
			 }
			 
			if(numbersInEquation.get(0) * numbersInEquation.get(1) == numbersInEquation.get(2)) {
				
				 System.out.println(number);
				break;
			}
			 
			 System.out.println(numbersInEquation);
			 numbersInEquation.clear();
	
//			 System.out.println(numberMatcher.group());

		}
		
//		System.out.println(numbersInEquation);

		return missingDigit;
	}

}
