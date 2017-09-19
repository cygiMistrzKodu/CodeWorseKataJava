package com.java8.mySamples;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class GettingAlongWithIntegerPartitionsKataTest {

	@Test @Ignore
	public void test() {

		assertEquals("Range: 1 Average: 1.50 Median: 1.50", GettingAlongWithIntegerPartitionsKata.part(2));

	}
	
	@Test
	public void generateUniquePartionsOfNumberTest() {
		
//		generateUniquePartition(4);
		
//		printAllUniqueParts(4);
		printAllUniqueParts(8);
		
	}	
   
    
    static void printArray(int p[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(p[i]+" ");
        System.out.println();
    }
    
    
    // Function to generate all unique partitions of an integer
    static void printAllUniqueParts(int n)
    {
        int[] partition = new int[n]; // An array to store a partition
        int indexOflastElementInPartition = 0;  // Index of last element in a partition
        partition[indexOflastElementInPartition] = n;  // Initialize first partition as number itself
  
        // This loop first prints current partition, then generates next
        // partition. The loop stops when the current partition has all 1s
        while (true)
        {
            // print current partition
            printArray(partition, indexOflastElementInPartition+1);
  
            // Generate next partition
  
            // Find the rightmost non-one value in p[]. Also, update the
            // rem_val so that we know how much value can be accommodated
            int rem_val = 0;
            while (indexOflastElementInPartition >= 0 && partition[indexOflastElementInPartition] == 1)
            {
                rem_val += partition[indexOflastElementInPartition];
                indexOflastElementInPartition--;
            }
  
            // if k < 0, all the values are 1 so there are no more partitions
            if (indexOflastElementInPartition < 0)  return;
  
            // Decrease the p[k] found above and adjust the rem_val
            partition[indexOflastElementInPartition]--;
            rem_val++;
  
  
            // If rem_val is more, then the sorted order is violeted.  Divide
            // rem_val in differnt values of size p[k] and copy these values at
            // different positions after p[k]
            while (rem_val > partition[indexOflastElementInPartition])
            {
                partition[indexOflastElementInPartition+1] = partition[indexOflastElementInPartition];
                rem_val = rem_val - partition[indexOflastElementInPartition];
                indexOflastElementInPartition++;
            }
  
            // Copy rem_val to next position and increment position
            partition[indexOflastElementInPartition+1] = rem_val;
            indexOflastElementInPartition++;
        }
    }
    
    
   

}
