package com.java8.mySamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class CollectionFreamworkTest {

	@Test
	@Ignore
	public void replaceTheLastApperanceOfTheValue5InTheResultingArrayList() {

		ArrayList<Integer> arrayList01 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5, 5));
		ArrayList<Integer> arrayList02 = new ArrayList<>(Arrays.asList(5));

		int positionfLast5 = Collections.lastIndexOfSubList(arrayList01, arrayList02);

		if (positionfLast5 == -1) {
			System.out.println("No index postion found of number in the second list");
			return;
		}

		arrayList01.set(positionfLast5, 6);
		System.out.println(arrayList01);
	}

	@Test
	@Ignore
	public void hashMapFun() {

		HashMap<String, Double> continenets = new HashMap<>();
		continenets.put("Europe", 1.018E8);
		continenets.put("North America", 2.449E8);
		continenets.put("Africa", 3.037E8);
		continenets.put("Asia", 4.382E8);
		continenets.put("Australia", 9.0085E7);
		continenets.put("South America", 1.7848E8);
		continenets.put("Antarctica", 1.372E8);

		String[] keys = continenets.keySet().toArray(new String[continenets.size()]);

		if (keys.length < 0)
			return;

		for (String str01 : keys) {
			System.out.println("continent-" + str01 + "\t\tsize= " + continenets.get(str01));

		}

	}

	private static void test2(List<String> lalaList) { // this for testing interface implementation

	}

	@Test
	public void frequencyOfUniqureWordsInTheRhymeVerse() {

		String rhyme = "Mary had a little lamb\nlittle lamb\nMary had a little lamb that was as white as snow";

		rhyme = rhyme.replace('\n', ' ');
		String[] rhymeArray = rhyme.split(" ");

		HashMap<String, Integer> hashMap01 = new HashMap<>();

		for (int count = 0; count < rhymeArray.length; count++) {

			if (hashMap01.containsKey(rhymeArray[count])) {
				hashMap01.replace(rhymeArray[count], hashMap01.get(rhymeArray[count])+1);

			} else {
				hashMap01.put(rhymeArray[count], 1);
			}


			System.out.println(hashMap01);
		}
//		System.out.println(hashMap01);
	}

}
