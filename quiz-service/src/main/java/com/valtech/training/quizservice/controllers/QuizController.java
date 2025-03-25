package com.valtech.training.quizservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.quizservice.services.QuestionClient;
import com.valtech.training.quizservice.services.QuizService;
import com.valtech.training.quizservice.vos.QuestionVO;
import com.valtech.training.quizservice.vos.QuizVO;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuestionClient questionClient;
	
	@GetMapping("/generate")
	public List<QuestionVO> generateQuiz(@RequestParam("topic") String topic,@RequestParam("numOfQues") int numOfQues){
		return questionClient.findRandomQuestionsByTopic(topic, numOfQues);
	}
	
	@PostMapping("/")
	public QuizVO createQuiz(@RequestBody QuizVO quizVO) {
		return quizService.saveOrUpdateQuiz(quizVO); 
	}
}
