package com.revature.eval.java.core;

import java.util.HashMap;
import java.util.Map;

public class TestDrive {
	public static void main(String[] args) {
		
		String string = "one,\\ntwo,\\nthree";
		String[] stringArray = string.split("[, ]+");
		for (int i =0; i < stringArray.length;i++) {
			System.out.println(stringArray[i]);
		}
		
		
	}
}
