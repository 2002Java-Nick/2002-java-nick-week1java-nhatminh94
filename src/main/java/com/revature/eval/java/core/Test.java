package com.revature.eval.java.core;

public class Test {
	public int calculateNthPrime(int i) {
		int primeNumber = 1;
		int count = 0;
		int numb;
		while (count < i) {
			primeNumber++;
			for( numb=2; numb <= primeNumber; numb++) {
			if (primeNumber % numb == 0) {
				break;
			}
			}
			if ( numb == primeNumber) {
				count++;
			}
		}
		return primeNumber;
	}
}
	