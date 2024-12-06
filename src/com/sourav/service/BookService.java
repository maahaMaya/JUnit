package com.sourav.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sourav.model.Book;

public class BookService {
	
	private List<Book> listOfBooks = new ArrayList<>();
	
	public void addBook(Book book) {
		listOfBooks.add(book);
	}	
	
	public List<Book> books(){
		return Collections.unmodifiableList(listOfBooks);
	}
	
	public Book getBookById(String bookId) {
		for(Book book : listOfBooks) {
			if(bookId.equals(book.getBookId())) {
				return book;
			}
		}
		return null;
	}
	
	public String[] getBookIdsByPublisher(String publisher) {
		List<String> bookIds = new ArrayList<>();
		for(Book book : listOfBooks) {
			if(publisher.equals(book.getPublisher())) {
				bookIds.add(book.getBookId());
			}
		}
		return bookIds.toArray(new String[bookIds.size()]);
	}
}
