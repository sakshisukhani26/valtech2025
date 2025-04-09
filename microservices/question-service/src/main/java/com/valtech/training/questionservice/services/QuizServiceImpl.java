package com.valtech.training.questionservice.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.questionservice.entities.Question;
import com.valtech.training.questionservice.repos.QuestionRepo;

@Service
@Transactional(propagation =Propagation.REQUIRED)
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuestionRepo questionRepo;
	private List<Question> currentQues;
	
//	@Override
//	public List<Question> getRandomQuiz(String topic,int numOfQues){
//		List<Question> questions = questionRepo.findRandomQuestionsByTopic(topic, numOfQues);
//		Collections.shuffle(questions);
////		currentQues = questions;
//		return questions;
//	}
	
//	public boolean validateAnswers(List<String[]> actualAns) {
//		if(currentQues == null || currentQues.isEmpty()) {
//			return false;
//		}
//		List<Long> quesId = currentQues.stream().map(Question::getId).toList();
//		for(String[] result:actualAns) {
//			Long questionId = Long.parseLong(result[0]);
//			if(!quesId.contains(questionId)) {
//				return false;
//			}
//		}
//		return true;
//	}
	
//	@Override
//	public QuizResult evaluateResult(Long quizId,String username,List<String[]> answers) {
//		int score = 0;
//		List<Question> questions = new ArrayList<>();
//		List<String> actualAnswers = new ArrayList<>();
//		
//		for(String[] result : answers) {
//			Long questionId = Long.parseLong(result[0]);
//			String actualAnswer = result[1];
//			
//			Question question = questionRepo.findById(questionId).orElse(null);
//			if(question == null) continue;
//			
//			if(question.getCorrectOption().equalsIgnoreCase(actualAnswer)) {
//				score++;
//			}
//			questions.add(question);
//			actualAnswers.add(actualAnswer);
//		}
//		return new QuizResult(username,score,questions,actualAnswers);
//	}
	
	
//	@Override
//	public QuizResult evaluateResult(String username,List<String[]> answers) {
//		int score = 0;
//		List<Question> questions = new ArrayList<>();
//		List<String> actualAnswers = new ArrayList<>();
//		
//		for(String[] result : answers) {
//			Long questionId = Long.valueOf(result[0]);
//			String actualAnswer = result[1];
//			
//			Question question = questionRepo.findById(questionId).orElse(null);
//			if(question == null) continue;
//			
//			if(question.getCorrectOption().equalsIgnoreCase(actualAnswer)) {
//				score++;
//			}
//			questions.add(question);
//			actualAnswers.add(actualAnswer);
//		}
//		return new QuizResult(username,score,questions,actualAnswers);
//	}
}
