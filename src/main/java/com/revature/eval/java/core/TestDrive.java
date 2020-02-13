package com.revature.eval.java.core;



public class TestDrive {
	public static void main(String[] args) {
		
		String string = "1 4539 1488 0343 6467";
		string = string.replaceAll("[^0-9]", "");
		String[] strArray = string.split("");
		Integer[] intArray = new Integer[strArray.length];
		for (int i =0; i < strArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		
		for (int i = 1; i < intArray.length;i = i +2) {
			intArray[i] = (intArray[i]) * 2;
			
			if(intArray[i] > 9 ) {
				intArray[i] = intArray[i] - 9;
			}
			}
		for (int i = 0; i < intArray.length;i++) { 
		System.out.println(intArray[i]);
	}
}
}
