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
    
    @Test
    public void _30_Equals_XXIX() {
	assertEquals("solution(29) should equal to XXIX", "XXIX", conversion.solution(29));
    }
    
    @Test
    public void _30_Equals_XXX() {
	assertEquals("solution(30) should equal to XXX", "XXX", conversion.solution(30));
    }
    
    @Test
    public void _31_Equals_XXXI() {
	assertEquals("solution(31) should equal to XXXI", "XXXI", conversion.solution(31));
    }
    
    @Test
    public void _39_Equals_XXXIX() {
	assertEquals("solution(39) should equal to XXXIX", "XXXIX", conversion.solution(39));
    }
    
    @Test
    public void _40_Equals_XL() {
	assertEquals("solution(40) should equal to XL", "XL", conversion.solution(40));
    }
    
    @Test
    public void _41_Equals_XLI() {
	assertEquals("XLI", conversion.solution(41));
    }
    
    @Test
    public void _48_Equals_XLVIII() {
	assertEquals("XLVIII", conversion.solution(48));
    }
    
    
    @Test
    public void _50_Equals_XL() {
	assertEquals("L", conversion.solution(50));
    }
    
    @Test
    public void _51_Equals_LI() {
	assertEquals("LI", conversion.solution(51));
    }
    
    @Test
    public void _55_Equals_LV() {
	assertEquals("LV", conversion.solution(55));
    }
    
    @Test
    public void _59_Equals_LIX() {
	assertEquals("LIX", conversion.solution(59));
    }
    
    @Test
    public void _60_Equals_LX() {
	assertEquals("LX", conversion.solution(60));
    }
    
    @Test
    public void _88_Equals_LXXXVIII() {
	assertEquals("LXXXVIII", conversion.solution(88));
    }
    
    @Test
    public void _90_Equals_LXL() {
	assertEquals("XC", conversion.solution(90));
    }
    
    @Test
    public void _91_Equals_XCI() {
	assertEquals("XCI", conversion.solution(91));
    }
    
    @Test
    public void _99_Equals_XCIX() {
	assertEquals("XCIX", conversion.solution(99));
    }
    
    @Test
    public void _100_Equals_C() {
	assertEquals("C", conversion.solution(100));
    }
    
    @Test
    public void _101_Equals_CI() {
	assertEquals("CI", conversion.solution(101));
    }
    
    @Test
    public void _150_Equals_CL() {
	assertEquals("CL", conversion.solution(150));
    }
    
    @Test
    public void _230_Equals_CCXXX() {
	assertEquals("CCXXX", conversion.solution(230));
    }
    
    @Test
    public void _390_Equals_CCCXC() {
	assertEquals("CCCXC", conversion.solution(390));
    }
    
    @Test
    public void _400_Equals_CD() {
	assertEquals("CD", conversion.solution(400));
    }
    
    @Test
    public void _401_Equals_CDI() {
	assertEquals("CDI", conversion.solution(401));
    }
    
    @Test
    public void _449_Equals_CDXLIX() {
	assertEquals("CDXLIX", conversion.solution(449));
    }
    
    @Test
    public void _600_Equals_DC() {
	assertEquals("DC", conversion.solution(600));
    }
    
    @Test
    public void _759_Equals_DCCLIX() {
	assertEquals("DCCLIX", conversion.solution(759));
    }
    
    @Test
    public void _899_Equals_DCCCXCIX() {
	assertEquals("DCCCXCIX", conversion.solution(899));
    }
    
    @Test
    public void _900_Equals_CM() {
	assertEquals("CM", conversion.solution(900));
    }
    
    @Test
    public void _901_Equals_CMI() {
	assertEquals("CMI", conversion.solution(901));
    }
    
    @Test
    public void _999_Equals_CMXCIX() {
	assertEquals("CMXCIX", conversion.solution(999));
    }
    
    @Test
    public void _1000_Equals_M() {
	assertEquals("M", conversion.solution(1000));
    }
    
    @Test
    public void _1001_Equals_MI() {
	assertEquals("MI", conversion.solution(1001));
    }
    
    @Test
    public void _1666_Equals_MDCLXVI() {
	assertEquals("MDCLXVI", conversion.solution(1666));
    }
    
    @Test
    public void _2004_Equals_MMIV() {
	assertEquals("MMIV", conversion.solution(2004));
    }
    
    @Test
    public void _3000_Equals_MMM() {
	assertEquals("MMM", conversion.solution(3000));
    }
    
    @Test
    public void _3999_Equals_MMMCMXCIX() {
	assertEquals("MMMCMXCIX", conversion.solution(3999));
    }
    




}
