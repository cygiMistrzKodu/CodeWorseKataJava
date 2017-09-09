package com.java8.mySamples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;

public class AreWeAlternate {

	private static int index = 0;
	private static Set<String> vovels = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));

	@Test
	public void test() {

		String text;

//		 text = "amazon";
//		 text = "apple";
//		 text = "banana";
//		 text = "ba";
//		 text = "bb";
		// text = "aaabbbb";
//		 text = "oaoaoiio";
//		 text = "zzzzzzzz";
		// text = "bbbbbb";
//		 text = "a";
//		 text = "b";
//		 text = "bejad";
		// text = "dihih";
		 text = "cebef";

//		 text = "cebefaa";
//		text = "oaoaoiio";

		System.out.println(isAlt(text));

	}

	public static boolean isAlt(String word) {
		
		index = 0 ;

		List<Boolean> rightOrderList = new LinkedList<>();

		for (int i = 0; i < word.length(); i++) {

			if (vovels.contains(word.substring(0, 1))) {
				
				if(i%2 == 0) {
					rightOrderList.add(true);	
				}
				else {
					rightOrderList.add(false);	
				}

			}

			if (!vovels.contains(word.substring(0, 1))) {

				if(i%2 == 0) {
					rightOrderList.add(false);	
				}
				else {
					rightOrderList.add(true);	
				}

			}

		}
			
	return	 Stream.of(word).map(a -> a.split(""))
		.flatMap(a -> Arrays.stream(a))
		.map(a -> counter(a))
	    .map(a -> vovels.contains(a))
		.allMatch(a -> a == rightOrderList.get(index-1)); 

	}

	private static String counter(String element) {

		index++;

		return element;
	}

	
	
	
	private static int isFirstLetterVovel(String word) {

		if (vovels.contains(word.substring(0, 1))) {
			return 1;
		}

		return 0;
	}

}
