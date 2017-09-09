package com.java8.mySamples;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class MorseCodeDecoder {

	@Test
	public void test() {
		
//		String message = ".... . -.--   .--- ..- -.. .";
//		String message = " .";
		String message = "   .   . ";
	
//		String message = ". -.- ..-   -.--";
		
		
		
		
		System.out.println(decode(message));
		
	}

	 public static String decode(String morseCode) {
		 		 
		 return Stream.of(morseCode)
		 .map(s -> s.split("   "))
		 .flatMap(Arrays::stream)
		 .map(s -> s.split(" "))
		 .map(s -> transletMorseCodeLineToNormalWord(s))
		 .collect(Collectors.joining(" ")).trim();
	    }
	 
	 private static String transletMorseCodeLineToNormalWord(String [] lineInMorseCode ) {		   
		  
		return Stream.of(lineInMorseCode)
		 .map(s -> s.split(" "))
		 .flatMap(Arrays::stream)
		 .filter(s -> !s.isEmpty())
		 .map(s -> MorseCode.get(s))
		 .collect(Collectors.joining(""));
	 }

}
