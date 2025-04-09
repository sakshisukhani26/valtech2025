package com.valtech.training.quizservice.services;

import java.util.List;

import com.valtech.training.quizservice.vos.QuestionResultVO;

public interface QuestionResultService {

	QuestionResultVO saveQuestionResult(QuestionResultVO vo);

	QuestionResultVO getById(long id);

	List<QuestionResultVO> getAll();

	List<QuestionResultVO> getAllByQuizId(long id);

}