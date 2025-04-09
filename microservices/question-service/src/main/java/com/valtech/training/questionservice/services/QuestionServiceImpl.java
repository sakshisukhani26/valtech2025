package com.valtech.training.questionservice.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.valtech.training.questionservice.entities.Question;
import com.valtech.training.questionservice.repos.QuestionRepo;
import com.valtech.training.questionservice.vos.QuestionVO;

@Service
@Transactional(propagation =Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public QuestionVO saveQuestion(QuestionVO question) {
		System.out.println("Question Repo Class = "+questionRepo.getClass().getName());
		Question ques = question.to();
		questionRepo.save(ques);
		return QuestionVO.from(ques);
	}
	
//	@Override
//	public QuestionVO updateQuestion(QuestionVO question) {
//		return questionRepo.save(question);
//	}
	
	@Override
	public void deleteQuestion(QuestionVO question) {
		questionRepo.delete(question.to());
	}
	
	@Override
	public QuestionVO getQuestion(long id) {
		return QuestionVO.from(questionRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuestionVO> getAllQuestions(){
		return questionRepo.findAll().stream().map(l -> QuestionVO.from(l)).collect(Collectors.toList());
	}
	

	@Override
	public List<QuestionVO> findAllByTopic(String topic) {
		List<QuestionVO> questions = questionRepo.findAllByTopic(topic).stream().map(q -> QuestionVO.from(q)).collect(Collectors.toList());
		return questions;
	}
	
	@Override
	public List<QuestionVO> getRandomQuiz(String topic,int numOfQues){
		List<QuestionVO> questions = questionRepo.findRandomQuestionsByTopic(topic, numOfQues).stream().map(q->QuestionVO.from(q)).collect(Collectors.toList());
		return questions;
	}
}

