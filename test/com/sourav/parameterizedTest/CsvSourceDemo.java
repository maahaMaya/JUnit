package com.sourav.parameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.sourav.example.StringHelper;


public class CsvSourceDemo {

	@ParameterizedTest
	@CsvSource({
		"car, rac",
		"test, tset"
	})
	public void csvSourceDemoTest(String input, String expect) {
		StringHelper stringHelper = new StringHelper();
		assertEquals(expect, stringHelper.reverse(input));
	}
	
	@ParameterizedTest
	@CsvSource({
		"car, 'my, car'",
		"car, ''",
		"book, "
	})
	public void csvSourceDemoWithSingleQuotes(String first, String second) {
		assertNotNull(first);
		assertNotNull(second);
	}
	
	@ParameterizedTest
	@CsvSource({
		"One, Two"
	})
	public void csvSourceDemoWithIntegers(String first, Integer second) {
		assertNotNull(first);
		assertNotNull(second);
	}
	
}
