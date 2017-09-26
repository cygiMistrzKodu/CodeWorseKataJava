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
	
	if (n >= 1000 && n <= 3999) {

	    IntStream.rangeClosed(1, n / 1000).forEach(index -> romanNumber += romanNumberSymbol.get(1000));
	    n = n - (n / 1000) * 1000;

	}
	
	
	if (n >= 900 && n <= 999) {
	    
	    romanNumber += romanNumberSymbol.get(100);
	    romanNumber += romanNumberSymbol.get(1000);
	    n = n - 900;

	}
	
	if (n >= 600 && n <= 899) {

	    romanNumber += romanNumberSymbol.get(500);
	    n = n - 500;

	}
	
	if (n >= 400 && n <= 599) {

	    romanNumber += romanNumberSymbol.get(100);
	    romanNumber += romanNumberSymbol.get(500);
	    n = n - 400;

	}

	if (n >= 100 && n <= 399) {

	    IntStream.rangeClosed(1, n / 100).forEach(index -> romanNumber += romanNumberSymbol.get(100));
	    n = n - (n / 100) * 100;

	}

	if (n >= 90 && n <= 99) {

	    romanNumber += romanNumberSymbol.get(10);
	    romanNumber += romanNumberSymbol.get(100);
	    n = n - 90;

	}

	if (n >= 50 && n <= 89) {

	    romanNumber += romanNumberSymbol.get(50);
	    n = n - 50;

	}

	if (n >= 40 && n <= 59) {

	    romanNumber += romanNumberSymbol.get(10);
	    romanNumber += romanNumberSymbol.get(50);
	    n = n - 40;

	}

	if (n >= 10 && n <= 39) {

	    IntStream.rangeClosed(1, n / 10).forEach(index -> romanNumber += romanNumberSymbol.get(10));

	    n = n - (n / 10) * 10;

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
