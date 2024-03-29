package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	
// First Method to add positive numbers	
	public int addPositive(int a, int b) {
		
		if( a > 0 && b > 0) {
			return a + b;
			
		}
		
		throw new IllegalArgumentException("Both parameters must be positive!");
		
	}

// Second method to subtract positive numbers	
	 public int subtractPositive(int a, int b) {
		 
		if( a > 0 && b > 0) {
			return a - b;
	  }
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
	
	 
//method obtains a random int between 1 and 10 and then returns the square of the number.	 

	public int randomNumberSquared() {
		int random = getRandomInt();
		return random * random;
			
		}
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	
	}
	
	

}
