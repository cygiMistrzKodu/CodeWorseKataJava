package com.java8.mySamples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;

public class StreamTests {

	@Test
	@Ignore
	public void test() {

		int[] exampleTest1 = { 2, 6, 8, -10, 3 };
		int[] exampleTest2 = { 206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781 };

		// List<Integer> evenNumbers = IntStream.of(exampleTest2).filter(number ->
		// number%2==0)
		// .boxed()
		// .collect(Collectors.toList());
		//

		List<Integer> evenNumbers = returnListBaseOnLambda(exampleTest1, number -> number % 2 == 0);

		evenNumbers.forEach(System.out::println);

		System.out.println("-------------------------------------------------------");

		// List<Integer> oddNumbers = IntStream.of(exampleTest2).filter(number ->
		// number%2==1)
		// .boxed()
		// .collect(Collectors.toList());

		List<Integer> oddNumbers = returnListBaseOnLambda(exampleTest1, number -> number % 2 == 1);

		oddNumbers.forEach(System.out::println);

		int value = (evenNumbers.size() == 1) ? evenNumbers.get(0) : oddNumbers.get(0);

		System.out.println("Number is : " + value);

	}

	List<Integer> returnListBaseOnLambda(int[] integersSequence, IntPredicate prdicate) {

		return IntStream.of(integersSequence).filter(prdicate).boxed().collect(Collectors.toList());

	}

	@Test
	@Ignore
	public void test2() {

		List<Integer> evenNumbers = new ArrayList<>();

		// evenNumbers.add(e)

	}

	@Test
	@Ignore
	public void thisIsFromCodeWars() {

		// import java.util.ArrayList;
		// import java.util.List;
		//
		// public class FindOutlier{
		// static int find(int[] integers){
		//
		//
		// List<Integer> evenNumbers = new ArrayList<>();
		// List<Integer> oddNumbers = new ArrayList<>();
		//
		// for (int number : integers ) {
		// if (number%2==0) {
		// evenNumbers.add(number);
		// }
		// else {
		// oddNumbers.add(number);
		// }
		//
		// }
		//
		// return (evenNumbers.size() == 1) ? evenNumbers.get(0) : oddNumbers.get(0) ;
		//
		// }
		// }

	}
	
	@Test
	public void hashSetTest() {
		
//	  Set<lalaObiekty> lal = new HashSet<>();
//	  clasHashsetOne hashsetOne = new clasHashsetOne();
//	  clasHashsetTwo hashsetTwo = new clasHashsetTwo();
//	  
//	  lal.add(hashsetOne);
//	  lal.add(hashsetTwo);
//	  
//	  lal.forEach(i -> System.out.println(i));
//	  
//	  System.out.println(lal);
//	  System.out.println(lal.remove(hashsetOne));
//	  System.out.println(lal);
	  
	  
	  clasHashsetOne hashsetOne = new clasHashsetOne();
	  clasHashsetOne hashsetOne2 = new clasHashsetOne();
	  clasHashsetOne hashsetOne3 = new clasHashsetOne();
	  
	  Set<clasHashsetOne>  lala2Conreet = new HashSet<>();
	  
	  lala2Conreet.add(hashsetOne);
	  
	  hashsetOne2.lalaPole1 = "11134";
	  hashsetOne3.lalaPole1 = "89766234234";
	  lala2Conreet.add(hashsetOne2);
	  lala2Conreet.add(hashsetOne3);

	   
	  
	  
	  lala2Conreet.forEach(i -> System.out.println(i.lalaPole1));
	  
//	  lala2Conreet.remove(hashsetOne);
	  
//	  System.out.println(lala2Conreet);
//	  System.out.println(lala2Conreet.remove(hashsetOne));
//	  System.out.println(lala2Conreet);
	  
	  
	  lala2Conreet.forEach(i -> System.out.println(i.lalaPole1));
		

	}

	private class clasHashsetOne implements lalaObiekty {
		
		 String lalaPole1 = "1";
		 
		 

		@Override
		public int hashCode() {
			
//			return lalaPole1.length();
			return 1;
		}



		@Override
		public boolean equals(Object obj) {
			System.out.println("Wowa³em methode Equals TO pewnie haschcode jest taki sam ");
			return super.equals(obj);
		}
		
		
		
		

	}

	private class clasHashsetTwo implements lalaObiekty {
		
		 String lalaPole3 = "2";

		@Override
		public int hashCode() {
			
			return 1;
		}
		

	}
	
	interface lalaObiekty { 
		
	}
	
	

}