package com.valtech.training.quizservice.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.quizservice.entities.Quiz;
import com.valtech.training.quizservice.repos.QuizRepo;
import com.valtech.training.quizservice.vos.QuestionVO;
import com.valtech.training.quizservice.vos.QuizVO;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Override
	public QuizVO saveOrUpdateQuiz(QuizVO vo){
		Quiz quiz = vo.to();
//		String topic = quiz.getTopic();
//		String username = quiz.getUser();
//		quiz.setTopic(topic);
//		quiz.setUser(username);
		quiz = quizRepo.save(quiz);
		return QuizVO.from(quiz);
	}
//	@Autowired
////	private QuestionRepo questionRepo;
//	
//	@Override
//	public List<QuestionVO> getRandomQuiz(String topic,int numOfQues){
//		List<QuestionVO> questions = questionRepo.findRandomQuestionsByTopic(topic, numOfQues).stream().map(q -> QuestionVO.from(q)).collect(Collectors.toList());
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
