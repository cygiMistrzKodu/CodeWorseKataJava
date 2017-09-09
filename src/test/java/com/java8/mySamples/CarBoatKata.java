package com.java8.mySamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;

public class CarBoatKata {

	@Test
	public void test() {

//		 System.out.println(howmuch(1, 37));
//		 System.out.println(howmuch(10000, 9950));
//		 System.out.println(howmuch(9950, 10000));   
		// howmuch(1, 100);
		System.out.println(howmuch(0, 100));

	}

	public static String howmuch(int m, int n) {
		
		if (m > n) {
			int tmp = n;
			n = m;
			m = tmp;
		}

		List<Map<String, Integer>> moneyBoatCarlist = IntStream.rangeClosed(m, n).boxed()
				.flatMap(money -> IntStream.rangeClosed(0, (int) Math.floor(money / 7)).boxed()
						.filter(boatWorth -> money - 7 * boatWorth == 2)
						.flatMap(boatWorth -> IntStream.rangeClosed(0, (int) Math.floor(money / 9)).boxed()
								.filter(carworth -> money - 9 * carworth == 1)
								.map(carworth -> createMap(money, boatWorth, carworth))))
				.collect(Collectors.toList());

		return formatMessage(moneyBoatCarlist.toString());
	}

	private static Map<String, Integer> createMap(int money, int boatWorth, int carWorth) {

		Map<String, Integer> tmpMap = new LinkedHashMap<>();
		tmpMap.put("M", money);
		tmpMap.put("B", boatWorth);
		tmpMap.put("C", carWorth);

		return tmpMap;
	}

	private static String formatMessage(String message) {

		message = message.replace("{", "[");
		message = message.replace("}", "]");
		message = message.replace("=", ": ");
		message = message.replace(",", "");
		message = message.replace("] [", "][");

		return message;

	}

	@Test
	@Ignore
	public void exampleHowToFormatStringFastByReplacing() {

		List<Map<String, Integer>> ListMapTest = new ArrayList<>();

		Map<String, Integer> testMap = new HashMap();

		testMap.put("M", 40);
		testMap.put("B", 5);
		testMap.put("C", 4);

		Map<String, Integer> testMap2 = new HashMap();

		testMap2.put("M", 21);
		testMap2.put("B", 8);
		testMap2.put("C", 3);

		Map<String, Integer> testMap3 = new HashMap();

		testMap3.put("M", 45);
		testMap3.put("B", 8);
		testMap3.put("C", 12);

		ListMapTest.add(testMap);
		ListMapTest.add(testMap2);
		ListMapTest.add(testMap3);

		String printOutString = ListMapTest.toString();

		printOutString = printOutString.replace("{", "[");
		printOutString = printOutString.replace("}", "]");
		printOutString = printOutString.replace("=", ": ");
		printOutString = printOutString.replace(",", "");
		printOutString = printOutString.replace("] [", "][");

		// printOutString = printOutString.replace

		System.out.println(printOutString);

	}

	@Test
	@Ignore
	public void test5() {

		int money = 37;

		System.out.println((int) Math.floor(money / 7));

	}

}
