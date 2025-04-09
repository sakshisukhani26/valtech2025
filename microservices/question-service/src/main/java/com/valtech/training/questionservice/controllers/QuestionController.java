package com.valtech.training.questionservice.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.questionservice.entities.Question;
import com.valtech.training.questionservice.services.QuestionService;
import com.valtech.training.questionservice.services.QuizService;
import com.valtech.training.questionservice.vos.QuestionVO;


@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	@GetMapping("/")
	public List<QuestionVO> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/{id}")
	public QuestionVO getQuestion(@PathVariable("id") long id) {
		return questionService.getQuestion(id);
	}
	
	@PostMapping("/")
	public QuestionVO createQuestion(@RequestBody QuestionVO questionVO) {
		return  questionService.saveQuestion(questionVO);
	}
	
	@GetMapping("/topic/{topic}")
	public List<QuestionVO> getQuestionByTopic(@PathVariable("topic") String topic) {
		return questionService.findAllByTopic(topic);
	}
	
//	@PostMapping("/submit")
//	public QuizResult submitQuiz(@RequestParam("quizId") Long quizId,@RequestParam String username,@RequestBody List<String[]> answers) {
//		return quizService.evaluateResult(quizId, username, answers);
//	}
	
//	@PostMapping("/submit")
//	public QuizResult submitQuiz(@RequestParam String username,@RequestBody List<String[]> answers) {
//		return quizService.evaluateResult(username, answers);
//	}
	
	
//	@PostMapping("/submit")
//	public QuizResult submitQuiz(@RequestParam String username,@RequestBody List<String[]> answers) {
//		return quizService.evaluateResult(username, answers);
//	}
	
	@GetMapping("/generate/{topic}/{numOfQues}")
	public List<QuestionVO> generateQuiz(@PathVariable("topic") String topic,@PathVariable("numOfQues") int numOfQues){
		return questionService.getRandomQuiz(topic, numOfQues);
	}
}
