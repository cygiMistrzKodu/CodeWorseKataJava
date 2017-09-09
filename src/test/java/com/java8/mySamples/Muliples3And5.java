package com.java8.mySamples;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;

public class Muliples3And5 {

	@Test
	public void test() {
		
		int sum = solution(11);
		System.out.println(sum);

	}

	int solution(int number) {

		return IntStream.range(1, number)
				.filter(i -> i % 3 == 0 || i % 5 == 0)
				.sum();

	}

}
