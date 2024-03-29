package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class TestDemoJUnitTest {
	
//private instance variable of type TestDemo named testDemo.  Remember that instance variables are non-static variables which are defined in a class, but outside of any method, constructor or a block. 	
	private TestDemo testDemo;
	
	
	
//TestDemo object will ensure that a new TestDemo object is created before each test. 
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
		
		
		
	}

// First test for 1st method to make sure the value returns correct		
@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(()->testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
			
		}
	}

//arguments lines to test the addPositive method . False for arguments that will not trigger an exception and true for arguments that will trigger an exception. exceptions will be triggered with anything less than 1. 

	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(1, 1, 2, false),
				arguments(0, 0, 0, true),
				arguments(-4, 3, -1, true),
				arguments(2, -4, -2, true)
				);		
	}
//test that the value returned from addPositive is equal to the correct value.
	@Test
		void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(2, 4)).isEqualTo(6);
		assertThat(testDemo.addPositive(1, 1)).isEqualTo(2);
		assertThat(testDemo.addPositive(3, 3)).isEqualTo(6);
		assertThat(testDemo.addPositive(10, 5)).isEqualTo(15);
		
		
	}
	
// second test for 2nd method to make sure the value returns correct		
    @ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForSubtractPositive")
	void assertThatTwoPositiveNumbersAreSubtractedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.subtractPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(()->testDemo.subtractPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
		}
		}
	
  ////arguments lines to test the subtractPositive method . False for arguments that will not trigger an exception and true for arguments that will trigger an exception. exceptions will be triggered with results that are anything less than 1.   
	static Stream<Arguments> argumentsForSubtractPositive(){
		return Stream.of(
				arguments(4, 2, 2, false),
				arguments(5, 1, 4, false),
				arguments(0, 0, 0, true),
				arguments(-4, 3, -7, true),
				arguments(-7, -4, -3, true)
				);	
	}
		
// test to make sure the numbers are subtracted correctly.	
	@Test
		void assertThatPairsOfPositiveNumbersAreSubtractedCorrectly() {
		assertThat(testDemo.subtractPositive(5, 3)).isEqualTo(2);
		assertThat(testDemo.subtractPositive(10, 5)).isEqualTo(5);
	}
	
// test to make sure the numbers are squared correctly (mock since number is at random)
	@Test
		void assertThatNumberSquaredIsCorrect() {
		
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		
		
	}
	
	
	
}
