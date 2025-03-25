package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Author;
import com.valtech.training.first.entities.Book;

public interface AuthorService {

	List<Author> getAllAuthors();

	Long countAllAuthors();
}
