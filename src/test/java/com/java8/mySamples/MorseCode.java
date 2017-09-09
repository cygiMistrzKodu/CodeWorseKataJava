package com.java8.mySamples;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MorseCode {
	
 private static	 Map<String, String> morseCode = new HashMap<>();
	
	static {
		morseCode.put(".-", "A");
		morseCode.put("-...", "B");
		morseCode.put("-.-.", "C");
		morseCode.put("-..", "D");
		morseCode.put(".", "E");
		morseCode.put("..-.", "F");
		morseCode.put("--.", "G");
		morseCode.put("....", "H");
		morseCode.put("..", "I");
		morseCode.put(".---", "J");
		morseCode.put("-.-", "K");
		morseCode.put(".-..", "L");
		morseCode.put("--", "M");
		morseCode.put("-.", "N");
		morseCode.put("---", "O");
		morseCode.put(".--.", "P");
		morseCode.put(".-.", "R");
		morseCode.put("...", "S");
		morseCode.put("-", "T");
		morseCode.put("..-", "U");
		morseCode.put("...-", "V");
		morseCode.put(".--", "W");
		morseCode.put("-..-", "X");
		morseCode.put("-.--", "Y");
		morseCode.put("--..", "Z");
		
		morseCode.put(".----", "1");
		morseCode.put("..---", "2");
		morseCode.put("...--", "3");
		morseCode.put("....-", "4");
		morseCode.put(".....", "5");
		morseCode.put("-....", "6");
		morseCode.put("--...", "7");
		morseCode.put("---..", "8");
		morseCode.put("----.", "9");
		morseCode.put("-----", "0");
		
//		morseCode.put("   ", " ");
	}

	public static String get(String morseCodeLetter) {
		// TODO Auto-generated method stub
		return morseCode.get(morseCodeLetter);
	}
	public static String getLetterFromMorseCode(String letter) {
		// TODO Auto-generated method stub
		return morseCode.entrySet()
				.stream()
				.filter(entry -> Objects.equals(entry.getValue(), letter))
				.map(Map.Entry::getKey)
//				.peek(i -> System.out.println(i))
				.findFirst()
				.get();
	}

}
