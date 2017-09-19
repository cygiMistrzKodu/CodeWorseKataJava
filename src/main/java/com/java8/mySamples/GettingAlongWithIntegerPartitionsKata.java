package com.java8.mySamples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GettingAlongWithIntegerPartitionsKata {

    public static String part(long n) {

	List<List<Long>> partitionsOfIntegerNumber = getAllUniquePartitons(n);

	List<Long> productOfPartitionDistinct = partitionsOfIntegerNumber.stream()
		.map(p -> productOfPartiton(p))
		.distinct()
		.sorted()
		.collect(Collectors.toList());
	
	Long range =  calculateRange(productOfPartitionDistinct);
	Double average = calculateAverage(productOfPartitionDistinct);

	System.out.println(productOfPartitionDistinct);
	System.out.println(range);
	System.out.println(average);

	return null;
    }
    
    private static Long calculateRange(List<Long> productList) {

	return productList.get(productList.size()-1) - productList.get(0);
    }
    
    private static Double calculateAverage(List<Long> productList) {

   	return productList.stream().mapToDouble(p -> p).average().orElse(0);
       }

    private static Long productOfPartiton(List<Long> parition) {

	return parition.stream().mapToLong(l -> l).reduce(1, (a, b) -> a * b);
    }

    private static List<List<Long>> getAllUniquePartitons(long n) {

	long[] partition = new long[(int) n];
	int indexOflastElementInPartition = 0;
	partition[indexOflastElementInPartition] = n;

	List<List<Long>> uniqueIntegersPartitions = new ArrayList<>();

	while (true) {

	    List<Long> currentParition = new ArrayList<>();
	    for (int i = 0; i < indexOflastElementInPartition + 1; i++) {
		currentParition.add(partition[i]);
	    }
	    uniqueIntegersPartitions.add(currentParition);

	    int rem_val = 0;
	    while (indexOflastElementInPartition >= 0 && partition[indexOflastElementInPartition] == 1) {

		rem_val += partition[indexOflastElementInPartition];
		indexOflastElementInPartition--;
	    }

	    if (indexOflastElementInPartition < 0)
		return uniqueIntegersPartitions;

	    partition[indexOflastElementInPartition]--;
	    rem_val++;

	    while (rem_val > partition[indexOflastElementInPartition]) {
		partition[indexOflastElementInPartition + 1] = partition[indexOflastElementInPartition];
		rem_val = (int) (rem_val - partition[indexOflastElementInPartition]);
		indexOflastElementInPartition++;
	    }

	    partition[indexOflastElementInPartition + 1] = rem_val;
	    indexOflastElementInPartition++;
	}
    }

}
