package com.valtech.training.quizservice.services;

import java.util.List;

import com.valtech.training.quizservice.vos.QuestionVO;
import com.valtech.training.quizservice.vos.QuizVO;

public interface QuizService {

	QuizVO saveOrUpdateQuiz(QuizVO vo);

//	List<QuestionVO> getRandomQuiz(String topic, int numOfQues);

}