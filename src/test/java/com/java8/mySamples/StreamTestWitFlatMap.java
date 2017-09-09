package com.java8.mySamples;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTestWitFlatMap {

	@Test
	public void test() {
		
		String [] words = {"Hello","World"};
		
		List<String> words2 = new ArrayList<>();
	    words2.add("Hello");
	    words2.add("World");
	
		
	 List<String>  result =	words2.stream()
		.map(word -> word.split(""))
//		.map(Arrays::stream)
		.flatMap(Arrays::stream)
		.distinct()  
		.collect(Collectors.toList());
		
		System.out.println(result);
		
		
	}

}
