package com.sourav.assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.sourav.exception.BookNotFoundException;
import com.sourav.model.Book;
import com.sourav.service.BookService;

public class AssertThrowsDemo {

	@Test
	public void assertThrowsWithNoMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		
		BookNotFoundException bookNotFoundException = assertThrows(BookNotFoundException.class, 
				() -> bookService.getBookByTitle("Head First Spring"));
		
		assertEquals ("Book not found in Bookstore!", bookNotFoundException.getMessage());
	}
	
	@Test
	public void assertThrowsWithMessage() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		
		assertThrows(BookNotFoundException.class,
				() -> bookService.getBookByTitle("Head First Spring"),
				"Different exception thrown!");
		
	}
	
	@Test
	public void assertThrowsWithMessageSupplier() {
		BookService bookService = new BookService();
		
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		
		assertThrows(BookNotFoundException.class,
				() -> bookService.getBookByTitle("Head First Spring"),
				() -> "Different exception thrown!");
		
	}
	
}