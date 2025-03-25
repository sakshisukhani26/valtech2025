package com.valtech.training.questionservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.valtech.training.questionservice.services.QuestionService;
import com.valtech.training.questionservice.vos.QuestionVO;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuestionServiceApplicationTests {
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	void testapis() {
		String url = "http://localhost:"+port+"/api/v1/questions/";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		System.out.println("Raw response "+response.getBody());
		assertNotNull(response.getBody());
	}
	@Test
	void testAddQuestions() {
		String url = "http://localhost:"+port+"/api/v1/questions/";
		List question = restTemplate.getForObject(url,List.class);
		if(question.size()==0) {
			System.out.println("Creating questions");
			QuestionVO q = restTemplate.postForObject(url
					, new QuestionVO(0, "What is the color of Sky?","Red","Green","Blue","white","Blue","GK"), QuestionVO.class);
			QuestionVO q1 = restTemplate.postForObject(url
					, new QuestionVO(0, "What is the color of Moon?","Red","Green","Blue","white","white","GK"), QuestionVO.class);
			QuestionVO q2 = restTemplate.postForObject(url
					, new QuestionVO(0, "What is the color of Mars?","Red","Green","Blue","white","Red","GK"), QuestionVO.class);
			QuestionVO q3 = restTemplate.postForObject(url
					, new QuestionVO(0, "What is the color of Jupiter?","Red","Green","Blue","white","Yellow","GK"), QuestionVO.class);
			QuestionVO q4 = restTemplate.postForObject(url
					, new QuestionVO(0, "What is the color of Saturn?","Red","Green","Blue","white","Blue","GK"), QuestionVO.class);
			QuestionVO q5 = restTemplate.postForObject(url
					, new QuestionVO(0, "What is the color of Venus?","Red","Green","Blue","white","white","GK"), QuestionVO.class);
			
			QuestionVO q6 = restTemplate.postForObject(url
					, new QuestionVO(0, "What is the super class of Exceptions?","Object","Exception","Throwable","Error","Throwable","Java"), QuestionVO.class);
			QuestionVO q7 = restTemplate.postForObject(url
					, new QuestionVO(0, "What is the class is used to create dynamic string?","string","dynamic string","String builder","builder","String builder","Java"), QuestionVO.class);
			QuestionVO q8 = restTemplate.postForObject(url
					, new QuestionVO(0, "How many methods are there in Marker Interface?","None","One","Two","Many","None","Java"), QuestionVO.class);
			QuestionVO q9 = restTemplate.postForObject(url
					, new QuestionVO(0, "How many methods are there in Functional Interface?","None","One","Two","Many","One","Java"), QuestionVO.class);
			QuestionVO q10 = restTemplate.postForObject(url
					, new QuestionVO(0, "Can an Interface have private methods?","Yes","No","Maybe","No methods can be there in an interface","Yes","Java"), QuestionVO.class);
			QuestionVO q11 = restTemplate.postForObject(url
					, new QuestionVO(0, "Which subclass of Exception is not checked by the compiler?","Exception","Error","RuntimeException","None","RuntimeException","Java"), QuestionVO.class);
			
		}
	}
//	@Test
//	void quizServiceTest() {
//			System.out.println(" REsultSet : "+questionService.getRandomQuiz("Java", 3)); 
//	}

}
