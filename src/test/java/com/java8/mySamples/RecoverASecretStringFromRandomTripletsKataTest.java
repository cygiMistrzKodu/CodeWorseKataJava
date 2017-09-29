package com.java8.mySamples;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class RecoverASecretStringFromRandomTripletsKataTest {

    char[][] triplets = { 
	    { 't', 'u', 'p' }, 
	    { 'w', 'h', 'i' },
	    { 't', 's', 'u' },
	    { 'a', 't', 's' },
	    { 'h', 'a', 'p' },
	    { 't', 'i', 's' },
	    { 'w', 'h', 's' } };
    
    
    
    char[][] triplets2 = { 
	    { 't', 's', 'f' }, 
	    { 'm', 'a', 'f' },
	    { 'a', 'i', 'n' },
	    { 's', 'u', 'n' },
	    { 'm', 'f', 'u' } ,
	    { 'a', 't', 'h' } ,
	    { 't', 'h', 'i' } ,
	    { 'h', 'i', 'f' } ,
	    { 'm', 'h', 'f' } ,
	    { 'm', 'a', 't' } ,
	    { 'a', 'u', 'n' } ,
	    { 'f', 'u', 'n' } ,
	    { 'h', 's', 'n' } ,
	    { 'a', 'i', 's' } ,
	    { 'm', 's', 'n' } ,
	    { 'm', 's', 'u' } , };
        
    
    @Test @Ignore
    public void test() {

	// System.out.println(Arrays.toString(triplets));

	List<char[]> test2 = Arrays.asList(triplets);
	for (char[] cs : test2) {

	    System.out.println(Arrays.toString(cs));

	}

    }
    
    
    @Test
    public void test2() {
	
	RecoverASecretStringFromRandomTripletsKata aSecretStringFromRandomTripletsKata  = new RecoverASecretStringFromRandomTripletsKata();
	
	String tmp = aSecretStringFromRandomTripletsKata.recoverSecret(triplets);
//	String tmp = aSecretStringFromRandomTripletsKata.recoverSecret(triplets2);
	
	System.out.println(tmp);
	
    }

}
