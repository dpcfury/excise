package com.dpc.test;


import junit.framework.TestCase;

import org.junit.Test;

import com.dpc.prime.PrimeNumCheck;

//PrimeNum测试用例
public class TestPrimeNum extends TestCase {
	
	private PrimeNumCheck primeCheck=new PrimeNumCheck();
	
	@Test
	public void testIsRangeEgeal(){
		
		assertTrue(primeCheck.isRangeEgeal(20));
	}
	
	@Test
	public void testIsPrime(){
		assertTrue(primeCheck.isPrime(13));
		
	}
	
}
