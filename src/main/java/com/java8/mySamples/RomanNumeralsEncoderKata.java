package com.java8.mySamples;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class RomanNumeralsEncoderKata {

    Map<Integer, String> romanNumberSymbol = new HashMap<>();

    String romanNumber = "";

    public String solution(int n) {

	initilizeRomanNumberMap();

	romanNumber = "";
	
	
	
	if (n >= 20 && n <= 30) {

	    IntStream.rangeClosed(1, n/10).forEach(index -> romanNumber += romanNumberSymbol.get(10));
	    
	    n = n - 20;

	}
	

	if (n >= 10 && n <= 19) {

	    romanNumber += romanNumberSymbol.get(10);
	    n = n - 10;

	}

	if (n >= 5 && n <= 8) {

	    romanNumber += romanNumberSymbol.get(5);
	    n = n - 5;

	}

	if (n <= 3) {

	    IntStream.rangeClosed(1, n).forEach(index -> romanNumber += romanNumberSymbol.get(1));

	}

	if (n == 4) {

	    romanNumber += romanNumberSymbol.get(1);
	    romanNumber += romanNumberSymbol.get(5);

	}

	if (n == 9) {
	    romanNumber += romanNumberSymbol.get(1);
	    romanNumber += romanNumberSymbol.get(10);
	}

	return romanNumber;
    }

    private void initilizeRomanNumberMap() {
	romanNumberSymbol.put(1, "I");
	romanNumberSymbol.put(5, "V");
	romanNumberSymbol.put(10, "X");
	romanNumberSymbol.put(50, "L");
	romanNumberSymbol.put(100, "C");
	romanNumberSymbol.put(500, "D");
	romanNumberSymbol.put(1000, "M");
    }

}
