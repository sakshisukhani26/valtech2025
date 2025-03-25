package com.valtech.training.jaxwsclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.jaxws.HelloWorld;
import com.valtech.training.jaxws.Movie;
import com.valtech.training.jaxws.webservices.MovieServiceWS;

@SpringBootTest
class JaxwsclientApplicationTests {

	@Autowired
	private MovieServiceWS movieServiceWS;
	@Autowired
	private HelloWorld helloWorld;
	
	@Test
	void contextLoads() {
		System.out.println(helloWorld.hello("Jax ws"));
		movieServiceWS.createMovie(new Movie("Zindagi na milegi dobara","Drama","Hindi",List.of("Hrithik Roshan","Farhan Akhtar","Abhay Deol")));
		movieServiceWS.createMovie(new Movie("Shershah","Action","Hindi",List.of("Sidharth Malhotra","Kiara Advani")));
		System.out.println(movieServiceWS.getAllMovies());
		
	}

}
