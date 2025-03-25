package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Author;
import com.valtech.training.first.repos.AuthorRepo;
import com.valtech.training.first.repos.BookRepo;

@Service
@Transactional(propagation =Propagation.REQUIRED)
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepo authorRepo;
	@Override
	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}
	@Override
	public Long countAllAuthors() {
		return authorRepo.count();
	}

}
