package com.sourav.dynamicTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import javax.print.DocFlavor.INPUT_STREAM;

import org.junit.jupiter.api.DynamicNode;
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
	
	
	@TestFactory
	public Iterator<DynamicTest> dynamicTestFromIterator() {
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
		
		return dynamicTests.iterator();
	}
	
	@TestFactory
	public Stream<DynamicTest> dynamicTestFromStream() {
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
		
		return dynamicTests.stream();
	}
	
	@TestFactory
	public DynamicTest[] dynamicTestFromArray() {
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
		
		return dynamicTests.toArray(new DynamicTest[dynamicTests.size()]);
	}
	
	@TestFactory
	public Stream<DynamicNode> dynamicTestsWithDynamicContainers(){
		return createInputList().stream()
				.map(input -> 
				dynamicContainer("Container for " + input, Stream.of(
						DynamicTest.dynamicTest("not null", () -> assertNotNull(input)),
						dynamicContainer("properties test " + input, Stream.of(
								DynamicTest.dynamicTest("length > 0", () -> assertTrue(input.length() > 0)),
								DynamicTest.dynamicTest("not empty", () -> assertFalse(input.isEmpty()))
						))
				)) 
			);
	}
	
	private List<String> createInputList(){
		return Arrays.asList("race", "mom", "dad");
	}
	
	private List<String> createOutputList(){
		return Arrays.asList("ecar", "mom", "dad");
	}
}
