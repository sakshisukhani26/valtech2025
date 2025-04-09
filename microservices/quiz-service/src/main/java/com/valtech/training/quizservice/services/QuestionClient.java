package com.valtech.training.quizservice.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.quizservice.vos.QuestionVO;



@Component
public class QuestionClient {
	
	RestTemplate temp = new RestTemplate();
	
	public List<QuestionVO> findRandomQuestionsByTopic(String topic,int numOfQues) {
		
		String url = "http://localhost:9020/api/v1/questions/generate/" + topic+"/"+numOfQues;
		System.out.println("url-------"+url);
		List<QuestionVO> ques = Arrays.asList(temp.getForObject(url, QuestionVO[].class));
//		System.out.println("Question"+ques);
		return ques;
	}
	
	public QuestionVO findQuestionById(long id) {
		String url = "http://localhost:9020/api/v1/questions/"+id;
		System.out.println("Id url-------"+url);
		QuestionVO ques = temp.getForObject(url, QuestionVO.class);
		System.out.println("Question"+ques);
		return ques;
	}
}
