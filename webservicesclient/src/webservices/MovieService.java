package webservices;

import java.util.List;

public interface MovieService {

	List<Movie> getAllMovies();

	Movie getMovies(int id);

	void addMovie(Movie m);

	void removeMovie(Movie m);

}