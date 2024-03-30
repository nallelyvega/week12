package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.*;

import java.util.stream.Stream;  
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class TestDemoJUnitTest {
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) 
		{ 
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected); 
			}else {
				assertThatThrownBy(() ->  
				testDemo.addPositive(a, b))
				.isInstanceOf(IllegalArgumentException.class);  
			}
	}
	public static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				Arguments.of(2, 4, 6, false),
				Arguments.of(1, 3, 4, false),
				Arguments.of(2, 8, 10, false),
				Arguments.of(-1, 10, 9, true)
				);
		
	}
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		TestDemo testDemo = new TestDemo();
		
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}
	@Test
	void testCalcArea() {
		TestDemo testDemo = new TestDemo();
		assertThat(testDemo.calcArea(4, 5)).isEqualTo(20);
		assertThat(testDemo.calcArea(3, 3)).isEqualTo(9);
		assertThat(testDemo.calcArea(0, 10)).isEqualTo(0);
	}
	
	@Test
	void assertThatNumberSquaredisCorrect() {
		TestDemo testDemo = new TestDemo();
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
}
