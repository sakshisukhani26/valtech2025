package com.valtech.training.streamingservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.repos.MovieRepo;
import com.valtech.training.streamingservice.vos.MovieVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public MovieVO saveOrUpdateMovie(MovieVO vo) {
		return MovieVO.from(movieRepo.save(vo.to()));
	}
	
	@Override
	public MovieVO getMovie(long id) {
		return MovieVO.from(movieRepo.getReferenceById(id));
	}
	
	@Override
	public List<MovieVO> getAllMovies(){
		return movieRepo.findAll().stream().map(m -> MovieVO.from(m)).collect(Collectors.toList());
	}
	
	@Override
	public List<MovieVO> getMoviesByGenre(String genre){
		return movieRepo.findAllByGenre(genre).stream().map(m -> MovieVO.from(m)).collect(Collectors.toList());
	}
	
	@Override
	public List<MovieVO> getMoviesByGenreAndLanguage(String genre,String language){
		return movieRepo.findAllByGenreAndLanguage(genre,language).stream().map(m -> MovieVO.from(m)).collect(Collectors.toList());
	}
	
	
}
