package com.valtech.training.streamingservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.streamingservice.entities.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long>{

	public List<Movie> findAllByGenre(String genre);
	public List<Movie> findAllByGenreAndLanguage(String genre,String language);
}
