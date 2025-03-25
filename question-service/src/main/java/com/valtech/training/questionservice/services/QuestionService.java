package com.valtech.training.questionservice.services;

import java.util.List;

import com.valtech.training.questionservice.entities.Question;
import com.valtech.training.questionservice.vos.QuestionVO;

public interface QuestionService {

	QuestionVO saveQuestion(QuestionVO question);

//	QuestionVO updateQuestion(QuestionVO question);

	void deleteQuestion(QuestionVO question);

	QuestionVO getQuestion(long id);

	List<QuestionVO> getAllQuestions();

	List<QuestionVO> findAllByTopic(String topic);

	List<QuestionVO> getRandomQuiz(String topic, int numOfQues);


}