package com.java8.mySamples;

import static org.junit.Assert.*;

import org.junit.Test;


public class RomanNumeralsEncoderKataTest {
    
    private RomanNumeralsEncoderKata conversion = new RomanNumeralsEncoderKata();
    
    @Test
    public void one_Equals_I() {
	 assertEquals("solution(1) should equal to I", "I", conversion.solution(1));
    }
    
    @Test
    public void two_Equals_II() {
	 assertEquals("solution(1) should equal to II", "II", conversion.solution(2));
    }
    
    @Test
    public void two_Equals_III() {
	 assertEquals("solution(1) should equal to III", "III", conversion.solution(3));
    }
    
    @Test
    public void four_Equals_IV() {
	 assertEquals("solution(4) should equal to IV", "IV", conversion.solution(4));
    }
    
    @Test
    public void six_Equals_VI() {
	assertEquals("solution(6) should equal to VI", "VI", conversion.solution(6));
    }
    
    @Test
    public void seven_Equals_VII() {
	assertEquals("solution(7) should equal to VII", "VII", conversion.solution(7));
    }
    
    @Test
    public void seven_Equals_VIII() {
	assertEquals("solution(8) should equal to VIII", "VIII", conversion.solution(8));
    }
    
    @Test
    public void nine_Equals_IX() {
	assertEquals("solution(9) should equal to IX", "IX", conversion.solution(9));
    }
    
    @Test
    public void ten_Equals_X() {
	assertEquals("solution(10) should equal to X", "X", conversion.solution(10));
    }
    
    @Test
    public void _13_Equals_XIII() {
	assertEquals("solution(13) should equal to XIII", "XIII", conversion.solution(13));
    }
    
    @Test
    public void _14_Equals_XIV() {
	assertEquals("solution(14) should equal to XIV", "XIV", conversion.solution(14));
    }
    
    @Test
    public void _15_Equals_XV() {
	assertEquals("solution(15) should equal to XV", "XV", conversion.solution(15));
    }
    
    @Test
    public void _16_Equals_XVI() {
	assertEquals("solution(16) should equal to XVI", "XVI", conversion.solution(16));
    }
    
    @Test
    public void _19_Equals_XIX() {
	assertEquals("solution(19) should equal to XIX", "XIX", conversion.solution(19));
    }
    
    @Test
    public void _20_Equals_XX() {
	assertEquals("solution(20) should equal to XX", "XX", conversion.solution(20));
    }
    
    @Test
    public void _21_Equals_XXI() {
	assertEquals("solution(21) should equal to XXI", "XXI", conversion.solution(21));
    }
    
    @Test
    public void _24_Equals_XXIV() {
	assertEquals("solution(24) should equal to XXIV", "XXIV", conversion.solution(24));
    }
    
    @Test
    public void _25_Equals_XXV() {
	assertEquals("solution(25) should equal to XXV", "XXV", conversion.solution(25));
    }

}
