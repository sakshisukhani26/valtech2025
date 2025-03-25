package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.services.MovieService;
import com.valtech.training.streamingservice.vos.MovieVO;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping("/")
	public MovieVO createMovie(@RequestBody MovieVO vo) {
		return movieService.saveOrUpdateMovie(vo);
	}
	
	@GetMapping("/{id}")
	public MovieVO findMovieById(@PathVariable long id) {
		return movieService.getMovie(id);
	}
	
	@GetMapping("/")
	public List<MovieVO> findAllMovies(){
		return movieService.getAllMovies();
	}
	
	@GetMapping("/{genre}")
	public List<MovieVO> findAllMoviesByGenre(@PathVariable String genre){
		return movieService.getMoviesByGenre(genre);
	}
	
	@GetMapping("/{genre}/{language}")
	public List<MovieVO> findAllMoviesByGenreAndLanguage(@PathVariable String genre,@PathVariable String language){
		return movieService.getMoviesByGenreAndLanguage(genre, language);
	}
}
