package com.java8.mySamples;

import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;

public class SortinOnPalnetTwisted {

	@Test @Ignore
	public void test() {

		Integer[] integers = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Integer[] sortedIntgers = sortTwisted37(integers);

		Stream.of(sortedIntgers).forEach(System.out::println);

	}

	public static Integer[] sortTwisted37(Integer[] array) {

		return array;
	}

}
