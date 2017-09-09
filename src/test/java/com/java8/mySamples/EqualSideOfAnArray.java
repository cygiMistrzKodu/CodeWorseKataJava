package com.java8.mySamples;

import static org.junit.Assert.*;

import org.junit.Test;

public class EqualSideOfAnArray {

	@Test
	public void test() {

		// int[] numbers = { 1, 2, 3, 4, 3, 2, 1 };

		// int[] numbers = {1,100,50,-51,1,1};

		int[] numbers = { 1, 2, 3, 4, 5, 6 };

		System.out.println(findEvenIndex(numbers));

	}

	public static int findEvenIndex(int[] arr) {

		int rightSideArraySum = 0;
		int leftSideAraySum = 0;

		for (int index = 0; index < arr.length; index++) {

			leftSideAraySum = 0;
			rightSideArraySum = 0;

			for (int leftIndex = 0; leftIndex < index; leftIndex++) {

				leftSideAraySum += arr[leftIndex];
			}

			for (int rightIndex = index + 1; rightIndex < arr.length; rightIndex++) {

				rightSideArraySum += arr[rightIndex];
			}

			if (rightSideArraySum == leftSideAraySum) {
				return index;
			}

		}

		return -1;

	}

}
