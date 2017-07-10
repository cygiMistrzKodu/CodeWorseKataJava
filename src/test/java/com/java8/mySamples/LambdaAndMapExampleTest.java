package com.java8.mySamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

import org.junit.Ignore;
import org.junit.Test;

public class LambdaAndMapExampleTest {

	/**
	 * 
	 */
	@Test @Ignore
	public void test() {

		List<String> istOfString = Arrays.asList("lambda", "in", "Practise");

		istOfString.stream().map(s -> s.length()).forEach(number -> System.out.println(number));

		// List<Integer> listOfInteger = map(istOfString,(String s ) => s.length() );

	}

	// this is only for lerning
	@FunctionalInterface
	public interface Function<T, R> {
		R apply(T r);
	}

	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {

		List<R> result = new ArrayList<>();
		for (T s : list) {
			result.add(f.apply(s));
		}
		return result;

	}

	@Test @Ignore
	public void secondAproch() {
		
		List<Integer> listI = map(Arrays.asList("lambda", "in", "Practise"), (String s ) -> s.length());
		
		listI.forEach(i -> System.out.println(i));

	}
	
	public interface intPrdicate {
		boolean test(int i);
	}
	
	@Test
	public void primitiveSpecialization() {
		
		IntPredicate evenNumber = (int i ) ->  i % 2 == 0;
		evenNumber.test(1000);
		
		System.out.println(evenNumber.test(1000));
		

	}

}
