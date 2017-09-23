package com.java8.mySamples;

import static org.junit.Assert.*;

import org.junit.Test;


public class RomanNumeralsEncoderKataTest {
    
    private RomanNumeralsEncoderKata conversion = new RomanNumeralsEncoderKata();

    @Test
    public void shouldCovertToRoman() {
        assertEquals("solution(1) should equal to I", "I", conversion.solution(1));
        assertEquals("solution(4) should equal to IV", "IV", conversion.solution(4));
        assertEquals("solution(6) should equal to VI", "VI", conversion.solution(6));
    }
    
    @Test
    public void test() {
	fail("Not yet implemented");
    }

}
