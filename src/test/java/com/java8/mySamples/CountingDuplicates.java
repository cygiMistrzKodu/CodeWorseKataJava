package com.java8.mySamples;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CountingDuplicates {

	@Test
	public void test() {

		// String inputText = "ABBA";
		String inputText = "Indivisibilities";
		// String inputText = "abcde";
		// String inputText = "aA11";

		System.out.println(duplicateCount(inputText));

	}

	public static int duplicateCount(String text) {

		Set<Character> distinctCharacters = new HashSet<>();

		return (int) text.toLowerCase().chars()
				.mapToObj(i -> (char) i)
				.filter(character -> !distinctCharacters.add(character))
				.distinct()
				.count();

	}

}
