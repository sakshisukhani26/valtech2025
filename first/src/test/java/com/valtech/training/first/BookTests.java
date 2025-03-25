package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.first.services.AuthorService;
import com.valtech.training.first.services.BookService;
import com.valtech.training.first.services.PublisherService;

@SpringBootTest
class BookTests {
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private PublisherService publisherService;
	@Test
	void bookService() {
		
		assertEquals(6, bookservice.getAllBooks().size());
		assertEquals(3, publisherService.getAllPublishers().size());
		assertEquals(6, authorService.getAllAuthors().size());
		assertEquals(5, bookservice.getBooksByYearBetween(2000,2006).size());
		assertEquals(3, bookservice.getBooksByPriceGreaterThan(100).size());
		assertEquals(2, bookservice.findAllPriceByAuthorId(1).size());
		System.out.println(bookservice.findAllPriceByAuthorId(1));
		System.err.println(bookservice.getBookInfoByAuthor(2));
	}
}
