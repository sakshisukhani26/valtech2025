package webservices;

import java.util.List;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

public class MovieServiceClient {

	public static void main(String[] args) {
		ClientProxyFactoryBean client = new ClientProxyFactoryBean();
		client.setAddress("http://localhost:7777/MovieService");
		MovieService ms = client.create(MovieService.class);
		System.out.println(ms.getAllMovies());
		System.out.println(ms.getMovies(1));
		System.out.println(ms.getMovies(5));
		ms.addMovie(new Movie(6,"Day and Knight","English","Action",List.of("Tom Cruise","Cameron Diaz")));
		System.out.println(ms.getAllMovies());
	}
}
