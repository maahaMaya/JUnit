package com.sourav.dynamicTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import com.sourav.example.StringHelper;

public class DynamicTestDemo {
	
	StringHelper stringHelper = new StringHelper();
	
	@TestFactory
	public DynamicTest testReverse() {
		return DynamicTest.dynamicTest("Dynamic Test method for reverse method", () -> {
			assertEquals("god", stringHelper.reverse("dog"));
		});
	}
	
	@TestFactory
	public Collection<DynamicTest> dynamicTestFromCollection() {
		List<String> inputList = createInputList();
		List<String> outputList = createOutputList();
		
		Collection<DynamicTest> dynamicTests = new ArrayList<DynamicTest>();
		
		for(int i = 0; i < inputList.size(); i++) {
			String input = inputList.get(i);
			String output = outputList.get(i);
			
			DynamicTest dynamicTest =  DynamicTest.dynamicTest("Dynamic Test method for reverse() : input", () -> {
				assertEquals(output, stringHelper.reverse(input));
			});
			dynamicTests.add(dynamicTest);
		}
		
		return dynamicTests;
	}
	
	private List<String> createInputList(){
		return Arrays.asList("race", "mom", "dad");
	}
	
	private List<String> createOutputList(){
		return Arrays.asList("ecar", "mom", "dad");
	}
}
