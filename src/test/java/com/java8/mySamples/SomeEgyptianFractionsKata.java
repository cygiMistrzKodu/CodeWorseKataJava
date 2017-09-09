package com.java8.mySamples;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import org.junit.Test;

public class SomeEgyptianFractionsKata {

	@Test
	public void test() {
		
		
//		System.out.println(convertDecimalToFraction(0.00395256916996047));
		
//		System.out.println(convertDecimalToFraction(0.28));
		
		
//		0.00909090909090909
		
//		0.00395256916996047
		
//		int[] numbers = toFractionPos(new BigDecimal("0.0090456"));
//		
//		System.out.println(numbers[0]+"/"+numbers[1]);
		
	   decompose("21", "23");
		
	}
	
	 public static String decompose(String nrStr, String drStr) {
		 
		 BigDecimal numerator = new BigDecimal(nrStr);	      
		 BigDecimal denominator = new BigDecimal(drStr);
		 
		BigDecimal decimalFraction = numerator.divide(denominator,6,RoundingMode.HALF_DOWN);
		
		System.out.println(decimalFraction.toString());
		
		
		 
		 return null;
	  }
	 
	 
	 
	 static int[] toFractionPos(BigDecimal x) {
		 
	        String[] parts = x.toString().split("\\.");
	        
	        System.out.println(parts[1].length());
	        
	        BigDecimal denominator = BigDecimal.TEN.pow(parts[1].length()); 
	        
	        System.out.println("denominator: "+denominator);
//	        BigDecimal denominator = BigDecimal.TEN.pow(1); 
	        BigDecimal numerator = (new BigDecimal(parts[0]).multiply(denominator)).add(new BigDecimal(parts[1])); 
	        
	        System.out.println("numerator: "+numerator);
	        
	        return reduceFraction(numerator.intValue(), denominator.intValue());
	    }

	    static int[] reduceFraction(int numerator, int denominator) {
	    	
	    	System.out.println("numerator: "+numerator +" denominator "+ denominator);
	    	
	        int gratestCommonDivisior = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator)).intValue(); 
	        
	        System.out.println("Gratest commond divisor: "+ gratestCommonDivisior);
	                                                                                  
	        int[] rf = { numerator / gratestCommonDivisior, denominator / gratestCommonDivisior };
	        return rf;
	    }
	    
	    
	    
	    
	    static private String convertDecimalToFraction(double x){
		    if (x < 0){
		        return "-" + convertDecimalToFraction(-x);
		    }
		    double tolerance = 1.0E-6;
		    double h1=1; 
		    double h2=0;
		    
		    double k1=0;
		    double k2=1;
		    double b = x;
		    do {
		        double a = Math.floor(b);
		        System.out.println("a = Math.floor(b) : "+ a);
		        double aux = h1;
		        System.out.println("aux = h1 : "+ aux);
		        h1 = a*h1+h2;
		        System.out.println("h1 = a*h1+h2 : "+ h1);
		        h2 = aux;
		        System.out.println("h2 = aux: "+ h2);
		        aux = k1; 
		        System.out.println("aux = k1: "+ aux);
		        k1 = a*k1+k2; 
		        System.out.println("k1 = a*k1+k2: "+ k1);
		        k2 = aux;
		        System.out.println("k2 = aux: "+ k2);
		        b = 1/(b-a);
		        System.out.println("b = 1/(b-a): "+ b);
		        System.out.println("------------------------------------------------");
		        System.out.println("Math.abs(x-h1/k1: "+ Math.abs(x-h1/k1));
		        System.out.println("x*tolerance: "+ x*tolerance);
		        System.out.println("------------------------------------------------");
		    } while (Math.abs(x-h1/k1) > x*tolerance);

		    return (int)h1+"/"+(int)k1;
		}
	    
	    

}
