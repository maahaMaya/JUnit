package com.sourav.assertions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.sourav.model.Book;
import com.sourav.service.BookService;

public class AssertArraysEqualsDemo {
	
	@Test
	public void assertArrayEqualsWithNoMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "Wrox");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		bookService.addBook(headFirstJavascriptBook);
		
		String[] actualBookIds = bookService.getBookIdsByPublisher("Wrox");
		
		assertArrayEquals(new String[] {"1", "3"}, actualBookIds);
	}
	
	@Test
	public void assertArrayEqualsWithMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "Wrox");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		bookService.addBook(headFirstJavascriptBook);
		
		String[] actualBookIds = bookService.getBookIdsByPublisher("Wrox");
		
		assertArrayEquals(new String[] {"1", "3"}, actualBookIds, "bookIds didnt match !");
	}
	
	@Test
	public void assertArrayEqualsWithMessageSupplier() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "Wrox");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		bookService.addBook(headFirstJavascriptBook);
		
		String[] actualBookIds = bookService.getBookIdsByPublisher("Wrox");
		
		assertArrayEquals(new String[] {"1", "3"}, actualBookIds, () -> "bookIds didnt match !");
	}
}
