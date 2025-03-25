package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.dtos.BookInfoDTO;

public interface BookService {

	List<Book> getAllBooks();

	Long countAllBooks();

	List<Book> getBooksByYearBetween(int i, int j);

	List<Book> getBooksByPriceGreaterThan(int i);
	
	List<Integer> findAllPriceByAuthorId(int i);
	
	List<BookInfoDTO> getBookInfoByAuthor(long id);
}
